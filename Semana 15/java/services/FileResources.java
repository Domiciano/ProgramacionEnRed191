package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

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
	
	@GET
	@Path("upload")
	public String upload(
			@FormDataParam("file") InputStream uploaded,
			@FormDataParam("file") FormDataContentDisposition details
			) throws IOException {
		
		String path = application.getRealPath("/");
		String storagePath = path + details.getFileName();
		
		writeFileInPath(uploaded, storagePath);
		
		return "El archivo fue escrito en "+storagePath;
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
