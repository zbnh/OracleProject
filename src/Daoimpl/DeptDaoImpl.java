package Daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import dao.DeptDao;
import domain.Dept;
import util.DbcpUtil;

public class DeptDaoImpl implements DeptDao {

	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		List<Dept> result = new ArrayList<Dept>();
		String sql = "select * from dept order by deptno";
		ResultSet rs = DbcpUtil.executeSelect(sql);
		try {
			while (rs.next()) {
				Dept d = new Dept();
				d.setDeptno(rs.getInt("DEPTNO"));
				d.setDname(rs.getString("DNAME"));
				d.setLoc(rs.getString("LOC"));
				result.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(int deptno) {
		int result = 0;
		String sql = "delete from dept where deptno = ?";
		PreparedStatement ps = DbcpUtil.getPrepareStatement(sql);
		try {
			ps.setInt(1, deptno);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Dept> find(int deptno) {
		// TODO Auto-generated method stub
		List<Dept> result = new ArrayList<Dept>();
		String sql = "select * from dept where deptno = " + deptno;
		ResultSet rs = DbcpUtil.executeSelect(sql);
		Dept dept = new Dept();
		try {
			while (rs.next()) {
				dept.setDeptno(rs.getInt("DEPTNO"));
				dept.setDname(rs.getString("DNAME"));
				dept.setLoc(rs.getString("LOC"));
				result.add(dept);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int insert(Dept dept) {
		// TODO Auto-generated method stub
		String sql = "insert into dept values (?,?,?)";
		int result = 0;
		PreparedStatement ps = DbcpUtil.getPrepareStatement(sql);
		try {
			ps.setInt(1, dept.getDeptno());
			ps.setString(2, dept.getDname());
			ps.setString(3, dept.getLoc());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(int deptid, Dept dept) {
		// TODO Auto-generated method stub
		String sql = "update dept set deptno = ?,dname = ?,loc = ? where deptno = ?";
		int i = 0;
		PreparedStatement ps = DbcpUtil.getPrepareStatement(sql);
		try {
			ps.setInt(1, dept.getDeptno());
			ps.setString(2, dept.getDname());
			ps.setString(3, dept.getLoc());
			ps.setInt(4, deptid);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}



}
