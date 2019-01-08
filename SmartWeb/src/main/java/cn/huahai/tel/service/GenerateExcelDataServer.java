package cn.huahai.tel.service;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.huahai.tel.bean.AllNetworkBase;
import cn.huahai.tel.bean.CellInfoBase;
import cn.huahai.tel.bean.CriticalValueBase;
import cn.huahai.tel.bean.DayAllNetworkBase;
import cn.huahai.tel.bean.DaySummaryBase;
import cn.huahai.tel.bean.DayTopCellworkBase;
import cn.huahai.tel.bean.HourAllNetWorkBase;
import cn.huahai.tel.bean.HourTopCellworkBase;
import cn.huahai.tel.bean.UnCellAllNetBase;
import cn.huahai.tel.bean.User;
import cn.huahai.tel.mapper.GenerateExcelDataMapper;
import cn.huahai.tel.mapper.KeyPointCellMapper;
import cn.huahai.tel.mapper.TopCellworkBaseMapper;
import cn.huahai.tel.util.*;

@Service
public class GenerateExcelDataServer implements IGenerateExcelDataServer {
	@Resource
	IDataServer ds;
	@Resource
	ISchoolSever scs ;
	@Resource
	KeyPointCellMapper kpcm;
	@Resource
	GenerateExcelDataMapper gedm;
	@Resource
	TopCellworkBaseMapper tcbm;
	@Autowired
	ITopCellServer tcs;
	@Resource
	private ISetValueServer svs;
	@Autowired
	IkeyPointCellServer kpcs;
	
	
	@Override
	public List<CriticalValueBase> getSetValue(Map<String,Object> data,HttpSession session){
		User user = (User) session.getAttribute("user");
		String flag = "";
		if(data.containsKey("ENODEBID_CELLID")) {
			System.out.println("小区级的excel");
			flag = "topCell";
		}else {
			System.out.println("全网级的excel");
			flag = "allNet";
		}
		return svs.getJsonValueBean(user.getUname(), flag);
	}
	
	@Override
	public CellInfoBase[] generatePointKeyCellDataExcel(String tagName, String timeNumber) {
		CellInfoBase[] data = null;
		String tablename = "YM_AQ_ALLCELL" + timeNumber;
		// 查询出符合正则的所有表名
		// ArrayList<String> tablenames = ds.selectStandardTableName(tablename);
		if ("VIP".equals(tagName)) {
			// 添加15分钟级表名正则
			// 调用联表查询的方法 ，对data进行赋值
			System.out.println("VIP小区");
			data = gedm.generateVIPCellDataExcel(tablename);
		} else {
			// 如果是小区组,查询小区表
			String cellTable = kpcm.selectTablenameByTagname(tagName);
			// 两表联查，得出数据
			System.out.println("重点小区组");
			data = gedm.generateCellDataExcel(tablename, cellTable);
		}
		return data;
	}
	
	
	@Override
	public byte[] generateExcel(String tagName, String timeNumber, int colors, HttpSession session) {
		CellInfoBase[] data = generatePointKeyCellDataExcel(tagName, timeNumber);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < data.length; i++) {
			try {
				dataList.add(GenerateExcel.bean2Map(data[i]));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 获取服务器真实路径
		String path = session.getServletContext().getRealPath("/");
		// 拼接文件路径
		String finalXlsxPath = path + "/web/model/modelCell.xlsx";
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			// 获取excel头部信息
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session,getSetValue(dataList.get(0),session),colors);
	}
	@Override
	public byte[] generateNotExcel(String tagName, String timeNumber, int colors, HttpSession session) {
		CellInfoBase[] data = generatePointKeyCellDataExcel(tagName, timeNumber);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < data.length; i++) {
			try {
				dataList.add(GenerateExcel.bean2Map(data[i]));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 获取服务器真实路径
		String path = session.getServletContext().getRealPath("/");
		// 拼接文件路径
		String finalXlsxPath = path + "/web/model/modelCell.xlsx";
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			// 获取excel头部信息
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session,getSetValue(dataList.get(0),session),colors);
	}

