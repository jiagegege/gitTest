package test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.huahai.tel.bean.AllNetworkBase;
import cn.huahai.tel.bean.CellInfoBase;
import cn.huahai.tel.bean.DaySummaryBase;
import cn.huahai.tel.bean.HourAllNetWorkBase;
import cn.huahai.tel.mapper.GenerateExcelDataMapper;
import cn.huahai.tel.mapper.TopCellworkBaseMapper;
import cn.huahai.tel.service.DataServer;
import cn.huahai.tel.service.IGenerateExcelDataServer;
import cn.huahai.tel.util.GenerateExcel;



public class GenerateExcelDataTest {
	
	ApplicationContext ac;
	
	GenerateExcelDataMapper gedm;
	
	IGenerateExcelDataServer igeds;
	
	DataServer ds;
	
	TopCellworkBaseMapper tcbm;
	
	@Before
	public void before() {
		this.ac= new ClassPathXmlApplicationContext("spring-mvc.xml","spring-service.xml","spring-mybatis.xml");
		this.gedm= ac.getBean("generateExcelDataMapper",GenerateExcelDataMapper.class);
		this.ds = ac.getBean("dataServer",DataServer.class);
		this.igeds = ac.getBean("generateExcelDataServer",IGenerateExcelDataServer.class);
	}
	@Test
	public void generateExcelData() {
		CellInfoBase[] data = gedm.generateVIPCellDataExcel("YM_AQ_ALLCELL201806110915");
		
		System.out.println(data[0]);
	}
	@Test
	public void generatePointKeyExcelData() {
//		TopCellworkBase[] data = gedm.generateVIPCellDataExcel("YM_AQ_ALLCELL201806110915");
		CellInfoBase[] data = gedm.generateCellDataExcel("YM_AQ_ALLCELL201806110915", "YM_BZH_20180607ZDXQ");
		try {
			Map<String, Object> top = GenerateExcel.bean2Map(data[0]);
			System.out.println(top.get("支持最大激活用户数"));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	/**
	 * 专门用来生成javaBean（针对数据类型都是String，并且字段较多的表）
	 */	
	public void dataTest(){
		List<String> data = gedm.getMapList("YM_SYS_OCELL");
		System.out.println(data.size());
		for (String string : data) {
			System.out.println("@JsonProperty(\""+string+"\")");
		    System.out.println("private String "+string+";");
// 			System.out.print("\""+string+"\""+",");
//			System.out.print(string+" ");
		}
	}
	@Test
	public void selectVipNetWork(){
		//AllNetworkBase  data = gedm.selectVIPAllNetWork("YM_AQ_ALLCELL201806071745");
		//AllNetworkBase data = gedm.selectKeyPonitAllNetWork("YM_AQ_ALLCELL201806110915", "YM_BZH_20180607ZDXQ");
		//HourAllNetWorkBase  data = gedm.selectVIPHourAllNetWork("YM_AH_ALLCELL2018062612");
		HourAllNetWorkBase  data = gedm.selectKeyPonitHourAllNetWork("YM_AH_ALLCELL2018062609", "YM_BZH_zjlych");
		System.out.println(data.getENB内切换成功次数());
	}
//	@Test
//	public void aaa() 
//	{
//		DaySummaryBase data =tcbm.selectAllSumCell("YM_AQ_ALLCELL201809082245","aa");
//		System.out.println(data);
//	}
	@Test
	public void selectKeyPointNetWork() {
		AllNetworkBase data = gedm.selectKeyPonitAllNetWork("YM_AQ_ALLCELL201806110915", "YM_BZH_20180607ZDXQ");
		System.out.println(data.getENB内切换成功次数());
	}
	@Test
	public void selectTableName() {
		String tablename = "^YM_AH_ALLCELL\\d{10}$";
		//查询出符合正则的所有表名
		ArrayList<String> tablenames = ds.selectStandardTableName(tablename);
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int timeNumber1=Integer.parseInt(o1.split("ALLCELL")[1]);
				int timeNumber2=Integer.parseInt(o1.split("ALLCELL")[1]);
				if(timeNumber1<timeNumber2)
					return 1;
				//注意！！返回值必须是一对相反数，否则无效。jdk1.7以后就是这样。
		//		else return 0; //无效
				else return -1;
			}
		};	
		Collections.sort(tablenames,c);
		System.out.println(tablenames);
	}
	@Test
	public void selectHourCell() {
		HourAllNetWorkBase[]  data = igeds.generateHourNetworkCellDataExcel("周杰伦演唱会");
		data[0].getENB内切换成功次数();
		System.out.println(data[0].getENB内切换成功次数());
	}
}
