package cn.huahai.tel.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
/**
 * 
 * @author lijia
 *
 */
@JsonPropertyOrder(value = {
		"DAY1", "HM", "HH","VIP",
		"ENODEBID_CELLID","基站名","ECELLNAME_CN","ECELLNAME","总基站数","流量GB","增幅","无线接通率","无线掉线率","切换成功率",
		"高负荷总个数","RRC加ERAB失败总次数","拥塞小区数","拥塞次数","平均激活用户数","最大激活用户数","支持最大激活用户数",
		"无线掉线率分子","上行干扰","RRC连接建立成功率","ERAB建立成功率"	,
		"ERAB掉线率","上行流量GB","下行流量GB","上行PRB平均利用率","下行PRB平均利用率","小区可用率",
		"RRC最大连接数","RRC连接总数","ENODEB寻呼数","RRC连接建立请求次数","RRC连接建立成功次数",
		"RRC连接建立失败次数","ERAB建立请求数","ERAB建立成功数","ERAB建立失败数","无线掉线率分母",
		"ERAB掉线次数","ERAB掉线率分母","切换请求次数","切换成功次数","切换失败次数","小区可用率分子",
		"小区可用率分母","上行PDCP平均速率KBPS","下行PDCP平均速率KBPS","ENB间切换成功次数",
		"ENB间切换数","ENB间切换成功率","ENB内切换成功次数","ENB内切换数","ENB内切换成功率",
		"用户面PDCP流量","VOLTE话务量","VOLTE接通率","VOLTE掉话率","VOLTE掉话次数",
		"VOLTE掉话分母","ESRVCC切换成功率","ESRVCC切换请求次数","ESRVCC切换成功次数",
		"ESRVCC切换失败次数","ESRVCC切换准备次数","ESRVCC切换失败总次数","VOLTE接入请求次数",
		"VOLTE接入成功次数","VOLTE接入失败次数","BTSVER","OMC","IP","基站状态",
		"链路测试时间","小区管理状态","小区操作状态","日常公司","基站类别","区域","有业务小区数","高用户小区数",
		"无服务小区数","零业务小区数","干扰小区数","断链小区数"
		
		
})

public class DaySummaryBase {
	
	private String tableName; // 表名字
	private String tagName;
	@JsonProperty("DAY1")
	private String DAY1;
	@JsonProperty("HM")
	private String HM;
	@JsonProperty("HH")
	private String HH;
	@JsonProperty("VIP")
	private String VIP;
	@JsonProperty("总基站数")
	private String 总基站数;
	
	@JsonProperty("拥塞次数")
	private String 拥塞次数;

	@JsonProperty("ENODEBID_CELLID")
	private String ENODEBID_CELLID;
	@JsonProperty("基站名")
	private String 基站名;
	
	@JsonProperty("ECELLNAME_CN")
	private String ECELLNAME_CN;
	@JsonProperty("ECELLNAME")
	private String ECELLNAME;
	@JsonProperty("无线接通率")
	private String 无线接通率;
	@JsonProperty("无线掉线率")
	private String 无线掉线率;
	@JsonProperty("切换成功率")
	private String 切换成功率;
	@JsonProperty("流量GB")
	private Double 流量GB;
	@JsonProperty("增幅")
	private Double 增幅;
	@JsonProperty("高负荷总个数")
	private Double 高负荷总个数;
	
