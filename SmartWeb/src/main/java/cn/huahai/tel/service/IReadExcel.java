package cn.huahai.tel.service;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 小区表更新相关
 * @author lizhuodong
 *
 */
public interface IReadExcel {
	/**
	 * 将excel解析成  List&lt;Map&lt;String, Object&gt;&gt; 
	 * @param fis 文件输入流
	 * @param filename 文件名
	 * @param m 每一行所对应的map
     * @throws Exception 解析异常
	 * @return excel的map集合
	 */
	List<Map<String, String>> readExcel(FileInputStream fis,String filename,Map<String,String> m) throws Exception;
	/**
	 * 给readExcel方法所需的参数Map&lt;String,String&gt; m 赋值
	 * @param list 字段数组
	 * @param map 被赋值的对象
	 * @return excel头部的map
	 */
	Map<String,String> setMapping(List<String> list,Map<String,String> map);
	/**
	 * 查看tablename 是否存在
	 * @param tablename 表名称
	 * @return 表是否存在
	 */
	boolean tableExist(String tablename);
	/**
	 * 根据tablename（表名）和 fields（字段创建表）
	 * 先判断表是否存在
	 * 如果存在就删除表
	 * 最后创建表
	 * @param tablename 表明
	 * @param fields 创建的字段
	 */
	void createTable(String tablename,List<String> fields);
	
	/**
	 * 批量插入 data
	 * @param data 插入表的字段
	 * @param tablename 表名称
	 */
	void insertBatchData(List<Map<String,String>> data,
			String tablename);
	/**
	 * 修改表名称
	 * @param oldTablename 原来的表名
	 * @param newTablename 新表名
	 */
	void changTablename(String oldTablename,String newTablename);
	/**
	 * 删除表
	 * @param tablename 表名称
	 */
	void deleteTablename(String tablename);
	/**
	 * 创建YM_SYS_NB_T表
	 */
	void createYM_SYS_NB_T();
	/**
	 * 给nb表添加ps字段
	 */
	void addfield();
}
