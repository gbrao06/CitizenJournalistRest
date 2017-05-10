package com.shareki.world.rest.mvc.controllers;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageReader {

	public ImageReader() {
		// TODO Auto-generated constructor stub
	}

	public byte[] getBytes(String urlPath) throws Exception
	{
    	URL url = new URL(urlPath);//new URL("http://localhost:18088/Shareki/images/DSC00278.jpg");

	        // Read the image ...
		InputStream inputStream      = url.openStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		//byte [] buffer               = new byte[ 1024 ];
		
		byte[] buffer = new byte[5000000];
    	
		/* 
		 *  int readBytes = 0;
                            
                            while ((readBytes = inputStream.read(buffer, 0, 1000000)) != -1) {
                                    outputStream.write(buffer, 0, readBytes);
                            }
                            outputStream.flush();
                            outputStream.close();
                           
                            inputStream.close();
		 */
	    
		int n = 0;
	    while (-1 != (n = inputStream.read(buffer,0,5000000))) {
	       outputStream.write(buffer, 0, n);
	    }
	
	    inputStream.close();
	
		// Here's the content of the image...
		byte [] data = outputStream.toByteArray();
	
		// Write it to a file just to compare...
		//OutputStream out = new FileOutputStream("data.png");
		//out.write( data );
		//out.close();

	// Print it to stdout 
		//for( byte b : data ) {
		//	System.out.printf("0x%x ", b);
		
		return data;
	}

	
}
