package stock.model;

import java.time.Instant;

/**
 * @author <b>Ventsislav Marinov</b>
 *
 */
public class Trade {

	private final Stock stock;
	private final Instant timestamp = Instant.now();
	private final int sharesQuantity;
	private final TradeIndicator indicator;
	private final double price;

	public Trade(Stock stock, int sharesQuantity, TradeIndicator indicator,
			double price) {
		super();
		this.stock = stock;
		this.sharesQuantity = sharesQuantity;
		this.indicator = indicator;
		this.price = price;
	}

	public Stock getStock() {
		return stock;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public int getSharesQuantity() {
		return sharesQuantity;
	}

	public TradeIndicator getIndicator() {
		return indicator;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((indicator == null) ? 0 : indicator.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sharesQuantity;
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
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
		Trade other = (Trade) obj;
		if (indicator != other.indicator)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (sharesQuantity != other.sharesQuantity)
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trade [stock=" + stock + ", timestamp=" + timestamp
				+ ", sharesQuantity=" + sharesQuantity + ", indicator="
				+ indicator + ", price=" + price + "]";
	}

}
