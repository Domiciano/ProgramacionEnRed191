package com.icesi.ClientePOST;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Gson g = new Gson();
    	FileModel file = new FileModel();
    	file.name = "asd";
    	file.data = "asd";
    	
        try {
        	
        	byte[] filecontent = FileUtils.readFileToByteArray(new File("D:/Usuarios/1143848922/Pictures/1.png"));
        	String codificado = Base64.getEncoder().encodeToString(filecontent);
        	System.out.println(codificado);
        	file.name = "archivo.png";
        	file.data = codificado;
        	
        	
			String response = Consumer.POSTrequest("http://localhost:8080/FileUploadas/web/files/upload/json", g.toJson(file));
			
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
