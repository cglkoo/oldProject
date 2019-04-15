package com.hzitxx.spring.demo.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hzitxx.spring.demo.vo.ResponseInfo;

@Controller
@RequestMapping("/file")
public class FileUploadController {
	
	@RequestMapping("toupload")
	public String toFileUpload(){
		return "file/fileUpload";
	}
	
	@RequestMapping("upload")
	@ResponseBody
	public ResponseInfo upload(HttpServletRequest request) throws Exception{
		MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
		MultipartFile file = req.getFile("file");
		String fileName = file.getOriginalFilename();
		String extName = fileName.substring(fileName.lastIndexOf("."));
		String prefixName = Long.toString(System.currentTimeMillis());
		String newFileName = prefixName + extName;
		String filePath = request.getServletContext().getRealPath("/upload");
		file.transferTo(new File(filePath + newFileName));
		ResponseInfo info = new ResponseInfo();
		info.setData("upload/" + newFileName);
		info.setMessage("上传成功");
		return info;
	}

}