	@JsonProperty("RRC加ERAB失败总次数")
	private String RRC加ERAB失败总次数;
	@JsonProperty("拥塞小区数")
	private String 拥塞小区数;
	@JsonProperty("平均激活用户数")
	private String 平均激活用户数;
	@JsonProperty("最大激活用户数")
	private Double 最大激活用户数;
	@JsonProperty("无线掉线率分子")
	private String 无线掉线率分子;
	@JsonProperty("上行干扰")
	private String 上行干扰;
	@JsonProperty("RRC连接建立成功率")
	private String RRC连接建立成功率;
	@JsonProperty("ERAB建立成功率")
	private String ERAB建立成功率;
	@JsonProperty("ERAB掉线率")
	private String ERAB掉线率;
	@JsonProperty("上行流量GB")
	private String 上行流量GB;
	@JsonProperty("下行流量GB")
	private String 下行流量GB;
	@JsonProperty("上行PRB平均利用率")
	private String 上行PRB平均利用率;
	@JsonProperty("下行PRB平均利用率")
	private String 下行PRB平均利用率;
	@JsonProperty("小区可用率")
	private String 小区可用率;
	@JsonProperty("RRC最大连接数")
	private String RRC最大连接数;
	@JsonProperty("RRC连接总数")
	private String RRC连接总数;
	@JsonProperty("ENODEB寻呼数")
	private String ENODEB寻呼数;
	@JsonProperty("RRC连接建立请求次数")
	private String RRC连接建立请求次数;
	@JsonProperty("RRC连接建立成功次数")
	private String RRC连接建立成功次数;
	@JsonProperty("RRC连接建立失败次数")
	private String RRC连接建立失败次数;
	@JsonProperty("ERAB建立请求数")
	private String ERAB建立请求数;
	@JsonProperty("ERAB建立成功数")
	private String ERAB建立成功数;
	@JsonProperty("ERAB建立失败数")
	private String ERAB建立失败数;
	@JsonProperty("无线掉线率分母")
	private String 无线掉线率分母;
	@JsonProperty("ERAB掉线次数")
	private String ERAB掉线次数;
	@JsonProperty("ERAB掉线率分母")
	private String ERAB掉线率分母;
	@JsonProperty("切换请求次数")
	private Double 切换请求次数;
	@JsonProperty("切换成功次数")
	private Double 切换成功次数;
	@JsonProperty("切换失败次数")
	private Double 切换失败次数;
	@JsonProperty("小区可用率分子")
	private String 小区可用率分子;
	@JsonProperty("小区可用率分母")
	private String 小区可用率分母;
	@JsonProperty("上行PDCP平均速率KBPS")
	private String 上行PDCP平均速率KBPS;
	@JsonProperty("下行PDCP平均速率KBPS")
	private String 下行PDCP平均速率KBPS;
	@JsonProperty("ENB间切换成功次数")
	private String ENB间切换成功次数;
	@JsonProperty("ENB间切换数")
	private String ENB间切换数;
	@JsonProperty("ENB间切换成功率")
	private String ENB间切换成功率;
	@JsonProperty("ENB内切换成功次数")
	private String ENB内切换成功次数;
	@JsonProperty("ENB内切换数")
	private String ENB内切换数;
	@JsonProperty("ENB内切换成功率")
	private String ENB内切换成功率;
	@JsonProperty("用户面PDCP流量")
	private String 用户面PDCP流量;
	@JsonProperty("VOLTE接通率")
	private String VOLTE接通率;
	@JsonProperty("VOLTE话务量")
	private String VOLTE话务量;
	@JsonProperty("VOLTE掉话次数")
	private String VOLTE掉话次数;
	@JsonProperty("VOLTE掉话分母")
	private String VOLTE掉话分母;
	@JsonProperty("VOLTE掉话率")
	private String VOLTE掉话率;
	@JsonProperty("ESRVCC切换请求次数")
	private String ESRVCC切换请求次数;
	@JsonProperty("ESRVCC切换成功次数")
	private String ESRVCC切换成功次数;
	@JsonProperty("ESRVCC切换失败次数")
	private String ESRVCC切换失败次数;
	@JsonProperty("ESRVCC切换成功率")
	private String ESRVCC切换成功率;
	@JsonProperty("ESRVCC切换准备次数")
	private String ESRVCC切换准备次数;
	@JsonProperty("ESRVCC切换失败总次数")
	private String ESRVCC切换失败总次数;
	@JsonProperty("VOLTE接入请求次数")
	private String VOLTE接入请求次数;
	@JsonProperty("VOLTE接入成功次数")
	private String VOLTE接入成功次数;
	@JsonProperty("VOLTE接入失败次数")
	private String VOLTE接入失败次数;
	@JsonProperty("ENODEBID")
	private String ENODEBID;

