package cc.ileiwang.bbms.dao.provider;

import static cc.ileiwang.bbms.util.common.BBMSConstants.BOOKTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cc.ileiwang.bbms.domain.Book;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018��5��21�� ����9:09:00
*/
public class BookDAOProvider {
	// ��ҳ��̬��ѯ
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(BOOKTABLE);
				if (params.get("book") != null) {
					Book book = (Book) params.get("book");
					if (book.getId() != 0) {
						WHERE("id LIKE CONCAT ('%',#{book.id},'%') ");
					}
					if (book.getName() != null && !book.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{book.name},'%') ");
					}
					if (book.getAuthor() != null && !book.getAuthor().equals("")) {
						WHERE("author LIKE CONCAT ('%',#{book.author},'%') ");
					}
					if (book.getPublisher() != null && !book.getPublisher().equals("")) {
						WHERE("publisher LIKE CONCAT ('%',#{book.publisher},'%') ");
					}
					if (book.getIsbn() != null && !book.getIsbn().equals("")) {
						WHERE("isbn LIKE CONCAT ('%',#{book.isbn},'%') ");
					}
					if (book.getYear() != 0) {
						WHERE("year LIKE CONCAT ('%',#{book.year},'%') ");
					}
					if (book.getWords() != 0) {
						WHERE("words LIKE CONCAT ('%',#{book.words},'%') ");
					}
					if (book.getCategory() != null && book.getCategory().getId() != 0) {
						WHERE("category_id LIKE CONCAT ('%',#{book.category.id},'%') ");
					}
				}
			}
		}.toString();

//		if (params.get("pageModel") != null) {
//			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
//		}
		return sql;
	}

	// ��̬��ѯ������
	public String countBook(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(BOOKTABLE);
				if (params.get("book") != null) {
					Book book = (Book) params.get("book");
					if (book.getId() != 0) {
						WHERE("id LIKE CONCAT ('%',#{book.id},'%') ");
					}
					if (book.getName() != null && !book.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{book.name},'%') ");
					}
					if (book.getAuthor() != null && !book.getAuthor().equals("")) {
						WHERE("author LIKE CONCAT ('%',#{book.author},'%') ");
					}
					if (book.getPublisher() != null && !book.getPublisher().equals("")) {
						WHERE("publisher LIKE CONCAT ('%',#{book.publisher},'%') ");
					}
					if (book.getIsbn() != null && !book.getIsbn().equals("")) {
						WHERE("isbn LIKE CONCAT ('%',#{book.isbn},'%') ");
					}
					if (book.getYear() != 0) {
						WHERE("year LIKE CONCAT ('%',#{book.year},'%') ");
					}
					if (book.getWords() != 0) {
						WHERE("words LIKE CONCAT ('%',#{book.words},'%') ");
					}
					if (book.getCategory() != null && book.getCategory().getId() != 0) {
						WHERE("category_id LIKE CONCAT ('%',#{book.category.id},'%') ");
					}
				}
			}
		}.toString();
	}

	// ��̬����
	public String insertBook(Book book) {

		return new SQL() {
			{
				INSERT_INTO(BOOKTABLE);
				if (book.getName() != null && !book.getName().equals("")) {
					VALUES("name", "#{name}");
				}
				if (book.getAuthor() != null && !book.getAuthor().equals("")) {
					VALUES("author", "#{author}");
				}
				if (book.getPublisher() != null&& !book.getPublisher().equals("")) {
					VALUES("publisher", "#{publisher}");
				}
				if (book.getIsbn() != null && !book.getIsbn().equals("")) {
					VALUES("isbn", "#{isbn}");
				}
				if (book.getYear() != 0) {
					VALUES("year", "#{year}");
				}
				if (book.getWords() != 0) {
					VALUES("words", "#{words}");
				}
				if (book.getCategory() != null && book.getCategory().getId() != 0) {
					VALUES("category_id", "#{category.id}");
				}
				if (book.getCoverfilename() != null && !book.getCoverfilename().equals("")) {
					VALUES("coverfilename", "#{coverfilename}");
				}
				
			}
		}.toString();
	}

	// ��̬����
	public String updateBook(Book book) {

		return new SQL() {
			{
				UPDATE(BOOKTABLE);
				if (book.getName() != null && !book.getName().equals("")) {
					SET("name = #{name}");
				}
				if (book.getAuthor() != null && !book.getAuthor().equals("")) {
					SET("author = #{author}");
				}
				if (book.getPublisher() != null&& !book.getPublisher().equals("")) {
					SET("publisher = #{publisher}");
				}
				if (book.getIsbn() != null && !book.getIsbn().equals("")) {
					SET("isbn = #{isbn}");
				}
				if (book.getYear() != 0) {
					SET("year = #{year}");
				}
				if (book.getWords() != 0) {
					SET("words = #{words}");
				}
				if (book.getCategory() != null && book.getCategory().getId() != 0) {
					SET("category_id = #{category.id}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
}
