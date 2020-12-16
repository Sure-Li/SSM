package com.situ.spring.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UpoladController {
	@RequestMapping("/upload1")
	public String doUpload(String stuName, MultipartFile stuFile, HttpServletRequest request) {
		System.out.println("stuFile:" + stuFile);
		System.out.println("stuName:" + stuName);
		if (!stuFile.isEmpty()) {// 判断不为空
			System.out.println("stuFile.getName()" + stuFile.getOriginalFilename());
			System.out.println("stuFile.getContentType()" + stuFile.getContentType());
			try {
				System.out.println("stuFile.getInputStream()" + stuFile.getInputStream());
				System.out.println("stuFile.getBytes()" + stuFile.getBytes());
				String realPath = request.getServletContext().getRealPath("/");
				StringBuilder stringBuilder = new StringBuilder();
				String fileSuffix = stuFile.getOriginalFilename()
						.substring(stuFile.getOriginalFilename().lastIndexOf("."));
				stringBuilder.append(realPath).append("upfiles/").append(Calendar.getInstance().getTimeInMillis())
						.append(fileSuffix);
				File outFile = new File(stringBuilder.toString());
				File getParentFile = outFile.getParentFile();
				if (!getParentFile.exists()) {
					getParentFile.mkdirs();
				}
				stuFile.transferTo(new File(stringBuilder.toString()));
				System.out.println(stringBuilder);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	@ResponseBody
	@RequestMapping("/upload3")
	public String doAjax(MultipartFile multipartFile, HttpServletRequest request) {
		System.out.println(multipartFile);
		String realPath = request.getServletContext().getRealPath("/");
		StringBuilder stringBuilder = new StringBuilder();
		String fileSuffix = multipartFile.getOriginalFilename()
				.substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		stringBuilder.append(realPath).append("upfiles/").append(Calendar.getInstance().getTimeInMillis())
				.append(fileSuffix);
		System.out.println("相对路径"+stringBuilder);
		File outFile = new File(stringBuilder.toString());
		File getParentFile = outFile.getParentFile();
		if (!getParentFile.exists()) {
			getParentFile.mkdirs();
		}
		try {
			multipartFile.transferTo(new File(stringBuilder.toString()));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		StringBuilder upBuilder = new StringBuilder("upfiles/");
		return upBuilder.append(Calendar.getInstance().getTimeInMillis())
				.append(fileSuffix).toString();
	}
}
