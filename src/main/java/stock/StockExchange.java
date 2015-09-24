package stock;

import stock.model.Stock;

/**
 * @author <b>Ventsislav Marinov</b>
 *
 */
public interface StockExchange {
	
	/**
	 * @param stock
	 * @param price
	 * @return dividend yield
	 */
	public double calculateDividendYield(Stock stock, double price);
	
	/**
	 * @param stock
	 * @param price
	 * @return P/E Ratio
	 */
	public double calculatePERatio(Stock stock, double price);
	
	/**
	 * @param stock
	 * @return Stock Price based on trades recorded in past 15 minutes
	 */
	public double calculateStockPrice(Stock stock);
	
	/**
	 * @return GBCE All Share Index using the geometric mean of prices for all stocks
	 */
	public double calculateGBCEAllShareIndex();
	
	/**
	 * @param stock
	 * @param sharesQuantity
	 * @param price
	 */
	public void sell(Stock stock, int sharesQuantity, double price);

	/**
	 * @param stock
	 * @param sharesQuantity
	 * @param price
	 */
	public void buy(Stock stock, int sharesQuantity, double price);

}
