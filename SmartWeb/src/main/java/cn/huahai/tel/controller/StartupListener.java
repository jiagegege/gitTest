package cn.huahai.tel.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import cn.huahai.tel.bean.HourTopCellworkBase;
import cn.huahai.tel.mapper.AllNetworkBaseMapper;
import cn.huahai.tel.mapper.ImportExcelMapper;
import cn.huahai.tel.mapper.LinkFailureMapper;
import cn.huahai.tel.mapper.StartupListenerMapper;
import cn.huahai.tel.mapper.TopCellworkBaseMapper;
import cn.huahai.tel.service.IDataServer;

/**
 * 进行相关数据表的初始化
 * @author lijia
 *
 */
@Component  
public class StartupListener implements ApplicationContextAware, ServletContextAware,  
        InitializingBean, ApplicationListener<ContextRefreshedEvent> {
	private String flag = "000000";
	@Resource
	private ImportExcelMapper iem;
	@Resource
	private LinkFailureMapper lfm;
	@Resource
	private AllNetworkBaseMapper anbm;
	@Resource								
	private StartupListenerMapper slm;
	@Resource
	IDataServer ds;
    @Override  
    public void setApplicationContext(ApplicationContext ctx) throws BeansException { 
    	
        System.out.println("1 => StartupListener.setApplicationContext");
        List<String> tableNames = Arrays.asList(anbm.selectAllTableName());
        //初始化创建访问相关的表
        if(tableNames.indexOf("YM_BZH_MAPPRING") < 0) {
        	slm.createYM_BZH_MAPPRING();
        }
        if(tableNames.indexOf("VISITCOUNT") < 0) {
        	slm.createVISITCOUNT();
        }
        if(tableNames.indexOf("VISIT_IP_COUNT") < 0) {
        	slm.createVISIT_IP_COUNT();
        }
        if(tableNames.indexOf("ALLNET_JSONVALUE") < 0) {
        	slm.createALLNET_JSONVALUE();
        }
        if(tableNames.indexOf("TOPCELL_JSONVALUE") < 0) {
        	slm.createTopCELL_JSONVALUE();
        }
    }  
   
    @Override  
    public void setServletContext(ServletContext context) {  
        System.out.println("2 => StartupListener.setServletContext");
    }  
   
    @Override  
    public void afterPropertiesSet() throws Exception {  
        System.out.println("3 => StartupListener.afterPropertiesSet");
    }  
    @Override  
    public void onApplicationEvent(ContextRefreshedEvent evt) {  
        System.out.println("4.1 => MyApplicationListener.onApplicationEvent");
        if (evt.getApplicationContext().getParent() == null) {  
            System.out.println("4.2 => MyApplicationListener.onApplicationEvent");
        }  
    }
    @Scheduled(fixedDelay = 600000)
    public void Interval () {
    	System.out.println("开始执行10分钟之后的延迟"+flag);
    	System.out.println( new Date());
    	 //声明保存表名和时间的list
        ArrayList<Map<String,String>> linkFailureData = new ArrayList<Map<String,String>>();
        
        //添加链路表名正则
      	String tableReg = "^YM_SYS_LINKBAD\\d+$";
  		// 查询出符合正则的所有表名
  		ArrayList<String> tablenames = ds.selectStandardTableName(tableReg);
  		for (String string : tablenames) {
  			Map<String,String> item = new HashMap<String,String>();
  			String date = lfm.selectDateTimeByTablename(string);
			item.put("tableName", string);
			item.put("tableDate", date);
			linkFailureData.add(item);
		}
  		Comparator<Map<String,String>> c = new Comparator<Map<String,String>>() {
			@Override
			public int compare(Map<String,String> o1, Map<String,String> o2) {
				// TODO Auto-generated method stub
				Long t1 = Long.parseLong(o1.get("tableDate"));
				Long t2 = Long.parseLong(o2.get("tableDate"));
				if(t1<t2)
					return 1;
				//注意！！返回值必须是一对相反数，否则无效。jdk1.7以后就是这样。
			//else return 0; //无效
				else return -1;
			}
		};
		try {
			Collections.sort(linkFailureData,c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

    	String flagTable = lfm.selectDateTimeByTablename("YM_SYS_LINKBAD");
		System.out.println("flagTable:"+flagTable);
		System.out.println("flag:"+flag);
		System.out.println(!flagTable.equals(flag));
		if(!flagTable.equals(flag)) {
			try {
				if(!flag.equals("000000")) {
					lfm.copyLinkFailTable("YM_SYS_LINKBAD"+flagTable);
				}
			} catch (Exception e) {
				// TODO: handle exception	
				e.printStackTrace();
			}
			flag = flagTable;
			System.out.println("newFlag:"+flag);
		}
  		System.out.println(linkFailureData);
  		
  		if(linkFailureData.size()>12) {
  			iem.deleteTable(linkFailureData.get(linkFailureData.size()-1).get("tableName"));
  		}
  		System.out.println(tablenames);
    }
}  
