package cn.huahai.tel.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huahai.tel.bean.DaySummaryBase;
import cn.huahai.tel.bean.TopCellworkBase;
import cn.huahai.tel.mapper.KeyPointCellMapper;
import cn.huahai.tel.util.Pinyin;

@Service
public class KeyPointCellServer implements IkeyPointCellServer {
@Resource
KeyPointCellMapper kpcm;
	/**
	 * 查看组名称是否存在
	 */
	public boolean selectTagNameExists(String tagname) {
		return kpcm.selectTagName(tagname) == 0;
	}
	public void insertKeyPointCell(String tablename, String tagname) {
		kpcm.insertKeyPointCell(tablename, tagname);
		
	}
	public void createKeyPointCell(String tablename) {
		kpcm.createKeyPointCell(tablename);
		
	}
	public void insertKeyPointCellName(String tablename, List<String> cellList) {
		kpcm.insertKeyPointCellName(tablename, cellList);
	}
	public List<String> selectAllMapping() {
		return kpcm.selectAllMapping();
	}
	public void deleteTagname(String tagname) {
		kpcm.deleteMapping(tagname);
		kpcm.deletekeypointTable(Pinyin.getPingYin("YM_BZH_"+tagname));
	}
	public void addCellMapping(String tablename, String tagname, List<String> cellList) {
		kpcm.insertKeyPointCell(tablename, tagname);
		kpcm.createKeyPointCell(tablename);
		kpcm.insertKeyPointCellName(tablename, cellList);
	}
	public TopCellworkBase[] selectKeyPontCellInfo(String cellInfoTablename, String regTablename) {
		return kpcm.selectKeyPontCellInfo(cellInfoTablename, regTablename);
	}
	public TopCellworkBase[] selectVipCellInfo(String tablename) {
		return kpcm.selectVIPCellInfo(tablename);
	}
	@Override
	public DaySummaryBase[] selectVipSumInfo(String tablename, Integer row) {
		// TODO Auto-generated method stub
		return kpcm.selectVipSumInfo( tablename, row);
	}
	@Override
	public DaySummaryBase selectVipCellSumInfo(String tablename) {
		// TODO Auto-generated method stub
		return kpcm.selectVIPCellSumInfo(tablename);
	}
	@Override
	public DaySummaryBase[] selectKeyPointSumCellInfo(String cellInfoTablename,String scellInfoTablename, String regTablename,String field) {
		// TODO Auto-generated method stub
		return kpcm.selectKeyPointSumCellInfo(cellInfoTablename,scellInfoTablename, regTablename,field);
	}
	@Override
	public DaySummaryBase[] selectAllHourSumCell(String tableName,String stableName) {
		
		return kpcm.selectAllHourSumCell(tableName,stableName);
	}
	@Override
	public DaySummaryBase selectVIPHourSumCell(String tableName) {
		// TODO Auto-generated method stub
		return kpcm.selectVIPHourSumCell(tableName);
	}
	@Override
	public DaySummaryBase selectKeyPointHourSumCell(String tableName, String regTablename) {
		// TODO Auto-generated method stub
		return kpcm.selectKeyPointHourSumCell(tableName, regTablename);
	}
	@Override
	public DaySummaryBase[] selectAllDaySumCell(String tableName,String stableName) {
		// TODO Auto-generated method stub
		return kpcm.selectAllDaySumCell(tableName,stableName);
	}
	@Override
	public DaySummaryBase selectVIPDaySumCell(String tableName) {
		// TODO Auto-generated method stub
		return kpcm.selectVIPDaySumCell(tableName);
	}
	@Override
	public DaySummaryBase[] selectPointKeyDaySumCell(String tableName,String stableName, String regTablename) {
		// TODO Auto-generated method stub
		return kpcm.selectPointKeyDaySumCell(tableName,stableName, regTablename);
	}
	@Override
	public DaySummaryBase[] selectNewAllSumCell(String tableName, String stableName, String field) {
		// TODO Auto-generated method stub
		return kpcm.selectNewAllSumCell(tableName, stableName,field);
	}
	@Override
	public DaySummaryBase[] selectAllHourNewSumCell(String tableName, String stableName) {
		// TODO Auto-generated method stub
		return kpcm.selectAllHourNewSumCell(tableName, stableName);
	}
	@Override
	public DaySummaryBase[] selectAllDayNewSumCell(String tableName, String stableName) {
		// TODO Auto-generated method stub
		return kpcm.selectAllDayNewSumCell(tableName, stableName);
	}
	@Override
	public DaySummaryBase[] selectKeyNewSumCellInfo(String tableName, String stableName, String regTablename,
			String field) {
		// TODO Auto-generated method stub
		return kpcm.selectKeyNewSumCellInfo(tableName, stableName,regTablename,field);
	}
	@Override
	public DaySummaryBase[] selectKeyDayNewSumCell(String tableName, String regTablename) {
		// TODO Auto-generated method stub
		return kpcm.selectKeyDayNewSumCell(tableName,regTablename);
	
	}
	@Override
	public DaySummaryBase[] selecttagNameData(String tagName,String tableName) {
		// TODO Auto-generated method stub
		return kpcm.selecttagNameData(tagName,tableName);
	}
	@Override
	public void updateTagName(String tagName) {
		kpcm.updateMappingByTagName(tagName);
		
	}
	@Override
	public boolean updateCellMapping(String pinyintagName, List<String> mlist) {
		boolean aa = false;
		kpcm.deleteData(pinyintagName);
		boolean bb =  kpcm.updateCellMapping(pinyintagName,mlist);
		if(bb) {
			aa = true;
		}
		return aa;
		
	}
	@Override
	public List<String> selectDataByECellId(String pinyintagName) {
		// TODO Auto-generated method stub
		return kpcm.selectDataByECellId(pinyintagName);
	}

}
