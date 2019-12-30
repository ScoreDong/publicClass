package com.xiaomi.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UploadUtils {
	// 上传的方法
	public static String upload(String errorPath,Part part, HttpServletRequest request, HttpServletResponse response) {

		// 获取文件名
		String photo = part.getSubmittedFileName();
		photo = UUID.randomUUID() + photo;//解决同名文件的问题
		// 获取到文件的后缀类型,进行类型判断
		String type = photo.substring(photo.lastIndexOf(".") + 1);
		// System.out.println(type);
		if (!("png".equalsIgnoreCase(type) || "jpg".equalsIgnoreCase(type) || "jpeg".equalsIgnoreCase(type))) {
			request.setAttribute("msg", "头像类型必须是png,jpg,jpeg格式的图片");
			try {
				request.getRequestDispatcher(errorPath).forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			photo = "";
		}
		// 为了保证图片正常获取,我们将图片上传到tomcat服务器内部
		String path = "F:/xmpic";
		// System.out.println(path);
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		try {
			part.write(path + "/" + photo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return photo;
	}

}
