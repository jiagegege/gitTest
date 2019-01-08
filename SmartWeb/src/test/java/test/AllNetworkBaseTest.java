package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.huahai.tel.bean.AllNetworkBase;
import cn.huahai.tel.bean.HourTopCellworkBase;
import cn.huahai.tel.mapper.AllNetworkBaseMapper;
import cn.huahai.tel.mapper.TopCellworkBaseMapper;
import cn.huahai.tel.service.IDataServer;

public class AllNetworkBaseTest {
	
	ApplicationContext ac;
	AllNetworkBaseMapper anb;
	TopCellworkBaseMapper tcbm;
	IDataServer ds;
	@Before
	public void before() {
		this.ac= new ClassPathXmlApplicationContext("spring-mvc.xml","spring-service.xml","spring-mybatis.xml");
		this.anb= ac.getBean("allNetworkBaseMapper",AllNetworkBaseMapper.class);
		this.ds = ac.getBean("dataServer",IDataServer.class);
		this.tcbm = ac.getBean("topCellworkBaseMapper",TopCellworkBaseMapper.class);
	}
	@Test 
	public void selectAllTest() {
		/*
		 * 查询数据库测试
		 */
		/*AllNetworkBase[] anbs = anb.selectAllNetworkbase("YM_AH_ALLCELL2018051014","hh");
		System.out.println(anbs[0]);*/
	}
	@Test
	public void selectTableName() {
		/*
		 * 查询当前用户下所有的表
		 */
		String[] tableName = anb.selectAllTableName();
		System.out.println(tableName.length);
	}
	@Test
	public void selectStandardTableName() {
		/*
		 * 查询当前用户下所有的表
		 */
		System.out.println(ds.selectStandardTableName("YM_AQ_ALL\\d{12}").size());
	}
	@Test
	public void selectTopCell() {
		/*
		 * 查询所有小区信息
		 */
		System.out.println(tcbm.selectAllTopCell("YM_AH_ALLCELL2018061908","HH")[0]);
	}
	@Test
	public void selectHourTopCell() {
		/*
		 * 查询所有小区信息
		 */
//		tcbm.selectAllHourTopCell("YM_AH_ALLCELL2018052110");
		HourTopCellworkBase[] t =tcbm.selectVIPHourTopCell("YM_AH_ALLCELL2018062612");
		System.out.println(t[1].getENB内切换成功次数());
		
	}
}
