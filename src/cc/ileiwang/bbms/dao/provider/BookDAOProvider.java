package cc.ileiwang.bbms.dao.provider;

import static cc.ileiwang.bbms.util.common.BBMSConstants.BOOKTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cc.ileiwang.bbms.domain.Book;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月21日 下午9:09:00
*/
public class BookDAOProvider {
	// 分页动态查询
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

	// 动态查询总数量
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

	// 动态插入
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

	// 动态更新
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
