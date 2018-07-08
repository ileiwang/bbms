package cc.ileiwang.bbms.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.bbms.domain.Book;
import cc.ileiwang.bbms.domain.Remark;
import cc.ileiwang.bbms.domain.Student;
import cc.ileiwang.bbms.service.BBMSService;

/**
 * @author Lei Wang
 * @email ileiwang@live.com
 * @blog www.ileiwang.cc
 * @version 2018��5��21�� ����9:08:03
 */
@Controller
public class BorrowController {
	// �Զ�ע��Service
	@Autowired
	@Qualifier("Service")
	private BBMSService Service;

	// ����ͼ��
	@RequestMapping(value = "/borrow")
	public ModelAndView borrow(ModelAndView mv, @Param("student_id") int student_id, @Param("book_id") int book_id) {
		Service.borrowBook(student_id, book_id);
		mv.setViewName("redirect:/showusercenter");
		return mv;
	}

	// �黹ͼ��
	@RequestMapping(value = "/back")
	public ModelAndView back(ModelAndView mv, @Param("student_id") int student_id, @Param("book_id") int book_id,
			@Param("title") String title, @Param("content") String content) {

		Service.backBook(student_id, book_id);
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
		mv.setViewName("redirect:/showusercenter");
		return mv;
	}

	// ��ʾ������Ϣ
	@RequestMapping(value = "/showborrowdetail")
	public ModelAndView showborrowdetail(ModelAndView mv) {
		mv.setViewName("borrow/borrowdetail");
		return mv;
	}

	// ��ʾͼ�������Ϣ
	@RequestMapping(value = "/showbookborrowdetail")
	public ModelAndView showbookborrowdetail(ModelAndView mv, @Param("name") String name,
			@Param("author") String author) {
		Book book = Service.selectBookByName(name);
		int id = book.getId();
		// һ��ͼ�����н�����
		List<Student> students = Service.selectStudentsByBookId(id);
		// һ��ͼ�鵱ǰ������
		Student student = Service.selectStudentByBookId(id);
		mv.addObject("students", students);
		mv.addObject("student", student);
		mv.addObject("book", book);
		mv.setViewName("borrow/bookborrowdetail");
		return mv;
	}

	// ��ʾѧ��������Ϣ
	@RequestMapping(value = "/showstudentborrowdetail")
	public ModelAndView showstudentborrowdetail(ModelAndView mv, @Param("name") String name, @Param("num") String num) {
		Student student = Service.selectStudentByNum(num);
		int id = student.getId();
		// һ��ѧ���Ѿ��黹��ͼ��
		List<Book> abooks = Service.selectAlreadyBorrowedByStudentId(id);
		// һ��ѧ����ǰ���ĵ�ͼ��
		List<Book> cbooks = Service.selectCurrentBorrowedByStudentId(id);
		mv.addObject("abooks", abooks);
		mv.addObject("cbooks", cbooks);
		mv.addObject("student", student);
		mv.setViewName("borrow/studentborrowdetail");
		return mv;
	}
}
