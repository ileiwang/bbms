package cc.ileiwang.bbms.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月21日 下午4:59:11
*/
public class Remark {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Date getTime() {
		return rtime;
	}
	public void setTime(Date rtime) {
		this.rtime = rtime;
	}
	public Remark(int id, String title,String content, Student student, Book book, Date rtime) {
		super();
		this.title = title;
		this.id = id;
		this.content = content;
		this.student = student;
		this.book = book;
		this.rtime = rtime;
	}
	public Remark() {
		super();
	}
	private int id;//ID
	private String title;
	private String content;//内容
	private Student student;//评论者
	private Book book;//评论图书
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date rtime;//评论时间

}
