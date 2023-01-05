package com.xyzcompany.crud.Dao;

import java.util.List;

import com.xyzcompany.crud.Model.Student;

public interface HomeDao {

	public int savedata(Student stu);

	public int loginCheck(String un, String pass);

	public List displayAllData();

	public int deletedata(int sid);

	public Student editpage(int sid);

	public int updatedata(Student s);

}
