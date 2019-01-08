package cn.huahai.tel.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.huahai.tel.bean.AllNetworkBase;
import cn.huahai.tel.bean.DaySummaryBase;
import cn.huahai.tel.bean.ResponseResult;
import cn.huahai.tel.service.ISchoolSever;
import cn.huahai.tel.util.Pinyin;
import net.sf.json.JSON;

@Controller
@RequestMapping("/sc")
public class SchoolController {
	@Resource
	ISchoolSever scs ;
	
	@RequestMapping("/selectMinAllDataByDatas.do")
	@ResponseBody
	public ResponseResult<DaySummaryBase[]> selectMinAllDataByDatas(String tagName, 
			String datas,String stime,int l,String site){
		ResponseResult<DaySummaryBase[]> rr = new ResponseResult<DaySummaryBase[]>();
		System.out.println("bbbb"+tagName);
		tagName =Pinyin.getPingYin("YM_BZH_"+tagName);
		String tableReg = "YM_AQ_ALLCELL";
		if(stime.length()<12) {
			String ss3 = stime.substring(0, stime.length()-3);
			String a = stime.substring(stime.length()-3);
			stime = ss3 +"0"+a;
			
		}
		String tableName = tableReg + stime;
		
			 if(l == 2) {
				 rr.setData(scs.selectDataByVip(tableName,datas,tagName));
			 }
			 if(l == 3) {
				 rr.setData(scs.selectDataByCell(tableName,site,tagName));
			 }
			 if(l == 4) {
				 rr.setData(scs.selectDataByflow(tableName,site,tagName));
			 }
			 if(l == 6) {
				 rr.setData(scs.selectDataByLoadCell(tableName,site,tagName));
			 }
			 if(l == 7) {
				 rr.setData(scs.selectDataByNotCell(tableName,site,tagName));
			 }
			
			 if(l == 8) {				
					rr.setData(scs.selectDataByMaxAc(tableName,datas,site,tagName)); 
			 }
		
			
			
		rr.setMessage("查询成功");
		rr.setState(1);
		return rr;
		
	}
	@RequestMapping("/selectHourAllDataByDatas.do")
	@ResponseBody
	public ResponseResult<DaySummaryBase[]> selectHourAllDataByDatas(String tagName, 
			String datas,String stime,int l,String site){
		ResponseResult<DaySummaryBase[]> rr = new ResponseResult<DaySummaryBase[]>();
		System.out.println("bbbb"+tagName);
		tagName =Pinyin.getPingYin("YM_BZH_"+tagName);
		String tableReg = "YM_AH_ALLCELL";
		if(stime.length()<10) {
			String ss3 = stime.substring(0, stime.length()-1);
			String a = stime.substring(stime.length()-1);
			stime = ss3 +"0"+a;
			
		}
		String tableName = tableReg + stime;
		
			 if(l == 2) {
				 rr.setData(scs.selectDataByVip(tableName,datas, tagName));
			 }
			 if(l == 3) {
				 rr.setData(scs.selectDataByCell(tableName,site, tagName));
			 }
			 if(l == 4) {
				 rr.setData(scs.selectDataByflow(tableName,site, tagName));
			 }
			 if(l == 6) {
				 rr.setData(scs.selectDataByLoadCell(tableName,site, tagName));
			 }
			 if(l == 7) {
				 rr.setData(scs.selectDataByNotCell(tableName,site, tagName));
			 }
			
			 if(l == 8) {				
					rr.setData(scs.selectDataByMaxAc(tableName,datas,site, tagName)); 
			 }
		
			
			
		rr.setMessage("查询成功");
		rr.setState(1);
		return rr;
		
	}
	@RequestMapping("/selectDayAllDataByDatas.do")
	@ResponseBody
	public ResponseResult<DaySummaryBase[]> selectDayAllDataByDatas(String tagName, 
			String datas,String stime,int l,String site){
		ResponseResult<DaySummaryBase[]> rr = new ResponseResult<DaySummaryBase[]>();
		System.out.println("bbbb"+tagName);
		String tableReg = "YM_AD_ALLCELL";
		tagName =Pinyin.getPingYin("YM_BZH_"+tagName);
		String tableName = tableReg + stime;
		
			 if(l == 1) {
				 rr.setData(scs.selectDataByVip(tableName,datas, tagName));
			 }
			 if(l == 2) {
				 rr.setData(scs.selectDataByCell(tableName,site, tagName));
			 }
			 if(l == 3) {
				 rr.setData(scs.selectDataByflow(tableName,site, tagName));
			 }
			 if(l == 5) {
				 rr.setData(scs.selectDataByLoadCell(tableName,site, tagName));
			 }
			 if(l == 6) {
				 rr.setData(scs.selectDataByNotCell(tableName,site, tagName));
			 }
			
			 if(l == 7) {				
					rr.setData(scs.selectDataByMaxAc(tableName,datas,site, tagName)); 
			 }
		
			
			
		rr.setMessage("查询成功");
		rr.setState(1);
		return rr;
		
	}
	@RequestMapping("/selectMinNewAllDataByDatas.do")
	@ResponseBody
	public ResponseResult<DaySummaryBase[]> selectMinNewAllDataByDatas(String tagName, 
			String datas,String stime,int l,String site){
		ResponseResult<DaySummaryBase[]> rr = new ResponseResult<DaySummaryBase[]>();
		System.out.println("bbbb"+tagName);
		
	//	String a = Pinyin("YM_BZH_"+tagName);
		String tableName = null;
		tagName =Pinyin.getPingYin("YM_BZH_"+tagName);
		
		String tableReg = "YM_AQ_ALLCELL";
		
		System.out.println("stime"+stime);
		if(stime.length()<12) {
			String ss3 = stime.substring(0, stime.length()-3);
			String a = stime.substring(stime.length()-3);
			stime = ss3 +"0"+a;
			
		}
			tableName = tableReg + stime;
			System.out.println("tableName");
		
			

			 if(l == 2) {
				 rr.setData(scs.selectDataByArea(tableName,site,tagName));
			 }
			 if(l == 3) {
				 rr.setData(scs.selectDataByServiceCell(tableName,site,tagName));
			 }
			 if(l == 4) {
				 rr.setData(scs.selectDataByHighCell(tableName,site,tagName));
			 }
			 if(l == 5) {
				 rr.setData(scs.selectDataByNotGbCell(tableName,site,tagName));
			 }
			 if(l == 6) {
				 rr.setData(scs.selectDataByDisturbCell(tableName,site,tagName));
			 }
			 if(l == 7) {
				 rr.setData(scs.selectDataByLinkCell(tableName,site,tagName));
			 }
			
			
		
			
			
		rr.setMessage("查询成功");
		rr.setState(1);
		return rr;
		
	}
	@RequestMapping("/selectHourNewAllDataByDatas.do")
	@ResponseBody
	public ResponseResult<DaySummaryBase[]> selectHourNewAllDataByDatas(String tagName, 
			String datas,String stime,int l,String site){
		ResponseResult<DaySummaryBase[]> rr = new ResponseResult<DaySummaryBase[]>();
		System.out.println("bbbb"+tagName);
		tagName =Pinyin.getPingYin("YM_BZH_"+tagName);
		String tableReg = "YM_AH_ALLCELL";
		if(stime.length()<10) {
			String ss3 = stime.substring(0, stime.length()-1);
			String a = stime.substring(stime.length()-1);
			stime = ss3 +"0"+a;
			
		}
		String tableName = tableReg + stime;
		
			 if(l == 2) {
				 rr.setData(scs.selectDataByArea(tableName,site,tagName));
			 }
			 if(l == 3) {
				 rr.setData(scs.selectDataByServiceCell(tableName,site, tagName));
			 }
			 if(l == 4) {
				 rr.setData(scs.selectDataByHighCell(tableName,site, tagName));
			 }
			 if(l == 5) {
				 rr.setData(scs.selectDataByNotGbCell(tableName,site, tagName));
			 }
			 if(l == 6) {
				 rr.setData(scs.selectDataByDisturbCell(tableName,site, tagName));
			 }
			 if(l == 7) {
				 rr.setData(scs.selectDataByLinkCell(tableName,site,tagName));
			 }
			
			
		
			
			
		rr.setMessage("查询成功");
		rr.setState(1);
		return rr;
		
	}
	@RequestMapping("/selectDayNewAllDataByDatas.do")
	@ResponseBody
	public ResponseResult<DaySummaryBase[]> selectDayNewAllDataByDatas(String tagName, 
			String datas,String stime,int l,String site){
		ResponseResult<DaySummaryBase[]> rr = new ResponseResult<DaySummaryBase[]>();
		System.out.println("bbbb"+tagName);
		String tableReg = "YM_AD_ALLCELL";
		tagName =Pinyin.getPingYin("YM_BZH_"+tagName);
		String tableName = tableReg + stime;
		
			 if(l == 1) {
				 rr.setData(scs.selectDataByArea(tableName,site,tagName));
			 }
			 if(l == 2) {
				 rr.setData(scs.selectDataByServiceCell(tableName,site, tagName));
			 }
			 if(l == 3) {
				 rr.setData(scs.selectDataByHighCell(tableName,site, tagName));
			 }
			 if(l == 4) {
				 rr.setData(scs.selectDataByNotGbCell(tableName,site, tagName));
			 }
			 if(l == 5) {
				 rr.setData(scs.selectDataByDisturbCell(tableName,site, tagName));
			 }
			 if(l == 6) {
				 rr.setData(scs.selectDataByLinkCell(tableName,site,tagName));
			 }
			 
			
			
		 
			
		rr.setMessage("查询成功");
		rr.setState(1);
		return rr;
		
	}
	@RequestMapping("/selectAllData.do")
	@ResponseBody
	public ResponseResult<DaySummaryBase[]> selectAllData(String tagName, 
			int two,String datetime,String data,int sumLength){
		ResponseResult<DaySummaryBase[]> rr = new ResponseResult<DaySummaryBase[]>();
		System.out.println("bbbb"+tagName);
		String tableReg = "";
		String tableName = "";
		if(two == 0) {
			
			tableName = "YM_AQ_ALLCELL"+datetime;						
		}else if(two == 1) {
			tableName = "YM_AH_ALLCELL"+datetime;	
		}else {
			tableName = "YM_AD_ALLCELL"+datetime;	
		}
		
		if(tagName.equals("all")) {
			tagName =Pinyin.getPingYin("YM_BZH_"+tagName);
		}else {
			tagName =Pinyin.getPingYin("YM_BZH_"+tagName);
		}
		if(sumLength == 0) {
			rr.setData(scs.selectDataAllCell(tagName,tableName));
		}
		if(sumLength == 1) {
			rr.setData(scs.selectDataAllServiceCell(tagName,tableName));
		}
		if(sumLength == 2) {
			rr.setData(scs.selectDataAllHightCell(tagName,tableName));
		}
		if(sumLength == 3) {
			rr.setData(scs.selectDataAllNotGbCell(tagName,tableName));
		}
		if(sumLength == 4) {
			rr.setData(scs.selectDataAllDisturbCell(tagName,tableName));
		}
		 if(sumLength == 5) {
			 rr.setData(scs.selectDataLinkCell(tableName,tagName));
		 }
		

			
			
		rr.setMessage("查询成功");
		rr.setState(1);
		return rr;
		
	}
	@RequestMapping("/AnInsert.do")
	@ResponseBody
	public ResponseResult<DaySummaryBase[]> AnInsert(HttpServletRequest res,HttpServletResponse response){
		ResponseResult<DaySummaryBase[]> rr = new ResponseResult<DaySummaryBase[]>();
		
		String cc =  res.getParameter("requestBody");
		String bb =  res.getParameter("data");
	
		System.out.println("bb"+res.getParameterNames());
		System.out.println("cc"+response.toString());
		System.out.println();
		
		System.out.println("caa"+res.toString());
		
		rr.setMessage("查询成功");
		rr.setState(1);
		return rr;
		
	}

}
