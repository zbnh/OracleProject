package Daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmpDao;
import domain.Emp;
import domain.EmpWithDept;
import util.DbcpUtil;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> findAll() {
		// TODO Auto-generated method stub
		List<Emp> result = new ArrayList<Emp>();
		String sql = "select * from emp order by empno";
		ResultSet rs = DbcpUtil.executeSelect(sql);
		try {
			while (rs.next()) {
				Emp e = new Emp();
				e.setEmpno(rs.getInt("EMPNO"));
				e.setEname(rs.getString("ENAME"));
				e.setJob(rs.getString("JOB"));
				e.setMgr(rs.getInt("MGR"));
				e.setHiredate(rs.getDate("HIREDATE"));
				e.setSal(rs.getFloat("SAL"));
				e.setComm(rs.getFloat("COMM"));
				e.setDeptno(rs.getInt("DEPTNO"));
				result.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(int empno) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "delete from emp where empno = ?";
		PreparedStatement ps = DbcpUtil.getPrepareStatement(sql);
		try {
			ps.setInt(1, empno);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<EmpWithDept> findAllWithDept() {
		// TODO Auto-generated method stub
		List<EmpWithDept> result = new ArrayList<EmpWithDept>();
		String sql = "select e.empno,e.ename,e.job,e.mgr,e.hiredate,e.sal,"
				+ "e.comm,e.deptno,d.dname,d.loc from emp e left join dept d on e.deptno=d.deptno order by empno";
		ResultSet rs = DbcpUtil.executeSelect(sql);
		try {
			while (rs.next()) {
				EmpWithDept ewd = new EmpWithDept();
				ewd.setEmpno(rs.getInt("EMPNO"));
				ewd.setEname(rs.getString("ENAME"));
				ewd.setJob(rs.getString("JOB"));
				ewd.setMgr(rs.getInt("MGR"));
				ewd.setHiredate(rs.getDate("HIREDATE"));
				ewd.setSal(rs.getFloat("SAL"));
				ewd.setComm(rs.getFloat("COMM"));
				ewd.setDeptno(rs.getInt("DEPTNO"));
				ewd.setDname(rs.getString("DNAME"));
				ewd.setLoc(rs.getString("LOC"));
				result.add(ewd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Emp> find(int empno) {
		// TODO Auto-generated method stub
		List<Emp> result = new ArrayList<Emp>();
		String sql = "select * from emp where empno = " + empno;
		ResultSet rs = DbcpUtil.executeSelect(sql);
		Emp emp = new Emp();
		try {
			while (rs.next()) {
				emp.setEmpno(rs.getInt("EMPNO"));
				emp.setEname(rs.getString("ENAME"));
				emp.setJob(rs.getString("JOB"));
				emp.setMgr(rs.getInt("MGR"));
				emp.setHiredate(rs.getDate("HIREDATE"));
				emp.setSal(rs.getFloat("SAL"));
				emp.setComm(rs.getFloat("COMM"));
				emp.setDeptno(rs.getInt("DEPTNO"));
				result.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(int empid, Emp emp) {
		// TODO Auto-generated method stub
		String sql = "update emp set empno = ?," + "ename = ?,job = ?,mgr = ?,"
				+ "hiredate = ?,sal = ?,comm = ?,deptno = ? " + "where empno = ?";
		int i = 0;
		PreparedStatement ps = DbcpUtil.getPrepareStatement(sql);
		try {
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getMgr());
			ps.setDate(5, emp.getHiredate());
			ps.setFloat(6, emp.getSal());
			ps.setFloat(7, emp.getComm());
			ps.setInt(8, emp.getDeptno());
			ps.setInt(9, empid);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int insert(Emp emp) {
		// TODO Auto-generated method stub
		String sql = "insert into emp values (?,?,?,?,?,?,?,?)";
		int result = 0;
		PreparedStatement ps = DbcpUtil.getPrepareStatement(sql);
		try {
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getMgr());
			ps.setDate(5, emp.getHiredate());
			ps.setFloat(6, emp.getSal());
			ps.setFloat(7, emp.getComm());
			ps.setFloat(8, emp.getDeptno());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
