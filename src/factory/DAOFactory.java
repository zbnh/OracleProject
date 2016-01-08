package factory;

import Daoimpl.DeptDaoImpl;
import Daoimpl.EmpDaoImpl;
import dao.DeptDao;
import dao.EmpDao;

public class DAOFactory {
	public static DeptDao getDeptDaoInstance(){
		return new DeptDaoImpl();
	}
	public static EmpDao getEmpDaoInstance() {
		return new EmpDaoImpl();
	}
}
