package cc.ileiwang.bbms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.bbms.domain.Category;
import cc.ileiwang.bbms.service.BBMSService;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018��5��21�� ����9:07:43
*/
@Controller
public class CategoryController {
	
	// �Զ�ע��Service
	@Autowired
	@Qualifier("Service")
	private BBMSService Service;
	
	//��ʾ���з���
	@RequestMapping(value = "/showcategorys")
	public ModelAndView showcategorys(ModelAndView mv) {
		List<Category> categorys = Service.findAllCategory();
		mv.addObject("categorys", categorys);
		mv.setViewName("category/categorys");
		return mv;
	}
	
	//��ʾ��ӷ���
	@RequestMapping(value = "/showaddcategory")
	public ModelAndView showaddcategory(ModelAndView mv) {
		List<Category> categorys = Service.findAllCategory();
		mv.addObject("categorys", categorys);
		mv.setViewName("category/addcategory");
		return mv;
	}
	
	//��ӷ���
	@RequestMapping(value = "/addcategory")
	public ModelAndView addcategory(ModelAndView mv,@ModelAttribute Category category) {
		Service.addCategory(category);
		mv.setViewName("redirect:/showcategorys");
		return mv;
	}
	
	//��ʾ�޸ķ���
	@RequestMapping(value = "/showmodifycategory")
	public ModelAndView showmodifycategory(ModelAndView mv,int id) {
		Category category = Service.selectCategoryById(id);
		mv.addObject("category", category);
		mv.setViewName("category/modifycategory");
		return mv;
	}
	
	//�޸ķ���
	@RequestMapping(value = "/modifycategory")
	public ModelAndView modifycategory(ModelAndView mv,@ModelAttribute Category category) {
		System.out.println(category.getName()+"----"+category.getSummary());
		Service.modifyCategory(category);
		mv.setViewName("redirect:/showcategorys");
		return mv;
	}
	
	//ɾ������
	@RequestMapping(value = "/deletecategory")
	public ModelAndView deletecategory(ModelAndView mv,int id) {
		Service.deleteCategoryById(id);
		mv.setViewName("redirect:/showcategorys");
		return mv;
	}

}
