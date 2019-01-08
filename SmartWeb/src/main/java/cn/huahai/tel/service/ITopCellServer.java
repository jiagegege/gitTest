package cn.huahai.tel.service;

import org.apache.ibatis.annotations.Param;

import cn.huahai.tel.bean.DaySummaryBase;
import cn.huahai.tel.bean.DayTopCellworkBase;
import cn.huahai.tel.bean.HourTopCellworkBase;
import cn.huahai.tel.bean.TopCellworkBase;

/**
 * 查询小区数据
 * @author lizhuodong
 *
 */
public interface ITopCellServer {
	/**
	 * 查询小区所有数据 前20条
	 * @param tableName 表名称
	 * @param field 字段
	 * @return  小区所有数据
	 */
	TopCellworkBase[] selectAllTopCell(String tableName,String field);
	
	/**
	 * 查询小区小时级数据所有数据 前20条
	 * @param tableName 表名称
	 * @return  小区所有数据
	 */
	HourTopCellworkBase[] selectAllHourTopCell(String tableName);
	
	/**
	 * 查询小时级VIP小区级数据 前20条
	 * @param tableName 有全部数据的表
	 * @return 小时级vip数据
	 */
	HourTopCellworkBase[] selectVIPHourTopCell(String tableName);
	
	/**
	 * 查询小时级重点小区级数据 前20条
	 * @param cellInfoTablename 主表-所有信息所在的表
	 * @param regTablename 小区信息所在的表
	 * @return 小时级重点小区数据
	 */
	HourTopCellworkBase[] selectKeyPointHourTopCell(String cellInfoTablename,
			String regTablename);
	/**
	 * 根据表名查询全部小区数据
	 * @param tableName 表名称
	 * @return 天级的top小区
	 */
	DayTopCellworkBase[] selectAllDayTopCell(String tableName);
	/**
	 * 根据表名和重点小区范围所在的表联表查询，查询重点小区数据
	 * @param cellInfoTablename 全部小区数据所在的表
	 * @param regTablename 重点小区范围所在的表
	 * @return 天级的重点小区数据
	 */
	DayTopCellworkBase[] selectPointKeyDayTopCell(String cellInfoTablename,
			String regTablename);
	/**
	 * 查询自身表中vip字段为VIP的小区数据
	 * @param tableName 全部小区数据所在的表名称
	 * @return 查询vip数据
	 */
	DayTopCellworkBase[] selectVIPDayTopCell(String tableName);
	
	/**
	 * 查找统计总小区的数据
	 * @param tableName
	 * @param field
	 * @param s 
	 * @return
	 */
	DaySummaryBase[] selectAllSumCell(String tableName, String field, String stableName);

	
	
}
