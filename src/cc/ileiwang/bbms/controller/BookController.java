package cc.ileiwang.bbms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.bbms.domain.*;
import cc.ileiwang.bbms.service.BBMSService;
import cc.ileiwang.bbms.util.common.BBMSConstants;
import cc.ileiwang.bbms.util.tag.PageModel;

import java.io.File;
import java.io.IOException;

//import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Lei Wang
 * @email ileiwang@live.com
 * @blog www.ileiwang.cc
 * @version 2018��5��21�� ����9:07:04
 */
@Controller
public class BookController {
	// �Զ�ע��Service
	@Autowired
	@Qualifier("Service")
	private BBMSService Service;

	// ��ʾ����ͼ��
	@RequestMapping(value = "/showbooks")
	public ModelAndView showbooks(ModelAndView mv) {
		List<Book> books = Service.findAllBook();
		mv.addObject("books", books);
		List<Category> categorys = Service.findAllCategory();
		mv.addObject("categorys", categorys);
		mv.setViewName("book/books");
		return mv;
	}

	// ��ʾ�ҵ����
	@RequestMapping(value = "/showmybooklist")
	public ModelAndView showmybooklist(ModelAndView mv, HttpSession session) {
		Student student = (Student) session.getAttribute(BBMSConstants.STUDENT_SESSION);
		List<Book> books = Service.selectCurrentBorrowedByStudentId(student.getId());
		mv.addObject("books", books);
		List<Book> backbooks = Service.selectAlreadyBorrowedByStudentId(student.getId());
		mv.addObject("backbooks", backbooks);
		mv.setViewName("book/mybooklist");
		return mv;
	}

	// ɾ��ͼ��
	@RequestMapping(value = "/deletebook")
	public ModelAndView deletebook(ModelAndView mv, int id) {
		Service.deleteBookById(id);
		mv.setViewName("redirect:/showbooks");
		return mv;
	}

	// ���ͼ��
	@RequestMapping(value = "/addbook")
	public ModelAndView addbook(HttpServletRequest request, ModelAndView mv, @ModelAttribute Book book,
			Integer category_id, @RequestParam("coverfile") MultipartFile coverfile)
			throws IllegalStateException, IOException {
		this.genericAssociation(category_id, book);
		if (!coverfile.isEmpty()) {
			// �ϴ��ļ�·��
			String path = request.getServletContext().getRealPath("/images/");
			System.out.println(path);
			// �ϴ��ļ���
			String filename = coverfile.getOriginalFilename();
			book.setCoverfilename(filename);
			File filepath = new File(path, filename);
			// �ж�·���Ƿ���ڣ���������ھʹ���һ��
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// ���ϴ��ļ����浽һ��Ŀ���ļ�����
			coverfile.transferTo(new File(path + File.separator + filename));
			Service.addBook(book);
			mv.setViewName("redirect:/showbooks");
		}
		return mv;
	}

	// ��ʾ���ͼ��ҳ��
	@RequestMapping(value = "/showaddbook")
	public ModelAndView showaddbook(ModelAndView mv) {
		List<Category> categorys = Service.findAllCategory();
		mv.addObject("categorys", categorys);
		mv.setViewName("/book/addbook");
		return mv;
	}

	// ��ʾ���ͼ������ҳ��
	@RequestMapping(value = "/showwishbook")
	public ModelAndView showwishbook(ModelAndView mv) {
		mv.setViewName("/book/wishbook");
		return mv;
	}

	// ��ʾ����ͼ������
	@RequestMapping(value = "/showallwishbook")
	public ModelAndView showallwishbook(ModelAndView mv) {
		List<Student> students = Service.selectStudentsFromWishbook();
		mv.addObject("students", students);
		mv.setViewName("/book/allwishbook");
		return mv;
	}

	// ����ͼ������
	@RequestMapping(value = "/wishbook")
	public ModelAndView wishbook(ModelAndView mv, @Param("student_id") int student_id, @Param("name") String name,
			@Param("author") String author) {
		Service.savewishbook(name, author, student_id);
		mv.setViewName("redirect:/showbooks");
		return mv;
	}

