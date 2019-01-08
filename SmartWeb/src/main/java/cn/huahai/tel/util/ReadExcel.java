package cn.huahai.tel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 读取excel
 * 
 * @author lizhuodong
 *
 */
public class ReadExcel {
	private final static String excel2003L = ".xls"; // 2003- 版本的excel
	private final static String excel2007U = ".xlsx"; // 2007+ 版本的excel

	/**
	 * 将流中的Excel数据转成map集合
	 * 
	 * @param in
	 *            输入流
	 * @param fileName
	 *            文件名（判断Excel版本）
	 * @param mapping
	 *            字段名称映射
	 * @return 将excel转化成为map集合对象
	 * @throws Exception
	 *             转化异常
	 */
	@SuppressWarnings("deprecation")
	public static List<Map<String, String>> parseExcel(InputStream in, String fileName, Map<String, String> mapping)
			throws Exception {
		// 根据文件名来创建Excel工作薄
		Workbook work = getWorkbook(in, fileName);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		// 返回数据
		List<Map<String, String>> ls = new ArrayList<Map<String, String>>();

		// 遍历Excel中所有的sheet
		for (int i = 0; i < work.getNumberOfSheets(); i++) {
			sheet = work.getSheetAt(i);
			if (sheet == null)
				continue;

			// 取第一行标题
			row = sheet.getRow(0);
			String title[] = null;
			if (row != null) {
				title = new String[row.getLastCellNum()];

				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
					cell = row.getCell(y);
					title[y] = (String) getCellValue(cell);
				}

			} else
				continue;
			
			// 遍历当前sheet中的所有行
			for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
				row = sheet.getRow(j);
				Map<String, String> m = new HashMap<String, String>();
				// 遍历所有的列
				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
					cell = row.getCell(y);
					String key = title[y];
					// log.info(JSON.toJSONString(key));
					
					if (mapping.get(key) != null) {
						
						m.put(mapping.get(key), getCellValue(cell));
					}
				}
				ls.add(m);
				
			}
			
			//只查询第一个sheet;
			break;

		}
		
		
		work.close();
		return ls;
	}

	/**
	 * 描述：根据文件后缀，自适应上传文件的版本
	 * 
	 * @param inStr
	 *            文件流
	 * @param fileName
	 *            文件名称
	 * @return 工作簿对象
	 * @throws Exception
	 *             文件读取异常
	 */
	public static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
		Workbook wb = null;
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		if (excel2003L.equals(fileType)) {
			wb = new HSSFWorkbook(inStr); // 2003-
		} else if (excel2007U.equals(fileType)) {
			wb = new XSSFWorkbook(inStr); // 2007+
		} else {
			throw new Exception("解析的文件格式有误！");
		}
		return wb;
	}

	/**
	 * 描述：对表格中数值进行格式化
	 * 
	 * @param cell
	 *            单元格对象
	 * @return java对象
	 */
	public static String getCellValue(Cell cell) {
		String cellValue = null;
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC: // 数字

			if (0 == cell.getCellType()) {// 判断单元格的类型是否则NUMERIC类型
				if (HSSFDateUtil.isCellDateFormatted(cell)) {// 判断是否为日期类型
					Date date = cell.getDateCellValue();
					DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					cellValue = formater.format(date);
				} else {
					cell.setCellType(Cell.CELL_TYPE_STRING);  
			        String temp = cell.getStringCellValue();  
			        // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串  
			        if (temp.indexOf(".") > -1) {
			        	cellValue = String.valueOf(new Double(temp)).trim();  
			        } else {  
			        	cellValue = temp.trim();  
			        }  
				}
			}
			break;
		case HSSFCell.CELL_TYPE_STRING: // 字符串
			cellValue = cell.getStringCellValue();
			break;

		case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
			cellValue = cell.getBooleanCellValue() + "";
			break;

		case HSSFCell.CELL_TYPE_FORMULA: // 公式
			cellValue = cell.getCellFormula() + "";
			break;

		case HSSFCell.CELL_TYPE_BLANK: // 空值
			cellValue = "";
			break;

		case HSSFCell.CELL_TYPE_ERROR: // 故障
			cellValue = "非法字符";
			break;

		default:
			cellValue = "未知类型";
			break;
		}
		return cellValue;
	}

	/**
	 * 获取excel标题
	 * 
	 * @param in
	 *            输入流
	 * @param fileName
	 *            excel文件名
	 * @return excel头部字段
	 * @throws Exception
	 *             io异常
	 */
	public static List<String> getTitleArr(InputStream in, String fileName) throws Exception {
		// 根据文件名来创建Excel工作薄
		Workbook work = getWorkbook(in, fileName);
		System.out.println("输入流进");
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		// 返回数据
		List<String> titleList = null;

		// 遍历Excel中所有的sheet
		for (int i = 0; i < work.getNumberOfSheets(); i++) {
			sheet = work.getSheetAt(i);
			if (sheet == null)
				continue;
			// 取第一行标题
			row = sheet.getRow(0);
			if (row != null) {
				titleList = new ArrayList<String>(row.getLastCellNum());
				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
					cell = row.getCell(y);
					titleList.add((String) getCellValue(cell));
				}
			}
			
		}
		work.close();
		return titleList;
	}

	public static void main(String[] args) throws Exception {
		File file = new File("E:\\test.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Map<String, String> m = new HashMap<String, String>();

		List<Map<String, String>> ls = parseExcel(fis, file.getName(), m);
		

		List<String> data = getTitleArr(fis, file.getName());
		for (String string : data) {
			System.out.println(string);
		}
	}
}
