package cn.huahai.tel.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AllNetwork implements IAllNetwork {

	public List<String> getFileList(String src,String reg) {
		String filepath = src;//本地文件夹
		File file = new File(filepath);//File类型是文件也可以是文件夹
		File[] fileList = file.listFiles();//将该目录可以下的所有文件放置在一个File类型的数组中
		List<String> fileNameList = new ArrayList<String>();
		for(File f:fileList){
	        if (f.isFile() && (f.getName().matches(reg))){
	        	
	        	fileNameList.add(f.getName());
	        }
	    }
		return fileNameList;
	}

	@Override
	public List<String> getList(ArrayList<String> tablenames) {
		
		return null;
	}

}
