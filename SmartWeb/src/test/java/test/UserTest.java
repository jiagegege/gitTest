package test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.huahai.tel.mapper.UserMapper;
import cn.huahai.tel.util.Pinyin;

public class UserTest {

	ApplicationContext ac;

	UserMapper um;

	@Before
	public void before() {
		this.ac = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-service.xml", "spring-mybatis.xml");
		this.um = ac.getBean("userMapper", UserMapper.class);
	}

	@Test
	public void selectAll() {
//		UserClass[] userClass = um.selectAll();
//		System.out.println(userClass[0]);
//		System.out.println(userClass[1]);
		// um.insertUser(8,"测试姓名");
	}

	@Test
	public void getpinyin() {
		System.out.println(Pinyin.getPingYin("lizhuodong"));
		System.out.println(Pinyin.getPinYinHeadChar("李卓东"));
	}

	@Test
	public void mapTest() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("key", "132");
		map.put("key", "123");
		System.out.println(map.get("key"));
	}
}
