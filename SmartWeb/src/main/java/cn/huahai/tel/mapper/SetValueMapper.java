package cn.huahai.tel.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * 设置表格和excel渲染的临界值（全网的和top小区的）
 * @author lijia
 *
 */
public interface SetValueMapper {
	/**
	 *根据username 查找全网临界值的json数据
	 * @param username 用户名
	 * @return 全网的临界值的json数据 
	 */
	String selectAllNetJsonValue(@Param("username") String username);
	/**
	 *根据username 查找top小区临界值的json数据
	 * @param username 用户名
	 * @return top小区的临界值的json数据 
	 */
	String selectTopCellJsonValue(@Param("username") String username);
	/**
	 * 根据用户名更新全网级临界值json字符串
	 * @param username 用户名
	 * @param jsonvalue 新的全网信息临界值json字符串
	 */
	void updateAllNetJsonValue(@Param("username") String username,@Param("jsonvalue") String jsonvalue);
	/**
	 * 根据用户名更新top小区临界值json字符串
	 * @param username 用户名
	 * @param jsonvalue 新的top小区信息临界值json字符串
	 */
	void updateTopCellJsonValue(@Param("username") String username,@Param("jsonvalue") String jsonvalue);
	/**
	 * 查询用户数量
	 * @param username 用户名
	 * @return 用户名存在的数量
	 */
	Integer getAllNetUserCount(@Param("username")String username);
	/**
	 * 查询用户数量
	 * @param username 用户名
	 * @return 用户名存在的数量
	 */
	Integer getTopCellUserCount(@Param("username")String username);
	/**
	 * 插入全网的JsonValue
	 * @param username 用户名
	 * @param jsonvalue 数据
	 */
	void insertAllNetJsonValue(@Param("username") String username,@Param("jsonvalue") String jsonvalue);
	/**
	 * 插入top小区的JsonValue
	 * @param username 用户名数据
	 * @param jsonvalue 数据
	 */
	void insertTopCellJsonValue(@Param("username") String username,@Param("jsonvalue") String jsonvalue);
	
}
