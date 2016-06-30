package com.fileUploader.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.fileUploader.services.UploadService;
import com.sun.jersey.multipart.FormDataParam;

@Path("/uploading")
public class UploadApi{

	@Autowired
	UploadService uploadService = new UploadService();
	
	@SuppressWarnings({ "static-access", "deprecation" })
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_HTML)
	public Response uploadingFile(@FormDataParam("file")File file) throws IOException{
		String response = uploadService.upload(new FileInputStream(file));
		if(response.equals("success")){
			response = "<HTML> <Head> <Title> Upload Application </Title><body> Uploaded Successfully</body> <Head> </HTML>";					
		}
		return Response.ok().entity(response).build();
	}
}
