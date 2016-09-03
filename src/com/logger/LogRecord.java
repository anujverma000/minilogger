package com.logger;

import java.io.Serializable;



public class LogRecord implements Serializable
{
	private static final long serialVersionUID = 6125467663793329856L;
	private String lev;
	private int seqNo;
	private String message;
	private long timeStamp;
	private String callingClass;
	private String callingMethod;
	private int lineNo;
	private String currentThread;
	private Throwable throwable;

	public LogRecord(int level, 
					 String message, 
					 String callingClass, 
					 String callingMethod, 
					 int lineNo, 
					 String currentThread,
					 Throwable throwable)
	{
		Level.setLevel(level);
		this.lev = Level.getLevel();
		this.seqNo = Logger.globalSequenceNumber++;
		this.message = message;		
		this.timeStamp = System.currentTimeMillis(); 
		this.callingClass = callingClass;
		this.callingMethod = callingMethod;
		this.lineNo = lineNo;
		this.currentThread = currentThread;
		this.throwable = throwable;
	}
	/**
	 * @return the level
	 */
	public String getLevel() {
		return lev;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		Level.setLevel(level);
		lev = Level.getLevel();
		
	}
	/**
	 * @return the seqNo
	 */
	public int getSeqNo() {
		return seqNo;
	}
	/**
	 * @param seqNo the seqNo to set
	 */
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @return the callingClass
	 */
	public String getCallingClass() {
		return callingClass;
	}
	/**
	 * @param callingClass the callingClass to set
	 */
	public void setCallingClass(String callingClass) {
		this.callingClass = callingClass;
	}
	/**
	 * @return the callingMethod
	 */
	public String getCallingMethod() {
		return callingMethod;
	}
	/**
	 * @param callingMethod the callingMethod to set
	 */
	public void setCallingMethod(String callingMethod) {
		this.callingMethod = callingMethod;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}	

	/**
	 * @return the currentThread
	 */
	public String getCurrentThread() {
		return currentThread;
	}
	/**
	 * @param currentThread the currentThread to set
	 */
	public void setCurrentThread(String currentThread) {
		this.currentThread = currentThread;
	}
	/**
	 * @return the lineNo
	 */
	public int getLineNo() {
		return lineNo;
	}
	/**
	 * @param lineNo the lineNo to set
	 */
	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}
	

	/**
	 * @return the throwable
	 */
	public Throwable getThrowable() {
		return throwable;
	}
	/**
	 * @param throwable the throwable to set
	 */
	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
}
