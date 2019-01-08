package cn.huahai.tel.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.huahai.tel.bean.ResponseResult;
import cn.huahai.tel.service.ISetValueServer;

/**
 * 临界值相关控制器
 * @author lijia
 *
 */
@Controller
@RequestMapping("/setValue")
public class SetValueController {
	
	@Value("#{setting[allNetJsonvalue]}")
	public String allNetJsonvalue;
	
	@Value("#{setting[topCellJsonvalue]}")
	public String topCellJsonvalue;
	
	@Resource
	private ISetValueServer svm;
	
	/**
	 * 根据username和flag查找渲染表格颜色的临界值
	 * @param username 用户名
	 * @param flag flag为topCell，查询top小区，flag为allNet，查询全网指标
	 * @return 临界值的json字符串
	 */
	@RequestMapping("/getJsonValue.do")
	@ResponseBody
	public ResponseResult<String> getJsonValue(
			@RequestParam("username") String username,
			@RequestParam("flag") String flag){
		ResponseResult<String> rr = new ResponseResult<String>();
		String data = svm.getJsonValue(username, flag);
		
		rr.setData(data);
		rr.setMessage("查询成功");
		rr.setState(1);
		return rr;
	}
	/**
	 * 根据用户名修改临界值
	 * @param username 用户名
	 * @param jsonvalue 临界值json字符串
	 * @param flag flag为topCell，修改top小区，flag为allNet，修改全网指标
	 * @return 是否修改成功
	 */
	@RequestMapping("/setJsonValue.do")
	@ResponseBody
	public ResponseResult<Void> setJsonValue(
			@RequestParam("username") String username,
			@RequestParam("jsonValue") String jsonvalue,
			@RequestParam("flag") String flag){
		svm.setJsonValue(username, flag, jsonvalue);
		ResponseResult<Void> rr = new ResponseResult<Void>();
		rr.setMessage("修改成功");
		rr.setState(1);
		return rr;
	}
}
