package cn.huahai.tel.bean;

import java.io.Serializable;

/**
 * 链路故障实体类
 * @author lijia
 *
 */
public class LinkFailure implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2091815353132500215L;
	private String hm;
	private String num;
	private String datetime;
	public String getHm() {
		return hm;
	}
	public void setHm(String hm) {
		this.hm = hm;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datetime == null) ? 0 : datetime.hashCode());
		result = prime * result + ((hm == null) ? 0 : hm.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
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
		LinkFailure other = (LinkFailure) obj;
		if (datetime == null) {
			if (other.datetime != null)
				return false;
		} else if (!datetime.equals(other.datetime))
			return false;
		if (hm == null) {
			if (other.hm != null)
				return false;
		} else if (!hm.equals(other.hm))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LinkFailure [hm=" + hm + ", num=" + num + ", datetime=" + datetime + "]";
	}
	public LinkFailure() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LinkFailure(String hm, String num, String datetime) {
		super();
		this.hm = hm;
		this.num = num;
		this.datetime = datetime;
	}
	
	
}
