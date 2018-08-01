package springboot.oa.base.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import springboot.oa.domain.user.SysUser;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * controller的父类
 */
public class BaseController {

	@Value("${file.upload.basepath}")
	public String uploadBaseUrl;
	@Value("${file.upload.downpath}")
	public String downpath;
	//json字符串转对象的工具
	public ObjectMapper jsonTranster = new ObjectMapper();
	public Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	//固定接口统一返回格式
	public Map<String, Object> addResultMapMsg(boolean flag, Object msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", flag);
		map.put("msg", msg);
		return map;
	}
	public SysUser getUser(){
		SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
		return user;//(User)session.getAttribute(Const.SESSION_USER);
	}

	public String saveFileToNative(String uptype,MultipartFile file)  {
		String fileName = file.getOriginalFilename();
		String datePartern = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String fileRelPath = "/" + uptype + "/" + datePartern + "/" + System.currentTimeMillis() + "_" + fileName;
		File tempFile = new File(uploadBaseUrl + fileRelPath);
		if (!tempFile.exists()) {
			tempFile.getParentFile().mkdirs();
			try {
				tempFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		try {
			file.transferTo(tempFile);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return fileRelPath;
	}

	public static File getFileFromResources(String resourcePath){
		File file = null;
		try{
			file = ResourceUtils.getFile(resourcePath);
		}catch (Exception e){

		}
		return file;
	}
	public static void main(String[] args){
		File file = getFileFromResources("classpath:excelmodel/sjhjModel.xlsx");
		if(file != null)
			System.out.println(file.getName());
	}
}