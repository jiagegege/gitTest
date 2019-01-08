package cn.huahai.tel.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huahai.tel.bean.OnlineList;
import cn.huahai.tel.mapper.VisitCountMapper;

/**
 * 记录访问次数
 * @author lizhuodong
 *
 */
@Service
public class VisitCountServer implements IVisitCountServer {
	@Resource
	private VisitCountMapper vc;
	
	@Override
	/**
	 * 记录访问次数，如果路径过长，则从后截取响应字符长度
	 */
	public void addVisitData(String requestURI,String queryString) {
		String path = null;
		if(queryString == null) {
			path = requestURI;
		}else {
			path = requestURI+"?"+queryString;
		}
		//中文进行编码
		try {
			path = URLDecoder.decode(path, "UTF-8");
			if(path.length()>100) {
				path = path.substring(path.length()-99, path.length());
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(vc.pathExit(path) == 0) {
			vc.insertVisitData(path);
		}else {
			Integer count = vc.getVisitDataByPath(path) + 1;
			vc.updateVisitData(path, count);
		}

	}

	@Override
	public void addVisitIpData(String ip, String date) {
		// TODO Auto-generated method stub
		vc.insertIpdate(ip, date);
	}

	

	

	

}
