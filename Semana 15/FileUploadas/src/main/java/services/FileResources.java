package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import entity.FileModel;

@Stateless
@Path("files")
public class FileResources {
	
	@Context
	private ServletContext application;
	
	
	@GET
	@Path("echo")
	public String echo() {
		return "echo";
	}
	
	@POST
	@Path("upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String upload(
			@FormDataParam("file") InputStream uploaded,
			@FormDataParam("file") FormDataContentDisposition details
			) throws IOException {
		
		String path = application.getRealPath("/");
		String storagePath = path + details.getFileName();
		
		
		writeFileInPath(uploaded, storagePath);
		
		return "El archivo fue escrito en "+storagePath;
	}
	
	
	@POST
	@Path("upload/json")
	@Consumes("application/json")
	public String uploadJson(FileModel file) throws IOException {
		String path = application.getRealPath("/");
		String storagePath = path + file.name;
		
		String coded = file.data;
		byte[] decoded = Base64.getDecoder().decode(coded);
		FileUtils.writeByteArrayToFile(new File(storagePath), decoded);
		return "OK";
		
	}
	

	private void writeFileInPath(InputStream uploaded, String storagePath) throws IOException {
		FileOutputStream fos = new FileOutputStream( new File(storagePath) );
		
		byte[] buffer = new byte[1024];
		int leidos = 0;
		while(  (leidos = uploaded.read(buffer)) != -1  ) {
			fos.write(buffer, 0, leidos);			
		}
		uploaded.close();
		fos.close();
		
	}
	
	
	
	
}
