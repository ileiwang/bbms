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
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.bbms.domain.Admin;
import cc.ileiwang.bbms.service.BBMSService;
import cc.ileiwang.bbms.util.common.BBMSConstants;
import cc.ileiwang.bbms.util.tag.PageModel;

/**
 * @author Lei Wang
 * @email ileiwang@live.com
 * @blog www.ileiwang.cc
 * @version 2018年5月8日 下午5:26:33
 */
@Controller
public class AdminController {

	// 自动注入Service
	@Autowired
	@Qualifier("Service")
	private BBMSService Service;

	// 书籍管理
	@RequestMapping(value = "/bookmgmt")
	public ModelAndView bookmgmt(ModelAndView mv) {
		mv.setViewName("admin/bookmgmt");
		return mv;
	}

	// 评论管理
	@RequestMapping(value = "/remarkmgmt")
	public ModelAndView remarkmgmt(ModelAndView mv) {
		mv.setViewName("admin/remarkmgmt");
		return mv;
	}

	// 分类管理
	@RequestMapping(value = "/categorymgmt")
	public ModelAndView categorymgmt(ModelAndView mv) {
		mv.setViewName("admin/categorymgmt");
		return mv;
	}

	// 借阅管理
	@RequestMapping(value = "/borrowmgmt")
	public ModelAndView borrowmgmt(ModelAndView mv) {
		mv.setViewName("admin/borrowmgmt");
		return mv;
	}

	// 用户管理
	@RequestMapping(value = "/usermgmt")
	public ModelAndView usermgmt(ModelAndView mv) {
		mv.setViewName("admin/usermgmt");
		return mv;
	}

	// 学生管理
	@RequestMapping(value = "/studentmgmt")
	public ModelAndView studentmgmt(ModelAndView mv) {
		mv.setViewName("admin/studentmgmt");
		return mv;
	}

	// 管理员管理
	@RequestMapping(value = "/adminmgmt")
	public ModelAndView adminmgmt(ModelAndView mv) {
		mv.setViewName("admin/adminmgmt");
		return mv;
	}
	
	//查看所有管理员
	@RequestMapping(value = "/showalladmin")
	public ModelAndView showalladmin(ModelAndView mv,HttpSession session) {
		List<Admin> admins = Service.findAllAdmin();
		if(session.getAttribute("admin")!=null)
		{
			mv.addObject("admins", admins);
			mv.setViewName("admin/alladmin");
		}
		else
		{
			mv.setViewName("redirect:/main");
		}
		
		return mv;
	}
	
	// 删除管理员
	@RequestMapping(value = "/deleteadmin")
	public ModelAndView deleteadmin(ModelAndView mv,int id,HttpSession session) {
		
		if(session.getAttribute("admin")!=null)
		{
			Service.deleteAdminById(id);
			mv.setViewName("redirect:/showalladmin");
		}
		else
		{
			mv.setViewName("redirect:/main");
		}

		return mv;
	}
	
	@RequestMapping(value = "/showaddadmin")
	public ModelAndView showaddadmin(ModelAndView mv,HttpSession session) {
		if(session.getAttribute("admin")!=null)
		{
			mv.setViewName("admin/addadmin");
		}
		else
		{
			mv.setViewName("redirect:/main");
		}
		
		return mv;
	}
	
	
	// 注册
	@RequestMapping(value = "/addadmin")
	public ModelAndView addadmin(@ModelAttribute Admin admin, ModelAndView mv, @Param("password1")String password1,@Param("password2")String password2,HttpSession session) {

			if(password1.equals(password2))
			{
				admin.setPassword(password1);
				System.out.println(admin.getName());
				System.out.println(admin.getTel());
				System.out.println(admin.getNum());
				System.out.println(admin.getEmail());
				System.out.println(admin.getPassword());
				Service.addAdmin(admin);
				session.setAttribute(BBMSConstants.ADMIN_SESSION, admin);
				mv.setViewName("/loginForm");
			}
			else
			{
				mv.setViewName("redirect:/showaddadmin");
			}
		return mv;
	}
	
	
	
	
	
	
	// 选择管理员
	@RequestMapping(value = "/admin/selectAdmin")
	public String selectAdmin(Integer pageIndex, @ModelAttribute Admin admin, Model model) {
		PageModel pageModel = new PageModel();
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		List<Admin> admins = Service.findAdmin(admin, pageModel);
		model.addAttribute("admins", admins);
		return "admin/admin";
	}
	// 添加管理员
	@RequestMapping(value = "/admin/addAdmin")
	public ModelAndView addAdmin(String flag, @ModelAttribute Admin admin, ModelAndView mv) {
		if (flag.equals("1")) {
			mv.setViewName("admin/addAdmin");
		} else {
			Service.addAdmin(admin);
			mv.setViewName("redirect:main");
		}
		return mv;
	}
	
	// 更新管理员
	@RequestMapping(value = "/admin/updateAdmin")
	public ModelAndView updateAdmin(String flag, @ModelAttribute Admin admin, ModelAndView mv) {
		if (flag.equals("1")) {
			Admin target = Service.selectAdminById(admin.getId());
			mv.addObject("admin", target);
			mv.setViewName("admin/showUpdateAdmin");
		} else {
			Service.modifyAdmin(admin);
			mv.setViewName("redirect:/admin/selectAdmin");
		}
		return mv;
	}
}
