package cc.ileiwang.bbms.service;
import java.util.List;


import cc.ileiwang.bbms.domain.*;
import cc.ileiwang.bbms.util.tag.PageModel;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018��5��8�� ����5:28:36
*/
public interface BBMSService {
	//Admin
	
	
	//������
	public List<Admin> findAdmin(Admin admin,PageModel pageModel);
	public List<Admin> findAllAdmin();
	//������
	public Admin selectAdminById(int id);
	public Admin selectAdminByNum(String num);
	public Admin selectAdminByName(String name);
	public Admin selectAdminByNumAndPassword(String num,String password);
	//���
	public void addAdmin(Admin admin);
	//�޸�
	public void modifyAdmin(Admin admin);
	//ɾ��
	public void deleteAdminById(int id);
	public void deleteAdminByNum(String num);
	public void deleteAdminByName(String name);
	
	
	
	//Student
	
	
	//������
	public List<Student> findStudent(Student student,PageModel pageModel);
	public List<Student> findAllStudent();
	public List<Student> selectStudentsByBookId(int book_id);
	public List<Student> selectStudentsFromWishbook();
	
	//������
	public Student selectStudentById(int id);
	public Student selectStudentByNum(String num);
	public Student selectStudentByName(String name);
	public Student selectStudentByNumAndPassword(String num,String password);
	public Student selectStudentByBookId(int book_id);
	//���
	public void addStudent(Student student);
	//�޸�
	public void modifyStudent(Student student);
	//ɾ��
	public void deleteStudentById(int id);
	public void deleteStudentByNum(String num);
	
	//�޸�����
	public void changepasswd(int student_id,String password);
	
	public String findpasswd(String num,String name);
	
	
	//Book
	
	//������
	public List<Book> findBook(Book book,PageModel pageModel);
	public List<Book> findAllBook();
	public List<Book> selectAlreadyBorrowedByStudentId(int student_id);
	public List<Book> selectCurrentBorrowedByStudentId(int student_id);
	public List<Book> selectBookByCategoryId(int category_id);
	
	//������
	public Book selectBookById(int id);
	public Book selectBookByIsbn(String isbn);
	public Book selectBookByName(String name);
	//���
	public void addBook(Book book);
	//�޸�
	public void modifyBook(Book book);
	//ɾ��
	public void deleteBookById(int id);
	public void deleteBookByName(String name);
	public void deleteBookByIsbn(String isbn);
	
	//�������
	public void borrowBook(int student_id,int book_id);
	//�黹����
	public void backBook(int student_id,int book_id);
	
	//�Ƿ��ѱ�����
	public int isborrow(int book_id);
	//�Ƿ��ѱ��黹
	public int isback(int book_id);
	
	public List<String> selectBookNameByStudentId(int id);
	
	//
	public void savewishbook(String name,String author,int student_id);
	
	
	
	
	//������
	public List<Category> findCategory(Category category,PageModel pageModel);
	public List<Category> findAllCategory();
	//������
	public Category selectCategoryById(int id);
	public Category selectCategoryByName(String name);

	//���
	public void addCategory(Category category);
	//�޸�
	public void modifyCategory(Category category);
	//ɾ��
	public void deleteCategoryById(int id);
	public void deleteCategoryByName(String name);
	
	
	//������
	public List<Remark> findRemark(Remark remark,PageModel pageModel);
	public List<Remark> findAllRemark();
	public List<Remark> findRemarksByBookId(int book_id);
	public List<Remark> findRemarksByStudentId(int student_id);
	//������
	public Remark selectRemarkById(int id);

	//���
	public void addRemark(Remark remark);
	//�޸�
	public void modifyRemark(Remark remark);
	//ɾ��
	public void deleteRemarkById(int id);
	public void deleteRemarkByBookId(int book_id);
	public void deleteRemarkByStudentId(int student_id);
	
	
	
	
	//Login����
	
	public Student studentlogin(String num,String password);
	public Admin adminlogin(String num,String password);

}
