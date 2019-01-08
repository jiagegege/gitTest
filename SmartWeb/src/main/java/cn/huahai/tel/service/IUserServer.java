package cn.huahai.tel.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import cn.huahai.tel.bean.User;

/**
 * 用户登陆相关
 * @author lizhuodong
 *
 */
public interface IUserServer {
	
	/**
	 * 用户登录
	 * @param request 请求对象
	 * @param received 验证码
	 * @param user 用户对象
	 * @return 用户对象
	 */
	User login(HttpServletRequest request,String received,User user);
	/**
	 * 生成验证码
	 * @param req 请求对象
	 * @param rsp 响应对象
	 * @throws Exception 生成图片过程中的异常
	 */
	public void kaptcha(HttpServletRequest req,HttpServletResponse rsp)throws Exception;
	/**
	 * 判断验证码是否正确 正确返回true 不正确返回false
	 * @param request 请求对象
	 * @param received 验证码
	 * @return 是否成功
	 */
	public boolean verify(HttpServletRequest request,String received);
	/**
	 *  生成json配置文件
	 * @param session session对象
	  * 读取项目根目录下面的userInfo，返回Map&lt;String, String&gt;
	 * @return 返回Map&lt;String, String$gt;
	 * @throws IOException json读取异常
	 * @throws JSONException json书写格式异常
	 */
	public Map<String, String> getJson(HttpSession session) throws IOException, JSONException;
}
