package cc.ileiwang.bbms.service;
import java.util.List;


import cc.ileiwang.bbms.domain.*;
import cc.ileiwang.bbms.util.tag.PageModel;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月8日 下午5:28:36
*/
public interface BBMSService {
	//Admin
	
	
	//批查找
	public List<Admin> findAdmin(Admin admin,PageModel pageModel);
	public List<Admin> findAllAdmin();
	//单查找
	public Admin selectAdminById(int id);
	public Admin selectAdminByNum(String num);
	public Admin selectAdminByName(String name);
	public Admin selectAdminByNumAndPassword(String num,String password);
	//添加
	public void addAdmin(Admin admin);
	//修改
	public void modifyAdmin(Admin admin);
	//删除
	public void deleteAdminById(int id);
	public void deleteAdminByNum(String num);
	public void deleteAdminByName(String name);
	
	
	
	//Student
	
	
	//批查找
	public List<Student> findStudent(Student student,PageModel pageModel);
	public List<Student> findAllStudent();
	public List<Student> selectStudentsByBookId(int book_id);
	public List<Student> selectStudentsFromWishbook();
	
	//单查找
	public Student selectStudentById(int id);
	public Student selectStudentByNum(String num);
	public Student selectStudentByName(String name);
	public Student selectStudentByNumAndPassword(String num,String password);
	public Student selectStudentByBookId(int book_id);
	//添加
	public void addStudent(Student student);
	//修改
	public void modifyStudent(Student student);
	//删除
	public void deleteStudentById(int id);
	public void deleteStudentByNum(String num);
	
	//修改密码
	public void changepasswd(int student_id,String password);
	
	public String findpasswd(String num,String name);
	
	
	//Book
	
	//批查找
	public List<Book> findBook(Book book,PageModel pageModel);
	public List<Book> findAllBook();
	public List<Book> selectAlreadyBorrowedByStudentId(int student_id);
	public List<Book> selectCurrentBorrowedByStudentId(int student_id);
	public List<Book> selectBookByCategoryId(int category_id);
	
	//单查找
	public Book selectBookById(int id);
	public Book selectBookByIsbn(String isbn);
	public Book selectBookByName(String name);
	//添加
	public void addBook(Book book);
	//修改
	public void modifyBook(Book book);
	//删除
	public void deleteBookById(int id);
	public void deleteBookByName(String name);
	public void deleteBookByIsbn(String isbn);
	
	//借书操作
	public void borrowBook(int student_id,int book_id);
	//归还操作
	public void backBook(int student_id,int book_id);
	
	//是否已被借阅
	public int isborrow(int book_id);
	//是否已被归还
	public int isback(int book_id);
	
	public List<String> selectBookNameByStudentId(int id);
	
	//
	public void savewishbook(String name,String author,int student_id);
	
	
	
	
	//批查找
	public List<Category> findCategory(Category category,PageModel pageModel);
	public List<Category> findAllCategory();
	//单查找
	public Category selectCategoryById(int id);
	public Category selectCategoryByName(String name);

	//添加
	public void addCategory(Category category);
	//修改
	public void modifyCategory(Category category);
	//删除
	public void deleteCategoryById(int id);
	public void deleteCategoryByName(String name);
	
	
	//批查找
	public List<Remark> findRemark(Remark remark,PageModel pageModel);
	public List<Remark> findAllRemark();
	public List<Remark> findRemarksByBookId(int book_id);
	public List<Remark> findRemarksByStudentId(int student_id);
	//单查找
	public Remark selectRemarkById(int id);

	//添加
	public void addRemark(Remark remark);
	//修改
	public void modifyRemark(Remark remark);
	//删除
	public void deleteRemarkById(int id);
	public void deleteRemarkByBookId(int book_id);
	public void deleteRemarkByStudentId(int student_id);
	
	
	
	
	//Login操作
	
	public Student studentlogin(String num,String password);
	public Admin adminlogin(String num,String password);

}
