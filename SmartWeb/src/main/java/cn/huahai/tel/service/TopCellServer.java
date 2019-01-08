package cn.huahai.tel.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huahai.tel.bean.DaySummaryBase;
import cn.huahai.tel.bean.DayTopCellworkBase;
import cn.huahai.tel.bean.HourTopCellworkBase;
import cn.huahai.tel.bean.TopCellworkBase;
import cn.huahai.tel.mapper.TopCellworkBaseMapper;
@Service
public class TopCellServer implements ITopCellServer {
	@Resource
	TopCellworkBaseMapper tcbm;
	public TopCellworkBase[] selectAllTopCell(String tableName,String field) {
		// TODO Auto-generated method stub
		return tcbm.selectAllTopCell(tableName,field);
	}
	@Override
	public HourTopCellworkBase[] selectAllHourTopCell(String tableName) {
		return tcbm.selectAllHourTopCell(tableName);
	}
	@Override
	public HourTopCellworkBase[] selectVIPHourTopCell(String tableName) {
		// TODO Auto-generated method stub
		return tcbm.selectVIPHourTopCell(tableName);
	}
	@Override
	public HourTopCellworkBase[] selectKeyPointHourTopCell(String cellInfoTablename, String regTablename) {
		// TODO Auto-generated method stub
		return tcbm.selectPointKeyHourTopCell(cellInfoTablename, regTablename);
	}
	@Override
	public DayTopCellworkBase[] selectAllDayTopCell(String tableName) {
		// TODO Auto-generated method stub
		return tcbm.selectAllDayTopCell(tableName);
	}
	@Override
	public DayTopCellworkBase[] selectPointKeyDayTopCell(String cellInfoTablename, String regTablename) {
		// TODO Auto-generated method stub
		return tcbm.selectPointKeyDayTopCell(cellInfoTablename, regTablename);
	}
	@Override
	public DayTopCellworkBase[] selectVIPDayTopCell(String tableName) {
		// TODO Auto-generated method stub
		return tcbm.selectVIPDayTopCell(tableName);
	}
	@Override
	public DaySummaryBase[] selectAllSumCell(String tableName,String stableName, String field) {
		// TODO Auto-generated method stub
		return tcbm.selectAllSumCell(tableName,stableName,field);
	}
}
