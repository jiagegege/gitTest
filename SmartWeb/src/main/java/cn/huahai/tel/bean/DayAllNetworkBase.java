package cn.huahai.tel.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 天级全网级数据
 * @author lijia
 *
 */
@JsonPropertyOrder(value = {"DAY1","无线接通率","无线掉线率","切换成功率","流量GB","RRC加ERAB失败总次数","拥塞次数",
		"平均激活用户数","最大激活用户数","无线掉线率分子","上行干扰","RRC连接建立成功率","ERAB建立成功率",
		"ERAB掉线率","上行流量GB","下行流量GB","上行PRB平均利用率","下行PRB平均利用率","小区可用率",
		"RRC最大连接数","RRC连接总数","ENODEB寻呼数","RRC连接建立请求次数","RRC连接建立成功次数",
		"RRC连接建立失败次数","ERAB建立请求数","ERAB建立成功数","ERAB建立失败数","无线掉线率分母",
		"ERAB掉线次数","ERAB掉线率分母","切换请求次数","切换成功次数","切换失败次数", "小区可用率分子","小区可用率分母","上行PDCP平均速率KBPS",
		"下行PDCP平均速率KBPS","ENB间切换成功次数","ENB间切换数","ENB间切换成功率",
		"ENB内切换成功次数","ENB内切换数","ENB内切换成功率","用户面PDCP流量","VOLTE接通率",
		"VOLTE话务量","VOLTE掉话次数","VOLTE掉话分母","VOLTE掉话率","ESRVCC切换成功率",
		"ESRVCC切换请求次数","ESRVCC切换成功次数","ESRVCC切换失败次数","ESRVCC切换准备次数",
		"ESRVCC切换失败总次数","VOLTE接入请求次数","VOLTE接入成功次数","VOLTE接入失败次数",
		})

