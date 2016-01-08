package dao;

import java.util.List;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import domain.Emp;
import domain.EmpWithDept;

public interface EmpDao {
	public List<Emp> findAll();

	public int delete(int empno);
	public List<EmpWithDept> findAllWithDept();
	public List<Emp> find(int empno);
	public int update(int empid,Emp emp);
	public int insert(Emp emp);
}
