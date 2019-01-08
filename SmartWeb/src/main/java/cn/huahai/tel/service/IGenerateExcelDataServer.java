package cn.huahai.tel.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.huahai.tel.bean.AllNetworkBase;
import cn.huahai.tel.bean.CellInfoBase;
import cn.huahai.tel.bean.CriticalValueBase;
import cn.huahai.tel.bean.DayAllNetworkBase;
import cn.huahai.tel.bean.HourAllNetWorkBase;

/**
 * 生成excel
 * @author lizhuodong
 *
 */
public interface IGenerateExcelDataServer {
	/**
	 * 根据数据判断出是小区，还是全网数据。返回相应的临界值报警数据
	 * @param data list数据中的其中一行
	 * @param session 获取用户名
	 * @return 返回相应的报警临界值
	 */
	public List<CriticalValueBase> getSetValue(Map<String,Object> data,HttpSession session);
	/**
	 * 根据 tagName和具体的时间点 ， 返回指定的数据
	 * @param tagName 小区组名称
	 * @param timeNumber 12位代表时间的数字
	 * @return 返回筛选之后的小区数据
	 */
	CellInfoBase[] generatePointKeyCellDataExcel(String tagName,String timeNumber);
	/**
	 * 根据 tagName和具体的时间点 ， 返回指定的数据 (筛选全网数据)
	 * @param tagName 小区组名称
	 * @param timeNumber 12位代表时间的数字
	 * @return 返回筛选之后的全网数据数据
	 */
	AllNetworkBase[] generateNetworkCellDataExcel(String tagName,String timeNumber,Integer number);
	/**
	 * 根据查询到的数据生成excel
	 * @param tagName 小区组名称
	 * @param timeNumber 12位代表时间的数字
	 * @param session 返回数据流所需
	 * @return 返回筛选之后的小区数据的excel文件数据流
	 */
	byte[] generateExcel(String tagName,String timeNumber,int colors,HttpSession session);
	/**
	 * 根据查询 汇总全网数据到的数据生成excel
	 * @param tagName 小区组名称
	 * @param timeNumber 12位代表时间的数字
	 * @param session 返回数据流所需
	 * @return 返回筛选之后的全网数据的excel文件数据流
	 */
	byte[] generateNetWorkExcel(String tagName,String timeNumber ,int colors,HttpSession session);
	
	/**
	 * 根据 tagName返回指定的(小时级全网)数据
	 * @param tagName 小区组名称
	 * @return 返回筛选之后的(小时)数据
	 */
	HourAllNetWorkBase[] generateHourNetworkCellDataExcel(String tagName);
	/**
	 * 根据 tagName返回指定的(天级全网)数据
	 * @param tagName 小区组名称
	 * @return 返回筛选之后的(天)数据
	 */
	DayAllNetworkBase[] generateDayNetworkCellDataExcel(String tagName);
	/**
	 * 根据查询 汇总全网数据到的数据生成excel(天级)
	 * @param tagName 小区组名称
	 * @param tableName 数据所在的表名称
	 * @param session 返回数据流所需
	 * @return 返回筛选之后的全网数据的excel文件数据流(天级)
	 */
	byte[] generateDayCellExcel(String tagName,String tableName ,int colors,HttpSession session);
	/**
	 * 根据查询 汇总全网数据到的数据生成excel(小时级)
	 * @param tagName 小区组名称
	 * @param tableName 数据所在的表名称
	 * @param session 返回数据流所需
	 * @return 返回筛选之后的全网数据的excel文件数据流(小时级)
	 */
	byte[] generateHourNetWorkExcel(String tagName,String tableName ,int colors,HttpSession session);
	/**
	 * 根据查询 小区级数据生成excel(小时级)
	 * @param tagName 小区组名称
	 * @param tableName 数据所在的表名称
	 * @param session 返回数据流所需
	 * @return 返回筛选之后的小区数据的excel文件数据流(小时级)
	 */
	byte[] generateHourCellExcel(String tagName,String tableName ,int colors,HttpSession session);
	/**
	 * 根据查询 汇总全网数据到的数据生成excel(小时级)小时级全网数据的前20条数据
	 * @param tagName 小区组名称
	 * @param session 返回数据流所需
	 * @return 返回筛选之后的全网数据的excel文件数据流(小时级)
	 */
	byte[] generateHourNetWorkTableExcel(String tagName ,int colors,HttpSession session);
	
	/**
	 * 根据查询 汇总全网数据到的数据生成excel(天级)小时级全网数据的前20条数据
	 * @param tagName 小区组名称
	 * @param session 返回数据流所需
	 * @return 返回筛选之后的全网数据的excel文件数据流(天级)
	 */
	byte[] generateDayNetWorkTableExcel(String tagName ,int colors,HttpSession session);
	
	/**
	 * 根据查询 汇总全网数据到的数据生成excel(分钟级)
	 * @param tagName 小区组名称
	 * @param session 返回数据流所需
	 * @return 返回筛选之后的全网数据的excel文件数据流(分钟级)
	 */
	 byte[] generateUnCellAllNetExcel(String tagName ,int colors, HttpSession session);
	 
	 
	public DayAllNetworkBase[] generateDaySummaryCellDataExcel(String tagName);
	
	
	public HourAllNetWorkBase[] generateDayCellSumDataExcel(String tagName);
	
	
	byte[] generateHourNewCellExcel(String tagName, String excelName ,int colors, HttpSession session);
	
	byte[] generateHourNewNetWorkExcel(String tagName, String excelName ,int colors, HttpSession session);
	
	public byte[] generateLinkAllNetExcel(String tagName, int colors, HttpSession session);
	
	byte[] generateNotExcel(String tagName, String timeNumber, int colors, HttpSession session);
	
	
	public byte[] generateSchoolTableExcel(String tagName, int colors,int two, HttpSession session);
	public byte[] generateSumTableExcel(String tagName, int colors, int two, HttpSession session);
	
	public byte[] generatetagNameExcel(String tagName, int colors, HttpSession session);
	public byte[] generateMinAllExcel(String tagName, int colors, HttpSession session);
	public byte[] generateSumExcelList(String tagName, int colors, String tableName, int l, String site, int two, HttpSession session);
	public byte[] generateSumMaryExcel(String tagName, int colors, String tableName, int sumLength, int two,
			HttpSession session);
	
	
}
