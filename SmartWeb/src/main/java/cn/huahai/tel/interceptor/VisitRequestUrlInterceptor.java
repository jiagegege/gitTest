package cn.huahai.tel.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.huahai.tel.service.VisitCountServer;

/**
 * 访问路径统计
 * @author lijia
 *
 */
public class VisitRequestUrlInterceptor  implements HandlerInterceptor {
	@Resource
	VisitCountServer vcs;
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
	// 	vcs.addVisitData(request.getRequestURI(), request.getQueryString());
		return true;
	}

}
