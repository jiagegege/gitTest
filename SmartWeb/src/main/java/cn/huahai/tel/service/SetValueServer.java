package cn.huahai.tel.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.huahai.tel.bean.CriticalValueBase;
import cn.huahai.tel.mapper.SetValueMapper;
import net.sf.json.JSONArray;

@Service
public class SetValueServer implements ISetValueServer {
	@Value("#{setting[allNetJsonvalue]}")
	private String allNetJsonvalue;
	
	@Value("#{setting[topCellJsonvalue]}")
	private String topCellJsonvalue;

	@Resource
	private SetValueMapper svm;
	
	@Override
	public String getJsonValue(String username, String flag) {
		// TODO Auto-generated method stub
		String jsonvalue = null;
		if("topCell".equals(flag)) {
			jsonvalue = svm.selectTopCellJsonValue(username);
			//如果数据库中查询不到结果，则则直接进行默认值的插入
			if(jsonvalue == null) {
				svm.insertTopCellJsonValue(username, topCellJsonvalue);
				jsonvalue = topCellJsonvalue;
			}
		}else if("allNet".equals(flag)) {
			jsonvalue = svm.selectAllNetJsonValue(username);
			if(jsonvalue == null) {
				svm.insertAllNetJsonValue(username, allNetJsonvalue);
				jsonvalue = allNetJsonvalue;
			}
			
		}
		return jsonvalue;
	}
	@Override
	public void setJsonValue(String username, String flag, String jsonValue) {
		// TODO Auto-generated method stub
		if("topCell".equals(flag)) {
			svm.updateTopCellJsonValue(username, jsonValue);
		}else if("allNet".equals(flag)) {
			svm.updateAllNetJsonValue(username, jsonValue);
		}
	}
	@Override
	public List<CriticalValueBase> getJsonValueBean(String username, String flag) {
		// TODO Auto-generated method stub
		Object data = getJsonValue(username, flag);
		System.out.println("datass"+data);
		JSONArray jsonarray = null;
		if(data!=null&&!"".equals(data)) {
			jsonarray = JSONArray.fromObject(data);
		}
		
		List<CriticalValueBase> datas = null;
		
		try {
			datas= (List<CriticalValueBase>)JSONArray.toCollection(jsonarray,CriticalValueBase.class);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return datas;
	}
}
