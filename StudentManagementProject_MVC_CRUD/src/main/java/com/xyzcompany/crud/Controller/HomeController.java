package com.xyzcompany.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyzcompany.crud.Model.Student;
import com.xyzcompany.crud.Service.HomeService;

@Controller
public class HomeController {

	@Autowired
	HomeService hs;

	@RequestMapping("/")
	public String OpeningHomePage() {
		return "Homepage";
	}

	@RequestMapping("/home")
	public String HomePage() {
		return "Homepage";
	}

	@RequestMapping("/login")
	public String LoginPage() {
		return "Login";
	}

	@RequestMapping("/register")
	public String NewStudentRegistration() {
		return "Register";
	}

	@RequestMapping("/reg")
	public String StudentRegistration(@ModelAttribute Student s) {
		hs.savedata(s);
		return "Login";
	}

	@RequestMapping("/Studentlogin")
	public String logincheck(@RequestParam("uname") String un, @RequestParam("password") String pass, ModelMap m) {

		int id = hs.loginCheck(un, pass);

		List list = hs.displayAllData();

		if (id > 0) 
		{
			m.addAttribute("data", list);
			return "Success";
		} 
		else 
		{
			return "Login";
		}
	}

	@RequestMapping("/delete")
	public String deletedata(@RequestParam("sid") int sid, ModelMap m) {
		int id = hs.deletedata(sid);
		List list = hs.displayAllData();

		if (id > 0) 
		{
			m.addAttribute("data", list);
			return "Success";
		} 
		else 
		{
			return "Login";
		}
	}

	@RequestMapping("/edit")
	public String editdata(@RequestParam("sid") int sid, ModelMap m) {
		Student s = hs.editpage(sid);
		m.addAttribute("data", s);
		return "Edit";
	}

	@RequestMapping("/update")
	public String updatedata(@ModelAttribute Student s, ModelMap m) {
		int id = hs.updatedata(s);
		List list = hs.displayAllData();
		System.out.println(s.getSid());
		if (id > 0) 
		{
			m.addAttribute("data", list);
			return "Success";
		} 
		else 
		{
			return "Edit";
		}
	}
}
