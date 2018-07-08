package cc.ileiwang.bbms.dao.provider;

import static cc.ileiwang.bbms.util.common.BBMSConstants.CATEGORYTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cc.ileiwang.bbms.domain.Category;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月21日 下午9:01:26
*/
public class CategoryDAOProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(CATEGORYTABLE);
				if (params.get("category") != null) {
					Category category = (Category) params.get("category");
					if (category.getId() != 0) {
						WHERE("id LIKE CONCAT ('%',#{category.id},'%') ");
					}
					if (category.getName() != null && !category.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{category.name},'%') ");
					}
					if (category.getSummary() != null && !category.getSummary().equals("")) {
						WHERE("summary LIKE CONCAT ('%',#{category.summary},'%') ");
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
	public String countCategory(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(CATEGORYTABLE);
				if (params.get("category") != null) {
					Category category = (Category) params.get("category");
					if (category.getId() != 0) {
						WHERE("id LIKE CONCAT ('%',#{category.id},'%') ");
					}
					if (category.getName() != null && !category.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{category.name},'%') ");
					}
					if (category.getSummary() != null && !category.getSummary().equals("")) {
						WHERE("summary LIKE CONCAT ('%',#{category.summary},'%') ");
					}
				}
			}
		}.toString();
	}

	// 动态插入
	public String insertCategory(Category category) {

		return new SQL() {
			{
				INSERT_INTO(CATEGORYTABLE);
				if (category.getName() != null && !category.getName().equals("")) {
					VALUES("name", "#{name}");
				}
				if (category.getSummary() != null && !category.getSummary().equals("")) {
					VALUES("summary", "#{summary}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateCategory(Category category) {

		return new SQL() {
			{
				UPDATE(CATEGORYTABLE);
				if (category.getName() != null && !category.getName().equals("")) {
					SET("name = #{name}");
				}
				if (category.getSummary() != null && !category.getSummary().equals("")) {
					SET("summary = #{summary}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}
