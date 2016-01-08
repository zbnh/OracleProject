package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import org.apache.taglibs.standard.tag.el.sql.UpdateTag;

import domain.Dept;
import factory.DAOFactory;

/**
 * Servlet implementation class DeptServlet
 */
@WebServlet("/DeptServlet")
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptServlet() {
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
			break;
		}
		case "preupdate": {
			preUpdate(request, response);
			break;
		}
		case "update": {
			update(request, response);
			break;
		}
		case "preinsert": {
			preinsert(request, response);
			break;
		}
		case "insert": {
			insert(request, response);
			break;
		}
		default:
			break;
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// System.out.println("yes1");
		int i = 0;
		try {
			Dept dept = new Dept();
			dept.setDeptno(Integer.parseInt(request.getParameter("deptno")));
			dept.setDname(request.getParameter("dname"));
			dept.setLoc(request.getParameter("loc"));
			i = DAOFactory.getDeptDaoInstance().insert(dept);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if (i != 0) {
			// System.out.println("yes");
			findAll(request, response);
		} else {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print("<script>alert('操作失败!'); window.location='Dept.jsp' </script>");
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
			int deptid = Integer.parseInt(request.getParameter("deptid"));
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			String dname = request.getParameter("dname");
			String loc = request.getParameter("loc");
			Dept dept = new Dept();
			dept.setDeptno(deptno);
			dept.setDname(dname);
			dept.setLoc(loc);
			i = DAOFactory.getDeptDaoInstance().update(deptid, dept);
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
				out.print("<script>alert('操作失败!'); window.location='Dept.jsp' </script>");
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
			request.getSession().removeAttribute("deptid");
			request.getSession().removeAttribute("deptno");
			request.getSession().removeAttribute("dname");
			request.getSession().removeAttribute("loc");
			HttpSession session = request.getSession();
			session.setAttribute("action", "./DeptServlet?method=insert");
			response.sendRedirect("Dept.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void preUpdate(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int deptno = Integer.parseInt(request.getParameter("deptId"));
		List<Dept> deptList = DAOFactory.getDeptDaoInstance().find(deptno);
		HttpSession session = request.getSession();
		String dname = "", loc = "";
		for (Dept dept : deptList) {
			deptno = deptList.get(0).getDeptno();
			dname = deptList.get(0).getDname();
			loc = deptList.get(0).getLoc();
		}
		// session.setAttribute("deptList", deptList);

		session.setAttribute("deptno", deptno);
		session.setAttribute("dname", dname);
		session.setAttribute("loc", loc);
		session.setAttribute("action", "./DeptServlet?method=update&deptid=" + deptno);
		try {
			response.sendRedirect("Dept.jsp");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int toDelete = Integer.parseInt(request.getParameter("deptId"));
		DAOFactory.getDeptDaoInstance().delete(toDelete);
		findAll(request, response);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		List<Dept> deptList = DAOFactory.getDeptDaoInstance().findAll();
		HttpSession session = request.getSession();
		session.setAttribute("deptList", deptList);
		try {
			response.sendRedirect("deptList.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
