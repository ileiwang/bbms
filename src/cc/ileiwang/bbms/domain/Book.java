package cc.ileiwang.bbms.domain;

import java.util.List;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月21日 下午4:48:38
*/
public class Book {
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getWords() {
		return words;
	}
	public void setWords(int words) {
		this.words = words;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Remark> getRemarks() {
		return remarks;
	}
	public void setRemarks(List<Remark> remarks) {
		this.remarks = remarks;
	}
	public Book(int id, String name, String author, String publisher, String isbn, int year, int words,
			Category category,List<Remark> remarks,String coverfilename) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.year = year;
		this.words = words;
		this.category = category;
		this.remarks = remarks;
		this.coverfilename = coverfilename;
	}
	public Book() {
		super();
	}
	private int id;
	private String name;
	private String author;
	private String publisher;
	private String isbn;
	private int year;
	private int words;
	private Category category;
	private List<Remark> remarks;//此图书的所有评论
	private String coverfilename;
	public String getCoverfilename() {
		return coverfilename;
	}
	public void setCoverfilename(String coverfilename) {
		this.coverfilename = coverfilename;
	}
}
