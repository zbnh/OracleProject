package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Dept;
import util.OracleConn;

public interface DeptDao {
//	private Connection conn;
//
//	public List<Dept> queryDept() {
//		conn = OracleConn.getConnection();
//		String strQueryDept = "select * from dept";
////		ArrayList<Object> deptlist = new ArrayList<>();
//		List<Dept> deptlist = new ArrayList<Dept>();
//		try {
//			PreparedStatement preparedStatement = conn.prepareStatement(strQueryDept);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				Dept dept = new Dept();
//				dept.setDeptno(resultSet.getInt(0));
//				dept.setDname(resultSet.getString(1));
//				dept.setLoc(resultSet.getString(2));
//				deptlist.add(dept);
//			}
//			conn.commit();
//			return deptlist;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO: handle exception
//					e.printStackTrace();
//				}
//			}
//		}
//		return deptlist;
//	}
	public List<Dept> find(int deptno);
	public List<Dept> findAll();
	public int update(int deptid,Dept dept);
	public int delete(int deptno);
	int insert(Dept dept);
	
	
}
