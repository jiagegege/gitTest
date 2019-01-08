package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.huahai.tel.mapper.LinkFailureMapper;

public class LinkFailure {
	
	ApplicationContext ac;
	LinkFailureMapper lfm;
	@Before
	public void before() {
		this.ac= new ClassPathXmlApplicationContext("spring-mvc.xml","spring-service.xml","spring-mybatis.xml");
		this.lfm = ac.getBean("linkFailureMapper",LinkFailureMapper.class);
	}
	@Test
	public void selectLinkFailure() {
		/*System.out.println(lfm.selectLinkFailure().length);*/
		lfm.selectAllLinkFailure("YM_SYS_LINKBAD");
		System.out.println(lfm.selectAllLinkFailure("YM_SYS_LINKBAD"));
	}
}
