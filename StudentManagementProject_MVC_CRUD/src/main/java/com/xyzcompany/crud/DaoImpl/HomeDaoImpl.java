package com.xyzcompany.crud.DaoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xyzcompany.crud.Dao.HomeDao;
import com.xyzcompany.crud.Model.Student;

@Repository
public class HomeDaoImpl implements HomeDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public int savedata(Student stu) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		int s = (int) session.save(stu);
		tx.commit();
		session.close();
		return s;
	}

	@Override
	public int loginCheck(String un, String pass) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Student where uname='" + un + "' and password='" + pass + "'");
		Student st = (Student) query.getSingleResult();
		int id = 1;
		tx.commit();
		session.close();
		return id;
	}

	@Override
	public List displayAllData() {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Student.class);
		List al = cr.list();
		tx.commit();
		session.close();
		return al;
	}

	@Override
	public int deletedata(int sid) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Student where sid='" + sid + "'");
		int id = query.executeUpdate();
		tx.commit();
		session.close();
		return id;
	}

	@Override
	public Student editpage(int sid) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Student st = session.get(Student.class, sid);
		tx.commit();
		session.close();
		return st;
	}

	@Override
	public int updatedata(Student s) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("update Student set name='" + s.getName() + "',uname='" + s.getUname()
				+ "',password='" + s.getPassword() + "',mobile='" + s.getMobile() + "' where sid='" + s.getSid() + "'");
//		String hql="update Student set name=?,uname=?,password=?,mobile=? where sid=?";
//		Query query=session.createQuery(hql);
//		query.setParameter(0, s.getName());
//		query.setParameter(1, s.getUname());
//		query.setParameter(2, s.getPassword());
//		query.setParameter(3, s.getMobile());
//		query.setParameter(4, s.getSid());
		int id = query.executeUpdate();
		tx.commit();
		session.close();
		return id;
	}

}
