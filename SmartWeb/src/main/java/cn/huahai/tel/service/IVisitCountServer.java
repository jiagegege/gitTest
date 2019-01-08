package cn.huahai.tel.service;

/**
 * 访问统计
 * @author lizhuodong
 *
 */
public interface IVisitCountServer {
	
	/**
	 *  添加访问次数
	 * @param requestURI 请求路径
	 * @param queryString 请求参数
	 */
	void addVisitData(String requestURI,String queryString);
	/**
	 * 添加ip次数
	 * @param ip 访问ip
	 * @param date 访问时间
	 */
	void addVisitIpData(String ip,String date);
	

}
