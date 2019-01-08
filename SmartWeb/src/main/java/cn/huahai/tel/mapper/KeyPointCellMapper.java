package cn.huahai.tel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huahai.tel.bean.DaySummaryBase;
import cn.huahai.tel.bean.TopCellworkBase;

/**
 * 重点小区设置相关
 * @author lijia
 *
 */
public interface KeyPointCellMapper {
	
	/**
	 * 根据tagname查找tablename
	 * @param tagname 组名称
	 * @return 表名称
	 */
	String selectTablenameByTagname(@Param("tagname") String tagname);
	/**
	 * 根据tagname 删除对应关系
	 * @param tagname 组名称
	 */
	void deleteMapping(@Param("tagname") String tagname);
	/**
	 * 插入表名称 和 组名称 的对应关系
	 * @param tablename 表名称
	 * @param tagname 组名称
	 */
	void insertKeyPointCell(@Param("tablename") String tablename,@Param("tagname") String tagname);
	/**
	 * 查询所有的组名称
	 * @return 组名称集合
	 */
	List<String> selectAllMapping();
	/**
	 * 创建重点小区表
	 * @param tablename 表名称
	 */
	void createKeyPointCell(@Param("tablename") String tablename);
	/**
	 * 删除重点小区表
	 * @param tablename 表名称
	 */
	void deletekeypointTable(@Param("tablename") String tablename);
	/**
	 * 插入小区数据
	 * @param tablename  表名称
	 * @param cellList 小区id集合
	 */
	void insertKeyPointCellName(@Param("tablename") String tablename,
			@Param("cellList") List<String> cellList);
	/**
	 * 查询tagname是否存在（重点小区组名称）
	 * @param tagname  tag名称
	 * @return 组的数量
	 */
	Integer selectTagName(@Param("tagname") String tagname);
	/**
	 * 根据范围查找top小区信息
	 * @param cellInfoTablename 全部小区信息
	 * @param regTablename 查找范围
	 * @return 规定范围内的小区top信息
	 */
	TopCellworkBase[] selectKeyPontCellInfo(@Param("cellInfoTablename") String cellInfoTablename,
			@Param("regTablename") String regTablename);
	
	/**
	 * 查询VIP小区信息
	 * @param tablename  表名称
	 * @return vip小区信息
	 */
	TopCellworkBase[] selectVIPCellInfo(@Param("tablename") String tablename);
	
	
	DaySummaryBase[] selectVipSumInfo(@Param("tablename") String tablename, Integer row);
	
	/**
	 * 查询分钟级VIP小区信息总数
	 * @param tablename
	 * @return
	 */
	DaySummaryBase selectVIPCellSumInfo(@Param("tablename") String tablename);
	/**
	 * 统计重点小区
	 * @param cellInfoTablename
	 * @param regTablename
	 * @return
	 */
	DaySummaryBase[] selectKeyPointSumCellInfo(@Param("cellInfoTablename") String cellInfoTablename,
			@Param("scellInfoTablename") String scellInfoTablename,
			@Param("regTablename") String regTablename,
			@Param("field") String field);
	/**
	 * 汇总小时级的全部小区
	 * @param tableName
	 * @return
	 */
	DaySummaryBase[] selectAllHourSumCell( @Param("tableName") String tableName,@Param("stableName") String stableName);
	/**
	 * 汇总小时级的VIP小区
	 * @param tableName
	 * @return
	 */
	DaySummaryBase selectVIPHourSumCell(@Param("tableName") String tableName);
	/**
	 * 汇总小时级的重点小区
	 * @param tableName
	 * @param regTablename
	 * @return
	 */
	DaySummaryBase selectKeyPointHourSumCell(@Param("cellInfoTablename") String cellInfoTablename, 
			@Param("regTablename") String regTablename);
	/**
	 * 汇总天级的全部小区
	 * @param tableName
	 * @return
	 */
	DaySummaryBase[] selectAllDaySumCell(@Param("tableName") String tableName,
			@Param("stableName") String stableName);
	/**
	 * 汇总天级的 VIP小区
	 * @param tableName
	 * @return
	 */
	DaySummaryBase selectVIPDaySumCell(@Param("tableName") String tableName);
	/**
	 * 汇总天级的重点小区
	 * @param tableName
	 * @param regTablename
	 * @return
	 */
	DaySummaryBase[] selectPointKeyDaySumCell(@Param("cellInfoTablename") String cellInfoTablename, 
			@Param("scellInfoTablename") String scellInfoTablename,
			@Param("regTablename")String regTablename);
	
	/**
	 * 新汇总统计 分钟级
	 * @param tableName
	 * @param stableName
	 * @param field
	 * @return
	 */
	DaySummaryBase[] selectNewAllSumCell(@Param("tableName")String tableName, 
			@Param("stableName")String stableName, 
			@Param("field")String field);
	/**
	 * 新汇总统计 小时级
	 * @param tableName
	 * @param stableName
	 * @return
	 */
	DaySummaryBase[] selectAllHourNewSumCell(@Param("tableName")String tableName, 
			@Param("stableName")String stableName);
	/**
	 * 新汇总统计 天级
	 * @param tableName
	 * @param stableName
	 * @return
	 */
	DaySummaryBase[] selectAllDayNewSumCell(@Param("tableName")String tableName, 
			@Param("stableName")String stableName);
	/**
	 * 新汇总统计 分钟级/小时级重点小区
	 * @param tableName
	 * @param stableName
	 * @param regTablename
	 * @param field 为HM是分钟,为HH是小时
	 * @return
	 */
	DaySummaryBase[] selectKeyNewSumCellInfo(@Param("tableName")String tableName, 
			@Param("stableName")String stableName, 
			@Param("regTablename")String regTablename, 
			@Param("field")String field);
	/**
	 * 新汇总统计 天级重点小区
	 * @param tableName
	 * @param regTablename
	 * @return
	 */
	DaySummaryBase[] selectKeyDayNewSumCell(
			@Param("tableName")String tableName, 
			@Param("regTablename")String regTablename);
	
	DaySummaryBase[] selecttagNameData(@Param("tagName")String tagName,
			@Param("tableName")String tableName);
	
	void updateMappingByTagName(@Param("tagName")String tagName);
	
	boolean updateCellMapping(@Param("pinyintagName")String pinyintagName, 
			@Param("cellList") List<String> cellList);
	List<String> selectDataByECellId(@Param("pinyintagName")String pinyintagName);
	void deleteData(@Param("pinyintagName")String pinyintagName);
	
	
}
