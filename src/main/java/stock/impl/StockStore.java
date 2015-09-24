package stock.impl;

import java.util.HashSet;
import java.util.Set;

import stock.model.Stock;
import stock.model.StockType;

/**
 * @author <b>Ventsislav Marinov</b>
 *
 */
public class StockStore {

	private static final Set<Stock> stocks = new HashSet<Stock>();

	static {
		stocks.add(new Stock("TEA", StockType.COMMON, 0, 0, 100));
		stocks.add(new Stock("POP", StockType.COMMON, 8, 0, 100));
		stocks.add(new Stock("ALE", StockType.COMMON, 23, 0, 60));
		stocks.add(new Stock("GIN", StockType.PREFERRED, 8, 2, 100));
		stocks.add(new Stock("JOE", StockType.COMMON, 13, 0, 250));
	}

	public static Set<Stock> getStocks() {
		return stocks;
	}
}
