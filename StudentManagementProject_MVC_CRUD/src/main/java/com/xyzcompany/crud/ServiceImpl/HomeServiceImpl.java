package com.xyzcompany.crud.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzcompany.crud.Dao.HomeDao;
import com.xyzcompany.crud.Model.Student;
import com.xyzcompany.crud.Service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	HomeDao hd;

	@Override
	public int savedata(Student stu) {

		return hd.savedata(stu);

	}

	@Override
	public int loginCheck(String un, String pass) {

		return hd.loginCheck(un, pass);
	}

	@Override
	public List displayAllData() {

		return hd.displayAllData();
	}

	@Override
	public int deletedata(int sid) {

		return hd.deletedata(sid);
	}

	@Override
	public Student editpage(int sid) {

		return hd.editpage(sid);
	}

	@Override
	public int updatedata(Student s) {

		return hd.updatedata(s);
	}

}
