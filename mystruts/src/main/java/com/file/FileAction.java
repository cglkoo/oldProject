package com.file.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class FileAction {
	
	//上传文件的属性
	private File upload;
	private String uploadContentType;  //上传的文件类型，不可自定义
	private String uploadFileName;     //上传的文件名称，不可自定义
	
	//下载文件的属性
	private String downloadFileName;    //下载的文件名称，不可自定义
	private InputStream inputStream;    //输入流，从服务器读取文件
	private String contentType;         //下载的文件类型
	private String contentDisposition;   //磁盘目录
	
	
	public FileAction() {
	}
	//文件上传方法
	public String upload() throws IOException {
		
		//处理接收到的文件，保存到服务器本地
		InputStream ins = new FileInputStream(upload);
		String extName=uploadFileName.substring(uploadFileName.lastIndexOf(".")); //要上传的文件后缀
		//保存路径
		String newFile =System.currentTimeMillis()+extName;  //文件名称，以系统时间命名
		String savePath = "D:/Cgl_Work/JAVA/myStruts/WebContent/upload/"+newFile;
		OutputStream os = new FileOutputStream(savePath);   //写入文件到目录
		IOUtils.copy(ins, os);    //调用第三方插件
		os.flush();
		os.close();
		ins.close();
		ActionContext.getContext().getSession().put("newFile", newFile);  //通过session保存
		return "upload_success";
	}
	
	//文件下载的方法
	public String download(){
		return "download_success";	
	}
	
	public InputStream getInputStream() throws FileNotFoundException {
		String downloadPath = ServletActionContext.getServletContext().getRealPath("/upload");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(downloadPath+"/"+this.downloadFileName));
		return bis;  //返回一个文件输入流
	}
	
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getDownloadFileName() {
		return downloadFileName;
	}
	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getContentDisposition() {
		return contentDisposition;
	}
	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
	
	
}
