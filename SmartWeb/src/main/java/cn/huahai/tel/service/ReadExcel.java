package cn.huahai.tel.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huahai.tel.mapper.ImportExcelMapper;
import cn.huahai.tel.util.SplitList;

@Service
public class ReadExcel implements IReadExcel {
	@Resource
	ImportExcelMapper iem;
	@Override
	public List<Map<String, String>> readExcel(FileInputStream fis, String filename, Map<String,String> m) throws Exception {
		List<Map<String, String>> ls = new ArrayList<Map<String, String>>();
		ls = cn.huahai.tel.util.ReadExcel.parseExcel(fis, filename, m);
		for(int i = 0;i<ls.size();i++) {
			Map<String, String> map = ls.get(i);
			//cell表判断追加eNodebid_LCRID
//			if(!map.containsKey("eNodebid_LCRID")) {
				String enodeid = map.get("eNodebid");
				String lcrid = map.get("LCRID");
				map.put("eNodebid_LCRID", enodeid+"_"+lcrid);
//			}
			//cell表判断追加eNodebid_Cellid
//			if(!map.containsKey("eNodebid_Cellid")) {
//				String enodeid = map.get("eNodebid");
				String cellid = map.get("CELLID");
				map.put("eNodebid_Cellid", enodeid+"_"+cellid);
//			}
		}
		return ls;
	}

	@Override
	public Map<String, String> setMapping(List<String> list, Map<String, String> map) {
		for(String str : list) {
		    map.put(str, str);
		}
		return map;
	}
	@Override
	public boolean tableExist(String tablename) {
		return iem.tableExist(tablename)>0;
	}
	
	@Override
	public void createTable(String tablename, List<String> fields) {
		if(iem.tableExist(tablename)>0) {
			iem.deleteTable(tablename);
		}
		iem.createTable(fields, tablename);
	}

	@Override
	public void insertBatchData(List<Map<String, String>> data, String tablename) {
		int n =data.size();
		//将长list 分隔成若干份每份80个
		if(data.size()>80) {
			n = data.size()/80;
		}else {
			n = 1;
		}
		List<List<Map<String, String>>> d =  SplitList.averageAssign(data, n);
//		重新获取字段值
		List<String> fields = new ArrayList<String>();
		for (Entry<String, String> entry : d.get(0).get(0).entrySet()) {  
//		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
		    fields.add(entry.getKey());
		}
		Long time1 = System.currentTimeMillis();
//		分段，批量插入，以提高性能
		for(int i=0;i<n;i++) {
			iem.insertData(d.get(i), fields, tablename);
		}
		Long time2 = System.currentTimeMillis();
		//此处需要大量插入数据，特此记录时间
		System.out.println("插入cell数据所用时间"+(time2-time1));
	}

	@Override
	public void changTablename(String oldTablename, String newTablename) {
		// TODO Auto-generated method stub
		iem.changeTablename(oldTablename, newTablename);
	}

	@Override
	public void deleteTablename(String tablename) {
		if(iem.tableExist(tablename)>0) {
			iem.deleteTable(tablename);
		}
	}

	@Override
	public void createYM_SYS_NB_T() {
		if(iem.tableExist("YM_SYS_NB_T")>0) {
			iem.deleteTable("YM_SYS_NB_T");
		}
		iem.copyDistinctTable();
	}

	@Override
	public void addfield() {
		iem.alterfield("YM_sys_NB_T", "ps");
	}
	
}
