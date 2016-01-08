package util;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
public class DbcpUtil {
	private static Connection conn =  null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static PreparedStatement ps= null;
	private static Properties p;
	private static BasicDataSource ds = null;


	
	public static void init()
	{
		if(ds != null)
		{
			try {
				ds.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		ds = null;
		
		p = new Properties();
		//p.setProperty("username", "root");
		//p.setProperty("password", "123");
		try {
			p.load(DbcpUtil.class.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ds = (BasicDataSource) BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static synchronized Connection getConnection()
	{
		if(ds == null)
		{
			init();
		}
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public static PreparedStatement getPrepareStatement(String sql)
	{
		try {
			ps = getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	
	
	public static int executeSQL(String sql)
	{
		int result = 0 ;
		
		try {
			stmt = getConnection().createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public static ResultSet executeSelect(String sql)
	{
		try {
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static void close()
	{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
