package cc.ileiwang.bbms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.bbms.domain.Admin;
import cc.ileiwang.bbms.domain.Book;
import cc.ileiwang.bbms.domain.Category;
import cc.ileiwang.bbms.domain.Remark;
import cc.ileiwang.bbms.domain.Student;
import cc.ileiwang.bbms.service.BBMSService;
import cc.ileiwang.bbms.util.common.BBMSConstants;
import cc.ileiwang.bbms.util.tag.PageModel;

/**
 * @author Lei Wang
 * @email ileiwang@live.com
 * @blog www.ileiwang.cc
 * @version 2018年5月8日 下午5:50:08
 */
@Controller
public class StudentController {
	// 自动注入Service
	@Autowired
	@Qualifier("Service")
	private BBMSService Service;

	// 登陆
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam("num") String num, @RequestParam("password") String password,
			@RequestParam("type") String type, @RequestParam("myresult") String myresult,
			@RequestParam("result") String result, HttpSession session, ModelAndView mv) {

		// 管理员
		if (type.equals("admin")) {
			Admin admin = Service.adminlogin(num, password);
			System.out.println(myresult);
			System.out.println(result);
			if (admin != null && (myresult.equals(result))) {
				session.setAttribute(BBMSConstants.ADMIN_SESSION, admin);
				session.setMaxInactiveInterval(60 * 60);
				List<Book> books = Service.findAllBook();
				session.setAttribute("books", books);
				List<Category> categorys = Service.findAllCategory();
				session.setAttribute("categorys", categorys);
				List<Remark> remarks = Service.findAllRemark();
				session.setAttribute("remarks", remarks);
				// mv.setViewName("/admin/admin");
				mv.setViewName("redirect:/main");
			} else {
				mv.addObject("message", "登录名或密码错误!请重新输入");
				mv.setViewName("forward:/loginForm");
			}
		}

		// 学生
		else {
			Student student = Service.studentlogin(num, password);
			System.out.println(result);
			System.out.println(myresult);
			if (student != null && (myresult.equals(result))) {
				session.setAttribute(BBMSConstants.STUDENT_SESSION, student);
				session.setMaxInactiveInterval(60 * 60);
				List<Book> books = Service.findAllBook();
				session.setAttribute("books", books);
				List<Category> categorys = Service.findAllCategory();
				session.setAttribute("categorys", categorys);
				List<Remark> remarks = Service.findAllRemark();
				session.setAttribute("remarks", remarks);
				mv.setViewName("redirect:/main");
			} else {
				mv.addObject("message", "账号密码不匹配,或验证码错误，请重新输入！");
				mv.setViewName("forward:/loginForm");
			}
		}
		return mv;
	}

	// 退出
	@RequestMapping(value = "/logoff")
	public ModelAndView logoff(HttpSession session, ModelAndView mv) {
		session.invalidate();
		mv.setViewName("redirect:/loginForm");
		return mv;
	}

	// 注册
	@RequestMapping(value = "/register")
	public ModelAndView register(String flag, @ModelAttribute Student student, ModelAndView mv, @Param("password1")String password1,@Param("password2")String password2,HttpSession session) {
		if (flag.equals("1")) {
			mv.setViewName("/register");
		} else {
			if(password1.equals(password2))
			{
				student.setPassword(password1);
				System.out.println(student.getName());
				System.out.println(student.getTel());
				System.out.println(student.getNum());
				System.out.println(student.getEmail());
				System.out.println(student.getPassword());
				Service.addStudent(student);
				session.setAttribute(BBMSConstants.STUDENT_SESSION, student);
				mv.setViewName("/loginForm");
			}
			else
			{
				mv.setViewName("/register?flag=1");
			}
		}
		return mv;
	}

	// 关于
	@RequestMapping(value = "/about")
	public String about() {
		return "about/about";
	}



	// 修改密码
	@RequestMapping(value = "/changepasswd")
	public ModelAndView changepasswd(String flag, @Param("oldpasswd")String oldpasswd, @Param("newpasswd1")String newpasswd1, @Param("newpasswd2")String newpasswd2,
			ModelAndView mv, HttpSession session) {
		if (flag.equals("1")) {
			mv.setViewName("student/changepasswd");
		} else {
			if (newpasswd1.equals(newpasswd2)) {
				Student student = (Student) session.getAttribute(BBMSConstants.STUDENT_SESSION);
				if (student.getPassword().equals(oldpasswd)) {
					Service.changepasswd(student.getId(), newpasswd1);
					session.invalidate();
					mv.setViewName("loginForm");
				}
			}

		}
		return mv;
	}

	// 忘记密码
	@RequestMapping(value = "/forgetpasswd")
	public ModelAndView forgetpasswd(ModelAndView mv) {
		mv.setViewName("forgetpasswd");
		return mv;
	}

	// 查找密码
	@RequestMapping(value = "/findpasswd")
	public ModelAndView findpasswd(@RequestParam("name") String name, @RequestParam("num") String num,
			ModelAndView mv) {
		String password = Service.findpasswd(num, name);
		if (password == null) {
			String error = "输入信息有误，请重新输入";
			mv.addObject("error", error);
		} else {
			mv.addObject("password", password);
		}
		mv.setViewName("passwd");
		return mv;
	}

	// 查看我的个人信息
	@RequestMapping(value = "/showmyprofile")
	public ModelAndView showmyprofile(ModelAndView mv) {
		mv.setViewName("student/myprofile");
		return mv;
	}

	// 查看其他用户的信息
	@RequestMapping(value = "/showprofile")
	public ModelAndView showprofile(int id, ModelAndView mv) {
		Student student = Service.selectStudentById(id);
		mv.addObject("student", student);
		mv.setViewName("student/profile");
		return mv;
	}

	// 查看用户中心
	@RequestMapping(value = "/showusercenter")
	public ModelAndView showusercenter(ModelAndView mv) {
		mv.setViewName("student/usercenter");
		return mv;
	}
	
	//查看所有学生
	@RequestMapping(value = "/showallstudent")
	public ModelAndView showalladmin(ModelAndView mv,HttpSession session) {
		List<Student> students = Service.findAllStudent();
		if(session.getAttribute("admin")!=null)
		{
			mv.addObject("students", students);
			mv.setViewName("student/allstudent");
		}
		else
		{
			mv.setViewName("redirect:/main");
		}
		
		return mv;
	}
	
	// 更新学生
	@RequestMapping(value = "updateprofile")
	public ModelAndView updateprofile(@ModelAttribute Student student, ModelAndView mv,HttpSession session) {
		Service.modifyStudent(student);
		session.invalidate();
		mv.setViewName("redirect:/loginForm");
		return mv;
	}
	
	// 删除学生
	@RequestMapping(value = "/deletestudent")
	public ModelAndView deletestudent(ModelAndView mv,int id,HttpSession session) {
		if(session.getAttribute("admin")!=null)
		{
			Service.deleteStudentById(id);
			mv.setViewName("redirect:/showallstudent");
		}
		else
		{
			mv.setViewName("redirect:/main");
		}

		return mv;
	}
	
	
	// 选择学生
	@RequestMapping(value = "/student/selectStudent")
	public String selectStudent(Integer pageIndex, @ModelAttribute Student student, Model model) {
		PageModel pageModel = new PageModel();
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		List<Student> students = Service.findStudent(student, pageModel);
		model.addAttribute("students", students);
		model.addAttribute("pageModel", pageModel);
		return "student/student";

	}

	// 添加学生
	@RequestMapping(value = "/addStudent")
	public ModelAndView addStudent(String flag,  Integer clazz_id, @ModelAttribute Student student,
			ModelAndView mv) {
		if (flag.equals("1")) {
			// List<Clazz> clazzs = Service.findAllClazz();
			// mv.addObject("clazzs", clazzs);
			mv.setViewName("student/showAddStudent");
		} else {
			// this.genericAssociation(clazz_id,student);
			Service.addStudent(student);
			mv.setViewName("redirect:/student/selectStudent");
		}
		return mv;
	}
}
