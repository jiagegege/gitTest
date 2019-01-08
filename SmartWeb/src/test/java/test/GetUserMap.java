package test;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.huahai.tel.service.IUserServer;


public class GetUserMap {
	ApplicationContext ac;
	IUserServer iu;
	@Before
	public void before() {
		this.ac= new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		this.iu= ac.getBean("userServer",IUserServer.class);
	}
	
	@Test
	public void getJson() throws IOException, JSONException {
		/*
		 * 服务器真正的运行环境 和开发环境 有区别 ，不能直接测试
		 */
//		System.out.println(iu.getJson().get("lizhuo"));
	}
}
