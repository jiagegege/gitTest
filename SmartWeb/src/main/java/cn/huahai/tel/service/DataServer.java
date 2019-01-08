package cn.huahai.tel.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huahai.tel.bean.AllNetworkBase;
import cn.huahai.tel.mapper.AllNetworkBaseMapper;

@Service
public class DataServer implements IDataServer {
	@Resource
	AllNetworkBaseMapper anbm;
	//查询全网数据
	public AllNetworkBase[] selectAllData(String tablename,String field,Integer number) {
		
		return anbm.selectAllNetworkbase(tablename,field,number);
	}
	public AllNetworkBase[] selectAllDatas(String tablename,String field,Integer number) {
		
		return anbm.selectAllNetworkbases(tablename,field,number);
	}

	//查询符合标准的表名称
	public ArrayList<String> selectStandardTableName(String reg) {
		String[] tablenames = anbm.selectAllTableName();
		ArrayList<String> standardTableName = new ArrayList<String>(tablenames.length);
		for(int i = 0;i<tablenames.length;i++) {
			boolean result=Pattern.compile(reg).matcher(tablenames[i]).find();
			if(result) {
				standardTableName.add(tablenames[i]);
			}
		}
		Collections.sort(standardTableName);
		return standardTableName;
	}
	
}
