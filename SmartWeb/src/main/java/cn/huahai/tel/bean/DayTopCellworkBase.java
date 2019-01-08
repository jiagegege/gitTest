package cn.huahai.tel.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
/**
 * 天级top小区级数据
 * @author lijia
 *
 */
@JsonPropertyOrder(value = {
		"DAY1","无线掉线率","无线接通率","切换成功率","ERAB建立请求数","小区可用率分母","流量GB","上行干扰",
		"RRC连接总数","上行PDCP平均速率KBPS","ESRVCC切换成功次数","ENODEB寻呼数",
		"ENB间切换成功次数","基站类别","上行流量GB","上行PRB平均利用率","ENB内切换成功率",
		"小区管理状态","切换请求次数","用户面PDCP流量","ENODEBID_CELLID","ERAB掉线率",
		"ERAB建立成功率","VOLTE接通率","VOLTE接入请求次数","RRC加ERAB失败总次数","小区可用率",
		"ERAB掉线率分母","切换成功次数","ENB间切换成功率","VOLTE接入失败次数","RRC连接建立请求次数",
		"无线掉线率分母","ENB内切换成功次数","VIP","RRC连接建立失败次数","ESRVCC切换失败次数",
		"VOLTE话务量","拥塞次数","ERAB建立失败数","小区可用率分子","平均激活用户数",
		"ENB间切换数","ENB内切换数","ESRVCC切换准备次数","BTSVER","OMC","IP","VOLTE掉话次数",
		"VOLTE接入成功次数","日常公司","ERAB掉线次数","VOLTE掉话率","支持最大激活用户数",
		"RRC连接建立成功率","下行流量GB","VOLTE掉话分母","ECELLNAME","链路测试时间",
		"ESRVCC切换成功率","基站状态","小区操作状态","RRC最大连接数","RRC连接建立成功次数",
		"ESRVCC切换失败总次数","ECELLNAME_CN","切换失败次数","下行PRB平均利用率","ERAB建立成功数",
		"区域","最大激活用户数","无线掉线率分子","下行PDCP平均速率KBPS","ESRVCC切换请求次数" })
