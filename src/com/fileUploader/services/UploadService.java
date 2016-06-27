package com.fileUploader.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class UploadService {
	@SuppressWarnings("deprecation")
	public String upload(InputStream instrm){
	
	OutputStream outstrm;
	try {
		new Date(System.currentTimeMillis());
		File filed=new File("F:\\uploadedFile.txt");
		outstrm = new FileOutputStream(filed);
	byte[] byt = new byte[1024];
	while(instrm.read(byt) != -1){
		outstrm.write(byt);
	}
	outstrm.close();
	System.out.println(filed.getPath());
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return "success";
	}
}
