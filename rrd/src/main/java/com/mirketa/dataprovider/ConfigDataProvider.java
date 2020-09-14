package com.mirketa.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	 public Properties pro;

	public ConfigDataProvider() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is: " + e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String url=pro.getProperty("url");
		return url;
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String getIEPath()
	{
		String iepath=pro.getProperty("IEpath");
		return iepath;
	}
	public String getFirefoxPath()
	{
		String firefoxpath=pro.getProperty("Firefoxpath");
		return firefoxpath;
	}
	

}
