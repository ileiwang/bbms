package cc.ileiwang.bbms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.bbms.domain.*;
import cc.ileiwang.bbms.service.BBMSService;
import cc.ileiwang.bbms.util.common.BBMSConstants;

/**
 * @author Lei Wang
 * @email ileiwang@live.com
 * @blog www.ileiwang.cc
 * @version 2018��5��21�� ����9:07:23
 */
@Controller
public class RemarkController {
	// �Զ�ע��Service
	@Autowired
	@Qualifier("Service")
	private BBMSService Service;
	
	//��ʾ��������
	@RequestMapping(value = "/showremarks")
	public ModelAndView showremarks(ModelAndView mv) {
		List<Remark> remarks = Service.findAllRemark();
		mv.addObject("remarks", remarks);
		List<Category> categorys = Service.findAllCategory();
		mv.addObject("categorys", categorys);
		mv.setViewName("/remark/remarks");
		return mv;
	}

	//��ʾ������ϸ
	@RequestMapping(value = "/showremarkdetail")
	public ModelAndView showremarkdetail(ModelAndView mv, int id) {
		Remark remark = Service.selectRemarkById(id);
		mv.addObject("remark", remark);
		mv.setViewName("/remark/remarkdetail");
		return mv;
	}
	
	//��ʾĳ��ȫ������
	@RequestMapping(value = "/showremarklist")
	public ModelAndView showremarklist(ModelAndView mv,int book_id) {
		List<Remark> remarks = Service.findRemarksByBookId(book_id);
		mv.addObject("remarks", remarks);
		mv.setViewName("/remark/remarks");
		return mv;
	}
	
	//��ʾ�ҵ�����
	@RequestMapping(value = "/showmyremarklist")
	public ModelAndView showmyremarklist(ModelAndView mv,HttpSession session) {
		Student student = (Student)session.getAttribute(BBMSConstants.STUDENT_SESSION);
		List<Remark> remarks = Service.findRemarksByStudentId(student.getId());
		mv.addObject("remarks", remarks);
		mv.setViewName("remark/myremarklist");
		return mv;
	}
	
	//�������
	@RequestMapping(value = "/addremark")
	public ModelAndView addremark(ModelAndView mv,int student_id,int book_id,String title,String content) {
		Student student = new Student();
		student.setId(student_id);
		Book book = new Book();
		book.setId(book_id);
		Remark remark = new Remark();
		remark.setStudent(student);
		remark.setBook(book);
		remark.setTitle(title);
		remark.setContent(content);
		Service.addRemark(remark);
		mv.setViewName("redirect:/showbookdetail?id="+book_id);
		return mv;
	}
	
	//ɾ������
	@RequestMapping(value = "/deleteremark")
	public ModelAndView deleteremark(ModelAndView mv,int id,String type) {
		
		Service.deleteRemarkById(id);
		if(type.equals("admin"))
		{
			mv.setViewName("redirect:/showremarks");
		}
		else
			mv.setViewName("redirect:/showmyremarklist");
		return mv;
	}
	
	//�޸�����
	@RequestMapping(value = "/modifyremark")
	public ModelAndView modifyremark(String flag,ModelAndView mv,int id,String title,String content) {
		Remark remark = Service.selectRemarkById(id);
		if(flag.equals("1")){
			mv.addObject("remark", remark);
			mv.setViewName("remark/modifyremark");
		}
		else
		{
			remark.setTitle(title);
			remark.setContent(content);
			Service.modifyRemark(remark);
			mv.setViewName("redirect:/showremarkdetail?id="+id);
		}
		return mv;
	}
	
	//��ʾ�������ҳ
	@RequestMapping(value = "/showaddremark")
	public ModelAndView showaddremark(ModelAndView mv,int book_id) {
		Book book = Service.selectBookById(book_id);
		mv.addObject("book",book);
		mv.setViewName("remark/addremark");
		return mv;
	}
}