public class DayAllNetworkBase {
	@JsonProperty("小区可用率分子")
	private Double 小区可用率分子;
	@JsonProperty("小区可用率分母")
	private Double 小区可用率分母;
	@JsonProperty("上行PDCP平均速率KBPS")
	private Double 上行PDCP平均速率KBPS;
	@JsonProperty("下行PDCP平均速率KBPS")
	private Double 下行PDCP平均速率KBPS;
	@JsonProperty("ENB间切换成功次数")
	private Double ENB间切换成功次数;
	@JsonProperty("ENB间切换数")
	private Double ENB间切换数;
	@JsonProperty("ENB间切换成功率")
	private Double ENB间切换成功率;
	@JsonProperty("ENB内切换成功次数")
	private Double ENB内切换成功次数;
	@JsonProperty("ENB内切换数")
	private Double ENB内切换数;
	@JsonProperty("ENB内切换成功率")
	private Double ENB内切换成功率;
	@JsonProperty("用户面PDCP流量")
	private Double 用户面PDCP流量;
	@JsonProperty("VOLTE接通率")
	private Double VOLTE接通率;
	@JsonProperty("VOLTE话务量")
	private Double VOLTE话务量;
	@JsonProperty("VOLTE掉话次数")
	private Double VOLTE掉话次数;
	@JsonProperty("VOLTE掉话分母")
	private Double VOLTE掉话分母;
	@JsonProperty("VOLTE掉话率")
	private Double VOLTE掉话率;
	@JsonProperty("ESRVCC切换成功率")
	private Double ESRVCC切换成功率;
	@JsonProperty("ESRVCC切换请求次数")
	private Double ESRVCC切换请求次数;
	@JsonProperty("ESRVCC切换成功次数")
	private Double ESRVCC切换成功次数;
	@JsonProperty("ESRVCC切换失败次数")
	private Double ESRVCC切换失败次数;
	@JsonProperty("ESRVCC切换准备次数")
	private Double ESRVCC切换准备次数;
	@JsonProperty("ESRVCC切换失败总次数")
	private Double ESRVCC切换失败总次数;
	@JsonProperty("VOLTE接入请求次数")
	private Double VOLTE接入请求次数;
	@JsonProperty("VOLTE接入成功次数")
	private Double VOLTE接入成功次数;
	@JsonProperty("VOLTE接入失败次数")
	private Double VOLTE接入失败次数;
	@JsonProperty("DAY1")
	private String DAY1;
	@JsonProperty("无线接通率")
	private Double 无线接通率;
	@JsonProperty("无线掉线率")
	private Double 无线掉线率;
	@JsonProperty("切换成功率")
	private Double 切换成功率;
	@JsonProperty("流量GB")
	private Double 流量GB;
	@JsonProperty("RRC加ERAB失败总次数")
	private Double RRC加ERAB失败总次数;
	@JsonProperty("拥塞次数")
	private Double 拥塞次数;
	@JsonProperty("平均激活用户数")
	private Double 平均激活用户数;
	@JsonProperty("最大激活用户数")
	private Double 最大激活用户数;
	@JsonProperty("无线掉线率分子")
	private Double 无线掉线率分子;
	@JsonProperty("上行干扰")
	private Double 上行干扰;
	@JsonProperty("RRC连接建立成功率")
	private Double RRC连接建立成功率;
	@JsonProperty("ERAB建立成功率")
	private Double ERAB建立成功率;
	@JsonProperty("ERAB掉线率")
	private Double ERAB掉线率;
	@JsonProperty("上行流量GB")
	private Double 上行流量GB;
	@JsonProperty("下行流量GB")
	private Double 下行流量GB;
	@JsonProperty("上行PRB平均利用率")
	private Double 上行PRB平均利用率;
	@JsonProperty("下行PRB平均利用率")
	private Double 下行PRB平均利用率;
	@JsonProperty("小区可用率")
	private Double 小区可用率;
	@JsonProperty("RRC最大连接数")
	private Double RRC最大连接数;
	@JsonProperty("RRC连接总数")
	private Double RRC连接总数;
	@JsonProperty("ENODEB寻呼数")
	private Double ENODEB寻呼数;
	@JsonProperty("RRC连接建立请求次数")
	private Double RRC连接建立请求次数;
	@JsonProperty("RRC连接建立成功次数")
	private Double RRC连接建立成功次数;
	@JsonProperty("RRC连接建立失败次数")
	private Double RRC连接建立失败次数;
	@JsonProperty("ERAB建立请求数")
	private Double ERAB建立请求数;
	@JsonProperty("ERAB建立成功数")
	private Double ERAB建立成功数;
	@JsonProperty("ERAB建立失败数")
	private Double ERAB建立失败数;
	@JsonProperty("无线掉线率分母")
	private Double 无线掉线率分母;
	@JsonProperty("ERAB掉线次数")
	private Double ERAB掉线次数;
	@JsonProperty("ERAB掉线率分母")
	private Double ERAB掉线率分母;
	@JsonProperty("切换请求次数")
	private Double 切换请求次数;
	@JsonProperty("切换成功次数")
	private Double 切换成功次数;
	@JsonProperty("切换失败次数")
	private Double 切换失败次数;
	public Double get小区可用率分子() {
		return 小区可用率分子;
	}
	public void set小区可用率分子(Double 小区可用率分子) {
		this.小区可用率分子 = 小区可用率分子;
	}
	public Double get小区可用率分母() {
		return 小区可用率分母;
	}
	public void set小区可用率分母(Double 小区可用率分母) {
		this.小区可用率分母 = 小区可用率分母;
	}
	public Double get上行PDCP平均速率KBPS() {
		return 上行PDCP平均速率KBPS;
	}
	public void set上行PDCP平均速率KBPS(Double 上行pdcp平均速率kbps) {
		上行PDCP平均速率KBPS = 上行pdcp平均速率kbps;
	}
	public Double get下行PDCP平均速率KBPS() {
		return 下行PDCP平均速率KBPS;
	}
	public void set下行PDCP平均速率KBPS(Double 下行pdcp平均速率kbps) {
		下行PDCP平均速率KBPS = 下行pdcp平均速率kbps;
	}
	public Double getENB间切换成功次数() {
		return ENB间切换成功次数;
	}
	public void setENB间切换成功次数(Double eNB间切换成功次数) {
		ENB间切换成功次数 = eNB间切换成功次数;
	}
	public Double getENB间切换数() {
		return ENB间切换数;
	}
	public void setENB间切换数(Double eNB间切换数) {
		ENB间切换数 = eNB间切换数;
	}
	public Double getENB间切换成功率() {
		return ENB间切换成功率;
	}
	public void setENB间切换成功率(Double eNB间切换成功率) {
		ENB间切换成功率 = eNB间切换成功率;
	}
	public Double getENB内切换成功次数() {
		return ENB内切换成功次数;
	}
	public void setENB内切换成功次数(Double eNB内切换成功次数) {
		ENB内切换成功次数 = eNB内切换成功次数;
	}
	public Double getENB内切换数() {
		return ENB内切换数;
	}
	public void setENB内切换数(Double eNB内切换数) {
		ENB内切换数 = eNB内切换数;
	}
	public Double getENB内切换成功率() {
		return ENB内切换成功率;
	}
	public void setENB内切换成功率(Double eNB内切换成功率) {
		ENB内切换成功率 = eNB内切换成功率;
	}
	public Double get用户面PDCP流量() {
		return 用户面PDCP流量;
	}
	public void set用户面PDCP流量(Double 用户面pdcp流量) {
		用户面PDCP流量 = 用户面pdcp流量;
	}
	public Double getVOLTE接通率() {
		return VOLTE接通率;
	}
	public void setVOLTE接通率(Double vOLTE接通率) {
		VOLTE接通率 = vOLTE接通率;
	}
	public Double getVOLTE话务量() {
		return VOLTE话务量;
	}
	public void setVOLTE话务量(Double vOLTE话务量) {
		VOLTE话务量 = vOLTE话务量;
	}
	public Double getVOLTE掉话次数() {
		return VOLTE掉话次数;
	}
	public void setVOLTE掉话次数(Double vOLTE掉话次数) {
		VOLTE掉话次数 = vOLTE掉话次数;
	}
	public Double getVOLTE掉话分母() {
		return VOLTE掉话分母;
	}
	public void setVOLTE掉话分母(Double vOLTE掉话分母) {
		VOLTE掉话分母 = vOLTE掉话分母;
	}
	public Double getVOLTE掉话率() {
		return VOLTE掉话率;
	}
	public void setVOLTE掉话率(Double vOLTE掉话率) {
		VOLTE掉话率 = vOLTE掉话率;
	}
	public Double getESRVCC切换成功率() {
		return ESRVCC切换成功率;
	}
	public void setESRVCC切换成功率(Double eSRVCC切换成功率) {
		ESRVCC切换成功率 = eSRVCC切换成功率;
	}
	public Double getESRVCC切换请求次数() {
		return ESRVCC切换请求次数;
	}
	public void setESRVCC切换请求次数(Double eSRVCC切换请求次数) {
		ESRVCC切换请求次数 = eSRVCC切换请求次数;
	}
	public Double getESRVCC切换成功次数() {
		return ESRVCC切换成功次数;
	}
	public void setESRVCC切换成功次数(Double eSRVCC切换成功次数) {
		ESRVCC切换成功次数 = eSRVCC切换成功次数;
	}
	public Double getESRVCC切换失败次数() {
		return ESRVCC切换失败次数;
	}
	public void setESRVCC切换失败次数(Double eSRVCC切换失败次数) {
		ESRVCC切换失败次数 = eSRVCC切换失败次数;
	}
	public Double getESRVCC切换准备次数() {
		return ESRVCC切换准备次数;
	}
	public void setESRVCC切换准备次数(Double eSRVCC切换准备次数) {
		ESRVCC切换准备次数 = eSRVCC切换准备次数;
	}
	public Double getESRVCC切换失败总次数() {
		return ESRVCC切换失败总次数;
	}
	public void setESRVCC切换失败总次数(Double eSRVCC切换失败总次数) {
		ESRVCC切换失败总次数 = eSRVCC切换失败总次数;
	}
	public Double getVOLTE接入请求次数() {
		return VOLTE接入请求次数;
	}
	public void setVOLTE接入请求次数(Double vOLTE接入请求次数) {
		VOLTE接入请求次数 = vOLTE接入请求次数;
	}
	public Double getVOLTE接入成功次数() {
		return VOLTE接入成功次数;
	}
	public void setVOLTE接入成功次数(Double vOLTE接入成功次数) {
		VOLTE接入成功次数 = vOLTE接入成功次数;
	}
	public Double getVOLTE接入失败次数() {
		return VOLTE接入失败次数;
	}
	public void setVOLTE接入失败次数(Double vOLTE接入失败次数) {
		VOLTE接入失败次数 = vOLTE接入失败次数;
	}
	public String getDAY1() {
		return DAY1;
	}
	public void setDAY1(String dAY1) {
		DAY1 = dAY1;
	}
	public Double get无线接通率() {
		return 无线接通率;
	}
	public void set无线接通率(Double 无线接通率) {
		this.无线接通率 = 无线接通率;
	}
	public Double get无线掉线率() {
		return 无线掉线率;
	}
	public void set无线掉线率(Double 无线掉线率) {
		this.无线掉线率 = 无线掉线率;
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
	public Double getRRC加ERAB失败总次数() {
		return RRC加ERAB失败总次数;
	}
	public void setRRC加ERAB失败总次数(Double rRC加ERAB失败总次数) {
		RRC加ERAB失败总次数 = rRC加ERAB失败总次数;
	}
	public Double get拥塞次数() {
		return 拥塞次数;
	}
	public void set拥塞次数(Double 拥塞次数) {
		this.拥塞次数 = 拥塞次数;
	}
	public Double get平均激活用户数() {
		return 平均激活用户数;
	}
	public void set平均激活用户数(Double 平均激活用户数) {
		this.平均激活用户数 = 平均激活用户数;
	}
	public Double get最大激活用户数() {
		return 最大激活用户数;
	}
	public void set最大激活用户数(Double 最大激活用户数) {
		this.最大激活用户数 = 最大激活用户数;
	}
	public Double get无线掉线率分子() {
		return 无线掉线率分子;
	}
	public void set无线掉线率分子(Double 无线掉线率分子) {
		this.无线掉线率分子 = 无线掉线率分子;
	}
	public Double get上行干扰() {
		return 上行干扰;
	}
	public void set上行干扰(Double 上行干扰) {
		this.上行干扰 = 上行干扰;
	}
	public Double getRRC连接建立成功率() {
		return RRC连接建立成功率;
	}
	public void setRRC连接建立成功率(Double rRC连接建立成功率) {
		RRC连接建立成功率 = rRC连接建立成功率;
	}
	public Double getERAB建立成功率() {
		return ERAB建立成功率;
	}
	public void setERAB建立成功率(Double eRAB建立成功率) {
		ERAB建立成功率 = eRAB建立成功率;
	}
	public Double getERAB掉线率() {
		return ERAB掉线率;
	}
	public void setERAB掉线率(Double eRAB掉线率) {
		ERAB掉线率 = eRAB掉线率;
	}
	public Double get上行流量GB() {
		return 上行流量GB;
	}
	public void set上行流量GB(Double 上行流量gb) {
		上行流量GB = 上行流量gb;
	}
	public Double get下行流量GB() {
		return 下行流量GB;
	}
	public void set下行流量GB(Double 下行流量gb) {
		下行流量GB = 下行流量gb;
	}
	public Double get上行PRB平均利用率() {
		return 上行PRB平均利用率;
	}
	public void set上行PRB平均利用率(Double 上行prb平均利用率) {
		上行PRB平均利用率 = 上行prb平均利用率;
	}
	public Double get下行PRB平均利用率() {
		return 下行PRB平均利用率;
	}
	public void set下行PRB平均利用率(Double 下行prb平均利用率) {
		下行PRB平均利用率 = 下行prb平均利用率;
	}
	public Double get小区可用率() {
		return 小区可用率;
	}
	public void set小区可用率(Double 小区可用率) {
		this.小区可用率 = 小区可用率;
	}
	public Double getRRC最大连接数() {
		return RRC最大连接数;
	}
	public void setRRC最大连接数(Double rRC最大连接数) {
		RRC最大连接数 = rRC最大连接数;
	}
	public Double getRRC连接总数() {
		return RRC连接总数;
	}
	public void setRRC连接总数(Double rRC连接总数) {
		RRC连接总数 = rRC连接总数;
	}
	public Double getENODEB寻呼数() {
		return ENODEB寻呼数;
	}
	public void setENODEB寻呼数(Double eNODEB寻呼数) {
		ENODEB寻呼数 = eNODEB寻呼数;
	}
	public Double getRRC连接建立请求次数() {
		return RRC连接建立请求次数;
	}
	public void setRRC连接建立请求次数(Double rRC连接建立请求次数) {
		RRC连接建立请求次数 = rRC连接建立请求次数;
	}
	public Double getRRC连接建立成功次数() {
		return RRC连接建立成功次数;
	}
	public void setRRC连接建立成功次数(Double rRC连接建立成功次数) {
		RRC连接建立成功次数 = rRC连接建立成功次数;
	}
	public Double getRRC连接建立失败次数() {
		return RRC连接建立失败次数;
	}
	public void setRRC连接建立失败次数(Double rRC连接建立失败次数) {
		RRC连接建立失败次数 = rRC连接建立失败次数;
	}
	public Double getERAB建立请求数() {
		return ERAB建立请求数;
	}
	public void setERAB建立请求数(Double eRAB建立请求数) {
		ERAB建立请求数 = eRAB建立请求数;
	}
	public Double getERAB建立成功数() {
		return ERAB建立成功数;
	}
	public void setERAB建立成功数(Double eRAB建立成功数) {
		ERAB建立成功数 = eRAB建立成功数;
	}
	public Double getERAB建立失败数() {
		return ERAB建立失败数;
	}
	public void setERAB建立失败数(Double eRAB建立失败数) {
		ERAB建立失败数 = eRAB建立失败数;
	}
	public Double get无线掉线率分母() {
		return 无线掉线率分母;
	}
	public void set无线掉线率分母(Double 无线掉线率分母) {
		this.无线掉线率分母 = 无线掉线率分母;
	}
	public Double getERAB掉线次数() {
		return ERAB掉线次数;
	}
	public void setERAB掉线次数(Double eRAB掉线次数) {
		ERAB掉线次数 = eRAB掉线次数;
	}
	public Double getERAB掉线率分母() {
		return ERAB掉线率分母;
	}
	public void setERAB掉线率分母(Double eRAB掉线率分母) {
		ERAB掉线率分母 = eRAB掉线率分母;
	}
	public Double get切换请求次数() {
		return 切换请求次数;
	}
	public void set切换请求次数(Double 切换请求次数) {
		this.切换请求次数 = 切换请求次数;
	}
	public Double get切换成功次数() {
		return 切换成功次数;
	}
	public void set切换成功次数(Double 切换成功次数) {
		this.切换成功次数 = 切换成功次数;
	}
	public Double get切换失败次数() {
		return 切换失败次数;
	}
	public void set切换失败次数(Double 切换失败次数) {
		this.切换失败次数 = 切换失败次数;
	}
	
}
