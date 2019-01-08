package cn.huahai.tel.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * 访问统计相关
 * @author lijia
 *
 */
public interface VisitCountMapper {
	/**
	 * 插入访问数据
	 * @param path 访问路径
	 */
	void insertVisitData(@Param("path")String path);
	/**
	 * 更新访问数据
	 * @param path 访问路径
	 * @param count 数量
	 */
	void updateVisitData(@Param("path")String path,@Param("count")Integer count);
	/**
	 * 通过访问路径查询访问次数
	 * @param path 访问路径
	 * @return path数量
	 */
	Integer getVisitDataByPath(@Param("path")String path);
	/**
	 * 查看访问路径在库中是否存在
	 * @param path 访问路径
	 * @return path数量
	 */
	Integer pathExit(@Param("path")String path);
	/**
	 * 插入ip和当前访问的时间
	 * @param ip 访问ip
	 * @param date 时间
	 */
	void insertIpdate(@Param("ip")String ip,@Param("date")String date);
}
