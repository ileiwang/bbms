package cc.ileiwang.bbms.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018��7��7�� ����9:20:32
*/
public class Notice {
	
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
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
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
	public Notice(int id, String title, String content, Admin admin, int readcount, Date createdate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.admin = admin;
		this.readcount = readcount;
		this.createdate = createdate;
	}
	public Notice() {
		super();
	}
	private int id;//���
	private String title;
	private String content;//����
	private Admin admin;//������
	private int readcount;//�������
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdate;//��������

}
