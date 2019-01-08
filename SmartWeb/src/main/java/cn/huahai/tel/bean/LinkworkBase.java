package cn.huahai.tel.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class LinkworkBase {
	
	@JsonPropertyOrder(value = {
		"ENODEBID","ENODEBNAME_CN","IP","ENODEBNAME","基站类型","LONGITUDE","LATITUDE","日常公司","VIP","VIP类型","代维","PS","基站类别","区域","DATETIME","状态","DATETIME1","HM","NEWEST","OCCTIME","ID","DEBUGIP"
		
		
	})
	
	@JsonProperty("ENODEBID")
	private String ENODEBID;
	@JsonProperty("ENODEBNAME_CN")
	private String ENODEBNAME_CN;
	@JsonProperty("IP")
	private String IP;
	@JsonProperty("ENODEBNAME")
	private String ENODEBNAME;
	@JsonProperty("基站类型")
	private String 基站类型;
	@JsonProperty("LONGITUDE")
	private String LONGITUDE;
	@JsonProperty("LATITUDE")
	private String LATITUDE;
	@JsonProperty("日常公司")
	private String 日常公司;
	@JsonProperty("VIP")
	private String VIP;
	@JsonProperty("VIP类型")
	private String VIP类型;
	@JsonProperty("代维")
	private String 代维;
	@JsonProperty("PS")
	private String PS;
	@JsonProperty("基站类别")
	private String 基站类别;
	@JsonProperty("区域")
	private String 区域;
	@JsonProperty("DATETIME")
	private String DATETIME;
	@JsonProperty("状态")
	private String 状态;
	@JsonProperty("DATETIME1")
	private String DATETIME1;
	@JsonProperty("HM")
	private String HM;
	@JsonProperty("NEWEST")
	private String NEWEST;
	@JsonProperty("OCCTIME")
	private String OCCTIME;
	@JsonProperty("ID")
	private String ID;
	@JsonProperty("DEBUGIP")
	private String DEBUGIP;
	@Override
	public String toString() {
		return "LinkworkBase [ENODEBID=" + ENODEBID + ", ENODEBNAME_CN=" + ENODEBNAME_CN + ", IP=" + IP
				+ ", ENODEBNAME=" + ENODEBNAME + ", 基站类型=" + 基站类型 + ", LONGITUDE=" + LONGITUDE + ", LATITUDE="
				+ LATITUDE + ", 日常公司=" + 日常公司 + ", VIP=" + VIP + ", VIP类型=" + VIP类型 + ", 代维=" + 代维 + ", PS=" + PS
				+ ", 基站类别=" + 基站类别 + ", 区域=" + 区域 + ", DATETIME=" + DATETIME + ", 状态=" + 状态 + ", DATETIME1=" + DATETIME1
				+ ", HM=" + HM + ", NEWEST=" + NEWEST + ", OCCTIME=" + OCCTIME + ", ID=" + ID + ", DEBUGIP=" + DEBUGIP
				+ "]";
	}

	
	
	
}
