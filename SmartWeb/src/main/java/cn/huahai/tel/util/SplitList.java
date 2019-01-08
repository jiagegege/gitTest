package cn.huahai.tel.util;

import java.util.ArrayList;
import java.util.List;
/**
 * 将集合拆分
 * @author lizhuodong
 *
 */
public class SplitList {
	/**
	 * 将list拆分成n等分
	 * @param source list数据
	 * @param <T> Bean类型
	 * @param n 拆分成几段
	 * @return 拆分之后数据
	 */
	public static <T> List<List<T>> averageAssign(List<T> source,int n){  
	    List<List<T>> result=new ArrayList<List<T>>();  
	    int remaider=source.size()%n;  //(先计算出余数)  
	    int number=source.size()/n;  //然后是商  
	    int offset=0;//偏移量  
	    for(int i=0;i<n;i++){  
	        List<T> value=null;  
	        if(remaider>0){  
	            value=source.subList(i*number+offset, (i+1)*number+offset+1);  
	            remaider--;  
	            offset++;  
	        }else{  
	            value=source.subList(i*number+offset, (i+1)*number+offset);  
	        }  
	        result.add(value);  
	    }  
	    return result;  
	} 
}