	@Override
	public AllNetworkBase[] generateNetworkCellDataExcel(String tagName, String timeNumber , Integer number) {
		// TODO Auto-generated method stub
		AllNetworkBase[] datas = null;
		
		
		AllNetworkBase data = null;
		String tablename = "^YM_AQ_ALLCELL\\d{12}$";
		// 查询出符合正则的所有表名
		ArrayList<String> tablenames = ds.selectStandardTableName(tablename);
		System.out.println("元素位置" + tablenames.indexOf("YM_AQ_ALLCELL" + timeNumber));
		int start = tablenames.indexOf("YM_AQ_ALLCELL" + timeNumber);
		int end = 0;
		if(number == null) {
			
			datas = new AllNetworkBase[4];
			if(start - 4 >0) {
				
				end = start - 4;
				
			}
		}else {
			
			 datas = new AllNetworkBase[number];
			 System.out.println("number"+number);
			if(start - number > 0) {
				end = start - number;
			}
		}
		System.out.println("start"+start);
		System.out.println("end"+end);
		
		int index = 0;
		for (int i = start; i > end; i--) {
			if ("VIP".equals(tagName)) {
				// 添加15分钟级表名正则
				// 调用联表查询的方法 ，对data进行赋值
				data = gedm.selectVIPAllNetWork(tablenames.get(i));
			} else {
				// 如果是小区组,查询小区表
				String cellTable = kpcm.selectTablenameByTagname(tagName);
				// 两表联查，得出数据
				data = gedm.selectKeyPonitAllNetWork(tablenames.get(i), cellTable);
			}
			System.out.println(tablenames.get(i));
			datas[index] = data;
			
			index++;
			
			
		}
		System.out.println("已经触发");
		return datas;
	}

