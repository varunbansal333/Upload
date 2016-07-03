package com.fileUploader.api;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/library")
public class LibrarySearchApi {
	
	@GET
	@Path("/book")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_HTML)
	public Response searchPage() throws IOException{
		String response = null;
		
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("/books")
	@Produces(MediaType.TEXT_PLAIN)
	public Response searchBooks(@PathParam("searchItem") String searchItem ) throws IOException{
		
		return Response.ok().build();
	}

}