public class DayTopCellworkBase {
	@JsonProperty("DAY1")
	private String DAY1;
	@JsonProperty("ERAB建立请求数")
	private Double ERAB建立请求数;
	@JsonProperty("小区可用率分母")
	private Double 小区可用率分母;
	@JsonProperty("切换成功率")
	private Double 切换成功率;
	@JsonProperty("流量GB")
	private Double 流量GB;
	@JsonProperty("上行干扰")
	private Double 上行干扰;
	@JsonProperty("RRC连接总数")
	private Double RRC连接总数;
	@JsonProperty("上行PDCP平均速率KBPS")
	private Double 上行PDCP平均速率KBPS;
	@JsonProperty("ESRVCC切换成功次数")
	private Double ESRVCC切换成功次数;
	@JsonProperty("ENODEB寻呼数")
	private Double ENODEB寻呼数;
	@JsonProperty("ENB间切换成功次数")
	private Double ENB间切换成功次数;
	@JsonProperty("基站类别")
	private String 基站类别;
	@JsonProperty("上行流量GB")
	private Double 上行流量GB;
	@JsonProperty("上行PRB平均利用率")
	private Double 上行PRB平均利用率;
	@JsonProperty("ENB内切换成功率")
	private Double ENB内切换成功率;
	@JsonProperty("小区管理状态")
	private String 小区管理状态;
	@JsonProperty("切换请求次数")
	private Double 切换请求次数;
	@JsonProperty("用户面PDCP流量")
	private String 用户面PDCP流量;
	@JsonProperty("ENODEBID_CELLID")
	private String ENODEBID_CELLID;
	@JsonProperty("ERAB掉线率")
	private Double ERAB掉线率;
	@JsonProperty("ERAB建立成功率")
	private Double ERAB建立成功率;
	@JsonProperty("VOLTE接通率")
	private Double VOLTE接通率;
	@JsonProperty("VOLTE接入请求次数")
	private Double VOLTE接入请求次数;
	@JsonProperty("RRC加ERAB失败总次数")
	private Double RRC加ERAB失败总次数;
	@JsonProperty("小区可用率")
	private Double 小区可用率;
	@JsonProperty("ERAB掉线率分母")
	private Double ERAB掉线率分母;
	@JsonProperty("切换成功次数")
	private Double 切换成功次数;
	@JsonProperty("ENB间切换成功率")
	private Double ENB间切换成功率;
	@JsonProperty("VOLTE接入失败次数")
	private Double VOLTE接入失败次数;
	@JsonProperty("RRC连接建立请求次数")
	private Double RRC连接建立请求次数;
	@JsonProperty("无线掉线率分母")
	private Double 无线掉线率分母;
	@JsonProperty("ENB内切换成功次数")
	private Double ENB内切换成功次数;
	@JsonProperty("VIP")
	private String VIP;
	@JsonProperty("RRC连接建立失败次数")
	private Double RRC连接建立失败次数;
	@JsonProperty("ESRVCC切换失败次数")
	private Double ESRVCC切换失败次数;
	@JsonProperty("VOLTE话务量")
	private Double VOLTE话务量;
	@JsonProperty("拥塞次数")
	private Double 拥塞次数;
	@JsonProperty("ERAB建立失败数")
	private Double ERAB建立失败数;
	@JsonProperty("小区可用率分子")
	private String 小区可用率分子;
	@JsonProperty("平均激活用户数")
	private String 平均激活用户数;
	@JsonProperty("ENB间切换数")
	private String ENB间切换数;
	@JsonProperty("ENB内切换数")
	private String ENB内切换数;
	@JsonProperty("ESRVCC切换准备次数")
	private String ESRVCC切换准备次数;
	@JsonProperty("BTSVER")
	private String BTSVER;
	@JsonProperty("OMC")
	private String OMC;
	@JsonProperty("IP")
	private String IP;
	@JsonProperty("VOLTE掉话次数")
	private String VOLTE掉话次数;
	@JsonProperty("VOLTE接入成功次数")
	private String VOLTE接入成功次数;
	@JsonProperty("日常公司")
	private String 日常公司;
	@JsonProperty("ERAB掉线次数")
	private String ERAB掉线次数;
	@JsonProperty("VOLTE掉话率")
	private String VOLTE掉话率;
	@JsonProperty("支持最大激活用户数")
	private String 支持最大激活用户数;
	@JsonProperty("RRC连接建立成功率")
	private String RRC连接建立成功率;
	@JsonProperty("下行流量GB")
	private String 下行流量GB;
	@JsonProperty("VOLTE掉话分母")
	private String VOLTE掉话分母;
	@JsonProperty("ECELLNAME")
	private String ECELLNAME;
	@JsonProperty("无线掉线率")
	private String 无线掉线率;
	@JsonProperty("链路测试时间")
	private String 链路测试时间;
	@JsonProperty("无线接通率")
	private String 无线接通率;
	@JsonProperty("ESRVCC切换成功率")
	private String ESRVCC切换成功率;
	@JsonProperty("基站状态")
	private String 基站状态;
	@JsonProperty("小区操作状态")
	private String 小区操作状态;
	@JsonProperty("RRC最大连接数")
	private String RRC最大连接数;
	@JsonProperty("RRC连接建立成功次数")
	private String RRC连接建立成功次数;
	@JsonProperty("ESRVCC切换失败总次数")
	private String ESRVCC切换失败总次数;
	@JsonProperty("ECELLNAME_CN")
	private String ECELLNAME_CN;
	@JsonProperty("切换失败次数")
	private String 切换失败次数;
	@JsonProperty("下行PRB平均利用率")
	private String 下行PRB平均利用率;
	@JsonProperty("ERAB建立成功数")
	private String ERAB建立成功数;
	@JsonProperty("区域")
	private String 区域;
	@JsonProperty("最大激活用户数")
	private String 最大激活用户数;
	@JsonProperty("无线掉线率分子")
	private String 无线掉线率分子;
	@JsonProperty("下行PDCP平均速率KBPS")
	private String 下行PDCP平均速率KBPS;
	@JsonProperty("ESRVCC切换请求次数")
	private String ESRVCC切换请求次数;
	public String getDAY1() {
		return DAY1;
	}
	public void setDAY1(String dAY1) {
		DAY1 = dAY1;
	}
	public Double getERAB建立请求数() {
		return ERAB建立请求数;
	}
	public void setERAB建立请求数(Double eRAB建立请求数) {
		ERAB建立请求数 = eRAB建立请求数;
	}
	public Double get小区可用率分母() {
		return 小区可用率分母;
	}
	public void set小区可用率分母(Double 小区可用率分母) {
		this.小区可用率分母 = 小区可用率分母;
	}
	public Double get切换成功率() {
		return 切换成功率;
	}
	public void set切换成功率(Double 切换成功率) {
		this.切换成功率 = 切换成功率;
	}
	public Double get流量GB() {
		return 流量GB;
	}
	public void set流量GB(Double 流量gb) {
		流量GB = 流量gb;
	}
	public Double get上行干扰() {
		return 上行干扰;
	}
	public void set上行干扰(Double 上行干扰) {
		this.上行干扰 = 上行干扰;
	}
	public Double getRRC连接总数() {
		return RRC连接总数;
	}
	public void setRRC连接总数(Double rRC连接总数) {
		RRC连接总数 = rRC连接总数;
	}
	public Double get上行PDCP平均速率KBPS() {
		return 上行PDCP平均速率KBPS;
	}
	public void set上行PDCP平均速率KBPS(Double 上行pdcp平均速率kbps) {
		上行PDCP平均速率KBPS = 上行pdcp平均速率kbps;
	}
	public Double getESRVCC切换成功次数() {
		return ESRVCC切换成功次数;
	}
	public void setESRVCC切换成功次数(Double eSRVCC切换成功次数) {
		ESRVCC切换成功次数 = eSRVCC切换成功次数;
	}
	public Double getENODEB寻呼数() {
		return ENODEB寻呼数;
	}
	public void setENODEB寻呼数(Double eNODEB寻呼数) {
		ENODEB寻呼数 = eNODEB寻呼数;
	}
	public Double getENB间切换成功次数() {
		return ENB间切换成功次数;
	}
	public void setENB间切换成功次数(Double eNB间切换成功次数) {
		ENB间切换成功次数 = eNB间切换成功次数;
	}
	public String get基站类别() {
		return 基站类别;
	}
	public void set基站类别(String 基站类别) {
		this.基站类别 = 基站类别;
	}
	public Double get上行流量GB() {
		return 上行流量GB;
	}
	public void set上行流量GB(Double 上行流量gb) {
		上行流量GB = 上行流量gb;
	}
	public Double get上行PRB平均利用率() {
		return 上行PRB平均利用率;
	}
	public void set上行PRB平均利用率(Double 上行prb平均利用率) {
		上行PRB平均利用率 = 上行prb平均利用率;
	}
	public Double getENB内切换成功率() {
		return ENB内切换成功率;
	}
	public void setENB内切换成功率(Double eNB内切换成功率) {
		ENB内切换成功率 = eNB内切换成功率;
	}
	public String get小区管理状态() {
		return 小区管理状态;
	}
	public void set小区管理状态(String 小区管理状态) {
		this.小区管理状态 = 小区管理状态;
	}
	public Double get切换请求次数() {
		return 切换请求次数;
	}
	public void set切换请求次数(Double 切换请求次数) {
		this.切换请求次数 = 切换请求次数;
	}
	public String get用户面PDCP流量() {
		return 用户面PDCP流量;
	}
	public void set用户面PDCP流量(String 用户面pdcp流量) {
		用户面PDCP流量 = 用户面pdcp流量;
	}
	public String getENODEBID_CELLID() {
		return ENODEBID_CELLID;
	}
	public void setENODEBID_CELLID(String eNODEBID_CELLID) {
		ENODEBID_CELLID = eNODEBID_CELLID;
	}
	public Double getERAB掉线率() {
		return ERAB掉线率;
	}
	public void setERAB掉线率(Double eRAB掉线率) {
		ERAB掉线率 = eRAB掉线率;
	}
	public Double getERAB建立成功率() {
		return ERAB建立成功率;
	}
	public void setERAB建立成功率(Double eRAB建立成功率) {
		ERAB建立成功率 = eRAB建立成功率;
	}
	public Double getVOLTE接通率() {
		return VOLTE接通率;
	}
	public void setVOLTE接通率(Double vOLTE接通率) {
		VOLTE接通率 = vOLTE接通率;
	}
	public Double getVOLTE接入请求次数() {
		return VOLTE接入请求次数;
	}
	public void setVOLTE接入请求次数(Double vOLTE接入请求次数) {
		VOLTE接入请求次数 = vOLTE接入请求次数;
	}
	public Double getRRC加ERAB失败总次数() {
		return RRC加ERAB失败总次数;
	}
	public void setRRC加ERAB失败总次数(Double rRC加ERAB失败总次数) {
		RRC加ERAB失败总次数 = rRC加ERAB失败总次数;
	}
	public Double get小区可用率() {
		return 小区可用率;
	}
	public void set小区可用率(Double 小区可用率) {
		this.小区可用率 = 小区可用率;
	}
	public Double getERAB掉线率分母() {
		return ERAB掉线率分母;
	}
	public void setERAB掉线率分母(Double eRAB掉线率分母) {
		ERAB掉线率分母 = eRAB掉线率分母;
	}
	public Double get切换成功次数() {
		return 切换成功次数;
	}
	public void set切换成功次数(Double 切换成功次数) {
		this.切换成功次数 = 切换成功次数;
	}
	public Double getENB间切换成功率() {
		return ENB间切换成功率;
	}
	public void setENB间切换成功率(Double eNB间切换成功率) {
		ENB间切换成功率 = eNB间切换成功率;
	}
	public Double getVOLTE接入失败次数() {
		return VOLTE接入失败次数;
	}
	public void setVOLTE接入失败次数(Double vOLTE接入失败次数) {
		VOLTE接入失败次数 = vOLTE接入失败次数;
	}
	public Double getRRC连接建立请求次数() {
		return RRC连接建立请求次数;
	}
	public void setRRC连接建立请求次数(Double rRC连接建立请求次数) {
		RRC连接建立请求次数 = rRC连接建立请求次数;
	}
	public Double get无线掉线率分母() {
		return 无线掉线率分母;
	}
	public void set无线掉线率分母(Double 无线掉线率分母) {
		this.无线掉线率分母 = 无线掉线率分母;
	}
	public Double getENB内切换成功次数() {
		return ENB内切换成功次数;
	}
	public void setENB内切换成功次数(Double eNB内切换成功次数) {
		ENB内切换成功次数 = eNB内切换成功次数;
	}
	public String getVIP() {
		return VIP;
	}
	public void setVIP(String vIP) {
		VIP = vIP;
	}
	public Double getRRC连接建立失败次数() {
		return RRC连接建立失败次数;
	}
	public void setRRC连接建立失败次数(Double rRC连接建立失败次数) {
		RRC连接建立失败次数 = rRC连接建立失败次数;
	}
	public Double getESRVCC切换失败次数() {
		return ESRVCC切换失败次数;
	}
	public void setESRVCC切换失败次数(Double eSRVCC切换失败次数) {
		ESRVCC切换失败次数 = eSRVCC切换失败次数;
	}
	
