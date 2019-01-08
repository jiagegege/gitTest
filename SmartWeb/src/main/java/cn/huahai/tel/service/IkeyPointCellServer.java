package cn.huahai.tel.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import cn.huahai.tel.bean.DaySummaryBase;
import cn.huahai.tel.bean.TopCellworkBase;
/**
 * 小区组设置相关
 * @author lizhuodong
 *
 */
public interface IkeyPointCellServer {
	/**
	 * 插入小区组，和表名称的对应关系
	 * @param tablename 表名称
	 * @param tagname 组名称
	 */
	void insertKeyPointCell(String tablename,String tagname);
	/**
	 * 创建重点小区表
	 * @param tablename 表名称
	 */
	void createKeyPointCell(String tablename);
	/**
	 * 给小区组表中批量添加小区
	 * @param tablename 表名称
	 * @param cellList 小区id数组
	 */
	void insertKeyPointCellName(String tablename,
			List<String> cellList);
	/**
	 * 添加小区组<br>
	 * 1.添加mapping映射<br>
	 * 2.创建小区组表<br>
	 * 3.给小区表中添加数据<br>
	 * @param tablename 表名称
	 * @param tagname 组名称
	 * @param cellList 小区id数组
	 */
	void addCellMapping(String tablename,String tagname,
			List<String> cellList);
	/**
	 * 查看组名称是否存在
	 * @param tagname 组名称
	 * @return 组名称是否存在
	 */
	boolean selectTagNameExists(String tagname);
	/**
	 * 查询所有的组名称
	 * @return 所有的组名称
	 */
	List<String> selectAllMapping();
	/**
	 * 删除小区组<br>
	 * 1.删除mapping映射<br>
	 * 2.删除小区组表<br>
	 * @param tagname 小区组名称
	 */
	void deleteTagname(String tagname);
	/**
	 * 根据范围查找top小区信息
	 * @param cellInfoTablename 全部小区信息
	 * @param regTablename 查找范围
	 * @return 规定范围内的小区top信息
	 */
	TopCellworkBase[] selectKeyPontCellInfo(@Param("cellInfoTablename") String cellInfoTablename,
			@Param("regTablename") String regTablename);
	
	/**
	 *  查询vip小区信息
	 * @param tablename 表名称
	 * @return vip小区信息
	 */
	TopCellworkBase[] selectVipCellInfo(String tablename);
	
	DaySummaryBase[] selectVipSumInfo(String tablename, Integer row);
	
	/**
	 * 查询VIP小区信息总数
	 * @param tablename
	 * @return
	 */
	DaySummaryBase selectVipCellSumInfo(String tablename);
	/**
	 * 
	 * @param cellInfoTablename 全部小区信息
	 * @param regTablename 查找范围
	 * @return
	 */
	DaySummaryBase[] selectKeyPointSumCellInfo(@Param("cellInfoTablename") String cellInfoTablename, 
			@Param("scellInfoTablename") String scellInfoTablename,
			@Param("regTablename") String regTablename,
			@Param("field") String field);
	/**
	 * 查询小时级全部小区汇总信息
	 * @param tableName
	 * @param stableName 
	 * @return
	 */
	DaySummaryBase[] selectAllHourSumCell(@Param("tableName") String tableName, 
			@Param("stableName")String stableName);
	/**
	 * 查询小时级VIP小区汇总信息
	 * @param tableName
	 * @return
	 */
	DaySummaryBase selectVIPHourSumCell(String tableName);
	/**
	 * 查询小时级 重点小区汇总信息
	 * @param tableName
	 * @param regTablename 查找范围
	 * @return
	 */
	DaySummaryBase selectKeyPointHourSumCell(String tableName, String regTablename);
	
	/**
	 * 查询天级 全部小区汇总信息
	 * @param tableName
	 * @param stableName 
	 * @return
	 */
	DaySummaryBase[] selectAllDaySumCell(String tableName, String stableName);
	/**
	 * 查询天级 VIP小区汇总信息
	 * @param tableName
	 * @return
	 */
	DaySummaryBase selectVIPDaySumCell(String tableName);
	/**
	 * 查询天级 重点小区汇总信息
	 * @param tableName
	 * @param regTablename
	 * @return
	 */
	DaySummaryBase[] selectPointKeyDaySumCell(String tableName,String stableName, String regTablename);
	
	
	DaySummaryBase[] selectNewAllSumCell(String tableName, String stableName, String field);
	
	DaySummaryBase[] selectAllHourNewSumCell(String tableName, String stableName);
	
	DaySummaryBase[] selectAllDayNewSumCell(String tableName, String stableName);
	
	DaySummaryBase[] selectKeyNewSumCellInfo(String tableName, String stableName, String regTablename, String field);
	
	DaySummaryBase[] selectKeyDayNewSumCell(String tableName, String regTablename);
	DaySummaryBase[] selecttagNameData(String tagName,String tableName);
	
	void updateTagName(String tagName);
	boolean updateCellMapping(String pinyintagName, List<String> mlist);
	List<String> selectDataByECellId(String pinyintagName);
	
	
	                          
	 
}
