package cn.huahai.tel.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 小区表设置相关
 * @author lijia
 *
 */
public interface ImportExcelMapper {
	/**
	 * 查看表是否存在 返回0 代表不存在 &gt;=1表示存在
	 * @param tablename 表名
	 * @return 表的数量
	 */
	Integer tableExist(@Param("tablename")String tablename);
	/**
	 * 
	 * @param fields 字段
	 * @param tablename 表名称
	 */
	void createTable(@Param("fields")List<String> fields,@Param("tablename")String tablename);
	/**
	 * 删除表
	 * @param tablename 表名称
	 */
	void deleteTable(@Param("tablename")String tablename);
	/**
	 * 更改表名
	 * @param oldTableName 原来的表名
	 * @param newTableName 新的表名
	 */
	void changeTablename(@Param("oldTableName")String oldTableName,@Param("newTableName")String newTableName);
	/**
	 * 批量插入数据
	 * @param data map的list集合
	 * @param fields 字段
	 * @param tablename 表名
	 */
	void insertData(
			@Param("data") List<Map<String,String>> data,
			@Param("fields") List<String> fields,
			@Param("tablename")String tablename);
	/**
	 * 拷贝数据库，并根据某字段进行去重
	 */
	void copyDistinctTable();
	
	/**
	 * 给nb表添加ps字段
	 * @param tablename 表名
	 * @param field 字段名
	 */
	void alterfield(@Param("tablename")String tablename,@Param("field")String field);
}
