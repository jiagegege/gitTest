package cn.huahai.tel.service;

import java.util.ArrayList;
import java.util.List;

/**
 * excel表格名称
 * @author lizhuodong
 *
 */
public interface IAllNetwork {
	/**
	 * 查询 本地src文件夹下，所有符合正则reg的文件
	 * @param src 本地路径
	 * @param reg 文件名正则
	 * @return 路径下符合正则的的文件名称
	 */
	List<String> getFileList(String src,String reg);

	List<String> getList(ArrayList<String> tablenames);
}
