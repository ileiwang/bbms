package cc.ileiwang.bbms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cc.ileiwang.bbms.dao.*;
import cc.ileiwang.bbms.domain.*;
import cc.ileiwang.bbms.service.BBMSService;
import cc.ileiwang.bbms.util.tag.PageModel;

/**
 * @author Lei Wang
 * @email ileiwang@live.com
 * @blog www.ileiwang.cc
 * @version 2018年5月8日 下午5:31:03
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("Service")
public class BBMSServiceImpl implements BBMSService {

	@Autowired
	private AdminDAO adminDao;

	@Autowired
	private BookDAO bookDao;

	@Autowired
	private CategoryDAO categoryDao;

	@Autowired
	private RemarkDAO remarkDao;

	@Autowired
	private StudentDAO studentDao;

	// Admin操作
	// 批查找
	@Transactional(readOnly = true)
	@Override
	public List<Admin> findAdmin(Admin admin, PageModel pageModel) {

		Map<String, Object> params = new HashMap<>();
		params.put("admin", admin);
		int recordCount = adminDao.count(params);
		pageModel.setRecordCount(recordCount);
		if (recordCount > 0) {
			params.put("pageModel", pageModel);
		}
		List<Admin> admins = adminDao.selectByPage(params);
		return admins;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Admin> findAllAdmin() {
		return adminDao.selectAll();
	}

	// 单查找
	@Transactional(readOnly = true)
	@Override
	public Admin selectAdminById(int id) {
		return adminDao.selectById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Admin selectAdminByNum(String num) {
		return adminDao.selectByNum(num);
	}

	@Transactional(readOnly = true)
	@Override
	public Admin selectAdminByName(String name) {
		return adminDao.selectByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public Admin selectAdminByNumAndPassword(String num, String password) {
		return adminDao.selectByNumAndPassword(num, password);
	}

	// 添加
	@Override
	public void addAdmin(Admin admin) {
		adminDao.save(admin);
	}

	// 修改
	@Override
	public void modifyAdmin(Admin admin) {
		adminDao.update(admin);
	}

	// 删除
	@Override
	public void deleteAdminById(int id) {
		adminDao.deleteById(id);
	}

	@Override
	public void deleteAdminByNum(String num) {
		adminDao.deleteByNum(num);
	}

	@Override
	public void deleteAdminByName(String name) {
		adminDao.deleteByName(name);
	}

	// Student操作
	// 批查找
	@Transactional(readOnly = true)
	@Override
	public List<Student> findStudent(Student student, PageModel pageModel) {
		Map<String, Object> params = new HashMap<>();
		params.put("student", student);
		int recordCount = studentDao.count(params);
		pageModel.setRecordCount(recordCount);
		if (recordCount > 0) {
			params.put("pageModel", pageModel);
		}
		List<Student> students = studentDao.selectByPage(params);
		return students;

	}

	@Transactional(readOnly = true)
	@Override
	public List<Student> findAllStudent() {
		return studentDao.selectAllStudent();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Student> selectStudentsByBookId(int book_id) {
		return studentDao.selectStudentsByBookId(book_id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Student> selectStudentsFromWishbook()
	{
		return studentDao.selectStudentsFromWishbook();
	}

	@Transactional(readOnly = true)
	@Override
	public Student selectStudentByBookId(int book_id) {
		return studentDao.selectStudentByBookId(book_id);
	}

	// 单查找
	@Transactional(readOnly = true)
	@Override
	public Student selectStudentById(int id) {
		return studentDao.selectById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Student selectStudentByNum(String num) {
		return studentDao.selectByNum(num);
	}

	@Transactional(readOnly = true)
	@Override
	public Student selectStudentByName(String name) {
		return studentDao.selectByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public Student selectStudentByNumAndPassword(String num, String password) {
		return studentDao.selectByNumAndPassword(num, password);
	}

	// 添加
	@Override
	public void addStudent(Student student) {
		studentDao.save(student);
	}

	// 修改
	@Override
	public void modifyStudent(Student student) {
		studentDao.update(student);
	}

	// 删除
	@Override
	public void deleteStudentById(int id) {
		studentDao.deleteById(id);
	}

	@Override
	public void deleteStudentByNum(String num) {
		studentDao.deleteByNum(num);
	}

	public void changepasswd(int student_id, String password) {
		studentDao.changepasswd(student_id, password);
	}

	public String findpasswd(String num, String name) {
		return studentDao.findpasswd(num, name);
	}

	// 批查找
	public List<Book> findBook(Book book, PageModel pageModel) {
		Map<String, Object> params = new HashMap<>();
		params.put("book", book);
		int recordCount = bookDao.count(params);
		pageModel.setRecordCount(recordCount);
		if (recordCount > 0) {
			params.put("pageModel", pageModel);
		}
		List<Book> books = bookDao.selectByPage(params);
		return books;
	}

	public List<Book> findAllBook() {
		return bookDao.selectAll();
	}

	public List<Book> selectAlreadyBorrowedByStudentId(int student_id) {
		return bookDao.selectAlreadyBorrowedByStudentId(student_id);
	}

	public List<Book> selectCurrentBorrowedByStudentId(int student_id) {
		return bookDao.selectCurrentBorrowedByStudentId(student_id);
	}

	public List<Book> selectBookByCategoryId(int category_id) {
		return bookDao.selectByCategoryId(category_id);
	}

	// 单查找
	public Book selectBookById(int id) {
		return bookDao.selectById(id);
	}

	public Book selectBookByIsbn(String isbn) {
		return bookDao.selectByIsbn(isbn);
	}

	public Book selectBookByName(String name) {
		return bookDao.selectByName(name);
	}

	// 添加
	public void addBook(Book book) {
		bookDao.save(book);
	}

	// 修改
	public void modifyBook(Book book) {
		System.out.println(book.getName());
		bookDao.update(book);
	}

	// 删除
	public void deleteBookById(int id) {
		bookDao.deleteborrowrecord(id);// 删除借阅记录
		remarkDao.deleteByBookId(id);// 删除评论记录
		bookDao.deleteById(id);// 删除图书
	}

	public void deleteBookByName(String name) {
		bookDao.deleteByName(name);
	}

	public void deleteBookByIsbn(String isbn) {
		bookDao.deleteByIsbn(isbn);
	}

	// 借书操作
	public void borrowBook(int student_id, int book_id) {
		bookDao.borrow(student_id, book_id);
	}

	// 归还操作
	public void backBook(int student_id, int book_id) {
		bookDao.back(student_id, book_id);
	}

	// 是否已被借阅
	public int isborrow(int book_id) {
		Book book = bookDao.isborrow(book_id);
		if (book != null) {
			return 1;
		} else
			return 0;
	}

	// 是否已被归还
	public int isback(int book_id) {
		System.out.print(book_id);
		Book book = bookDao.isback(book_id);
		if (book == null) {
			return 1;
		} else
			return 0;
	}

	public void savewishbook(String name, String author, int student_id) {
		bookDao.savewishbook(name, author, student_id);
	}
	
	
	public List<String> selectBookNameByStudentId(int id)
	{
		return bookDao.selectBookNameByStudentId(id);
	}

	// 批查找
	public List<Category> findCategory(Category category, PageModel pageModel) {
		Map<String, Object> params = new HashMap<>();
		params.put("category", category);
		int recordCount = categoryDao.count(params);
		pageModel.setRecordCount(recordCount);
		if (recordCount > 0) {
			params.put("pageModel", pageModel);
		}
		List<Category> categorys = categoryDao.selectByPage(params);
		return categorys;
	}

	public List<Category> findAllCategory() {
		return categoryDao.selectAll();
	}

	// 单查找
	public Category selectCategoryById(int id) {
		return categoryDao.selectById(id);
	}

	public Category selectCategoryByName(String name) {
		return categoryDao.selectByName(name);
	}

	// 添加
	public void addCategory(Category category) {
		categoryDao.save(category);
	}

	// 修改
	public void modifyCategory(Category category) {
		categoryDao.update(category);
	}

	// 删除
	public void deleteCategoryById(int id) {
		categoryDao.deleteById(id);
	}

	public void deleteCategoryByName(String name) {
		categoryDao.deleteByName(name);
	}

	// 批查找
	public List<Remark> findRemark(Remark remark, PageModel pageModel) {
		Map<String, Object> params = new HashMap<>();
		params.put("remark", remark);
		int recordCount = remarkDao.count(params);
		pageModel.setRecordCount(recordCount);
		if (recordCount > 0) {
			params.put("pageModel", pageModel);
		}
		List<Remark> remarks = remarkDao.selectByPage(params);
		return remarks;
	}

	public List<Remark> findAllRemark() {
		return remarkDao.selectAll();
	}

	public List<Remark> findRemarksByBookId(int book_id) {
		return remarkDao.selectByBookId(book_id);
	}

	public List<Remark> findRemarksByStudentId(int student_id) {
		return remarkDao.selectByStudentId(student_id);
	}

	// 单查找
	public Remark selectRemarkById(int id) {
		return remarkDao.selectById(id);
	}

	// 添加
	public void addRemark(Remark remark) {
		remarkDao.save(remark);
	}

	// 修改
	public void modifyRemark(Remark remark) {
		remarkDao.update(remark);
	}

	// 删除
	public void deleteRemarkById(int id) {
		remarkDao.deleteById(id);
	}

	public void deleteRemarkByBookId(int book_id) {
		remarkDao.deleteByBookId(book_id);
	}

	public void deleteRemarkByStudentId(int student_id) {
		remarkDao.deleteByStudentId(student_id);
	}

	// Login操作
	@Transactional(readOnly = true)
	@Override
	public Student studentlogin(String num, String password) {
		return studentDao.selectByNumAndPassword(num, password);
	}

	@Transactional(readOnly = true)
	@Override
	public Admin adminlogin(String num, String password) {
		return adminDao.selectByNumAndPassword(num, password);
	}

}
