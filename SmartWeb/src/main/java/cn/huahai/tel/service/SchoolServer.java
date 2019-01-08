package cn.huahai.tel.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huahai.tel.bean.AllNetworkBase;
import cn.huahai.tel.bean.DaySummaryBase;
import cn.huahai.tel.mapper.SchoolMapper;
@Service
public class SchoolServer implements ISchoolSever{

	@Resource
	SchoolMapper scm;
	@Override
	public DaySummaryBase[] selectDataByMaxAc( String tableName,String datas,String site,String tagName) {
		
		return scm.selectDataByMaxAc(tableName, datas,site,tagName);
	}
	@Override
	public DaySummaryBase[] selectDataByVip(String tableName, String datas,String tagName) {
		// TODO Auto-generated method stub
		return scm.selectDataByVip(tableName, datas,tagName);
	}
	@Override
	public DaySummaryBase[] selectDataByNotCell(String tableName,String site,String tagName) {
		// TODO Auto-generated method stub
		return scm.selectDataByNotCell(tableName,site,tagName);
	}
	@Override
	public DaySummaryBase[] selectDataByflow(String tableName,String site,String tagName) {
		// TODO Auto-generated method stub
		return scm.selectDataByflow(tableName,site,tagName);
	}
	@Override
	public DaySummaryBase[] selectDataByCell(String tableName,String site,String tagName) {
		// TODO Auto-generated method stub
		return scm.selectDataByCell(tableName,site,tagName);
	}
	@Override
	public DaySummaryBase[] selectDataByLoadCell(String tableName,String site,String tagName) {
		// TODO Auto-generated method stub
		return scm.selectDataByLoadCell(tableName,site,tagName);
	}
	@Override
	public DaySummaryBase[] selectDataByArea(String tableName, String site, String tagName) {
		// TODO Auto-generated method stub
		return scm.selectDataByArea(tableName,site,tagName);
	}
	@Override
	public DaySummaryBase[] selectDataByServiceCell(String tableName, String site, String tagName) {
		// TODO Auto-generated method stub
		return scm.selectDataByServiceCell(tableName,site,tagName);
	}
	@Override
	public DaySummaryBase[] selectDataByHighCell(String tableName, String site, String tagName) {
		// TODO Auto-generated method stub
		return scm.selectDataByHighCell(tableName,site,tagName);
	}
	@Override
	public DaySummaryBase[] selectDataByNotGbCell(String tableName, String site, String tagName) {
		// TODO Auto-generated method stub
		return scm.selectDataByNotGbCell(tableName,site,tagName);
	}
	@Override
	public DaySummaryBase[] selectDataByDisturbCell(String tableName, String site, String tagName) {
		// TODO Auto-generated method stub
		return scm.selectDataByDisturbCell(tableName,site,tagName);
	}
	@Override
	public DaySummaryBase[] selectDataAllCell(String tagName, String tableName) {
		// TODO Auto-generated method stub
		return scm.selectDataAllCell(tagName,tableName);
	}
	@Override
	public DaySummaryBase[] selectDataAllServiceCell(String tagName, String tableName) {
		// TODO Auto-generated method stub
		return scm.selectDataAllServiceCell(tagName,tableName);
	}
	@Override
	public DaySummaryBase[] selectDataAllHightCell(String tagName, String tableName) {
		// TODO Auto-generated method stub
		return scm.selectDataAllHightCell(tagName,tableName);
	}
	@Override
	public DaySummaryBase[] selectDataAllNotGbCell(String tagName, String tableName) {
		// TODO Auto-generated method stub
		return scm.selectDataAllNotGbCell(tagName,tableName);
	}
	@Override
	public DaySummaryBase[] selectDataAllDisturbCell(String tagName, String tableName) {
		// TODO Auto-generated method stub
		return scm.selectDataAllDisturbCell(tagName,tableName);
	}
	@Override
	public DaySummaryBase[] selectDataByLinkCell(String tableName, String site, String tagName) {
		// TODO Auto-generated method stub
		return scm.selectDataByLinkCell(tableName,site,tagName);
	}
	@Override
	public DaySummaryBase[] selectDataLinkCell(String tableName, String tagName) {
		// TODO Auto-generated method stub
		return scm.selectDataLinkCell(tagName,tableName);
	}

}
