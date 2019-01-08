package cn.huahai.tel.bean;

/**
 * 临界值的javaBean
 * @author lijia
 *
 */
public class CriticalValueBase {
	private String attribute;
	private Double compare;
	private Integer symbol;
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public Double getCompare() {
		return compare;
	}
	public void setCompare(Double compare) {
		this.compare = compare;
	}
	public Integer getSymbol() {
		return symbol;
	}
	public void setSymbol(Integer symbol) {
		this.symbol = symbol;
	}
	@Override
	public String toString() {
		return "CriticalValueBase [attribute=" + attribute + ", compare=" + compare + ", symbol=" + symbol + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attribute == null) ? 0 : attribute.hashCode());
		result = prime * result + ((compare == null) ? 0 : compare.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
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
		CriticalValueBase other = (CriticalValueBase) obj;
		if (attribute == null) {
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		if (compare == null) {
			if (other.compare != null)
				return false;
		} else if (!compare.equals(other.compare))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}
	
	

}
