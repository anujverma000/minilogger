package com.logger;

import java.util.Vector;

public class Logger
{
	protected static int globalSequenceNumber = 0;

	private static Vector logQueue = new Vector();

	private Vector handlers = new Vector();
	
	private static int maxLogLevel = Level.ALL;
	
	/**
	 * @return the maxLogLevel
	 */
	public static int getMaxLogLevel()
	{
		return maxLogLevel;
	}
	/**
	 * @param maxLogLevel the maxLogLevel to set
	 */
	public static void setMaxLogLevel(int logLevel) 
	{
		maxLogLevel = logLevel;
	}
	
	private static Logger logger = new Logger();;
	
	public static Logger getLogger()
	{
		return logger;
	}	
	public synchronized static void log(Object object)
	{
		log(object, Level.INFO);
	}
	public synchronized static void info(Object object)
	{
		log(object, Level.INFO);
	}
	public synchronized static void debug(Object object)
	{
		log(object, Level.DEBUG);
	}
	public synchronized static void fatal(Object object)
	{
		log(object, Level.FATAL);
	}
	public synchronized static void error(Object object)
	{
		log(object, Level.ERROR);
	}
	public synchronized static void config(Object object)
	{
		log(object, Level.CONFIG);
	}
	public synchronized static void fine(Object object)
	{
		log(object, Level.FINE);
	}
	public synchronized static void finer(Object object)
	{
		log(object, Level.FINER);
	}
	public synchronized static void finest(Object object)
	{
		log(object, Level.FINEST);
	}
	public synchronized static void warn(Object object)
	{
		log(object, Level.WARN);
	}
	public synchronized static void log(Object object, int level)
	{
		String message="";
		if(object !=null)
				message= object.toString();
		Throwable t = new Throwable(); 
		StackTraceElement[] elements = t.getStackTrace(); 	
		LogRecord logRecord = null;
		try		
		{
			if(level > getMaxLogLevel())
			{
				logRecord = new LogRecord(level
										  ,message
										  ,Class.forName(elements[2].getClassName()).toString()
										  ,elements[2].getMethodName()+"()"
										  ,elements[2].getLineNumber()
										  ,Thread.currentThread().getName()
										  ,t);
				logQueue.addElement(logRecord);
				logger.requestPublish();
			}
		} 
		catch (ClassNotFoundException e) 
		{
			 Logger.log(e.getMessage());
		}		
	}
	

	public void addHandler(Handler handler)
	{
		handlers.add(handler); 
	}
	public Handler[] getHandlers()
	{
		Handler handler[] = new Handler[handlers.size()];
		for(int i =0; i<handlers.size();i++)
		{
			handler[i] = (Handler)handlers.get(i);
		}
		return handler;
	}
	private void requestPublish()
	{
		Handler handlers[] = getHandlers();
		for(int j=0;j<logQueue.size();j++)
		{
			for(int i =0 ; i<handlers.length ; i++)
			{
				handlers[i].publish((LogRecord)logQueue.get(j));			
			}
			logQueue.remove(j);
		}
		
	}
}

