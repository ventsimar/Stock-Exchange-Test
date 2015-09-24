package stock.model;

/**
 * @author <b>Ventsislav Marinov</b>
 *
 */
public class Stock {

	private final String stockSymbol;
	private final StockType type;
	private final double lastDividend;
	private final double fixedDividend;
	private final double parValue;

	public Stock(String stockSymbol, StockType type, double lastDividend,
			double fixedDividend, double parValue) {
		super();
		this.stockSymbol = stockSymbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public StockType getType() {
		return type;
	}

	public double getLastDividend() {
		return lastDividend;
	}

	public double getFixedDividend() {
		return fixedDividend;
	}

	public double getParValue() {
		return parValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(fixedDividend);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lastDividend);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(parValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((stockSymbol == null) ? 0 : stockSymbol.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (Double.doubleToLongBits(fixedDividend) != Double
				.doubleToLongBits(other.fixedDividend))
			return false;
		if (Double.doubleToLongBits(lastDividend) != Double
				.doubleToLongBits(other.lastDividend))
			return false;
		if (Double.doubleToLongBits(parValue) != Double
				.doubleToLongBits(other.parValue))
			return false;
		if (stockSymbol == null) {
			if (other.stockSymbol != null)
				return false;
		} else if (!stockSymbol.equals(other.stockSymbol))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stock [stockSymbol=" + stockSymbol + ", type=" + type
				+ ", lastDividend=" + lastDividend + ", fixedDividend="
				+ fixedDividend + ", parValue=" + parValue + "]";
	}

}
