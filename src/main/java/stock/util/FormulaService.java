package stock.util;

import stock.model.Stock;

/**
 * @author <b>Ventsislav Marinov</b>
 *
 */
public enum FormulaService {
	INSTANCE;

	public double calculateDividendYield(Stock stock, double tickerPrice) {
		if (tickerPrice <= 0) {
			return 0;
		}
		
		switch (stock.getType()) {
			case COMMON:
				return stock.getLastDividend() / tickerPrice;
	
			case PREFERRED:
				return (stock.getFixedDividend() * stock.getParValue()) / tickerPrice;
	
			default:
				return 0;
		}
	}

	public double calculatePERatio(Stock stock, double tickerPrice) {
		if (tickerPrice <= 0) {
			return 0;
		}

		return tickerPrice / stock.getLastDividend();
	}

}
