package cn.huahai.tel.mapper;

/**
 * 初始化表
 * @author lijia
 */
public interface StartupListenerMapper {
	/**
	 * 创建YM_BZH_MAPPRING表；
	 */
	void createYM_BZH_MAPPRING ();
	/**
	 * 创建VISITCOUNT表；
	 */
	void createVISITCOUNT();
	/**
	 * 创建VISIT_IP_COUNT表；
	 */
	void createVISIT_IP_COUNT();
	
	/**
	 * 创建ALLNET_JSONVALUE表
	 */
	void createALLNET_JSONVALUE();
	/**
	 * 创建TopCELL_JSONVALUE表
	 */
	void createTopCELL_JSONVALUE();
}
