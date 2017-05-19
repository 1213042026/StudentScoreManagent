package com.lyswzs.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lyswzs.bean.Admins;
import com.lyswzs.bean.Student;
import com.lyswzs.bean.Teacher;
import com.lyswzs.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String role;
	private String yzm;
	
	public String getYzm() {
		return yzm;
	}
	public void setYzm(String yzm) {
		this.yzm = yzm;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getRole() {
		return role;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String login(){
		
		System.out.println("username:" + getUsername()+"|pwd:" + getPassword() + "|verify:" + "|role:" + getRole());
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		LoginService service = new LoginService();
		int id=Integer.valueOf(username);
		switch (Integer.valueOf(getRole())) {
		case 1:
			System.out.println("管理员");
			Admins admins=service.isAdminsLoginSuccess(id, password);
			if(admins!=null){
				session.setAttribute("admins", admins);
				session.setAttribute("name", admins.getAdmins_id());
				session.setAttribute("role", admins.getRole_id());
			}else{
				this.addFieldError("username", "用户名不存在！");
				return INPUT;
			}
			break;
			
		case 2:
			System.out.println("教师");
			Teacher teacher = service.isTeacherLoginSuccess(id, password);
			if (teacher!=null) {
				session.setAttribute("teacher", teacher);
				session.setAttribute("name", teacher.getTeac_name());
				session.setAttribute("role", teacher.getRole_id());
			}else{
				this.addFieldError("username", "用户名不存在！");
				return INPUT;
			}
			break;	
		case 3:
			System.out.println("学生");
			Student student=service.isStudentLoginSuccess(id, password);
			if(student!=null){
				session.setAttribute("student", student);
				session.setAttribute("name", student.getStu_name());
				session.setAttribute("role", student.getRole_id());
			}else{
				this.addFieldError("username", "用户名不存在！");
				return INPUT;
			}
			break;
		default:
			break;
		}
		
		String syzm=(String) session.getAttribute("randomStr");
		if(syzm.equalsIgnoreCase(yzm)){
		return SUCCESS;
		}else{
			return INPUT;
		}
		}
	
	public String logout(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "ok";
	}
	
	 
}
