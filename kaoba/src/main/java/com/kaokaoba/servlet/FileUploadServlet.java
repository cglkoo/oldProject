package com.kaokaoba.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMutilpart =  ServletFileUpload.isMultipartContent(request);
		String fileName = ""; // 上传成功后的图片路径以及图片名字
		if(isMutilpart){
			try{
				
				String filePath = request.getServletContext().getRealPath("/upload");
				filePath = filePath.replace('\\', '/');
				File file = new File(filePath);
				if(!file.exists()){
					file.mkdirs();
				}
				// 声明DiskFileItem工厂类
				DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
				diskFileItemFactory.setSizeThreshold(4*1024);
				ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
				servletFileUpload.setSizeMax(40000); // 设置文件的大小 40000bytes ~= 40kb
				
				List<FileItem> list = servletFileUpload.parseRequest(request);
				for(FileItem item : list){
					if(item.isFormField()){
						// input为text,mail,number等类型的数据
						String fieldName = item.getFieldName();
						if(fieldName.equals("userId")){
							System.out.println("userId:"+item.getString("UTF-8"));
						}
					}else{
						// input为file类型的数据
						// 获取文件后辍名
						String extName = item.getName().substring(item.getName().lastIndexOf("."));
						String fn = System.currentTimeMillis() + extName;
						fileName = "upload/" + fn;
						File outFile = new File(filePath, fn);
						item.write(outFile);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
				response.setStatus(500);
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("code", 500);
				jsonObject.put("msg", "服务器异常，上传失败");
				out.write(JSON.toJSONString(jsonObject));
				return;
			}
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", 200);
			jsonObject.put("data", fileName);
			jsonObject.put("msg", "上传成功");
			System.out.println(JSON.toJSONString(jsonObject));
			out.write(JSON.toJSONString(jsonObject));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
