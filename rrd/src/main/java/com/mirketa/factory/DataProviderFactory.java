package com.mirketa.factory;

import com.mirketa.dataprovider.ConfigDataProvider;
import com.mirketa.dataprovider.ExcelDataProvider;

public class DataProviderFactory 
{
	public static ConfigDataProvider getConfig()
	{
		ConfigDataProvider config=new ConfigDataProvider();
		return config;
	}
	
	public static ExcelDataProvider getExcel()
	{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel;
	}
	

}
