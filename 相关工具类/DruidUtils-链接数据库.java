package com.xiaomi.utils;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 
 * @author Administrator
 *	此类专门为QueryRunner提供数据源
 */
public class DruidUtils {
	private static DataSource dataSource = null;
	
	static {
		Properties properties = new Properties();
		try {
			//类加载器自带的输入流对象,可以默认自动去读取src下的文件
			InputStream asStream = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
			properties.load(asStream);
			dataSource = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}
