	@JsonProperty("ENODEBID_LCRID")
	private String ENODEBID_LCRID;
	@JsonProperty("CELLID")
	private String CELLID;
	@JsonProperty("LCRID")
	private String LCRID;
	@JsonProperty("ECELLID")
	private String ECELLID;
	@JsonProperty("ENODEBNAME")
	private String ENODEBNAME;

	@JsonProperty("IP")
	private String IP;
	@JsonProperty("BTS_VERSION")
	private String BTS_VERSION;
	@JsonProperty("EARFCN")
	private String EARFCN;
	@JsonProperty("PHYCELLID")
	private String PHYCELLID;
	@JsonProperty("TAC")
	private String TAC;
	@JsonProperty("管理状态")
	private String 管理状态;
	@JsonProperty("操作状态")
	private String 操作状态;
	@JsonProperty("BAND")
	private String BAND;
	@JsonProperty("FREQ")
	private String FREQ;
	@JsonProperty("DLSECTORBFWEIGHTPROFNAME")
	private String DLSECTORBFWEIGHTPROFNAME;
	@JsonProperty("PMAX_DBM")
	private String PMAX_DBM;
	@JsonProperty("每通道发射功率W")
	private String 每通道发射功率W;
	@JsonProperty("CHBW")
	private String CHBW;
	@JsonProperty("ROOTSEQINDEX")
	private String ROOTSEQINDEX;
	@JsonProperty("PRACHCS")
	private String PRACHCS;
	@JsonProperty("PRACHCONFINDEX")
	private String PRACHCONFINDEX;
	@JsonProperty("ULRSCS")
	private String ULRSCS;
	@JsonProperty("GRPASSIGPUSCH")
	private String GRPASSIGPUSCH;
	@JsonProperty("CELLRESELPRIO")
	private String CELLRESELPRIO;
	@JsonProperty("支持最大激活用户数")
	private String 支持最大激活用户数;
	@JsonProperty("DRX")
	private String DRX;
	@JsonProperty("CA")
	private String CA;
	@JsonProperty("CELL_OPERATIONAL_STATE")
	private String CELL_OPERATIONAL_STATE;
	@JsonProperty("OMC")
	private String OMC;
	@JsonProperty("LONGITUDE_OMC1")
	private String LONGITUDE_OMC1;
	@JsonProperty("LATITUDE_OMC1")
	private String LATITUDE_OMC1;
	@JsonProperty("ENODEBNAME_CN")
	private String ENODEBNAME_CN;

	@JsonProperty("基站类型")
	private String 基站类型;
	@JsonProperty("LONGITUDE")
	private String LONGITUDE;
	@JsonProperty("LATITUDE")
	private String LATITUDE;
	@JsonProperty("AZIMUTH")
	private String AZIMUTH;
	@JsonProperty("天线挂高")
	private String 天线挂高;
	@JsonProperty("区域")
	private String 区域;
	@JsonProperty("覆盖区域")
	private String 覆盖区域;
	@JsonProperty("日常公司")
	private String 日常公司;

	@JsonProperty("VIP类型")
	private String VIP类型;
	@JsonProperty("代维")
	private String 代维;
	@JsonProperty("基站类别")
	private String 基站类别;
	@JsonProperty("覆盖单位")
	private String 覆盖单位;
	@JsonProperty("NCELLNO")
	private String NCELLNO;
	@JsonProperty("PS")
	private String PS;
	@JsonProperty("DATETIME")
	private String DATETIME;
	@JsonProperty("状态")
	private String 状态;


	@JsonProperty("基站状态")
	private String 基站状态;
	@JsonProperty("链路测试时间")
	private String 链路测试时间;
	@JsonProperty("小区管理状态")
	private String 小区管理状态;
	@JsonProperty("小区操作状态")
	private String 小区操作状态;

	@JsonProperty("DATETIME1")
	private String DATETIME1;
	
	@JsonProperty("NEWEST")
	private String NEWEST;
	@JsonProperty("OCCTIME")
	private String OCCTIME;
	@JsonProperty("ID")
	private String ID;
	@JsonProperty("DEBUGIP")
	private String DEBUGIP;
	

