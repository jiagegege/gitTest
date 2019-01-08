package cn.huahai.tel.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.huahai.tel.bean.CriticalValueBase;
import cn.huahai.tel.bean.ResponseResult;
import cn.huahai.tel.service.DataServer;
import cn.huahai.tel.service.IAllNetwork;
import cn.huahai.tel.service.IGenerateExcelDataServer;
import cn.huahai.tel.util.FileNameConversion;
import cn.huahai.tel.util.SetValueParseExcel;
/**
 * 概述：全网级excel查询下载相关
 * @author lijia
 *
 */

@Controller
@RequestMapping("/allNetwork")
public class AllNetworkController {
	/**
	 * excel文件的本地路径
	 */
	@Value("#{setting[excelPath]}")
	public String localFileSrc;
	@Resource
	private IAllNetwork anw;
	@Resource
	private DataServer ds;
	@Resource
	private IGenerateExcelDataServer geds;
	//打印日志
	private static Logger logger = Logger.getLogger(AllNetworkController.class);
	/**
	 * 前端传入excel文件名，后台根据事先设置好的路径，读取excel文件并返回文件流
	 * @param filename excel文件名
	 * @param excelname 文件名
	 * @param session session
	 * @param response 响应对象
	 * @param request 请求对象
	 */
	@RequestMapping("/getAllNetWork.do")
	public void getAllNetwork(
			String filename,
			String excelname,
			int colors,
			HttpSession session,HttpServletResponse response,HttpServletRequest request) {
		System.out.println(excelname);
		
		InputStream in = null;
		OutputStream out = null;
		//中文进行编码
		try {
			filename = URLDecoder.decode(filename, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		try {
			File srcFlie = new File(localFileSrc+excelname);
			in = new FileInputStream(srcFlie);
			//获取文件头部名称
			Map<String, Object> titlemap = SetValueParseExcel.getTitleArr(in, filename);
			System.out.println("获取文件头");
			//获取临界值
			List<CriticalValueBase> jsonValue = geds.getSetValue(titlemap, session);
			System.out.println("获取临界值");
			//设置响应头
			FileNameConversion.setHeader(response, request, filename);
			System.out.println("设置响应头");
			//获取文件输出流
			out = response.getOutputStream();
			//输入流被关闭，重新获取。
			System.out.println("开始解析文件");
			in = new FileInputStream(srcFlie);
			SetValueParseExcel.parseExcel(in, filename,jsonValue, out,colors);
			/*byte[] buf = new byte[1024*8];
			int length = 0;
			while((length = in.read(buf)) != -1) {
				out.write(buf, 0, length);
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				if(out != null) {
					out.close();
				}
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error(e);
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 前端传入flag字符串，后台返回相应的文件列表
	 * @param flag  1代表全网数据 ，2代表小区数据数据，3代表Top小区数据
	 * @param session session对象
	 * @return 文件名称的集合
	 */
	@RequestMapping("/getAllNetworkFileList.do")
	@ResponseBody
	public ResponseResult<List<String>> getAllNetworkFileList(String flag,HttpSession session){
		ResponseResult<List<String>> rr =  new ResponseResult<List<String>>();
		String tablename = "^YM_AQ_ALLCELL\\d{12}$";
		ArrayList<String> tablenames = ds.selectStandardTableName(tablename);

//		Collections.sort(tablenames);
		System.out.println(localFileSrc);
		//如果是15分钟
		switch (flag) {
			case "1":
				rr.setData(anw.getFileList(localFileSrc,"全网监控_Q\\d{12}.(xls|xlsx)"));
				break;
			case "2":
				rr.setData(anw.getFileList(localFileSrc,"小区监控_Q\\d{12}.(xls|xlsx)"));
				break;
			case "3":
				rr.setData(anw.getFileList(localFileSrc,"Top小区监控_Q\\d{12}.(xls|xlsx)"));
				break;
			case "4":
				rr.setData(anw.getFileList(localFileSrc,"Alarm\\d{12}.(xls|xlsx)"));
				break;
			case "5":
				rr.setData(anw.getFileList(localFileSrc,"基站链路监控\\d{12}.(xls|xlsx)"));
				break;
			case "6":
				rr.setData(anw.getFileList(localFileSrc,"系统工参\\d{8}.(xls|xlsx)"));
				break;
			case "7":
				rr.setData(anw.getFileList(localFileSrc,"最大用户数核查\\d{8}.(xls|xlsx)"));
				break;
			case "8":
				rr.setData(tablenames);
				break;
			
				
			default:
				break;
		}
		rr.setMessage("获取成功");
		rr.setState(1);
		return rr;
	}
	
	
	
	/**
	 * 
	 * @return 天极小区级excel文件列表 
	 */
	@RequestMapping("/getDayTopCellFileList.do")
	@ResponseBody
	public ResponseResult<List<String>> getDayTopCellFileList(){
		ResponseResult<List<String>> rr =  new ResponseResult<List<String>>();
		String tablename = "^YM_AD_ALLCELL\\d{8}$";
		//查询出符合正则的所有表名
		ArrayList<String> tablenames = ds.selectStandardTableName(tablename);
		System.out.println("天tablenames"+tablenames.size());
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int timeNumber1=Integer.parseInt(o1.split("ALLCELL")[1]);
				int timeNumber2=Integer.parseInt(o2.split("ALLCELL")[1]);
				if(timeNumber1<timeNumber2)
					return 1;
				//注意！！返回值必须是一对相反数，否则无效。jdk1.7以后就是这样。
			//else return 0; //无效
				else return -1;
			}
		};	
		Collections.sort(tablenames,c);
		rr.setData(tablenames);
		rr.setMessage("获取成功");
		rr.setState(1);
		return rr;
	};
	/**
	 * 前端传入flag字符串，后台返回相应的文件列表(小时级)
	 * @param flag  1代表全网数据 ，2代表小区数据数据，3代表Top小区数据
	 * @return 文件名称的集合
	 */
	@RequestMapping("/getHourAllNetworkFileList.do")
	@ResponseBody
	public ResponseResult<List<String>> getHourAllNetworkFileList(String flag){
		ResponseResult<List<String>> rr =  new ResponseResult<List<String>>();
		String tablename = "^YM_AH_ALLCELL\\d{10}$";
		//查询出符合正则的所有表名
		ArrayList<String> tablenames = ds.selectStandardTableName(tablename);
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int timeNumber1=Integer.parseInt(o1.split("ALLCELL")[1]);
				int timeNumber2=Integer.parseInt(o2.split("ALLCELL")[1]);
				if(timeNumber1<timeNumber2)
					return 1;
				//注意！！返回值必须是一对相反数，否则无效。jdk1.7以后就是这样。
			//else return 0; //无效
				else return -1;
			}
		};	
		Collections.sort(tablenames,c);
		//如果是小时级
		switch (flag) {
			case "1":
				rr.setData(tablenames);
				break;
			case "2":
				rr.setData(tablenames);
				break;
			case "3":
				rr.setData(tablenames);
				break;
			case "4":
				rr.setData(anw.getFileList(localFileSrc,"0流量_监控_H\\d{10}.(xls|xlsx)"));
				break;
			default:
				break;
		}
		rr.setMessage("获取成功");
		rr.setState(1);
		return rr;
	};
	@RequestMapping("/getDates.do")
	@ResponseBody
	public ResponseResult<List<String>> getDates(String two){
		ResponseResult<List<String>> rr =  new ResponseResult<List<String>>();
		String tablename= "";
		if(two.equals("0")) {
			tablename = "^YM_AQ_ALLCELL\\d{12}$";
		}else if(two.equals("1")) {
			tablename = "^YM_AH_ALLCELL\\d{10}$";
		}else {
			tablename = "^YM_AD_ALLCELL\\d{8}$";
		}
		
		//查询出符合正则的所有表名
		ArrayList<String> tablenames = ds.selectStandardTableName(tablename);
			
		Collections.sort(tablenames);
		//如果是小时级
		switch (two) {
			case "0":
				rr.setData(tablenames);
				break;
			case "1":
				rr.setData(tablenames);
				break;
			case "2":
				rr.setData(tablenames);
				break;
			
			default:
				break;
		}
		rr.setMessage("获取成功");
		rr.setState(1);
		return rr;
	};
	
}
