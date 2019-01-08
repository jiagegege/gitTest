package cn.huahai.tel.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.huahai.tel.bean.ResponseResult;
import cn.huahai.tel.bean.User;
import cn.huahai.tel.service.IUserServer;
import cn.huahai.tel.util.VerSionUtil;

/**
 * 用户登陆相关
 * @author lijia
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserServer userService;
	
	/**
	 * 项目显示头部名称
	 */
	@Value("#{setting[projectName]}")
	public String projectName;
	private static Logger logger = Logger.getLogger(UserController.class);
//	显示登录页
	/**
	 * 返回登陆页面
	 * @return 登录页面
	 */
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";
	}
	/**
	 * 用户登录判断
	 * @param req 请求对象
	 * @param Uname 用户名
	 * @param password 密码
	 * @param received 验证码
	 * @return 是否登陆成功
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(
			HttpServletRequest req,
			String Uname,
			String password,
			String received){
		User user = new User(Uname,password);
		ResponseResult<Void> rr = new ResponseResult<Void>();
		try {
			HttpSession session = req.getSession();
			
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = formatter.format(date);
			VerSionUtil version = new VerSionUtil();
			userService.login(req,received,user);
			String path = session.getServletContext().getRealPath("/");
			System.out.println(path);
	//		String xml =path+"META-INF\\maven\\huahai.com\\SmartWeb\\pom.xml";
			
			String xml = path + "WEB-INF\\classes\\aaa.xml";
			System.out.println("xml"+xml);
			
			
		//	System.out.println("version"+version.getVersion(xml));
			System.out.println("version:"+version.getVersion(xml)+dateString);
			
			session.setAttribute("user", user);
			session.setAttribute("projectName", projectName);
			
			
			rr.setMessage("登陆成功");
			rr.setState(1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			rr.setMessage(e.getMessage());
			rr.setState(0);
		}
		return rr;
	}
	/**
	 * 生成验证码
	 * @param req 将验证码绑定到请求对象上
	 * @param rsp 响应体，返回图片
	 */
	@RequestMapping("/codeImg.do")
	public void imgCode(HttpServletRequest req, HttpServletResponse rsp) {
		try {
			userService.kaptcha(req,rsp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 验证码生成异常，到日志
			logger.error(e);
			e.printStackTrace();
		}
	}
	/**
	 * 判断验证码是否正确
	 * @param req Request
	 * @param received 验证码
	 * @return 是否正确
	 */
	@RequestMapping("/verify.do")
	@ResponseBody
	public ResponseResult<Void> verify(HttpServletRequest req,String received){
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if(userService.verify(req,received)) {
			rr.setState(1);
			rr.setMessage("验证码正确");
		}else {
			rr.setState(0);
			rr.setMessage("验证码错误");
		}
		return rr;
	}
	/**
	 * 退出登录
	 * @param session session对象
	 * @return 返回登陆页面
	 */
	@RequestMapping("/exit.do")
	public String exit(HttpSession session) {
		
		//打印退出日志
		User user = (User)session.getAttribute("user");
	
		// 清除session
		session.invalidate();
		return "forward:/user/showLogin.do";
	}
}
