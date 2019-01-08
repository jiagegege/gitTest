package cn.huahai.tel.mapper;

import org.apache.ibatis.annotations.Param;

import cn.huahai.tel.bean.AllNetworkBase;
import cn.huahai.tel.bean.DaySummaryBase;
/**
 * 校园Mapper
 * @author lijia
 *
 */
public interface SchoolMapper {
	
	DaySummaryBase[] selectDataByMaxAc(@Param("tableName") String tableName,
			@Param("datas") String datas,
			@Param("site") String site,
			@Param("tagName")String tagName);
	
	
	DaySummaryBase[] selectDataByVip(@Param("tableName")String tableName, 
			@Param("datas")String datas,
			@Param("tagName")String tagName);


	DaySummaryBase[] selectDataByNotCell(@Param("tableName")String tableName,
			@Param("site")String site,
			@Param("tagName")String tagName);


	DaySummaryBase[] selectDataByflow(@Param("tableName")String tableName,
			@Param("site")String site,
			@Param("tagName")String tagName);


	DaySummaryBase[] selectDataByCell(@Param("tableName")String tableName,
			@Param("site")String site,
			@Param("tagName")String tagName);


	DaySummaryBase[] selectDataByLoadCell(@Param("tableName")String tableName,
			@Param("site")String site,
			@Param("tagName")String tagName);


	DaySummaryBase[] selectDataByArea(@Param("tableName")String tableName, 
			@Param("site")String site, 
			@Param("tagName")String tagName);


	DaySummaryBase[] selectDataByServiceCell(@Param("tableName")String tableName, 
			@Param("site")String site,
			@Param("tagName")String tagName);


	DaySummaryBase[] selectDataByHighCell(@Param("tableName")String tableName, 
			@Param("site")String site,
			@Param("tagName")String tagName);


	DaySummaryBase[] selectDataByNotGbCell(@Param("tableName")String tableName, 
			@Param("site")String site,
			@Param("tagName")String tagName);


	DaySummaryBase[] selectDataByDisturbCell(@Param("tableName")String tableName, 
			@Param("site")String site,
			@Param("tagName")String tagName);

	//全部区域
	DaySummaryBase[] selectDataAllCell(@Param("tagName") String tagName,
			@Param("tableName")String tableName);

	//有业务小区
	DaySummaryBase[] selectDataAllServiceCell(@Param("tagName") String tagName,
			@Param("tableName")String tableName);

	//高业务小区
	DaySummaryBase[] selectDataAllHightCell(@Param("tagName") String tagName,
			@Param("tableName")String tableName);
	//无服务小区
	DaySummaryBase[] selectDataAllNotGbCell(@Param("tagName") String tagName,
			@Param("tableName")String tableName);
	//干扰小区
	DaySummaryBase[] selectDataAllDisturbCell(@Param("tagName") String tagName,
			@Param("tableName")String tableName);


	DaySummaryBase[] selectDataByLinkCell(@Param("tableName")String tableName, 
			@Param("site")String site,
			@Param("tagName")String tagName);


	DaySummaryBase[] selectDataLinkCell(@Param("tagName") String tagName,
			@Param("tableName")String tableName);
	
}
