package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConn {
	public static Connection getConnection() {
		String connURL = "jdbc:oracle:thin:@192.168.213.129:1521:ORCL";
		String user = "scott";
		String pwd = "123";
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			conn=DriverManager.getConnection(connURL,user,pwd);
			conn.setAutoCommit(false);
			return conn;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
