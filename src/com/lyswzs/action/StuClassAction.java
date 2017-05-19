package com.lyswzs.action;

import java.util.List;

import com.lyswzs.bean.StuClass;
import com.lyswzs.bean.Student;
import com.lyswzs.dao.StuClassDao;
import com.lyswzs.dao.impl.StuClassDaoImpl;

public class StuClassAction {

	private StuClass stuClass;
	private List<StuClass> list;
	private List<Student> lists;
	public List<Student> getLists() {
		return lists;
	}
	public void setLists(List<Student> lists) {
		this.lists = lists;
	}

	private StuClassDao dao=new StuClassDaoImpl();
	private String stuclass_id;
	
	public String getStuclass_id() {
		return stuclass_id;
	}
	public void setStuclass_id(String stuclass_id) {
		this.stuclass_id = stuclass_id;
	}
	
	public StuClass getStuClass() {
		return stuClass;
	}
	public void setStuClass(StuClass stuClass) {
		this.stuClass = stuClass;
	}
	public List<StuClass> getList() {
		return list;
	}
	public void setList(List<StuClass> list) {
		this.list = list;
	}
	public String findAll(){
		list=dao.findAll();
		String result="error";
		if(list!=null){
			result="ok";
		}
		return result;
	}

	
	public String update(){
		String result="error";
		if(dao.update(stuClass)){
			result="ok";
		}
		return result;
	}
	public String insert(){
		String result="error";
		if(dao.insert(stuClass)){
			result="addok";
		}
		return result;
	}
	
	public String queryById(){ 
      lists=dao.queryByIdstuclass(stuclass_id);
          if(lists != null){        	
        return "queryByidok";
        }
          return "error";
	}
}
