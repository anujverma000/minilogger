package com.logger;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class SocketHandler extends Handler {

	private String host = "";
	private int port;
	private Socket socket;
	private ObjectOutputStream oos;
	
	public SocketHandler(String hostName, String portNumber)
	{
		this.host = hostName;
		this.port = Integer.parseInt(portNumber);
	
	}
    public synchronized boolean publish(LogRecord record ) 
    {
       try 
       { 	
    	   socket = new Socket(host, port);
    	   oos = new ObjectOutputStream(socket.getOutputStream());
    	   oos.writeObject(record);
    	   oos.flush();
    	   oos.close();
    	   socket.close();
    	   return true;
       } 
       catch (UnknownHostException e) 
       {		
    	   Logger.log(e.getMessage());
    	   return false;
       }
       catch (IOException e) 
       {		
    	   Logger.log(e.getMessage());
    	   return false;
       } 
    }
    
}
