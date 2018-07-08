package cc.ileiwang.bbms.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018��5��21�� ����5:23:21
*/
public class Borrow {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getBorrowtime() {
		return borrowtime;
	}
	public void setBorrowtime(Date borrowtime) {
		this.borrowtime = borrowtime;
	}
	public Date getBacktime() {
		return backtime;
	}
	public void setBacktime(Date backtime) {
		this.backtime = backtime;
	}
	public Borrow(int id, Student student, Book book, Date borrowtime, Date backtime) {
		super();
		this.id = id;
		this.student = student;
		this.book = book;
		this.borrowtime = borrowtime;
		this.backtime = backtime;
	}
	
	public Borrow(int id, Student student, Book book, Date borrowtime) {
		super();
		this.id = id;
		this.student = student;
		this.book = book;
		this.borrowtime = borrowtime;
	}
	public Borrow() {
		super();
	}
	private int id;
	private Student student;//������
	private Book book;//����ͼ��
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date borrowtime;//����ʱ��
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date backtime;//�黹ʱ��

}
