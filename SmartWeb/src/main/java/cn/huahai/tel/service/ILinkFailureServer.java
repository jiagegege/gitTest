package cn.huahai.tel.service;

import java.util.ArrayList;

import cn.huahai.tel.bean.LinkFailure;

/**
 * 链路故障
 * @author lizhuodong
 *
 */
public interface ILinkFailureServer {
	/**
	 * 查询链路故障
	 * @return 链路故障信息
	 */
	LinkFailure[] selectLinkFailure();
	/**
	 * 查询链路故障
	 * @param tagName tag名称是全网数据还是vip小区
	 * @return 链路故障
	 */
	ArrayList<LinkFailure> selectNewLinkFailure(String tagName);
	
}
