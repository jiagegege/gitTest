package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.huahai.tel.service.IAllNetwork;

public class AllNetwork {
	ApplicationContext ac;
	IAllNetwork ian;
	@Before
	public void before() {
		this.ac= new ClassPathXmlApplicationContext("spring-mvc.xml","spring-service.xml","spring-mybatis.xml");
		this.ian = ac.getBean("allNetwork",IAllNetwork.class);
	}
	@Test
	public void getFlieList() {
		System.out.println(ian.getFileList("E:\\SmartZJI0510A\\AutoKpi","小区监控_Q\\d{12}.(xls|xlsx)").get(2));
		System.out.println(ian.getFileList("E:\\SmartZJI0510A\\AutoKpi","小区监控_Q\\d{12}.(xls|xlsx)").size());
	}
	@Test
	public void splitString() {
		String excelName = "小区监控_Q201806111645.xlsx";
		String str = "abc,12,3yy98,0";
		String[] strs=str.split(",");
		System.out.println(excelName.split("\\.")[0]);
		String timeNumber=excelName.split("\\.")[0].split("_Q")[1];
		System.out.println(timeNumber);
//		String fileName = excelName.split(".")[0];
	}
}
