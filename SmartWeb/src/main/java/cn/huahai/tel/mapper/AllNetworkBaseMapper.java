package cn.huahai.tel.mapper;

import org.apache.ibatis.annotations.Param;

import cn.huahai.tel.bean.AllNetworkBase;

/**
 * 全网表格数据相关
 * @author lijia
 *	
 */
public interface AllNetworkBaseMapper {
	
	/**
	 * 查询所有的全网信息 
	 * @param tableName 表明
	 * @param field 字段名
	 * @return 全网数据
	 */
	AllNetworkBase[] selectAllNetworkbase(
			@Param("tablename")String tablename,
			@Param("field")String field,
			@Param("number")Integer number
			);
	/**
	 * 查询所有表名	
	 * @return 表名称 
	 */
	String[] selectAllTableName();
	AllNetworkBase[] selectAllNetworkbases(
			@Param("tablename")String tablename,
			@Param("field")String field,
			@Param("number")Integer number
			);
	
}
