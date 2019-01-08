package cn.huahai.tel.service;

import java.util.List;

import cn.huahai.tel.bean.CriticalValueBase;

public interface ISetValueServer {
	/**
	 * 获取jsonValue的字符串
	 * @param username 用户名
	 * @param flag 全网级还是小区级
	 * @return jsonValue的字符串
	 */
	String getJsonValue(String username,String flag);
	/**
	 * 根据用户名更改jsonValue的字符串
	 * @param username 用户名
	 * @param flag 全网级还是小区级
	 * @param jsonValue jsonValue的字符串
	 */
	void setJsonValue(String username,String flag,String jsonValue);
	/**
	 * 获取jsonValue的javaBean
	 * @param username 用户名
	 * @param flag 全网级还是小区级
	 * @return jsonValue的javaBean
	 */
	List<CriticalValueBase> getJsonValueBean(String username,String flag);
}