	public Double getVOLTE话务量() {
		return VOLTE话务量;
	}
	public void setVOLTE话务量(Double vOLTE话务量) {
		VOLTE话务量 = vOLTE话务量;
	}
	public Double get拥塞次数() {
		return 拥塞次数;
	}
	public void set拥塞次数(Double 拥塞次数) {
		this.拥塞次数 = 拥塞次数;
	}
	public Double getERAB建立失败数() {
		return ERAB建立失败数;
	}
	public void setERAB建立失败数(Double eRAB建立失败数) {
		ERAB建立失败数 = eRAB建立失败数;
	}
	public String get小区可用率分子() {
		return 小区可用率分子;
	}
	public void set小区可用率分子(String 小区可用率分子) {
		this.小区可用率分子 = 小区可用率分子;
	}
	public String get平均激活用户数() {
		return 平均激活用户数;
	}
	public void set平均激活用户数(String 平均激活用户数) {
		this.平均激活用户数 = 平均激活用户数;
	}
	public String getENB间切换数() {
		return ENB间切换数;
	}
	public void setENB间切换数(String eNB间切换数) {
		ENB间切换数 = eNB间切换数;
	}
	public String getENB内切换数() {
		return ENB内切换数;
	}
	public void setENB内切换数(String eNB内切换数) {
		ENB内切换数 = eNB内切换数;
	}
	public String getESRVCC切换准备次数() {
		return ESRVCC切换准备次数;
	}
	public void setESRVCC切换准备次数(String eSRVCC切换准备次数) {
		ESRVCC切换准备次数 = eSRVCC切换准备次数;
	}
	public String getBTSVER() {
		return BTSVER;
	}
	public void setBTSVER(String bTSVER) {
		BTSVER = bTSVER;
	}
	public String getOMC() {
		return OMC;
	}
	public void setOMC(String oMC) {
		OMC = oMC;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getVOLTE掉话次数() {
		return VOLTE掉话次数;
	}
	public void setVOLTE掉话次数(String vOLTE掉话次数) {
		VOLTE掉话次数 = vOLTE掉话次数;
	}
	public String getVOLTE接入成功次数() {
		return VOLTE接入成功次数;
	}
	public void setVOLTE接入成功次数(String vOLTE接入成功次数) {
		VOLTE接入成功次数 = vOLTE接入成功次数;
	}
	public String get日常公司() {
		return 日常公司;
	}
	public void set日常公司(String 日常公司) {
		this.日常公司 = 日常公司;
	}
	public String getERAB掉线次数() {
		return ERAB掉线次数;
	}
	public void setERAB掉线次数(String eRAB掉线次数) {
		ERAB掉线次数 = eRAB掉线次数;
	}
	public String getVOLTE掉话率() {
		return VOLTE掉话率;
	}
	public void setVOLTE掉话率(String vOLTE掉话率) {
		VOLTE掉话率 = vOLTE掉话率;
	}
	public String get支持最大激活用户数() {
		return 支持最大激活用户数;
	}
	public void set支持最大激活用户数(String 支持最大激活用户数) {
		this.支持最大激活用户数 = 支持最大激活用户数;
	}
	public String getRRC连接建立成功率() {
		return RRC连接建立成功率;
	}
	public void setRRC连接建立成功率(String rRC连接建立成功率) {
		RRC连接建立成功率 = rRC连接建立成功率;
	}
	public String get下行流量GB() {
		return 下行流量GB;
	}
	public void set下行流量GB(String 下行流量gb) {
		下行流量GB = 下行流量gb;
	}
	public String getVOLTE掉话分母() {
		return VOLTE掉话分母;
	}
	public void setVOLTE掉话分母(String vOLTE掉话分母) {
		VOLTE掉话分母 = vOLTE掉话分母;
	}
	public String getECELLNAME() {
		return ECELLNAME;
	}
	public void setECELLNAME(String eCELLNAME) {
		ECELLNAME = eCELLNAME;
	}
	public String get无线掉线率() {
		return 无线掉线率;
	}
	public void set无线掉线率(String 无线掉线率) {
		this.无线掉线率 = 无线掉线率;
	}
	public String get链路测试时间() {
		return 链路测试时间;
	}
	public void set链路测试时间(String 链路测试时间) {
		this.链路测试时间 = 链路测试时间;
	}
	public String get无线接通率() {
		return 无线接通率;
	}
	public void set无线接通率(String 无线接通率) {
		this.无线接通率 = 无线接通率;
	}
	public String getESRVCC切换成功率() {
		return ESRVCC切换成功率;
	}
	public void setESRVCC切换成功率(String eSRVCC切换成功率) {
		ESRVCC切换成功率 = eSRVCC切换成功率;
	}
	public String get基站状态() {
		return 基站状态;
	}
	public void set基站状态(String 基站状态) {
		this.基站状态 = 基站状态;
	}
	public String get小区操作状态() {
		return 小区操作状态;
	}
	public void set小区操作状态(String 小区操作状态) {
		this.小区操作状态 = 小区操作状态;
	}
	public String getRRC最大连接数() {
		return RRC最大连接数;
	}
	public void setRRC最大连接数(String rRC最大连接数) {
		RRC最大连接数 = rRC最大连接数;
	}
	public String getRRC连接建立成功次数() {
		return RRC连接建立成功次数;
	}
	public void setRRC连接建立成功次数(String rRC连接建立成功次数) {
		RRC连接建立成功次数 = rRC连接建立成功次数;
	}
	public String getESRVCC切换失败总次数() {
		return ESRVCC切换失败总次数;
	}
	public void setESRVCC切换失败总次数(String eSRVCC切换失败总次数) {
		ESRVCC切换失败总次数 = eSRVCC切换失败总次数;
	}
	public String getECELLNAME_CN() {
		return ECELLNAME_CN;
	}
	public void setECELLNAME_CN(String eCELLNAME_CN) {
		ECELLNAME_CN = eCELLNAME_CN;
	}
	public String get切换失败次数() {
		return 切换失败次数;
	}
	public void set切换失败次数(String 切换失败次数) {
		this.切换失败次数 = 切换失败次数;
	}
	public String get下行PRB平均利用率() {
		return 下行PRB平均利用率;
	}
	public void set下行PRB平均利用率(String 下行prb平均利用率) {
		下行PRB平均利用率 = 下行prb平均利用率;
	}
	public String getERAB建立成功数() {
		return ERAB建立成功数;
	}
	public void setERAB建立成功数(String eRAB建立成功数) {
		ERAB建立成功数 = eRAB建立成功数;
	}
	public String get区域() {
		return 区域;
	}
	public void set区域(String 区域) {
		this.区域 = 区域;
	}
	public String get最大激活用户数() {
		return 最大激活用户数;
	}
	public void set最大激活用户数(String 最大激活用户数) {
		this.最大激活用户数 = 最大激活用户数;
	}
	public String get无线掉线率分子() {
		return 无线掉线率分子;
	}
	public void set无线掉线率分子(String 无线掉线率分子) {
		this.无线掉线率分子 = 无线掉线率分子;
	}
	public String get下行PDCP平均速率KBPS() {
		return 下行PDCP平均速率KBPS;
	}
	public void set下行PDCP平均速率KBPS(String 下行pdcp平均速率kbps) {
		下行PDCP平均速率KBPS = 下行pdcp平均速率kbps;
	}
	public String getESRVCC切换请求次数() {
		return ESRVCC切换请求次数;
	}
	public void setESRVCC切换请求次数(String eSRVCC切换请求次数) {
		ESRVCC切换请求次数 = eSRVCC切换请求次数;
	}
	
	
	
}
