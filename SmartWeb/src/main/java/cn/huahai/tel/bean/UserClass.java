package cn.huahai.tel.bean;

import java.io.Serializable;

public class UserClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5243806305006733369L;
	
	private Integer id ;
	private String className;
	public UserClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserClass(Integer id, String className) {
		super();
		this.id = id;
		this.className = className;
	}
	@Override
	public String toString() {
		return "UserClass [id=" + id + ", className=" + className + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UserClass other = (UserClass) obj;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getclassName() {
		return className;
	}
	public void setclassName(String className) {
		this.className = className;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
