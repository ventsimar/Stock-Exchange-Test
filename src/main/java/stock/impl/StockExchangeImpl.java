package stock.impl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import stock.StockExchange;
import stock.model.Stock;
import stock.model.Trade;
import stock.model.TradeIndicator;
import stock.util.FormulaService;

/**
 * @author <b>Ventsislav Marinov</b>
 *
 */
public class StockExchangeImpl implements StockExchange {

	private static final int FIFTEEN_MINUTES = 15;
	
	private Set<Trade> allTrades = new HashSet<Trade>();
	
	public double calculateDividendYield(Stock stock, double price) {
		return FormulaService.INSTANCE.calculateDividendYield(stock, price);
	}
	
	public double calculatePERatio(Stock stock, double price) {
		return FormulaService.INSTANCE.calculatePERatio(stock, price);
	}

	public double calculateStockPrice(Stock stock) {
		// get all trades for specified stock 
		Set<Trade> stockTrades = filterTradesByStock(allTrades, stock);
		
		// get the trades for the last 15 minutes
		Set<Trade> lastestTrades = filterTradesByPeriod(stockTrades, FIFTEEN_MINUTES); 
		
		// calculate trades stock price
		double stockPrice = getStockPriceOfTrades(lastestTrades);
		
		return stockPrice;
	}
	
	public double calculateGBCEAllShareIndex() {
		Set<Stock> stocks = StockStore.getStocks();
		
		double stockPricesMultiply = 1;
		for (Stock stock : stocks) {
			// multiplication of all Stock Prices
			stockPricesMultiply *= calculateStockPrice(stock);
		}
		
		int n = stocks.size();
		
		return Math.pow(stockPricesMultiply,(1/n));
	}
	
	public void sell(Stock stock, int sharesQuantity, double price) {
		Trade trade = new Trade(stock, sharesQuantity, TradeIndicator.SELL, price);

		synchronized (stock) {
			allTrades.add(trade);
		}
	}

	public void buy(Stock stock, int sharesQuantity, double price) {
		Trade trade = new Trade(stock, sharesQuantity, TradeIndicator.BUY, price);

		synchronized (stock) {
			allTrades.add(trade);
		}
	}
	
	private Set<Trade> filterTradesByPeriod(Set<Trade> trades, int minutes) {
		Instant currentTime = Instant.now();

		Set<Trade> filteredTrades = trades.stream()
				.filter(trade -> ChronoUnit.MINUTES.between(trade.getTimestamp(),
						currentTime) < minutes).collect(Collectors.toSet());
		
		return filteredTrades;
	}
	
	private Set<Trade> filterTradesByStock(Set<Trade> trades, Stock stock) {
		Set<Trade> filteredTrades = trades.stream()
				.filter(trade -> trade.getStock().equals(stock)).collect(Collectors.toSet());
		
		return filteredTrades;
	}

	private double getStockPriceOfTrades(Set<Trade> trades) {
		double tradePriceSum = 0;
		int shareQuantitySum = 0;
		for (Trade trade : trades) {
			// sum of Trade Price x Quantity
			tradePriceSum += (trade.getPrice() * trade.getSharesQuantity());
			// sum of all shares quantity
			shareQuantitySum += trade.getSharesQuantity();
		}

		if (shareQuantitySum <= 0) {
			return 0;
		}

		return tradePriceSum / shareQuantitySum;
	}
}
