package cc.ileiwang.bbms.dao.provider;

import static cc.ileiwang.bbms.util.common.BBMSConstants.REMARKTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cc.ileiwang.bbms.domain.Remark;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月21日 下午9:09:18
*/
public class RemarkDAOProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(REMARKTABLE);
				if (params.get("remark") != null) {
					Remark remark = (Remark) params.get("remark");
					if (remark.getId() != 0) {
						WHERE("id LIKE CONCAT ('%',#{remark.id},'%') ");
					}
					if (remark.getTitle() != null && !remark.getTitle().equals("")) {
						WHERE("title LIKE CONCAT ('%',#{remark.title},'%') ");
					}
					if (remark.getContent() != null && !remark.getContent().equals("")) {
						WHERE("content LIKE CONCAT ('%',#{remark.content},'%') ");
					}
					if (remark.getStudent() != null && remark.getStudent().getId()!=0) {
						WHERE("student_id LIKE CONCAT ('%',#{remark.student.id},'%') ");
					}
					if (remark.getBook() != null && remark.getBook().getId()!=0) {
						WHERE("book_id LIKE CONCAT ('%',#{remark.book.id},'%') ");
					}
				}
			}
		}.toString();

		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		return sql;
	}

	// 动态查询总数量
	public String countRemark(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(REMARKTABLE);
				if (params.get("remark") != null) {
					Remark remark = (Remark) params.get("remark");
					if (remark.getId() != 0) {
						WHERE("id LIKE CONCAT ('%',#{remark.id},'%') ");
					}
					if (remark.getTitle() != null && !remark.getTitle().equals("")) {
						WHERE("title LIKE CONCAT ('%',#{remark.title},'%') ");
					}
					if (remark.getContent() != null && !remark.getContent().equals("")) {
						WHERE("content LIKE CONCAT ('%',#{remark.content},'%') ");
					}
					if (remark.getStudent() != null && remark.getStudent().getId()!=0) {
						WHERE("student_id LIKE CONCAT ('%',#{remark.student.id},'%') ");
					}
					if (remark.getBook() != null && remark.getBook().getId()!=0) {
						WHERE("book_id LIKE CONCAT ('%',#{remark.book.id},'%') ");
					}
				}
			}
		}.toString();
	}

	// 动态插入
	public String insertRemark(Remark remark) {

		return new SQL() {
			{
				INSERT_INTO(REMARKTABLE);
				if (remark.getTitle() != null && !remark.getTitle().equals("")) {
					VALUES("title", "#{title}");
				}
				if (remark.getContent() != null && !remark.getContent().equals("")) {
					VALUES("content", "#{content}");
				}
				if (remark.getStudent() != null && remark.getStudent().getId()!=0) {
					VALUES("student_id", "#{student.id}");
				}
				if (remark.getBook() != null && remark.getBook().getId()!=0) {
					VALUES("book_id", "#{book.id}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateRemark(Remark remark) {

		return new SQL() {
			{
				UPDATE(REMARKTABLE);
				if (remark.getTitle() != null && !remark.getTitle().equals("")) {
					SET("title = #{title}");
				}
				if (remark.getContent() != null && !remark.getContent().equals("")) {
					SET("content = #{content}");
				}
				if (remark.getStudent() != null && remark.getStudent().getId()!=0) {
					SET("student_id = #{student.id}");
				}
				if (remark.getBook() != null && remark.getBook().getId()!=0) {
					SET("book_id = #{book.id}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}
