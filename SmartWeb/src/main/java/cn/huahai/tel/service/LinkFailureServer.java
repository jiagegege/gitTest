package cn.huahai.tel.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huahai.tel.bean.LinkFailure;
import cn.huahai.tel.mapper.LinkFailureMapper;
import cn.huahai.tel.util.Pinyin;

@Service
public class LinkFailureServer implements ILinkFailureServer {
	@Resource
	IDataServer ds;
	@Resource
	LinkFailureMapper lfm;
	public LinkFailure[] selectLinkFailure() {
		
		// TODO Auto-generated method stub
		System.out.println("持久层查询出：" + lfm.selectLinkFailure().length+"条");
		return lfm.selectLinkFailure();
	}
	@Override
	public ArrayList<LinkFailure> selectNewLinkFailure(String tagName) {
		// TODO Auto-generated method stub
		ArrayList<LinkFailure> data = new ArrayList<LinkFailure>();
		
		 //添加链路表名正则
      	String tableReg = "^YM_SYS_LINKBAD\\d+$";
  		// 查询出符合正则的所有表名
  		ArrayList<String> tablenames = ds.selectStandardTableName(tableReg);
  		System.out.println("YM_SYS_LINKBAD表"+tablenames.size());
		for (String string : tablenames) {
			if("all".equals(tagName)) {
				data.add(lfm.selectAllLinkFailure(string));
			}else if("VIP小区".equals(tagName)) {
				data.add(lfm.selectVipLinkFailure(string));
			}else{
				data.add(lfm.selectPointLinkFailure(string,Pinyin.getPinYinHeadChar("YM_BZH_"+tagName)));
				//Pinyin.getPinYinHeadChar("YM_BZH_"+tagName);
				System.out.println(Pinyin.getPinYinHeadChar("YM_BZH_"+tagName));
			};
		}
		return data;
	}

}
