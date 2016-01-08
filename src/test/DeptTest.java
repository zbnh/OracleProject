package test;

import java.util.List;

import domain.Dept;
import factory.DAOFactory;

public class DeptTest {
	public static void main(String[] args) {
		List<Dept> list = DAOFactory.getDeptDaoInstance().findAll();
		for (Dept dept : list) {
			System.out.println(dept.getDeptno());
		}
	}
}
