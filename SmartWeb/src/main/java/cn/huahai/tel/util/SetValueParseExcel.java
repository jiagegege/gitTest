package cn.huahai.tel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.huahai.tel.bean.CriticalValueBase;

public class SetValueParseExcel {
	private final static String excel2003L = ".xls"; // 2003- 版本的excel
	private final static String excel2007U = ".xlsx"; // 2007+ 版本的excel

	/**
	 * 将流中的Excel数据转成map集合
	 * @param in 输入流
	 * @param fileName 文件名你 （判断Excel版本）
	 * @param setValue 临界值
	 * @param out 输出流
	 * @throws Exception 转化异常
	 */
	@SuppressWarnings("deprecation")
	public static void parseExcel(
			InputStream in, 
			String fileName, 
			List<CriticalValueBase> setValue,
			OutputStream out,
			int colors)
			throws Exception {
		// 根据文件名来创建Excel工作薄
		Workbook work = getWorkbook(in, fileName);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		// 遍历Excel中所有的sheet
		for (int i = 0; i < work.getNumberOfSheets(); i++) {
			sheet = work.getSheetAt(i);
			
			if (sheet == null)
				continue;

			// 取第一行标题
			row = sheet.getRow(0);
			String title[] = null;
			Map<String, String> titleMapping = new HashMap<String,String>();
			if (row != null) {
				title = new String[row.getLastCellNum()];

				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
					cell = row.getCell(y);
					String value = (String) getCellValue(cell);
					
					title[y] = value;
					titleMapping.put(value, value);
				}
			} else
				continue;
			
				CellStyle styleRed = work.createCellStyle(); // 填充色 
				CellStyle styleBlue = work.createCellStyle(); // 填充色 
				styleRed.setFillForegroundColor(HSSFColorPredefined.RED.getIndex());
				styleBlue.setFillForegroundColor(HSSFColorPredefined.BLUE.getIndex());
				styleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				styleBlue.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				Font font = work.createFont();
				font.setColor(IndexedColors.WHITE.getIndex());
				styleRed.setFont(font);
				styleBlue.setFont(font);
				
			// 遍历当前sheet中的所有行
			for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
				row = sheet.getRow(j);
				Map<String, String> m = new HashMap<String, String>();
				// 遍历所有的列
				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
					cell =row.getCell(y);
					
					if(colors == 1) {
						Boolean flag = GenerateExcel.setCellColor(setValue, title[y], getCellValue(cell));
						if (flag!= null) {
							if(flag) {
								cell.setCellStyle(styleRed);
							}else {
								cell.setCellStyle(styleBlue);
							}
						}
					}
					
					/*String key = title[y];
					if (titleMapping.get(key) != null) {
						m.put(titleMapping.get(key), getCellValue(cell));
					}*/
				}
			}
			
			//只查询第一个sheet;
			break;

		}
		System.out.println("文件流开始写入");
		work.write(out);
		System.out.println("文件流写入完成");
		work.close();
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
	public static Object getCellValue(Cell cell) {
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
			      
			        	cellValue = String.valueOf(new Double(temp)).trim();  
			       System.out.println("cellValue"+cellValue);
			      
			       
			      
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
	public static Map<String,Object>  getTitleArr(InputStream in, String fileName) throws Exception {
		// 根据文件名来创建Excel工作薄
		Workbook work = getWorkbook(in, fileName);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		// 返回数据
		List<String> titleList = null;
		Map<String, Object> titleMap = new HashMap<String,Object>();
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
					titleMap.put((String) getCellValue(cell), (String) getCellValue(cell));
				}
			}
			
		}
		work.close();
		return titleMap;
	}

	public static void main(String[] args) throws Exception {
		File file = new File("E:\\test.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Map<String, String> m = new HashMap<String, String>();

	/*	List<Map<String, String>> ls = parseExcel(fis, file.getName(), m);
		System.out.println(ls);*/
		Map<String, Object> ss = getTitleArr(fis, file.getName());
		System.out.println(ss);
	}
}
