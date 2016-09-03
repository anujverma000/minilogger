package com.logger;


public class Level 
{
	
	public static final int ALL = Integer.MIN_VALUE;
	public static final int INFO = Integer.MIN_VALUE+1;
	public static final int DEBUG = Integer.MIN_VALUE+2;
	public static final int FATAL = Integer.MIN_VALUE+3;
	public static final int ERROR = Integer.MIN_VALUE+4;
	public static final int CONFIG = Integer.MIN_VALUE+5;
	public static final int FINE = Integer.MIN_VALUE+6;
	public static final int FINER = Integer.MIN_VALUE+7;
	public static final int FINEST = Integer.MIN_VALUE+8;
	public static final int WARN = Integer.MIN_VALUE+9;
	public static final int OFF = Integer.MAX_VALUE;
	
	private static String Level = "ALL";

	/**
	 * @return the level
	 */
	public static String getLevel() {
		return Level;
	}

	/**
	 * @param level the level to set
	 */
	public static void setLevel(int level) {
		switch(level)
		{
			case ALL:Level = "ALL";
				break;
			case INFO:Level = "INFO";
				break;
			case DEBUG:Level = "DEBUG";
				break;
			case FATAL:Level = "FATAL";
				break;
			case ERROR:Level = "ERROR";
				break;
			case CONFIG:Level = "CONFIG";
				break;
			case FINE:Level = "FINE";
				break;
			case FINER:Level = "FINER";
				break;
			case FINEST:Level = "FINEST";
				break;
			case WARN: Level = "WARN";
				break;
			case OFF:Level = "OFF";
				break;				
		}
	}
}
