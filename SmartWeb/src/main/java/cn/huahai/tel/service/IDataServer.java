package cn.huahai.tel.service;

import java.util.ArrayList;

import cn.huahai.tel.bean.AllNetworkBase;

/**
 * 查询表格数据
 * @author lizhuodong
 *
 */
public interface IDataServer {
	/**
	 * 查询全网所有数据
	 * @param tableName 表名称
	 * @param field 查询字段
	 * @return 全网信息
	 */
	AllNetworkBase[] selectAllData(String tablename,String field,Integer number);
	/**
	 * 查询符合标准的表名，并进行排序（依据时间）
	 * @param reg 正则
	 * @return 符合正则的表名列表
	 */
	ArrayList<String> selectStandardTableName(String reg);
	AllNetworkBase[] selectAllDatas(String allTable, String field, Integer number);
}
