package com.lyswzs.dao;

import java.util.List;

import com.lyswzs.bean.StuClass;
import com.lyswzs.bean.Student;

public interface StuClassDao {
   public boolean insert(StuClass cs);
	
   public boolean update(StuClass cs);
   
   public List<StuClass> findAll();
   
   public List<Student> queryByIdstuclass(String stuclass_id);
   
}
