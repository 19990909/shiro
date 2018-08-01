package springboot.oa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 基于POI生成Excel（带标题，字体样式修改功能）
* @ClassName: ExcelByPOI
* @Description: TODO(有生成默认格式Excel、生成指定格式Excel、调用模板Excel 三个方法)
* @author lingshufeng
* @date 2016-10-10 上午11:08:07
*
 */
public class ExcelByPOI {
	private static String DEFAULT_NULL_VALUE="暂无";
	
	public static List<String> readExcelFile(int sheetNum,String readExcelPath,int beginRow,int beginCol){
		File readExcel = new File(readExcelPath);
		if(!readExcel.exists()){
			return null;
		}
		InputStream ioInputStream=null;
		List<String> resultList = new ArrayList<String>();
		try {
			ioInputStream = new FileInputStream(readExcel);
			HSSFWorkbook workbook = new HSSFWorkbook(ioInputStream);
			Sheet sheet = workbook.getSheetAt(sheetNum);
			int rowNums = sheet.getLastRowNum(); //该表有效行数
			for(int i=beginRow;i<=rowNums;i++){
				Row row = sheet.getRow(i);
				int cellNums = row.getLastCellNum(); //改行有效列数
				String string = "";
				for(int j=beginCol;j<cellNums;j++){
					Cell cell = row.getCell(j);
					String valueString =DEFAULT_NULL_VALUE;
					if(cell != null && !StringUtils.isEmpty(cell.toString())){
						valueString = cell.toString().trim(); //得到该行该格子值
					}
					string +=(valueString+"/");
				}
				if(!StringUtils.isEmpty(string)){
					if(string.endsWith("/")){
						string = string.substring(0, string.lastIndexOf("/"));
					}
					resultList.add(string);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}finally{
			try {
				if(ioInputStream!=null)
				ioInputStream.close();
				
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return resultList;
	}

	/**
	 * 前端传入的是MultipartFile时，通过sheet来解析
	 * @param sheet
	 * @param beginRow 开始行，从0开始
	 * @param beginCol 开始列，从0开始
	 * @return
	 */
	public static Map<String,Object> readExcelBySheet(Sheet sheet,int beginRow,int beginCol){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		List<String> dataList = new ArrayList<String>();
		List<String> errortList = new ArrayList<String>();
		int rowNums = sheet.getLastRowNum(); //该表有效行数
		int a = beginCol;
		for(int i=beginRow;i<=rowNums;i++){
			Row row = sheet.getRow(i);
			if(row == null){
				continue;
			}
			int cellNums = row.getLastCellNum(); //改行有效列数
			String string = "";
			boolean overflag = true;
			for(int j=beginCol;j<cellNums;j++){
				Cell cell = row.getCell(j);
				String valueString = null;
				if(cell != null && !StringUtils.isEmpty(cell.toString().trim())){
//					valueString = cell.toString().trim(); //得到该行该格子值
					String valueString2 = cell.toString().trim(); //得到该行该格子值
					valueString = getXCellVal(cell); //得到该行该格子值
					if(valueString.lastIndexOf(".0") != -1){
						valueString = valueString.substring(0,valueString.lastIndexOf("."));
					}
				}
				if(j == beginCol) { //第一列作为验证数据内容是否存在的
					if (valueString == null) {
//						errortList.add("导入的数据不能为空");
						overflag = false;
						break; //如果第一列为null，则直接退出。
					}
				}else{
					if (valueString == null) {
						if(a == beginCol){
							a = j;
						}else if(j < a){
							errortList.add("第"+(i+1)+"行,第"+(j+1)+"列，数据不符合规范");
						}
						continue;
//						errortList.add("第"+(i+1)+"行,第"+(j+1)+"列，数据不符合规范");
					}
				}
				string += (valueString+"/");
			}
			if(errortList.isEmpty() && overflag){ //没有错误发生，则数据正常
				if(string.endsWith("/")){
					string = string.substring(0, string.lastIndexOf("/"));
				}
				dataList.add(string);
			}

		}
		resultMap.put("errorList",errortList);
		resultMap.put("dataList",dataList);
		return resultMap;
	}


	/**
	 * 针对于全指标入库，将空格替换为0
	 * @param sheet
	 * @param beginRow 开始行，从0开始
	 * @param beginCol 开始列，从0开始
	 * @return
	 */
	public static Map<String,Object> readExcelBySheetForQzb(Sheet sheet,int beginRow,int beginCol){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		List<String> dataList = new ArrayList<String>();
		List<String> errortList = new ArrayList<String>();
		int rowNums = sheet.getLastRowNum(); //该表有效行数
		int a = beginCol;
		for(int i=beginRow;i<=rowNums;i++){
			Row row = sheet.getRow(i);
			if(row == null){
				continue;
			}
			int cellNums = row.getLastCellNum(); //改行有效列数
			String string = "";
			boolean overflag = true;
			for(int j=beginCol;j<cellNums;j++){
				Cell cell = row.getCell(j);
				String valueString = null;
				if(cell != null && !StringUtils.isEmpty(cell.toString().trim())){
//					valueString = cell.toString().trim(); //得到该行该格子值
					String valueString2 = cell.toString(); //得到该行该格子值
					valueString = getXCellVal(cell); //得到该行该格子值
					if(valueString != null && valueString.lastIndexOf(".0") != -1){
						valueString = valueString.substring(0,valueString.lastIndexOf("."));
					}
				}
				if(j == beginCol) { //第一列作为验证数据内容是否存在的
					if (valueString == null) {
//						errortList.add("导入的数据不能为空");
						overflag = false;
						break; //如果第一列为null，则直接退出。
					}
				}else{
					if (valueString == null) {
//						if(a == beginCol){ //这里有bug，暂时先不该。逻辑错误
//							a = j;
//						}else if(j < a){
							valueString = "0";
//							errortList.add("第"+(i+1)+"行,第"+(j+1)+"列，数据不符合规范");
//						}
//						continue;
//						errortList.add("第"+(i+1)+"行,第"+(j+1)+"列，数据不符合规范");
					}
				}
				if("&".equals(valueString)){
					errortList.add("第"+(i+1)+"行,第"+(j+1)+"列，含有不规范的字符&");
				}
				string += (valueString+"&");
			}
			if(errortList.isEmpty() && overflag){ //没有错误发生，则数据正常
				if(string.endsWith("&")){
					string = string.substring(0, string.lastIndexOf("&"));
				}
				dataList.add(string);
			}

		}
		resultMap.put("errorList",errortList);
		resultMap.put("dataList",dataList);
		return resultMap;
	}



	/**
	 * @author: LS
	 * 2016-8-25 下午7:40:05
	 * @param cell
	 * @return String
	 * 获取单元格中的值
	 */
	private static String getXCellVal(Cell cell) {
		if(cell.toString() == null){
			return null;
		}
		String  val = null;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd"); //日期格式yyyy-mm-dd
		DecimalFormat df = new DecimalFormat("0.00"); //保留两位小数
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					val = fmt.format(cell.getDateCellValue()); //日期型
				} else {
					val = df.format(cell.getNumericCellValue()); //数字型
				}
				break;
			case Cell.CELL_TYPE_STRING: //文本类型
				val = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN: //布尔型
				val = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_BLANK: //空白
				val = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_ERROR: //错误
				val = "错误";
				break;
			case Cell.CELL_TYPE_FORMULA: //公式
				try {
					val = String.valueOf(cell.getStringCellValue());
				} catch (IllegalStateException e) {
					val = String.valueOf(cell.getNumericCellValue());
				}
				break;
			default:
				val = cell.getRichStringCellValue() == null ? null : cell.getRichStringCellValue().toString();
		}
		return val;
	}

	/**
	 * 往指定Excel模板中写入数据
	 * @param srcFilePath 模板Excel路径
	 * @param saveFilePath 输出Excel路径
	 * @param dataList 写入的数据
	 * @param beginRowNum 从模板excel的第几行开始写入（第一行为0，依次类推）
	 * @return list对象,里面包含从Excel文件里获取到的数据
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean  writeInModelExcel(String srcFilePath,String saveFilePath,List<String[]> dataList,int beginRowNum,int beginColNum) {
		 InputStream io=null;
		 try {  
	            File srcFile = new File(srcFilePath); // 找到模板文件对象  
	            if(!srcFile.exists()){
	            	return false;
	            }
	            File saveFile = new File(saveFilePath);
	            FileUtils.copyFile(srcFile, saveFile);
	            io = new FileInputStream(saveFile);
	            HSSFWorkbook hw = new HSSFWorkbook(io); // 从文件流中获取Excel工作区对象（HSSFWorkbook）  
	            
	            Sheet sheet = hw.getSheetAt(0); // 从工作区中取得页（Sheet）  
	            if(dataList == null || dataList.size() == 0 ) {
	            	return false;
	            }
	            if(sheet == null){
	            	return false;
	            }
	            FileOutputStream outputStream = new FileOutputStream(saveFile);
	            CellStyle cStyle = getCellStyle(hw);
	            for (int i = beginRowNum; i < beginRowNum+dataList.size(); i++) { // 循环模板Excel，添加内容
	            	Row row = sheet.getRow(i); //模板中有可能行不为空
	            	if(row == null){ //调用模板的时候要考虑行为空的情况，如果只调用createRow也会报错，因为模板中有可能是有空的row，同理下边的cell的创建，也要考虑为null的情况
	            		row = sheet.createRow(i);
	            	}
	            	String[] strings = dataList.get(i-beginRowNum);
	                for (int j = beginColNum; j < beginColNum+strings.length; j++) {  
	                    Cell cell = row.getCell(j); 
	                    if(cell == null){
	                    	cell = row.createCell(j);	                    	
	                    }
	                    String valueString =  strings[j-beginColNum];
	                   if(NumberUtils.isNumber(valueString)){
	                	   cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
	                	  double value =  Double.valueOf(valueString);
	                	  cell.setCellValue(value);
	                   }else{
	                	   cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	                	   cell.setCellValue(valueString);
	                   }
	                    cell.setCellStyle(cStyle);
	                }   
	            }  
	            hw.write(outputStream);
	            outputStream.flush();
	            outputStream.close();
	        } catch (Exception e) {  
	        	e.printStackTrace();
	           return false; 
	        }finally{
	        	if(io != null){
	        		try {
						io.close();
					} catch (IOException e) {
						return false;
					}
	        	}
	        }
	        return true;  
	}


	/**
	 * 往指定数据汇交Excel模板中写入数据
	 * @param saveFilePath 输出Excel路径
	 * @param dataList 写入的数据
	 * @param beginRowNum 从模板excel的第几行开始写入（第一行为0，依次类推）
	 * @return list对象,里面包含从Excel文件里获取到的数据
	 *
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean  writeInModelExcelForSjhj(File srcFile,String saveFilePath,List<String[]> dataList,int beginRowNum,int beginColNum) {
		InputStream io=null;
		try {
			File saveFile = new File(saveFilePath);
			FileUtils.copyFile(srcFile, saveFile);
			io = new FileInputStream(saveFile);
			XSSFWorkbook hw = new XSSFWorkbook(io); // 从文件流中获取Excel工作区对象（HSSFWorkbook）

			Sheet sheet = hw.getSheetAt(0); // 从工作区中取得页（Sheet）
			if(dataList == null || dataList.size() == 0 ) {
				return false;
			}
			if(sheet == null){
				return false;
			}
			FileOutputStream outputStream = new FileOutputStream(saveFile);
			CellStyle cStyle = getCellStyle(hw);
			for (int i = beginRowNum; i < beginRowNum+dataList.size(); i++) { // 循环模板Excel，添加内容
				Row row = sheet.getRow(i); //模板中有可能行不为空
				if(row == null){ //调用模板的时候要考虑行为空的情况，如果只调用createRow也会报错，因为模板中有可能是有空的row，同理下边的cell的创建，也要考虑为null的情况
					row = sheet.createRow(i);
				}
				String[] strings = dataList.get(i-beginRowNum);
				for (int j = beginColNum; j < beginColNum+strings.length; j++) {
					Cell cell = row.getCell(j);
					if(cell == null){
						cell = row.createCell(j);
					}
					String valueString =  strings[j-beginColNum];
					if(NumberUtils.isNumber(valueString)){
						cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
						double value =  Double.valueOf(valueString);
						cell.setCellValue(value);
					}else{
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(valueString);
					}
					cell.setCellStyle(cStyle);
				}
			}
			hw.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			if(io != null){
				try {
					io.close();
				} catch (IOException e) {
					return false;
				}
			}
		}
		return true;
	}



	/*
	 * 创建excel的入口方法，默认字体格式，调用该方法生成Excel，如果数据为对象集合，
	 * 请调用本类最下边的转换字符串数组方法(注意不要忘了保证集合第一条数组里存的是标题，之后才是数据)，转换后再调用生成excel
	 */
	public static boolean createExcel(String outputPath,String sheetName,String headName,List<String[]> data){
		Map<String,String[]> style = new HashMap<String,String[]>();
		style.put("top", new String[]{"宋体","25","#1256cc","#ffffff","粗体"}); //默认带合并单元格大标题，格式为蓝色粗体，无背景，字体大小为30
		style.put("title", new String[]{"黑体","15","#000000","#cccccc","粗体"}); //默认带字段值小标题,格式为黑色粗体，灰色网格背景，字体大小为15
		style.put("content", new String[]{"宋体","10","#000000","#ffffff","常规"}); //默认内容，格式为宋体常规，无背景，字体大小为10
		return createExcel(outputPath,sheetName,headName,data,style);
	}
	/*
	 * 创建excel的入口方法，附带字体格式修改功能，调用该方法生成Excel，如果数据为对象集合，
	 * 请调用本类最下边的转换字符串数组方法(注意不要忘了保证集合第一条数组里存的是标题，之后才是数据)，转换后再调用生成excel
	 */
	public static boolean  createExcel(String outputPath,String sheetName,String headName,List<String[]> data,Map<String,String[]> style){
		boolean result = false;
		int length = data.get(0).length; //得到生成Excel的列数
		if(data == null || data.size() == 0 || data.get(0).length == 0){
			System.out.println("没有数据可生成excel");
			return result;
		}
		HSSFWorkbook hw = new HSSFWorkbook(); //创建Excel对象
		HSSFSheet hs = hw.createSheet(sheetName); //创建sheet对象
		result = exportExcel(outputPath,headName,data,style,hw,hs);
		return  result;
	}
	
	/*
	 * 导出excel,excel字体样式修改方法
	 */
	@SuppressWarnings("deprecation")
	public static boolean exportExcel(String outputPath,String headName,List<String[]> data,Map<String,String[]> formStyle,Workbook wb,Sheet hs){
		FileOutputStream fs = null;
		try {
			File file = new File(outputPath);
			if(!file.exists()){
				file.getParentFile().mkdirs();		
			}
			fs = new FileOutputStream(file);	
		 //设置大标题合并单元格范围（开始行，结束行，开始列，结束列）默认从0开始
			CellRangeAddress ar = new CellRangeAddress(0, 3,(short)0, (short)(data.get(0).length-1)); 
			hs.addMergedRegion(ar); //合并单元格
			String[] topForm = formStyle.get("top");
			createCellTitle(0,3,(short)0, (short)(data.get(0).length-1),hs,wb,headName,topForm);
		    
			/*
			 * 注意下边这个格子样式（styleContent）一定要放在下边for循环之外设置，
			 * 是因为changeColor方法用到一个静态变量a，如果放在里边，频繁的去设置格子样式，
			 * 会导致a不断变化，造成背景颜色和字体颜色会乱
			 */
			String[] titleForm = formStyle.get("title");
			short titleHeight = Short.valueOf(titleForm[1]);
			CellStyle styleContent = designCellStyle(wb,titleForm[0],titleHeight,titleForm[2],titleForm[3],titleForm[4]);  
			//在大标题下第一行开始写字段名(小标题)并修改字体样式
			Row hrTitle = hs.createRow(4); 	
			for(int i = 0;i<data.get(0).length;i++){
				Cell celTitle = hrTitle.createCell(i); //在该行创建格子
				int titleL = data.get(0)[i].getBytes().length;
				hs.setColumnWidth(i, titleL*2*256); //自动设置列宽
				celTitle.setCellValue(data.get(0)[i]); //格子中赋值
				hrTitle.setHeightInPoints(titleHeight+(short)6); //将小标题行高设置为（内容字体高度+5）
				celTitle.setCellStyle(styleContent);  //将该字段名(小标题)应用此样式
				
			}
			
			/*
			 * 注意下边这个格子样式（styleContent）一定要放在下边for循环之外设置，
			 * 是因为changeColor方法用到一个静态变量a，如果放在里边，频繁的去设置格子样式，
			 * 会导致a不断变化，造成背景颜色和字体颜色会乱
			 */
			String[] contentForm = formStyle.get("content");
			short contentHeight = Short.valueOf(contentForm[1]);
			CellStyle sty= designCellStyle(wb,contentForm[0],contentHeight,contentForm[2],contentForm[3],contentForm[4]);   //修改该格子字体样式
		   //在字段名（小标题）下边填写内容部分并修改字体样式
			for(int i = 1;i<data.size();i++){
				Row hrContent = hs.createRow(4+i); //在字段名(小标题)下加一行
				for(int j = 0;j<data.get(i).length;j++){
					Cell celContent = hrContent.createCell(j);//在添加的行创建格子
					String contentV = data.get(i)[j];
					int contentL = contentV.getBytes().length*2*256;
					int colLength = hs.getColumnWidth(j); //得到列的原本宽度
					if(contentL>colLength){
						hs.setColumnWidth(j, contentL); //自动设置列宽
					}
					celContent.setCellValue(contentV); //在格子中赋值
					
					celContent.setCellStyle(sty);  //将该格子应用此样式
				}
				hrContent.setHeightInPoints(contentHeight+(short)6); //将内容数据行高设置为（内容字体高度+6）
			}
			wb.write(fs);	
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			if(fs !=null){
				try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/*
	 * 设置字体格式
	 * form为字体样式    例如：楷体 
	 * formHeight 为字体大小
	 * color为字体颜色 
	 * bold 为字体加粗或常规
	 * 返回值为cellStyle，可以将该类型添加到一个cell里，即对该cell可以调整字体格式
	 */
	public static CellStyle designCellStyle(Workbook wb,String form,short formHeight,String colorForm,String colorBack,String bold){
		
		 //创建一个字体 
	    Font font = wb.createFont();  
	    //设置字体高度
	    font.setFontHeightInPoints(formHeight);  
	    //设置字体样式
	    font.setFontName(form);  
	    font.setColor(changeColor(colorForm,wb));
	    short boldValue = (short)0;
	    if("加粗".equals(bold)){
	    	boldValue = Font.BOLDWEIGHT_BOLD;
	    }else if("常规".equals(bold)){
	    	boldValue = Font.BOLDWEIGHT_NORMAL;
	    }
	    font.setBoldweight(boldValue);
//	    //设置是否使用斜体  
//	    font.setItalic(true);  
//	    //设置是否删除线通过字体  
//	    font.setStrikeout(true);  
	    //将创建的Font设置给CellStyle,所以需要创建一个新的Font  
	    CellStyle style = wb.createCellStyle();  
	    style.setAlignment(CellStyle.ALIGN_CENTER_SELECTION); //设置字体水平居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER); //设置字体垂直居中
	    style.setFont(font); 
	    style.setFillPattern(CellStyle.SOLID_FOREGROUND); //设置背景色没有这一步，下一步将没有作用，纯色使用前景颜色填充
	    style.setFillForegroundColor(changeColor(colorBack,wb)); //设置前景颜色（不能设置成背景颜色）
	    style.setBorderBottom((short)1);
	    style.setBorderLeft((short)1);
	    style.setBorderTop((short)1);
	    style.setBorderRight((short)1);
	    return style;
	}
	/**
	 * 自动调整字体颜色逻辑
	 * str传入的是十六进制格式调整颜色
	 * 
	 */
	static int  a = 0;
	public static short changeColor(String str,Workbook wb){
		a++;
		short value = (short)(HSSFColor.BLACK.index+a);
	    //处理把它转换成十六进制并放入一个数
	    int[] color=new int[3];
	    color[0]=Integer.parseInt(str.substring(1, 3), 16);
	    color[1]=Integer.parseInt(str.substring(3, 5), 16);
	    color[2]=Integer.parseInt(str.substring(5, 7), 16);
	  //自定义颜色
	    HSSFPalette palette = ((HSSFWorkbook) wb).getCustomPalette();
	    palette.setColorAtIndex(value,(byte)color[0], (byte)color[1], (byte)color[2]);
	    //将自定义的颜色引入进来 
	    return value;
	}
	
	public static void createCellTitle(int rowFrom,int rowTo,short colFrom,short colTo,Sheet hs,Workbook wb,String headName,String[] topForm){
		for(int i = rowFrom;i<=rowTo;i++){
			Row rowTitle = hs.createRow(i);
			for(short j = colFrom;j<=colTo;j++){
				Cell cellTitle = rowTitle.createCell(j);
				CellStyle style = wb.createCellStyle();
				style.setBorderBottom((short)1);
				style.setBorderLeft((short)1);
				style.setBorderTop((short)1);
				style.setBorderRight((short)1);
				if(i == rowFrom && j== colFrom){
					cellTitle.setCellValue(headName);
					short topheight = Short.valueOf(topForm[1]);
					rowTitle.setHeightInPoints(topheight); //将大标题的行高设置为（字体高度+5）
					style = designCellStyle(wb,topForm[0],topheight,topForm[2],topForm[3],topForm[4]);  
					cellTitle.setCellStyle(style);  //将大标题单元格应用此样式  
					continue;
				}
				cellTitle.setCellStyle(style);
			}
		}
	}
	//将对象集合转换为字符数组集合（以下五个方法都是起到对象转换成字符数组的作用）
	public static List<String[]> ObjectChangeToStringArray(List list){
		List<String[]> resultList = new ArrayList<String[]>();
		for(Object obj:list){
			String[] colNames = columnResult(obj.getClass());
			if(colNames != null || colNames.length !=0){ //如果有属性名，说明是对象
				
			}
			String result = "";
			for(String cname:colNames){
				String methodName = getRefMethodName(cname,false);
				String value = (String)ref(obj,methodName,null,false,false) ;
				result +=(value+",");
			}
			String [] resultArray = result.substring(0, result.lastIndexOf(",")).split(",");
			resultList.add(resultArray);
		}
		return resultList;
	}
	public static String[] columnResult(Class cla){	
		Field[] fields=cla.getDeclaredFields();
		if(fields.length>0){
			String before="";
			for(Field f:fields){
				before+=(f.getName()+"/");
			}
			String[] columns=before.split("/");	
			return columns;
		}
		return null;
	}
	
	private static Object ref(Object obj,String mName,Object value,boolean isSet,boolean isClob){
		if(mName == null) return null;
		Object ret = null;
		try{
			Method method = null;
			Class<? extends Object> c = obj.getClass();
			method = isSet 
					? c.getMethod(mName,new Class[]{isClob?java.sql.Clob.class:String.class}) 
					: c.getMethod(mName);
			if(method != null){
				if(isSet){
					method.invoke(obj,new Object[]{value});
				}else{
					ret = method.invoke(obj);
				}
			}
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return ret;
	}
	private static String toFirstUpperCase(String src){
		String f = src.substring(0,1);
		return f.toUpperCase() + src.substring(1,src.length());
	}
	private static String getRefMethodName(String name,boolean isSet){
		return  (isSet?"set":"get") + toFirstUpperCase(name);
	}
	public static CellStyle getCellStyle(HSSFWorkbook hw) {
		CellStyle style=hw.createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中  
		return style;
	}

	public static CellStyle getCellStyle(XSSFWorkbook hw) {
		CellStyle style=hw.createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		return style;
	}


	public static void main(String[] args){
		List<String[]> data = new ArrayList<String[]>();
		String[] a = {"姓名","性别","年龄","体重","身高","健康状况"};
		String[] b = {"张三","男","23","55","169","健康"};
		String[] c = {"李四","女","23","45","163","健康"};
		String[] d = {"王五","男","30","65","174","健康"};
		String[] e = {"赵文六","女","3333","50","165","健康"};
		String[] f = {"钱七七七七七","男难难安娜娜安娜","216666666666666","60","177","健康"};
		data.add(a);
		data.add(b);
		data.add(c);
		data.add(d);
		data.add(e);
		data.add(f);
		String outPutPath = "d:\\excel测试结果.xls";
		/**
		 * 创建excel调用方法
		 */
//		createExcel(outPutPath,"信息统计","信息统计表",data);


		/**
		 * 调用模板创建excel
		 */
//		writeInModelExcel("d:/excelCeshiModel.xls","d:/excelCeshiModel2.xls",data,2,2);

		/**
		 * 读取excel,excel必须为2007版，高版本不行，如果需要2010版，则需要改这个HSSFWorkbook
		 */
//		List<String> readExcelFile = readExcelFile(0,"D:/123.xls", 1, 0);
		
		System.out.println("完成");
	}


}
