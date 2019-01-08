package cn.huahai.tel.mapper;

import org.apache.ibatis.annotations.Param;

import cn.huahai.tel.bean.LinkFailure;

/**
 * 链路故障相关
 * @author lijia
 *
 */
public interface LinkFailureMapper {
	/**
	 * 查询所有链路故障信息
	 * @return 链路故障信息
	 */
	LinkFailure[] selectLinkFailure();
	/**
	 * 查询相对应的表名的全网级链路故障。
	 * @param tablename 表名称
	 * @return 链路故障
	 */
	LinkFailure selectAllLinkFailure(@Param("tablename") String tablename);
	/**
	 * 查询相对应的表名的vip链路故障
	 * @param tablename 表名称
	 * @return 链路故障
	 */
	LinkFailure selectVipLinkFailure(@Param("tablename") String tablename);
	/**
	 * 查询相对应的表名的重点小区的链路故障
	 * @param tablename 链路表
	 * @param regTablename 重点小区表
	 * @return 链路故障
	 */
	LinkFailure selectPointLinkFailure(@Param("tablename") String tablename ,@Param("regTablename") String regTablename);
	/**
	 * 根据表名查询时间
	 * @param tablename 表名称
	 * @return 时间
	 */
	String selectDateTimeByTablename(@Param("tablename") String tablename);
	/**
	 * 复制一个表YM_SYS_LINKBAD
	 * @param table_name_new 新的表名
	 */
	void copyLinkFailTable(@Param("table_name_new")String table_name_new);
}
