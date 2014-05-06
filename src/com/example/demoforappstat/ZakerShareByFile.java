package com.example.demoforappstat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import android.content.Context;
import android.text.TextUtils;

/**
 * 
 * 此工具类用于一些跨进程无法正确读取的变量
 * 
 * @author Administrator
 * 
 */
public class ZakerShareByFile {
 
	static final String ZAKER_SHARE_FILE = "ZAKER_SHARE_FILE";

	public static void saveBoolean(Context context, String tag, boolean value) {

		Properties properties = loadConfig(context, ZAKER_SHARE_FILE);

		properties.put(tag, String.valueOf(value));

		saveConfig(context, ZAKER_SHARE_FILE, properties);

	}

	public static boolean getBoolean(Context context, String tag,
			boolean defaultValue) {

		Properties properties = loadConfig(context, ZAKER_SHARE_FILE);

		String value = (String) properties.get(tag);

		if (value == null) {
			return defaultValue;
		} else {
			return Boolean.parseBoolean(value);
		}

	}

	public static void saveString(Context context, String tag, String value) {
		
		Properties properties = loadConfig(context, ZAKER_SHARE_FILE);

		if (value != null)
			properties.put(tag, value);

		saveConfig(context, ZAKER_SHARE_FILE, properties);
	}

	public static void clearString(Context context, String tag) {
		Properties properties = loadConfig(context, ZAKER_SHARE_FILE);

		properties.remove(tag);

		saveConfig(context, ZAKER_SHARE_FILE, properties);
	}
	
	public static void saveLong(Context context, String tag, long value)
	{
		Properties properties = loadConfig(context, ZAKER_SHARE_FILE);
		
		properties.put(tag, String.valueOf(value));
		
		saveConfig(context, ZAKER_SHARE_FILE, properties);
	}
	
	public static long getLong(Context context, String tag, long defaultValue)
	{
		Properties properties = loadConfig(context, ZAKER_SHARE_FILE);

		String value = (String) properties.get(tag);

		if (value != null) { 
			return Long.valueOf(value);
		}
		return defaultValue;
	}
	

	public static String getString(Context context, String tag,
			String defaultValue) {

		Properties properties = loadConfig(context, ZAKER_SHARE_FILE);

		String value = (String) properties.get(tag);

		if (value == null) {
			return defaultValue;
		} else {
			return value;
		}
	}

	public static Properties loadConfig(Context context, String file) {
		Properties properties = new Properties();
		try {
			FileInputStream s = context.openFileInput(file);
			properties.load(s);
		} catch (Exception e) {
		}
		return properties;
	}

	public static void saveConfig(Context context, String file,
			Properties properties) {
		try {
			FileOutputStream s = context.openFileOutput(file,
					Context.MODE_PRIVATE);
			properties.store(s, "utf-8");
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
