 package com.lsy.mvcapp.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * JDBC操作的工具类
 * 
 * @author apple
 *
 */
public class JdbcUtils {

	public static void releaseConnection(Connection connection){
		try {
			if(connection != null){
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static DataSource dataSource=null;
	
	static{
		dataSource=new ComboPooledDataSource("mvcapp");
	}
	
	
	/**
	 * 返回数据源的一个connection对象
	 * @return
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