	@Override
	public byte[] generateNetWorkExcel(String tagName, String timeNumber , int colors, HttpSession session) {
		// TODO Auto-generated method stub
		AllNetworkBase[] data = generateNetworkCellDataExcel(tagName, timeNumber, null);
		System.out.println("获取数据长度为：" + data.length);
		System.out.println(data[0]);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < data.length; i++) {
			try {
				System.out.println("data"+data[i]);
				dataList.add(GenerateExcel.bean2Map(data[i]));
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 获取服务器真实路径
		String path = session.getServletContext().getRealPath("/");
		// 拼接文件路径（模板excel）
		String finalXlsxPath = path + "/web/model/modelAllNetWork.xlsx";
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null ; 
		try {
			fis = new FileInputStream(file);
			// 获取excel头部信息
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session,getSetValue(dataList.get(0),session) ,colors);
	}

	@Override
	public HourAllNetWorkBase[] generateHourNetworkCellDataExcel(String tagName) {

		HourAllNetWorkBase[] datas = null;
		HourAllNetWorkBase data = null;
		String tablename = "^YM_AH_ALLCELL\\d{10}$";
		// 查询出符合正则的所有表名
		ArrayList<String> tablenames = ds.selectStandardTableName(tablename);

		// 查看当前小时级数据是否超过24个
		if (tablenames.size() > 24) {
			datas = new HourAllNetWorkBase[24];
		} else {
			datas = new HourAllNetWorkBase[tablenames.size()];
		}
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int timeNumber1 = Integer.parseInt(o1.split("ALLCELL")[1]);
				int timeNumber2 = Integer.parseInt(o1.split("ALLCELL")[1]);
				if (timeNumber1 < timeNumber2)
					return 1;
				// 注意！！返回值必须是一对相反数，否则无效。jdk1.7以后就是这样。
				// else return 0; //无效
				else
					return -1;
			}
		};
		Collections.sort(tablenames, c);
		int i = 0;
		for (String string : tablenames) {
			if (i > 23) {
				break;
			};
			if ("VIP".equals(tagName)) {
				// 添加15分钟级表名正则
				// 调用联表查询的方法 ，对data进行赋值
				// data = gedm.generateVIPCellDataExcel(tablename);
				data = gedm.selectVIPHourAllNetWork(string);
			} else if ("all".equals(tagName)) {
				data = gedm.selectALLHourAllNetWork(string);
			} else {
				// 如果是小区组,查询小区表
				String cellTable = kpcm.selectTablenameByTagname(tagName);
				// 两表联查,得出数据
				data = gedm.selectKeyPonitHourAllNetWork(string, cellTable);
			}
			datas[i] = data;
			i++;
		}
		return datas;
	}

	@Override
	public DayAllNetworkBase[] generateDayNetworkCellDataExcel(String tagName) {
		// TODO Auto-generated method stub
		DayAllNetworkBase[] datas = null;
		DayAllNetworkBase data = null;
		//YM_AD_ALLCELL20180724
		String tablename = "^YM_AD_ALLCELL\\d{8}$";
		// 查询出符合正则的所有表名
		ArrayList<String> tablenames = ds.selectStandardTableName(tablename);
		System.out.println("进4"+tablenames.size());
		// 查看当前天级数据是否超过20个
		if (tablenames.size() > 20) {
			datas = new DayAllNetworkBase[20];
		} else {
			datas = new DayAllNetworkBase[tablenames.size()];
		}
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int timeNumber1 = Integer.parseInt(o1.split("ALLCELL")[1]);
				int timeNumber2 = Integer.parseInt(o1.split("ALLCELL")[1]);
				if (timeNumber1 < timeNumber2)
					return 1;
				// 注意！！返回值必须是一对相反数，否则无效。jdk1.7以后就是这样。
				// else return 0; //无效
				else
					return -1;
			}
		};
		Collections.sort(tablenames, c);
		int i = 0;
		for (String string : tablenames) {
			
			if (i > 19) {
				break;
			};
			if ("VIP".equals(tagName)) {
				// 添加15分钟级表名正则
				// 调用联表查询的方法 ，对data进行赋值
				// data = gedm.generateVIPCellDataExcel(tablename);
				data = gedm.selectVIPDayAllNetWork(string);
			} else if ("all".equals(tagName)) {
				data = gedm.selectALLDayAllNetWork(string);
			} else {
				// 如果是小区组,查询小区表
				String cellTable = kpcm.selectTablenameByTagname(tagName);
				// 两表联查,得出数据
				data = gedm.selectKeyPonitDayAllNetWork(string, cellTable);
			}
			
			datas[i] = data;
			
			i++;
		}
		return datas;
	}
	
	@Override
	public byte[] generateDayCellExcel(String tagName, String tableName,int colors, HttpSession session) {
		
		DayTopCellworkBase[] dataCell = null;
		if ("VIP".equals(tagName)) {
			
			//dataCell = tcbm.selectVIPDayTopCell(tableName);
			dataCell = tcbm.selectAllVIPDayTopCell(tableName);
		} else if ("all".equals(tagName)) {
			//dataCell = tcbm.selectAllDayTopCell(tableName);
			dataCell = tcbm.selectAllAllNetDayTopCell(tableName);
		} else {
			// 如果是小区组,查询小区表
			String cellTable = kpcm.selectTablenameByTagname(tagName);
			// 两表联查,得出数据
			//dataCell = tcbm.selectPointKeyDayTopCell(tableName, cellTable);
			dataCell = tcbm.selectAllPointKeyDayTopCell(tableName, cellTable);
		}
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		System.out.println("查询出数据长度：" + dataCell.length);
		for (int i = 0; i < dataCell.length; i++) {
			try {
				dataList.add(GenerateExcel.bean2Map(dataCell[i]));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 获取服务器真实路径
		String path = session.getServletContext().getRealPath("/");
		// 拼接文件路径（模板excel）
		String finalXlsxPath = path + "/web/model/modelDayCell.xlsx";
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			// 获取excel头部信息
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session,getSetValue(dataList.get(0),session),colors);
	}
	@Override
	public byte[] generateHourNetWorkExcel(String tagName, String tableName ,int colors, HttpSession session) {
		HourAllNetWorkBase dataAll = null;

		if ("VIP".equals(tagName)) {
			// 添加15分钟级表名正则
			// 调用联表查询的方法 ，对data进行赋值
			// data = gedm.generateVIPCellDataExcel(tablename);
			dataAll = gedm.selectVIPHourAllNetWork(tableName);
		} else if ("all".equals(tagName)) {
			dataAll = gedm.selectALLHourAllNetWork(tableName);
		} else {
			// 如果是小区组,查询小区表
			String cellTable = kpcm.selectTablenameByTagname(tagName);
			// 两表联查,得出数据
			dataAll = gedm.selectKeyPonitHourAllNetWork(tableName, cellTable);
		}
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		try {
			dataList.add(GenerateExcel.bean2Map(dataAll));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取服务器真实路径
		String path = session.getServletContext().getRealPath("/");
		// 拼接文件路径（模板excel）
		String finalXlsxPath = path + "/web/model/modelHourAllNetWork.xlsx";
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null ; 
		
		try {
			fis = new FileInputStream(file);
			// 获取excel头部信息
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session,getSetValue(dataList.get(0),session),colors);
	}

	@Override
	public byte[] generateHourCellExcel(String tagName, String tableName ,int colors, HttpSession session) {
		HourTopCellworkBase[] dataCell = null;
		if ("VIP".equals(tagName)) {
			// 添加15分钟级表名正则
			// 调用联表查询的方法 ，对data进行赋值
			// data = gedm.generateVIPCellDataExcel(tablename);
			//dataCell = tcbm.selectVIPHourTopCell(tableName);
			System.out.println("已经出发");
			dataCell = tcbm.selectAllVIPHourTopCell(tableName);
		} else if ("all".equals(tagName)) {
			dataCell = tcbm.selectAllAllNetHourTopCell(tableName);
		} else {
			// 如果是小区组,查询小区表
			String cellTable = kpcm.selectTablenameByTagname(tagName);
			// 两表联查,得出数据
			//dataCell = tcbm.selectPointKeyHourTopCell(tableName, cellTable);
			dataCell = tcbm.selectAllPointKeyHourTopCell(tableName, cellTable);
		}
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		System.out.println("查询出数据长度：" + dataCell.length);
		for (int i = 0; i < dataCell.length; i++) {
			try {
				dataList.add(GenerateExcel.bean2Map(dataCell[i]));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 获取服务器真实路径
		String path = session.getServletContext().getRealPath("/");
		// 拼接文件路径（模板excel）					
		String finalXlsxPath = path + "/web/model/modelHourCell.xlsx";
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			// 获取excel头部信息
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session,getSetValue(dataList.get(0),session),colors);
	}
	@Override
	public byte[] generateHourNewCellExcel(String tagName, String tableName ,int colors, HttpSession session) {
		HourTopCellworkBase[] dataCell = null;
		if ("VIP".equals(tagName)) {
			// 添加15分钟级表名正则
			// 调用联表查询的方法 ，对data进行赋值
			// data = gedm.generateVIPCellDataExcel(tablename);
			//dataCell = tcbm.selectVIPHourTopCell(tableName);
			System.out.println("已经出发");
			dataCell = tcbm.selectAllVIPHourTopCell(tableName);
		} else if ("all".equals(tagName)) {
			dataCell = tcbm.selectAllAllNetHourTopCell(tableName);
		} else {
			// 如果是小区组,查询小区表
			String cellTable = kpcm.selectTablenameByTagname(tagName);
			// 两表联查,得出数据
			//dataCell = tcbm.selectPointKeyHourTopCell(tableName, cellTable);
			dataCell = tcbm.selectAllPointKeyHourTopCell(tableName, cellTable);
		}
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		System.out.println("查询出数据长度：" + dataCell.length);
		for (int i = 0; i < dataCell.length; i++) {
			try {
				dataList.add(GenerateExcel.bean2Map(dataCell[i]));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 获取服务器真实路径
		String path = session.getServletContext().getRealPath("/");
		// 拼接文件路径（模板excel）
		String finalXlsxPath = path + "/web/model/modelHourNewCell.xlsx";
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			// 获取excel头部信息
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session,getSetValue(dataList.get(0),session),colors);
	}

	@Override
	public byte[] generateHourNetWorkTableExcel(String tagName,int colors, HttpSession session) {
		// TODO Auto-generated method stub
		HourAllNetWorkBase[] data = generateHourNetworkCellDataExcel(tagName);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i < data.length; i++) {
			try {
				System.out.println(data[i]);
				dataList.add(GenerateExcel.bean2Map(data[i]));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 获取服务器真实路径
		String path = session.getServletContext().getRealPath("/");
		// 拼接文件路径（模板excel）
		String finalXlsxPath = path + "/web/model/modelHourAllNetWork.xlsx";
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null ;
		try {
			fis = new FileInputStream(file);
			// 获取excel头部信息
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session,getSetValue(dataList.get(0),session),colors);
	}
	@Override
	public byte[] generateDayNetWorkTableExcel(String tagName ,int colors, HttpSession session) {
		// TODO Auto-generated method stub
		DayAllNetworkBase[] data = generateDayNetworkCellDataExcel(tagName);
		
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < data.length; i++) {
			try {
				
				
				dataList.add(GenerateExcel.bean2Map(data[i]));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 获取服务器真实路径
		String path = session.getServletContext().getRealPath("/");
		// 拼接文件路径（模板excel）
		String finalXlsxPath = path + "/web/model/modelDayAllNetWork.xlsx";
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			// 获取excel头部信息
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session,getSetValue(dataList.get(0),session),colors);
	}
	public UnCellAllNetBase[] generateUnCellAllNetExcel(String tagName) {
		String tablename = "^YM_AQ_ALLCELL\\d{12}$";
		// 查询出符合正则的所有表名
		ArrayList<String> tablenames = ds.selectStandardTableName(tablename);
		UnCellAllNetBase[] data = null;	
		System.out.println("tablenames"+tablenames.size());
		System.out.println("tagName"+tagName);
		for(String string : tablenames) {
			if("VIP".equals(tagName)) {
				
				data = gedm.generateVIPUnCellDataExcel(string);
			}else if("all".equals(tagName)){
				data = gedm.generateUnCellDataExcel(string);
				
			} else {
				// 如果是小区组,查询小区表
				String cellTable = kpcm.selectTablenameByTagname(tagName);
				// 两表联查,得出数据
				data = gedm.selectKeyPonitMinUnAllNetWork(string, cellTable);
			}
		}
		
		return data;		
	}

	public byte[] generateUnCellAllNetExcel(String tagName ,int colors,HttpSession session) {
		UnCellAllNetBase[] data = generateUnCellAllNetExcel(tagName);
		System.out.println("查询出Un数据长度：" + data.length);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		
		for(int i = 0 ; i < data.length ; i ++) {
			try {
				dataList.add(GenerateExcel.bean2Map(data[i]));
				
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		String path = session.getServletContext().getRealPath("/");
		String finalXlsxPath = path + "/web/model/modelUnAllNetWork.xlsx";
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("dataList"+dataList.size());
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session, getSetValue(dataList.get(0), session),colors);
	}

	@Override
	public DayAllNetworkBase[] generateDaySummaryCellDataExcel(String tagName) {
		DayAllNetworkBase[] datas = null;
		DayAllNetworkBase data = null;
		//YM_AD_ALLCELL20180724
		String tablename = "^YM_AD_ALLCELL\\d{8}$";
		// 查询出符合正则的所有表名
		ArrayList<String> tablenames = ds.selectStandardTableName(tablename);
		// 查看当前天级数据是否超过30个
		if (tablenames.size() > 30) {
			datas = new DayAllNetworkBase[24];
		} else {
			datas = new DayAllNetworkBase[tablenames.size()];
		}
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int timeNumber1 = Integer.parseInt(o1.split("ALLCELL")[1]);
				int timeNumber2 = Integer.parseInt(o1.split("ALLCELL")[1]);
				if (timeNumber1 < timeNumber2)
					return 1;
				// 注意！！返回值必须是一对相反数，否则无效。jdk1.7以后就是这样。
				// else return 0; //无效
				else
					return -1;
			}
		};
		Collections.sort(tablenames, c);
		int i = 0;
		for (String string : tablenames) {
			if (i > 29) {
				break;
			};
			if ("VIP".equals(tagName)) {
				// 添加15分钟级表名正则
				// 调用联表查询的方法 ，对data进行赋值
				// data = gedm.generateVIPCellDataExcel(tablename);
				data = gedm.selectVIPDaySumNetWork(string);
			} else if ("all".equals(tagName)) {
				data = gedm.selectALLDayAllNetWork(string);
			} else {
				// 如果是小区组,查询小区表
				String cellTable = kpcm.selectTablenameByTagname(tagName);
				// 两表联查,得出数据
				data = gedm.selectKeyPonitDayAllNetWork(string, cellTable);
			}
			datas[i] = data;
			i++;
		}
		return datas;
	}

	@Override
	public HourAllNetWorkBase[] generateDayCellSumDataExcel(String tagName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] generateHourNewNetWorkExcel(String tagName, String tableName ,int colors, HttpSession session) {
		HourAllNetWorkBase dataAll = null;

		if ("VIP".equals(tagName)) {
			// 添加15分钟级表名正则
			// 调用联表查询的方法 ，对data进行赋值
			// data = gedm.generateVIPCellDataExcel(tablename);
			dataAll = gedm.selectVIPHourAllNetWork(tableName);
		} else if ("all".equals(tagName)) {
			dataAll = gedm.selectALLHourAllNetWork(tableName);
		} else {
			// 如果是小区组,查询小区表
			String cellTable = kpcm.selectTablenameByTagname(tagName);
			// 两表联查,得出数据
			dataAll = gedm.selectKeyPonitHourAllNetWork(tableName, cellTable);
		}
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		try {
			dataList.add(GenerateExcel.bean2Map(dataAll));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取服务器真实路径
		String path = session.getServletContext().getRealPath("/");
		// 拼接文件路径（模板excel）
		String finalXlsxPath = path + "/web/model/modelHourAllNetWork.xlsx";
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null ; 
		
		try {
			fis = new FileInputStream(file);
			// 获取excel头部信息
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session,getSetValue(dataList.get(0),session),colors);
	}

	public byte[] generateLinkAllNetExcel(String tagName ,int colors,HttpSession session) {
		UnCellAllNetBase[] data = generateUnCellAllNetExcel(tagName);
		System.out.println("查询出Un数据长度：" + data.length);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		
		for(int i = 0 ; i < data.length ; i ++) {
			try {
				dataList.add(GenerateExcel.bean2Map(data[i]));
				
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		String path = session.getServletContext().getRealPath("/");
		String finalXlsxPath = path + "/web/model/modelUnAllNetWork.xlsx";
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("dataList"+dataList.size());
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session, getSetValue(dataList.get(0), session),colors);
	}

	@Override
	public byte[] generateSchoolTableExcel(String tagName, int colors,int two, HttpSession session) {
		DaySummaryBase[] data = generateSchoolExcel(tagName,two);
		
		System.out.println("查询出Un数据长度：" + data.length);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		
		for(int i = 0 ; i < data.length ; i ++) {
			try {
				dataList.add(GenerateExcel.bean2Map(data[i]));
				
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		String path = session.getServletContext().getRealPath("/");
		String finalXlsxPath = null;
		if(two == 0) {
			finalXlsxPath = path + "/web/model/modelSumSchool.xlsx";
		}else if(two == 1) {
			finalXlsxPath = path + "/web/model/modelHourSchool.xlsx";
		}else if(two == 2) {
			finalXlsxPath = path + "/web/model/modelDaySchool.xlsx";
		}
		 
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session, getSetValue(dataList.get(0), session),colors);
	}

	private DaySummaryBase[] generateSchoolExcel(String tagName,int two) {
		String tablename = null;
		System.out.println("two"+two);
		String field = "";
		if(two == 0) {
			tablename = "^YM_AQ_ALLCELL\\d{12}$";
			field = "HM";
		}else if(two == 1) {
			tablename = "^YM_AH_ALLCELL\\d{10}$";
			field = "HH";
		}else {
			tablename = "^YM_AD_ALLCELL\\d{8}$";
		}
		
		// 查询出符合正则的所有表名
		ArrayList<String> tablenames = ds.selectStandardTableName(tablename);
		DaySummaryBase[] data = null;	
		System.out.println("tablenames"+tablenames.size());
		System.out.println(tablenames.get(tablenames.size() - 1));
		System.out.println("tagName"+tagName);
	//	for(String string : tablenames) {
			if("VIP".equals(tagName)) {
				
//				data = gedm.generateSchoolExcel(string);
			}else if("all".equals(tagName)){
				if(two == 2) {
					if(tablenames.size() == 1) {
						
						data = kpcs.selectAllDaySumCell(tablenames.get(tablenames.size() - 1),tablenames.get(tablenames.size() - 1));
					}else {

						
						data = kpcs.selectAllDaySumCell(tablenames.get(tablenames.size() - 1),tablenames.get(tablenames.size() - 2));
					}
				}else {
					data = tcs.selectAllSumCell(tablenames.get(tablenames.size() - 1),tablenames.get(tablenames.size() - 2), field);
					
				}
				
				
			} else {
				if(two == 2) {
					System.out.println("two= 2");
					if(tablenames.size() == 1) {

						data = kpcs.selectPointKeyDaySumCell(tablenames.get(tablenames.size() - 1),tablenames.get(tablenames.size() - 1), Pinyin.getPingYin("YM_BZH_"+tagName));
			
					}else {
						data = kpcs.selectPointKeyDaySumCell(tablenames.get(tablenames.size() - 1),tablenames.get(tablenames.size() - 2), Pinyin.getPingYin("YM_BZH_"+tagName));
						
					}
					
					
				}else {
					// 如果是小区组,查询小区表
					String cellTable = kpcm.selectTablenameByTagname(tagName);
					// 两表联查,得出数据
					//data = gedm.generateSchoolExcel(string);
					data = kpcs.selectKeyPointSumCellInfo(tablenames.get(tablenames.size() - 1),tablenames.get(tablenames.size() - 2), cellTable,field);
					 
					
				}
				
			}
	//	}
		
		return data;	
	}

	@Override
	public byte[] generateSumTableExcel(String tagName, int colors, int two, HttpSession session) {
		DaySummaryBase[] data = generateSumExcel(tagName,two);
		
		System.out.println("查询出Un数据长度：" + data.length);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		
		for(int i = 0 ; i < data.length ; i ++) {
			try {
				dataList.add(GenerateExcel.bean2Map(data[i]));
				
				
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		System.out.println(dataList);
		
		String path = session.getServletContext().getRealPath("/");
		String finalXlsxPath = null;
		if(two == 0) {
			finalXlsxPath = path + "/web/model/modelSumCell.xlsx";
		}else if(two == 1) {
			finalXlsxPath = path + "/web/model/modelSumHourCell.xlsx";
		}else if(two == 2) {
			finalXlsxPath = path + "/web/model/modelSumDayCell.xlsx";
		}
		 
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return GenerateExcel2.writeExcel(dataList, finalXlsxPath, datatitle, session, getSetValue(dataList.get(0), session),colors,two);
	}

	private DaySummaryBase[] generateSumExcel(String tagName, int two) {
		String tablename = null;
		System.out.println("two"+two);
		String field = "";
		if(two == 0) {
			tablename = "^YM_AQ_ALLCELL\\d{12}$";
			field = "HM";
		}else if(two == 1) {
			tablename = "^YM_AH_ALLCELL\\d{10}$";
			field = "HH";
		}else {
			tablename = "^YM_AD_ALLCELL\\d{8}$";
		}
		
		// 查询出符合正则的所有表名
		ArrayList<String> tablenames = ds.selectStandardTableName(tablename);
		DaySummaryBase[] data = null;	
		
		System.out.println("tablenames"+tablenames.size());
		System.out.println(tablenames.get(tablenames.size() - 1));
		System.out.println("tagName"+tagName);

			if("VIP".equals(tagName)) {
				

			}else if("all".equals(tagName)){
				if(two == 2) {
					if(tablenames.size() == 1) {
						
						data = kpcs.selectAllDayNewSumCell(tablenames.get(tablenames.size() - 1),tablenames.get(tablenames.size() - 1));
					}else {

						
						data = kpcs.selectAllDayNewSumCell(tablenames.get(tablenames.size() - 1),tablenames.get(tablenames.size() - 2));
					}
				}else {
					data = kpcs.selectNewAllSumCell(tablenames.get(tablenames.size() - 1),tablenames.get(tablenames.size() - 2), field);
					
				}
				
				
			} else {
				// 如果是小区组,查询小区表
				String regTablename = kpcm.selectTablenameByTagname(tagName);
				if(two == 2) {
					if(tablenames.size() == 1) {

						data = kpcs.selectKeyDayNewSumCell(tablenames.get(tablenames.size() - 1), Pinyin.getPingYin("YM_BZH_"+tagName));
						
					}else {
						data = kpcs.selectKeyDayNewSumCell(tablenames.get(tablenames.size() - 1), Pinyin.getPingYin("YM_BZH_"+tagName));
						
					}
					
				}else {
					
					data = kpcs.selectKeyNewSumCellInfo(tablenames.get(tablenames.size() - 1),tablenames.get(tablenames.size() - 2), regTablename,field);
					
				}
			}
			
		return data;
	}
	
	@Override
	public byte[] generatetagNameExcel(String tagName, int colors, HttpSession session) {
		DaySummaryBase[] data = generatetagNameExcel(tagName);
		
		System.out.println("查询出Un数据长度：" + data.length);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		
		for(int i = 0 ; i < data.length ; i ++) {
			try {	
				dataList.add(GenerateExcel.bean2Map(data[i]));
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		String path = session.getServletContext().getRealPath("/");
		String finalXlsxPath = null;
		
			finalXlsxPath = path + "/web/model/modelTagName.xlsx";
		
		 
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session, getSetValue(dataList.get(0), session),colors);
	
	}

	private DaySummaryBase[] generatetagNameExcel(String tagName) {
		DaySummaryBase[] data = null;
		String tablename = "^YM_AD_ALLCELL\\d{8}$";
		ArrayList<String> tablenames = ds.selectStandardTableName(tablename);
		tagName = Pinyin.getPingYin("YM_BZH_"+tagName);
		System.out.println("tagName"+tagName);
		data = kpcs.selecttagNameData(tagName,tablenames.get(tablenames.size()-1));
		
		
		return data;
	}

	@Override
	public byte[] generateMinAllExcel(String tagName, int colors, HttpSession session) {
		AllNetworkBase[] data = generateMinNetworkCellDataExcel(tagName,colors);
		System.out.println("获取数据长度为：" + data.length);
		System.out.println(data[0]);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < data.length; i++) {
			try {
				System.out.println("data"+data[i]);
				dataList.add(GenerateExcel.bean2Map(data[i]));
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 获取服务器真实路径
		String path = session.getServletContext().getRealPath("/");
		// 拼接文件路径（模板excel）
		String finalXlsxPath = path + "/web/model/modelAllNetWork.xlsx";
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null ; 
		try {
			fis = new FileInputStream(file);
			// 获取excel头部信息
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session,getSetValue(dataList.get(0),session) ,colors);
	}

	private AllNetworkBase[] generateMinNetworkCellDataExcel(String tagName, int colors) {
		AllNetworkBase[] datas = null;
		String allTable = "YM_AQ_ALLK";
		String field = "HM";
		datas = ds.selectAllDatas(allTable, field,null);
		return datas;
	}

	@Override
	public byte[] generateSumExcelList(String tagName, int colors, String tableName, int l, String site, int two,
			HttpSession session) {
		DaySummaryBase[] data = null;
		tagName = Pinyin.getPingYin("YM_BZH_"+tagName);
		
		if(two != 2) {
			 if(l == 2) {
				 data = scs.selectDataByArea(tableName,site,tagName);
			 }
			 if(l == 3) {
				 data = scs.selectDataByServiceCell(tableName,site,tagName);
			 }
			 if(l == 4) {
				 data = scs.selectDataByHighCell(tableName,site,tagName);
			 }
			 if(l == 5) {
				 data = scs.selectDataByNotGbCell(tableName,site,tagName);
			 }
			 if(l == 6) {
				 data = scs.selectDataByDisturbCell(tableName,site,tagName);
			 }
			 if(l == 7) {
				 data = scs.selectDataByLinkCell(tableName,site,tagName);
			 }
			
		}else {
			if(l == 1) {
				data = scs.selectDataByArea(tableName,site,tagName);
			 }
			 if(l == 2) {
				 data = scs.selectDataByServiceCell(tableName,site, tagName);
			 }
			 if(l == 3) {
				 data = scs.selectDataByHighCell(tableName,site, tagName);
			 }
			 if(l == 4) {
				 data = scs.selectDataByNotGbCell(tableName,site, tagName);
			 }
			 if(l == 5) {
				 data = scs.selectDataByDisturbCell(tableName,site, tagName);
			 }
			 if(l == 6) {
				 data = scs.selectDataByLinkCell(tableName,site,tagName);
			 }
		}
		
		System.out.println("查询出Un数据长度：" + data.length);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		
		for(int i = 0 ; i < data.length ; i ++) {
			try {
				dataList.add(GenerateExcel.bean2Map(data[i]));
				
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		String path = session.getServletContext().getRealPath("/");
		String finalXlsxPath = null;
		if(two == 0) {
			if(l == 5) {
				finalXlsxPath = path + "/web/model/modelUnAllNetWork.xlsx";
				
			}else {
				finalXlsxPath = path + "/web/model/modelCell.xlsx";
			}
			
		}else if(two == 1) {
			if(l == 5) {
				finalXlsxPath = path + "/web/model/modelUnAllNetWork.xlsx";
				
			}else {
				finalXlsxPath = path + "/web/model/modelHourCell.xlsx";
			}
			
		}else if(two == 2) {
			if(l == 4) {
				finalXlsxPath = path + "/web/model/modelUnAllNetWork.xlsx";
				
			}else {
				finalXlsxPath = path + "/web/model/modelDayCell.xlsx";
			}
			
		}
		 
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session, getSetValue(dataList.get(0), session),colors);
	}

	@Override
	public byte[] generateSumMaryExcel(String tagName, int colors, String tableName, int sumLength, int two,
			HttpSession session) {
		DaySummaryBase[] data = null;
		tagName = Pinyin.getPingYin("YM_BZH_"+tagName);
		
		
			if(sumLength == 0) {
				data = scs.selectDataAllCell(tagName,tableName);
			}
			if(sumLength == 1) {
				data = scs.selectDataAllServiceCell(tagName,tableName);
			}
			if(sumLength == 2) {
				data = scs.selectDataAllHightCell(tagName,tableName);
			}
			if(sumLength == 3) {
				data = scs.selectDataAllNotGbCell(tagName,tableName);
			}
			if(sumLength == 4) {
				data = scs.selectDataAllDisturbCell(tagName,tableName);
			}
			if(sumLength == 5) {
				data = scs.selectDataLinkCell(tagName,tableName);
			}
			
		
		
		System.out.println("查询出Un数据长度：" + data.length);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		
		for(int i = 0 ; i < data.length ; i ++) {
			try {
				dataList.add(GenerateExcel.bean2Map(data[i]));
				
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		String path = session.getServletContext().getRealPath("/");
		String finalXlsxPath = null;
		if(sumLength == 3) {
			finalXlsxPath = path + "/web/model/modelUnAllNetWork.xlsx";
			
		}else if(sumLength == 5){
			finalXlsxPath = path + "/web/model/modelLink.xlsx";
					
		}else{
			finalXlsxPath = path + "/web/model/modelCell.xlsx";
		}
		File file = new File(finalXlsxPath);
		List<String> datatitle = null;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			datatitle = cn.huahai.tel.util.ReadExcel.getTitleArr(fis, file.getName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return GenerateExcel.writeExcel(dataList, finalXlsxPath, datatitle, session, getSetValue(dataList.get(0), session),colors);
	}

	
	
}
