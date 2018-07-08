package cc.ileiwang.bbms.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018��7��7�� ����8:57:51
*/
public class Booklist {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Booklist(int id, String name, String summary, List<Book> books, Student student, int readcount,
			Date createdate) {
		super();
		this.id = id;
		this.name = name;
		this.summary = summary;
		this.books = books;
		this.student = student;
		this.readcount = readcount;
		this.createdate = createdate;
	}
	public Booklist() {
		super();
	}
	private int id;//�鵥���
	private String name;//�鵥����
	private String summary;//�鵥���
	private List<Book> books;//�鵥������ͼ��
	private Student student;//�鵥����
	private int readcount;//�鵥�������
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdate;//�鵥��������
}