	// ��ʾͼ������
	@RequestMapping(value = "/showbookdetail")
	public ModelAndView showbookdetail(ModelAndView mv, int id) {
		Book book = Service.selectBookById(id);
		mv.addObject("book", book);
		int isback = Service.isback(id);
		mv.addObject("isback", isback);
		mv.setViewName("/book/bookdetail");
		return mv;
	}

	// ��������ʾͼ��
	@RequestMapping(value = "/showbooksbycategoryid")
	public ModelAndView showbooksbycategoryid(ModelAndView mv, int category_id) {
		List<Book> books = Service.selectBookByCategoryId(category_id);
		Category category = Service.selectCategoryById(category_id);
		mv.addObject("books", books);
		mv.addObject("category", category);
		mv.setViewName("book/booksbycategoryid");
		return mv;
	}

	// ����
	// @RequestMapping(value = "/searchbook")
	// public String searchbook(Integer pageIndex, @ModelAttribute Book book, Model
	// model) {
	// PageModel pageModel = new PageModel();
	// if (pageIndex != null) {
	// pageModel.setPageIndex(pageIndex);
	// }
	// List<Book> books = Service.findBook(book, pageModel);
	// model.addAttribute("books", books);
	// model.addAttribute("pageModel", pageModel);
	// return "book/books";
	// }

	//����ͼ��
	@RequestMapping(value = "/searchbook")
	public ModelAndView searchbook(String name, ModelAndView mv) {
		Book book = Service.selectBookByName(name);
		
		int isback = 0;
		if(book!=null)
		{
			System.out.println("BOOK NOT NULL");
			isback = Service.isback(book.getId());
		}
		else
		{
			System.out.println("BOOK NULL");
		}
		//�ж��Ƿ��Ѿ��黹
		
		mv.addObject("isback", isback);
		mv.addObject("book", book);
		
		mv.setViewName("/book/bookdetail");
		return mv;
	}

	// ��ʾ�߼�����ҳ��
	@RequestMapping(value = "/advancedsearch")
	public String advancedsearch(Model model) {
		return "book/advancedsearch";
	}

	// �߼�����
	@RequestMapping(value = "/advancedsearchbook")
	public ModelAndView advancedsearchbook(ModelAndView mv, @Param("name") String name, @Param("author") String author,
			@Param("isbn") String isbn, @Param("publisher") String publisher, @Param("year") int year) {
		Book book = new Book();
		if (author != null) {
			book.setAuthor(author);
		}
		if (name != null) {
			book.setName(name);
		}
		if (year != 0) {
			book.setYear(year);
		}
		if (isbn != null) {
			book.setIsbn(isbn);
		}
		if (publisher != null) {
			book.setPublisher(publisher);
		}

		System.out.println("********" + book.getName() + "*******");
		PageModel pageModel = new PageModel();
		List<Book> books = Service.findBook(book, pageModel);
		mv.addObject("books", books);
		mv.setViewName("book/books");
		return mv;
	}

	// ������Ϣ
	private void genericAssociation(Integer category_id, Book book) {
		if (category_id != null) {
			Category category = new Category();
			category.setId(category_id);
			book.setCategory(category);
		}
	}

	// ��ʾ�޸�ҳ��

	@RequestMapping(value = "/showmodifybook")
	public ModelAndView showmodifybook(ModelAndView mv, int id) {
		Book book = Service.selectBookById(id);
		List<Category> categorys = Service.findAllCategory();
		mv.addObject("categorys", categorys);
		mv.addObject("book", book);
		mv.setViewName("book/modifybook");
		return mv;
	}

	// �޸�
	@RequestMapping(value = "/modifybook")
	public ModelAndView modifybook(ModelAndView mv, @ModelAttribute Book book, int category_id) {
		this.genericAssociation(category_id, book);
		Service.modifyBook(book);
		mv.setViewName("redirect:/showbooks");
		return mv;
	}

	// �޸�
	@RequestMapping(value = "/showwishbookname")
	public ModelAndView showwishbookname(ModelAndView mv, int id) {
		List<String> booknames = Service.selectBookNameByStudentId(id);
		mv.addObject("booknames", booknames);
		mv.setViewName("book/wishbookname");
		return mv;
	}
}
