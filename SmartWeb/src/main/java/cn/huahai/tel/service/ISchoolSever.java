package cn.huahai.tel.service;

import cn.huahai.tel.bean.AllNetworkBase;
import cn.huahai.tel.bean.DaySummaryBase;

public interface ISchoolSever {
	/**
	 * 查询所有分钟级最大激活用户数
	 * @param datas
	 * @param stime
	 * @return
	 */
	DaySummaryBase[] selectDataByMaxAc(String datas, String stime,String site,String tagName);
	
	
	DaySummaryBase[] selectDataByVip(String tableName, String datas,String tagName);
	//无服务小区
	DaySummaryBase[] selectDataByNotCell(String tableName,String site,String tagName);
	//流量GB
	DaySummaryBase[] selectDataByflow(String tableName,String site,String tagName);

	DaySummaryBase[] selectDataByCell(String tableName,String site,String tagName);
	
	DaySummaryBase[] selectDataByLoadCell(String tableName,String site, String tagName);
	
	//新区域
	DaySummaryBase[] selectDataByArea(String tableName, String datas, String tagName);

	//有业务小区
	DaySummaryBase[] selectDataByServiceCell(String tableName, String site, String tagName);

	//高用户小区
	DaySummaryBase[] selectDataByHighCell(String tableName, String site, String tagName);

	//无服务小区
	DaySummaryBase[] selectDataByNotGbCell(String tableName, String site, String tagName);


	DaySummaryBase[] selectDataByDisturbCell(String tableName, String site, String tagName);


	DaySummaryBase[] selectDataAllCell(String tagName, String tableName);


	DaySummaryBase[] selectDataAllServiceCell(String tagName, String tableName);


	DaySummaryBase[] selectDataAllHightCell(String tagName, String tableName);


	DaySummaryBase[] selectDataAllNotGbCell(String tagName, String tableName);


	DaySummaryBase[] selectDataAllDisturbCell(String tagName, String tableName);


	DaySummaryBase[] selectDataByLinkCell(String tableName, String site, String tagName);


	DaySummaryBase[] selectDataLinkCell(String tableName, String tagName);

}
