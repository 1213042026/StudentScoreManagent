package com.lyswzs.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lyswzs.bean.Student;
import com.lyswzs.bean.StudentScore;
import com.lyswzs.dao.StudentDao;
import com.lyswzs.dao.impl.StudentDaoImpl;
import com.lyswzs.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	/**
	 * 
	 */

	private List<StudentScore> scorelist;
	private Student stus;
	private List<Student> list;
	private StudentDao dao = new StudentDaoImpl();
	private String stu_id;
	
	public String getStu_id(){
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public List<StudentScore> getScorelist() {
		return scorelist;
	}

	public void setScorelist(List<StudentScore> scorelist) {
		this.scorelist = scorelist;
	}

	public Student getStus() {
		return stus;
	}

	public void setStus(Student stus) {
		this.stus = stus;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public String Score() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Student student = (Student) session.getAttribute("student");
		StudentService service = new StudentService();
		// scorelist=new ArrayList<StudentScore>();
		scorelist = service.findScore(student.getStu_id());
		// session.setAttribute("scorelist", list);
		return "scorelist";
	}

	public String Update() {
		StudentService service = new StudentService();
		if (service.update(stus.getStu_id(), stus.getStu_pwd(), stus.getStu_tel(), stus.getStu_address())) {
			return SUCCESS;
		}
		return INPUT;
	}

	public String Info() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Student student = (Student) session.getAttribute("student");
		StudentService service = new StudentService();
		stus = service.findStu(student.getStu_id());
		session.setAttribute("student", stus);
		return "stus";
	}

	public String findAll() {
		list = dao.findAll();
		String result = "error";
		if (list != null) {
			result = "ok";
		}
		return result;
	}

	public String deleteById(){
		String result = "error";
		if (dao.deleteById(Integer.parseInt(stu_id))) {
			result = "deleteok";
		}
		return result;
	}

	public String insert() {
		String result = "error";
		if (dao.insert(stus)) {
			result = "addok";
		}
		return result;
	}
}
