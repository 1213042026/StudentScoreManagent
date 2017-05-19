package com.lyswzs.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lyswzs.bean.Course;
import com.lyswzs.bean.CourseInfo;
import com.lyswzs.bean.Teacher;
import com.lyswzs.bean.TeacherQueryScore;
import com.lyswzs.dao.TeacherDao;
import com.lyswzs.dao.impl.TeacherDaoImpl;
import com.lyswzs.service.TeacherService;

public class TeacherAction {
	private TeacherDao dao = new TeacherDaoImpl();
	private Course course;
	private Teacher teacher;
	private CourseInfo courseInfo;
	private String upd_pwd;
	private String cour_name;
	private List<Teacher> list;
	private String teac_id;
	
	public List<Teacher> getList() {
		return list;
	}

	public void setList(List<Teacher> list) {
		this.list = list;
	}

	public String getTeac_id() {
		return teac_id;
	}

	public void setTeac_id(String teac_id) {
		this.teac_id = teac_id;
	}

	public TeacherService getService() {
		return service;
	}

	public void setService(TeacherService service) {
		this.service = service;
	}

	public String getCour_name() {
		return cour_name;
	}

	public void setCour_name(String cour_name) {
		this.cour_name = cour_name;
	}

	public String getUpd_pwd() {
		return upd_pwd;
	}

	public void setUpd_pwd(String upd_pwd) {
		this.upd_pwd = upd_pwd;
	}

	public CourseInfo getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	TeacherService service = null;

	public String courseList() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		service = new TeacherService();
		List<Course> list = (List<Course>) service.courseList(teacher.getTeac_id());
		System.out.println(list.size());
		session.setAttribute("courseList", list);
		return "courseList";
	}

	public String updateTeacherInfo() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		service = new TeacherService();
		System.out.println(teacher.getTeac_id());
		System.out.println(teacher.getTeac_pwd());
		String pwd = getUpd_pwd();
		if (service.updateTeacheInfo(teacher.getTeac_id(), pwd)) {
			return "updateTeacher";
		} else {
			return "error";
		}
	}

	public String courseInfo() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		service = new TeacherService();
		System.out.println(teacher.getTeac_id());
		List<CourseInfo> list = (List<CourseInfo>) service.courseInfo(teacher.getTeac_id(), getCour_name());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(((CourseInfo) list.get(i)).getCour_name() + "||" + i);
		}
		session.setAttribute("courseinfo", list);
		return "courseInfo";
	}

	public String scoreList() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		service = new TeacherService();
		List<Course> list = (List<Course>) service.scoreList(teacher.getTeac_id());
		session.setAttribute("scoreList", list);
		return "scoreList";
	}

	public String scoreInfo() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		service = new TeacherService();
		List<TeacherQueryScore> list = (List<TeacherQueryScore>) service.scoreInfo(teacher.getTeac_id(), cour_name);
		session.setAttribute("scoreInfo", list);
		return "scoreInfo";
	}

	public String findAll() {
		list = dao.findAll();
		String result = "error";
		if (list != null) {
			result = "ok";
		}
		return result;
	}

	public String deleteById() {
		String result = "error";
		if (dao.deleteById(Integer.parseInt(teac_id))) {
			result = "deleteok";
		}
		return result;
	}

	public String insert() {
		String result = "error";
		if (dao.insert(teacher)) {
			result = "insertok";
		}
		return result;
	}
}
