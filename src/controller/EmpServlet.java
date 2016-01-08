package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import com.sun.org.apache.xerces.internal.util.EntityResolver2Wrapper;

import domain.Dept;
import domain.Emp;
import domain.EmpWithDept;
import factory.DAOFactory;

@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Method(request, response);
	}

	private void Method(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		switch (method) {
		case "findAll":
			findAll(request, response);
			break;
		case "delete": {
			delete(request, response);
			System.out.println("1");
			break;
		}
		case "findAllWithDept": {
			findAllWithDept(request, response);
			break;
		}
		case "update": {
			update(request, response);
			break;
		}
		case "insert": {
			insert(request, response);
			break;
		}
		case "preupdate": {
			preupdate(request, response);
			break;
		}
		case "preinsert": {
			preinsert(request, response);
			break;
		}
		case "checklogin": {
			checklogin(request, response);
			break;
		}
		default:
			break;
		}
	}

	private void checklogin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		if ("scott".equals(uname) && "123".equals(upwd)) {
			findAll(request, response);
		} else {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print("<script>alert('用户名或密码错误!'); window.location='Login.jsp' </script>");
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void preinsert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		try {
			request.getSession().removeAttribute("empid");
			request.getSession().removeAttribute("empno");
			request.getSession().removeAttribute("ename");
			request.getSession().removeAttribute("job");
			request.getSession().removeAttribute("mgr");
			request.getSession().removeAttribute("hiredate");
			request.getSession().removeAttribute("sal");
			request.getSession().removeAttribute("comm");
			request.getSession().removeAttribute("deptno");
			HttpSession session = request.getSession();
			session.setAttribute("action", "./EmpServlet?method=insert");
			response.sendRedirect("Emp.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void preupdate(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int empno = Integer.parseInt(request.getParameter("empno"));
		List<Emp> empList = DAOFactory.getEmpDaoInstance().find(empno);
		HttpSession session = request.getSession();
		String ename = "", job = "";
		int mgr = 0, deptno = 0;
		Date hiredate = null;
		float sal = 0, comm = 0;
		for (Emp emp : empList) {
			empno = empList.get(0).getEmpno();
			ename = empList.get(0).getEname();
			job = empList.get(0).getJob();
			mgr = empList.get(0).getMgr();
			hiredate = empList.get(0).getHiredate();
			sal = empList.get(0).getSal();
			comm = empList.get(0).getComm();
			deptno = empList.get(0).getDeptno();
		}
		session.setAttribute("empno", empno);
		session.setAttribute("ename", ename);
		session.setAttribute("job", job);
		session.setAttribute("mgr", mgr);
		session.setAttribute("hiredate", hiredate);
		session.setAttribute("sal", sal);
		session.setAttribute("comm", comm);
		session.setAttribute("deptno", deptno);
		session.setAttribute("action", "./EmpServlet?method=update&empno=" + empno);
		try {
			response.sendRedirect("Emp.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) {
		int i = 0;
		// TODO Auto-generated method stub
		try {
			Emp emp = new Emp();
			emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
			emp.setEname(request.getParameter("ename"));
			emp.setJob(request.getParameter("job"));
			emp.setMgr(Integer.parseInt(request.getParameter("mgr")));
			java.sql.Date date = java.sql.Date.valueOf(request.getParameter("hiredate"));
			emp.setHiredate(date);
			emp.setSal(Float.parseFloat(request.getParameter("sal")));
			emp.setComm(Float.parseFloat(request.getParameter("comm")));
			emp.setDeptno(Integer.parseInt(request.getParameter("deptno")));
			i = DAOFactory.getEmpDaoInstance().insert(emp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if (i != 0) {
			findAll(request, response);
		} else {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print("<script>alert('操作失败!'); window.location='Emp.jsp' </script>");
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			int empid = Integer.parseInt(request.getParameter("empno"));
			Emp emp = new Emp();
			emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
			emp.setEname(request.getParameter("ename"));
			emp.setJob(request.getParameter("job"));
			emp.setMgr(Integer.parseInt(request.getParameter("mgr")));
			java.sql.Date date = java.sql.Date.valueOf(request.getParameter("hiredate"));
			emp.setHiredate(date);
			emp.setSal(Float.parseFloat(request.getParameter("sal")));
			emp.setComm(Float.parseFloat(request.getParameter("comm")));
			emp.setDeptno(Integer.parseInt(request.getParameter("deptno")));
			i = DAOFactory.getEmpDaoInstance().update(empid, emp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if (i != 0) {
			findAll(request, response);
		} else {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print("<script>alert('操作失败!'); window.location='Emp.jsp' </script>");
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int toDelete = Integer.parseInt(request.getParameter("empid"));
		int i = DAOFactory.getEmpDaoInstance().delete(toDelete);
		findAll(request, response);
		System.out.println("i=" + i);
		System.out.println("2");
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		List<Emp> empList = DAOFactory.getEmpDaoInstance().findAll();
		HttpSession session = request.getSession();
		session.setAttribute("empList", empList);
		try {
			response.sendRedirect("EmpList.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void findAllWithDept(HttpServletRequest request, HttpServletResponse response) {
		List<EmpWithDept> ewdList = DAOFactory.getEmpDaoInstance().findAllWithDept();
		HttpSession session = request.getSession();
		session.setAttribute("ewdList", ewdList);
		try {
			response.sendRedirect("EmpAndDeptList.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