	@JsonProperty("有业务小区数")
	private Double 有业务小区数;
	@JsonProperty("高用户小区数")
	private Double 高用户小区数;
	@JsonProperty("无服务小区数")
	private Double 无服务小区数;
	@JsonProperty("零业务小区数")
	private Double 零业务小区数;
	@JsonProperty("干扰小区数")
	private Double 干扰小区数;
	@JsonProperty("断链小区数")
	private Double 断链小区数;
	@Override
	public String toString() {
		return "DaySummaryBase [tableName=" + tableName + ", tagName=" + tagName + ", DAY1=" + DAY1 + ", HM=" + HM
				+ ", HH=" + HH + ", VIP=" + VIP + ", 总基站数=" + 总基站数  + ", 拥塞次数=" + 拥塞次数
				+ ", ENODEBID_CELLID=" + ENODEBID_CELLID + ", 基站名=" + 基站名 + ", ECELLNAME_CN=" + ECELLNAME_CN
				+ ", ECELLNAME=" + ECELLNAME + ", 无线接通率=" + 无线接通率 + ", 无线掉线率=" + 无线掉线率 + ", 切换成功率=" + 切换成功率 + ", 流量GB="
				+ 流量GB + ", 增幅=" + 增幅 + ", 高负荷总个数=" + 高负荷总个数 + ", RRC加ERAB失败总次数=" + RRC加ERAB失败总次数 + ", 拥塞小区数=" + 拥塞小区数
				+ ", 平均激活用户数=" + 平均激活用户数 + ", 最大激活用户数=" + 最大激活用户数 + ", 无线掉线率分子=" + 无线掉线率分子 + ", 上行干扰=" + 上行干扰
				+ ", RRC连接建立成功率=" + RRC连接建立成功率 + ", ERAB建立成功率=" + ERAB建立成功率 + ", ERAB掉线率=" + ERAB掉线率 + ", 上行流量GB="
				+ 上行流量GB + ", 下行流量GB=" + 下行流量GB + ", 上行PRB平均利用率=" + 上行PRB平均利用率 + ", 下行PRB平均利用率=" + 下行PRB平均利用率
				+ ", 小区可用率=" + 小区可用率 + ", RRC最大连接数=" + RRC最大连接数 + ", RRC连接总数=" + RRC连接总数 + ", ENODEB寻呼数=" + ENODEB寻呼数
				+ ", RRC连接建立请求次数=" + RRC连接建立请求次数 + ", RRC连接建立成功次数=" + RRC连接建立成功次数 + ", RRC连接建立失败次数=" + RRC连接建立失败次数
				+ ", ERAB建立请求数=" + ERAB建立请求数 + ", ERAB建立成功数=" + ERAB建立成功数 + ", ERAB建立失败数=" + ERAB建立失败数 + ", 无线掉线率分母="
				+ 无线掉线率分母 + ", ERAB掉线次数=" + ERAB掉线次数 + ", ERAB掉线率分母=" + ERAB掉线率分母 + ", 切换请求次数=" + 切换请求次数 + ", 切换成功次数="
				+ 切换成功次数 + ", 切换失败次数=" + 切换失败次数 + ", 小区可用率分子=" + 小区可用率分子 + ", 小区可用率分母=" + 小区可用率分母 + ", 上行PDCP平均速率KBPS="
				+ 上行PDCP平均速率KBPS + ", 下行PDCP平均速率KBPS=" + 下行PDCP平均速率KBPS + ", ENB间切换成功次数=" + ENB间切换成功次数 + ", ENB间切换数="
				+ ENB间切换数 + ", ENB间切换成功率=" + ENB间切换成功率 + ", ENB内切换成功次数=" + ENB内切换成功次数 + ", ENB内切换数=" + ENB内切换数
				+ ", ENB内切换成功率=" + ENB内切换成功率 + ", 用户面PDCP流量=" + 用户面PDCP流量 + ", VOLTE接通率=" + VOLTE接通率 + ", VOLTE话务量="
				+ VOLTE话务量 + ", VOLTE掉话次数=" + VOLTE掉话次数 + ", VOLTE掉话分母=" + VOLTE掉话分母 + ", VOLTE掉话率=" + VOLTE掉话率
				+ ", ESRVCC切换请求次数=" + ESRVCC切换请求次数 + ", ESRVCC切换成功次数=" + ESRVCC切换成功次数 + ", ESRVCC切换失败次数=" + ESRVCC切换失败次数
				+ ", ESRVCC切换成功率=" + ESRVCC切换成功率 + ", ESRVCC切换准备次数=" + ESRVCC切换准备次数 + ", ESRVCC切换失败总次数=" + ESRVCC切换失败总次数
				+ ", VOLTE接入请求次数=" + VOLTE接入请求次数 + ", VOLTE接入成功次数=" + VOLTE接入成功次数 + ", VOLTE接入失败次数=" + VOLTE接入失败次数
				+ ", ENODEBID=" + ENODEBID + ", ENODEBID_LCRID=" + ENODEBID_LCRID + ", CELLID=" + CELLID + ", LCRID="
				+ LCRID + ", ECELLID=" + ECELLID + ", ENODEBNAME=" + ENODEBNAME + ", IP=" + IP + ", BTS_VERSION="
				+ BTS_VERSION + ", EARFCN=" + EARFCN + ", PHYCELLID=" + PHYCELLID + ", TAC=" + TAC + ", 管理状态=" + 管理状态
				+ ", 操作状态=" + 操作状态 + ", BAND=" + BAND + ", FREQ=" + FREQ + ", DLSECTORBFWEIGHTPROFNAME="
				+ DLSECTORBFWEIGHTPROFNAME + ", PMAX_DBM=" + PMAX_DBM + ", 每通道发射功率W=" + 每通道发射功率W + ", CHBW=" + CHBW
				+ ", ROOTSEQINDEX=" + ROOTSEQINDEX + ", PRACHCS=" + PRACHCS + ", PRACHCONFINDEX=" + PRACHCONFINDEX
				+ ", ULRSCS=" + ULRSCS + ", GRPASSIGPUSCH=" + GRPASSIGPUSCH + ", CELLRESELPRIO=" + CELLRESELPRIO
				+ ", 支持最大激活用户数=" + 支持最大激活用户数 + ", DRX=" + DRX + ", CA=" + CA + ", CELL_OPERATIONAL_STATE="
				+ CELL_OPERATIONAL_STATE + ", OMC=" + OMC + ", LONGITUDE_OMC1=" + LONGITUDE_OMC1 + ", LATITUDE_OMC1="
				+ LATITUDE_OMC1 + ", ENODEBNAME_CN=" + ENODEBNAME_CN + ", 基站类型=" + 基站类型 + ", LONGITUDE=" + LONGITUDE
				+ ", LATITUDE=" + LATITUDE + ", AZIMUTH=" + AZIMUTH + ", 天线挂高=" + 天线挂高 + ", 区域=" + 区域 + ", 覆盖区域=" + 覆盖区域
				+ ", 日常公司=" + 日常公司 + ", VIP类型=" + VIP类型 + ", 代维=" + 代维 + ", 基站类别=" + 基站类别 + ", 覆盖单位=" + 覆盖单位
				+ ", NCELLNO=" + NCELLNO + ", PS=" + PS + ", DATETIME=" + DATETIME + ", 状态=" + 状态 + ", 基站状态=" + 基站状态
				+ ", 链路测试时间=" + 链路测试时间 + ", 小区管理状态=" + 小区管理状态 + ", 小区操作状态=" + 小区操作状态 + ", DATETIME1=" + DATETIME1
				+ ", NEWEST=" + NEWEST + ", OCCTIME=" + OCCTIME + ", ID=" + ID + ", DEBUGIP=" + DEBUGIP + ", 有业务小区数="
				+ 有业务小区数 + ", 高用户小区数=" + 高用户小区数 + ", 无服务小区数=" + 无服务小区数 + ", 零业务小区数=" + 零业务小区数 + ", 干扰小区数=" + 干扰小区数
				+ ", 断链小区数=" + 断链小区数 + "]";
	}
	
	
	
	


}
