package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.huahai.tel.mapper.ImportExcelMapper;
import cn.huahai.tel.service.IReadExcel;
import cn.huahai.tel.util.SplitList;

public class ImportExcelTest {
	ApplicationContext ac;
	ImportExcelMapper iem;
	IReadExcel ire;
	@Before
	public void before() {
		this.ac= new ClassPathXmlApplicationContext("spring-mvc.xml","spring-service.xml","spring-mybatis.xml");
		this.iem = ac.getBean("importExcelMapper",ImportExcelMapper.class);
		this.ire = ac.getBean("readExcel",IReadExcel.class);
	}
	@Test
	public void tableExist() {
		System.out.println(iem.tableExist("YM_SYS_CELL_T"));
	}
	@Test
	public void createTable() {
		List<String> fields = new ArrayList<String>();
		fields.add("name");
		fields.add("age");
		iem.createTable(fields, "YM_SYS_CELL_T");
	}
	@Test
	public void deleteTable() {
		iem.deleteTable("YM_SYS_CELL_T");
	}
	@Test
	public void changeTablename() {
		iem.changeTablename("aaaaa1", "aaaaa2");
	}
	@Test
	public void createTableService() {
		List<String> fields = new ArrayList<String>();
		fields.add("name");
		fields.add("age");
		ire.createTable("aaaaa", fields);
	}
	@Test
	public void insertBatchData() {
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		Map<String,String> value = new HashMap<String,String>();
		value.put("name", "lizhuodong");
		value.put("age", "21");
		
		Map<String,String> value2 = new HashMap<String,String>();
		value2.put("name", "lizhuokun");
		value2.put("age", "22");
		data.add(value2);
		
		
		List<String> fields = new ArrayList<String>();
		fields.add("name");
		fields.add("age");
		iem.insertData(data, fields, "aaaaa");
	}
	@Test
	public void splitList() {
		List<String> l = new ArrayList<String>();
		l.add("1");
		l.add("23");
		l.add("5");
		l.add("8");
		l.add("5");
		l.add("8");
		l.add("6");
		List<List<String>> ls = SplitList.averageAssign(l, 3);
		System.out.println(ls.size());
	}
}
