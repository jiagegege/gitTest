package cn.huahai.tel.mapper;

import org.apache.ibatis.annotations.Param;

import cn.huahai.tel.bean.DaySummaryBase;
import cn.huahai.tel.bean.DayTopCellworkBase;
import cn.huahai.tel.bean.HourTopCellworkBase;
import cn.huahai.tel.bean.TopCellworkBase;

/**
 * top小区相关
 * @author lijia
 *
 */
public interface TopCellworkBaseMapper {
	/**
	 * 查询出前20条信息  ORDER BY RRC加ERAB失败总次数 desc
	 * @param tablename 表名称
	 * @param field 字段
	 * @return 小区信息
	 */
	TopCellworkBase[] selectAllTopCell(@Param("tablename")String tablename,
			@Param("field")String field);
	
	/**
	 * 查询出前小时级别20条信息  ORDER BY RRC加ERAB失败总次数 desc
	 * @param tablename 表名称
	 * @return hour小区信息
	 */
	HourTopCellworkBase[] selectAllHourTopCell(@Param("tablename")String tablename);
	
	/**
	 * 查询出前小时级别所有的信息  ORDER BY RRC加ERAB失败总次数 desc
	 * @param tablename 表名称
	 * @return hour小区信息
	 */
	HourTopCellworkBase[] selectAllAllNetHourTopCell(@Param("tablename")String tablename);
	/**
	 * 查询前天级前20条数据 ORDER BY RRC加ERAB失败总次数 desc
	 * @param tablename 表名称
	 * @return Day小区信息
	 */
	DayTopCellworkBase[] selectAllDayTopCell(@Param("tablename") String tablename);
	
	/**
	 * 查询前天级所有数据 ORDER BY RRC加ERAB失败总次数 desc
	 * @param tablename 表名称
	 * @return Day小区信息
	 */
	DayTopCellworkBase[] selectAllAllNetDayTopCell(@Param("tablename") String tablename);
	
	/**
	 *  查询出前小时级别VIP,20条信息  ORDER BY RRC加ERAB失败总次数 desc
	 * @param tablename 表名称
	 * @return 小时级Vip小区top信息
	 */
	HourTopCellworkBase[] selectVIPHourTopCell(@Param("tablename")String tablename);
	
	/**
	 *  查询出全部小时级别VIP ORDER BY RRC加ERAB失败总次数 desc
	 * @param tablename 表名称
	 * @return 小时级Vip小区top信息
	 */
	HourTopCellworkBase[] selectAllVIPHourTopCell(@Param("tablename")String tablename);
	
	/**
	 * 查询前天级VIP的20条数据 ORDER BY RRC加ERAB失败总次数 desc
	 * @param tablename 表名称
	 * @return Day小区信息
	 */
	DayTopCellworkBase[] selectVIPDayTopCell(@Param("tablename") String tablename);
	/**
	 * 查询前天级VIP的所有数据 ORDER BY RRC加ERAB失败总次数 desc
	 * @param tablename 表名称
	 * @return Day小区信息
	 */
	DayTopCellworkBase[] selectAllVIPDayTopCell(@Param("tablename") String tablename);
	
	
	/**
	 *  查询出前小时级别重点小区,20条信息  ORDER BY RRC加ERAB失败总次数 desc
	 * @param cellInfoTablename 小时级小区信息表
	 * @param regTablename 存储小区enode_id的正则表
	 * @return 小时级重点小区top信息
	 */
	HourTopCellworkBase[] selectPointKeyHourTopCell(@Param("cellInfoTablename") String cellInfoTablename,
			@Param("regTablename") String regTablename);
	
	/**
	 *  查询出前小时级别重点小区所有信息  ORDER BY RRC加ERAB失败总次数 desc
	 * @param cellInfoTablename 小时级小区信息表
	 * @param regTablename 存储小区enode_id的正则表
	 * @return 小时级重点小区top信息
	 */
	HourTopCellworkBase[] selectAllPointKeyHourTopCell(@Param("cellInfoTablename") String cellInfoTablename,
			@Param("regTablename") String regTablename);
	
	
	
	/**
	 * 查询前天级重点小区的20条数据 ORDER BY RRC加ERAB失败总次数 desc
 	 * @param cellInfoTablename 小时级小区信息表
	 * @param regTablename 存储小区enode_id的正则表
	 * @return Day小区信息
	 */
	DayTopCellworkBase[] selectPointKeyDayTopCell(@Param("cellInfoTablename") String cellInfoTablename,
			@Param("regTablename") String regTablename);
	
	
	/**
	 * 查询前天级重点小区的所有数据 ORDER BY RRC加ERAB失败总次数 desc
 	 * @param cellInfoTablename 小时级小区信息表
	 * @param regTablename 存储小区enode_id的正则表
	 * @return Day小区信息
	 */
	DayTopCellworkBase[] selectAllPointKeyDayTopCell(@Param("cellInfoTablename") String cellInfoTablename,
			@Param("regTablename") String regTablename);
	/**
	 * 汇总统计
	 * @param tableName
	 * @param field
	 * @return
	 */
	DaySummaryBase[] selectAllSumCell(@Param("tableName")String tableName,@Param("stableName")String stableName, 
			@Param("field") String field);
	
}
