package cc.ileiwang.bbms.domain;

import java.util.List;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月21日 下午4:48:56
*/
public class Category {
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
	public Category(int id, String name, String summary, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.summary = summary;
		this.books = books;
	}
	public Category() {
		super();
	}
	private int id;
	private String name;
	private String summary;
	private List<Book> books;

}
