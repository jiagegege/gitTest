package cn.huahai.tel.controller;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.huahai.tel.bean.OnlineList;

public class OnlineSessionListener implements HttpSessionListener{
	 OnlineList ol = OnlineList.getInstance();
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
		// TODO Auto-generated method stub
		ol.addSession();
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		ol.addSession();
	}

}
