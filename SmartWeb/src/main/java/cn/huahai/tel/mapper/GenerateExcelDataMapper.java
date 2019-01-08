package cn.huahai.tel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huahai.tel.bean.AllNetworkBase;
import cn.huahai.tel.bean.CellInfoBase;
import cn.huahai.tel.bean.DayAllNetworkBase;
import cn.huahai.tel.bean.DaySummaryBase;
import cn.huahai.tel.bean.HourAllNetWorkBase;
import cn.huahai.tel.bean.UnCellAllNetBase;

/**
 * 筛选出excel数据相关
 * @author lijia
 *
 */
public interface GenerateExcelDataMapper {
	/**
	 * 根据条件删选cell 小区表数据
	 * @param resourceTableName   cell小区数据
	 * @param conditionTableName   依据的条件（存放小区id的表明）
	 * @return 小区数据 cn.huahai.tel.bean.CellInfoBase
	 * 
	 */
	CellInfoBase[] generateCellDataExcel(@Param("resourceTableName") String resourceTableName,
			@Param("conditionTableName") String conditionTableName);
	/**
	 * 查询vip小区小区数据
	 * @param resourceTableName  cell小区数据
	 * @return 小区数据 
	 */
	CellInfoBase[] generateVIPCellDataExcel(@Param("resourceTableName") String resourceTableName);
	/**
	 * 数据测试 打印出表的所有字段
	 * @param tablename 查询的表名称
	 * @return 表中的所有字段
	 */
	List<String> getMapList(@Param("tablename") String tablename);
	/**
	 * 筛选出vip小区的全网数据
	 * @param tablename 查询的表名称
	 * @return 表中vip的数据
	 */
	AllNetworkBase selectVIPAllNetWork(@Param("tablename") String tablename);
	/**
	 * 筛选出重点小区的全网信息
	 * @param resourceTableName 数据源（表明）
	 * @param conditionTableName 存放小区id的表明
	 * @return  联表查询之后的数据
	 */
	AllNetworkBase selectKeyPonitAllNetWork(@Param("resourceTableName") String resourceTableName,
			@Param("conditionTableName") String conditionTableName);
	
	/**
	 * 筛选出vip（小时级）小区的全网数据
	 * @param tablename 查询的表名称
	 * @return （小时级）表中vip的数据
	 */
	HourAllNetWorkBase selectVIPHourAllNetWork(@Param("tablename") String tablename);
	
	/**
	 * 筛选出重点小区（小时级）的全网信息
	 * @param resourceTableName 数据源（表名）
	 * @param conditionTableName 存放小区id的表名
	 * @return  联表查询之后的数据（小时级）
	 */
	HourAllNetWorkBase selectKeyPonitHourAllNetWork(@Param("resourceTableName") String resourceTableName,
			@Param("conditionTableName") String conditionTableName);
	
	/**
	 * 筛选出所有的（小时级）小区的全网数据
	 * @param tablename 查询的表名称
	 * @return （小时级）表中的数据
	 */
	HourAllNetWorkBase selectALLHourAllNetWork(@Param("tablename") String tablename);
	
	/**
	 * 筛选出vip（天级）小区的全网数据
	 * @param tablename 查询的表名称
	 * @return （天级）表中vip的数据
	 */
	DayAllNetworkBase selectVIPDayAllNetWork(@Param("tablename") String tablename);
	
	/**
	 * 筛选出重点小区（天级）的全网信息
	 * @param resourceTableName 数据源（表名）
	 * @param conditionTableName 存放小区id的表名
	 * @return  联表查询之后的数据（天级）
	 */
	DayAllNetworkBase selectKeyPonitDayAllNetWork(@Param("resourceTableName") String resourceTableName,
			@Param("conditionTableName") String conditionTableName);
	
	/**
	 * 筛选出所有的（天级）小区的全网数据
	 * @param tablename 查询的表名称
	 * @return （天级）表中的数据
	 */
	DayAllNetworkBase selectALLDayAllNetWork(@Param("tablename") String tablename);
	
	/**
	 * 筛选出所有的15分钟的VIP无服务小区
	 * @param tablename 查询的表名称
	 * @return 无服务小区(分钟级) 
	 */	
	UnCellAllNetBase[] generateVIPUnCellDataExcel(@Param("tablename") String tablename);
	
	/**
	 * 筛选出所有的15分钟的无服务小区
	 * @param tablename 查询的表名称
	 * @return 无服务小区(分钟级) 
	 */	
	UnCellAllNetBase[] generateUnCellDataExcel(@Param("tablename") String tablename);
	
	/**
	 * 筛选出所有的（天级）VIP小区总数的全网数据
	 * @param tablename 查询的表名称
	 * @return （天级）表中的数据
	 */
	DayAllNetworkBase selectVIPDaySumNetWork(String string);
	
	/**重点小区
	 * 筛选出所有的15分钟的无服务小区
	 * @param tablename 查询的表名称 
	 * @return 无服务小区(分钟级) 
	 */	
	
	UnCellAllNetBase[] selectKeyPonitMinUnAllNetWork(@Param("resourceTableName")String resourceTableName, @Param("conditionTableName")String conditionTableName);
	
	DaySummaryBase[] generateSchoolExcel(String string);
	
	
	
}
