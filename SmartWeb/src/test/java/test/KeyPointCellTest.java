package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.huahai.tel.mapper.KeyPointCellMapper;
import cn.huahai.tel.mapper.SetValueMapper;
import cn.huahai.tel.util.Pinyin;

public class KeyPointCellTest {
	ApplicationContext ac;
	KeyPointCellMapper kpcm;
	SetValueMapper svm;
	@Before
	public void before() {
		this.ac= new ClassPathXmlApplicationContext("spring-mvc.xml","spring-service.xml","spring-mybatis.xml");
		this.kpcm = ac.getBean("keyPointCellMapper",KeyPointCellMapper.class);
		this.svm = ac.getBean("setValueMapper",SetValueMapper.class);
	}
	@Test
	public void insert() {
		kpcm.insertKeyPointCell("YM_BZH_ADS","保障");
	}
	@Test
	public void create() {
		kpcm.createKeyPointCell("YM_BZH_TSXQZ");
	}
	@Test
	public void insertCellName() {
		List<String> cellName = new ArrayList<String>();
//		567761_129,567761_130,575713_129,575713_130,575714_129,
		cellName.add("567761_129");
		cellName.add("567761_130");
		cellName.add("575713_130");
		cellName.add("575714_129");
		kpcm.insertKeyPointCellName("YM_BZH_TSXQZ", cellName);
	}
	@Test
	public void selecTagNameCount() {
		System.out.println(kpcm.selectTagName("YM_BZH_ADS"));
	}
	@Test 
	public void testPinyin() {
		System.out.println(Pinyin.getPinYinHeadChar("YM_BZH_"+"测试小区组"));
	}
	@Test 
	public void selectAllMapping() {
		System.out.println(kpcm.selectAllMapping());
	}
	@Test 
	public void deleteMapping() {
		kpcm.deleteMapping("测试小区组");
	}
	@Test
	public void deleteTable() {
		kpcm.deletekeypointTable(Pinyin.getPinYinHeadChar("YM_BZH_"+"测试小区组"));
	}
	@Test
	public void selectRegInfo() {
		System.out.println(kpcm.selectKeyPontCellInfo("YM_AQ_ALLCELL201805241130", "YM_BZH_CSXQZ").length);
	}
	@Test
	public void selectVip() {
		System.out.println(kpcm.selectVIPCellInfo("YM_AQ_ALLCELL201806071745")[0]);
	}
	@Test
	public void selectJson() {
		System.out.println(svm.selectAllNetJsonValue("lizhuoDong"));
	}
}
