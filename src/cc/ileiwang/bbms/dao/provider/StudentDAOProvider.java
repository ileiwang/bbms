package cc.ileiwang.bbms.dao.provider;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cc.ileiwang.bbms.domain.Student;

import static cc.ileiwang.bbms.util.common.BBMSConstants.*;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月8日 下午5:21:14
*/
public class StudentDAOProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(STUDENTTABLE);
				if (params.get("student") != null) {
					Student student = (Student) params.get("student");
					if (student.getId() != 0) {
						WHERE(" id LIKE CONCAT ('%',#{student.id},'%') ");
					}
					if (student.getNum() != null && !student.getNum().equals("")) {
						WHERE(" num LIKE CONCAT ('%',#{student.num},'%') ");
					}
					if (student.getName() != null && !student.getName().equals("")) {
						WHERE(" name LIKE CONCAT ('%',#{student.name},'%') ");
					}
					if (student.getIdcard() != null && !student.getIdcard().equals("")) {
						WHERE(" idcard LIKE CONCAT ('%',#{student.idcard},'%') ");
					}
					if (student.getSex() != null && !student.getSex().equals("")) {
						WHERE(" sex LIKE CONCAT ('%',#{student.sex},'%') ");
					}
					if (student.getPassword() != null && !student.getPassword().equals("")) {
						WHERE(" password LIKE CONCAT ('%',#{student.password},'%') ");
					}
					if (student.getTel() != null && !student.getTel().equals("")) {
						WHERE(" tel LIKE CONCAT ('%',#{student.tel},'%') ");
					}
					if (student.getQq() != null && !student.getQq().equals("")) {
						WHERE(" qq LIKE CONCAT ('%',#{student.qq},'%') ");
					}
					if (student.getEmail() != null && !student.getEmail().equals("")) {
						WHERE(" email LIKE CONCAT ('%',#{student.email},'%') ");
					}
					if (student.getAddress() != null && !student.getAddress().equals("")) {
						WHERE(" address LIKE CONCAT ('%',#{student.address},'%') ");
					}
					if (student.getMajor() != null && !student.getMajor().equals("")) {
						WHERE(" major LIKE CONCAT ('%',#{student.major},'%') ");
					}
					if (student.getCollege() != null && !student.getCollege().equals("")) {
						WHERE(" college LIKE CONCAT ('%',#{student.college},'%') ");
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
	public String countStudent(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(STUDENTTABLE);
				if (params.get("student") != null) {
					Student student = (Student) params.get("student");
					if (student.getId() != 0) {
						WHERE(" id LIKE CONCAT ('%',#{student.id},'%') ");
					}
					if (student.getNum() != null && !student.getNum().equals("")) {
						WHERE(" num LIKE CONCAT ('%',#{student.num},'%') ");
					}
					if (student.getName() != null && !student.getName().equals("")) {
						WHERE(" name LIKE CONCAT ('%',#{student.name},'%') ");
					}
					if (student.getIdcard() != null && !student.getIdcard().equals("")) {
						WHERE(" idcard LIKE CONCAT ('%',#{student.idcard},'%') ");
					}
					if (student.getSex() != null && !student.getSex().equals("")) {
						WHERE(" sex LIKE CONCAT ('%',#{student.sex},'%') ");
					}
					if (student.getPassword() != null && !student.getPassword().equals("")) {
						WHERE(" password LIKE CONCAT ('%',#{student.password},'%') ");
					}
					if (student.getTel() != null && !student.getTel().equals("")) {
						WHERE(" tel LIKE CONCAT ('%',#{student.tel},'%') ");
					}
					if (student.getQq() != null && !student.getQq().equals("")) {
						WHERE(" qq LIKE CONCAT ('%',#{student.qq},'%') ");
					}
					if (student.getEmail() != null && !student.getEmail().equals("")) {
						WHERE(" email LIKE CONCAT ('%',#{student.email},'%') ");
					}
					if (student.getAddress() != null && !student.getAddress().equals("")) {
						WHERE(" address LIKE CONCAT ('%',#{student.address},'%') ");
					}
					if (student.getMajor() != null && !student.getMajor().equals("")) {
						WHERE(" major LIKE CONCAT ('%',#{student.major},'%') ");
					}
					if (student.getCollege() != null && !student.getCollege().equals("")) {
						WHERE(" college LIKE CONCAT ('%',#{student.college},'%') ");
					}
				}
			}
		}.toString();
	}

	// 动态插入
	public String insertStudent(Student student) {

		return new SQL() {
			{
				INSERT_INTO(STUDENTTABLE);
				if (student.getNum() != null && !student.getNum().equals("")) {
					VALUES("num", "#{num}");
				}
				if (student.getName() != null && !student.getName().equals("")) {
					VALUES("name", "#{name}");
				}
				if (student.getIdcard() != null && !student.getIdcard().equals("")) {
					VALUES("idcard", "#{idcard}");
				}
				if (student.getSex() != null && !student.getSex().equals("")) {
					VALUES("sex", "#{sex}");
				}
				if (student.getPassword() != null && !student.getPassword().equals("")) {
					VALUES("password", "#{password}");
				}
				if (student.getTel() != null && !student.getTel().equals("")) {
					VALUES("tel", "#{tel}");
				}
				if (student.getQq() != null && !student.getQq().equals("")) {
					VALUES("qq", "#{qq}");
				}
				if (student.getEmail() != null && !student.getEmail().equals("")) {
					VALUES("email", "#{email}");
				}
				if (student.getAddress() != null && !student.getAddress().equals("")) {
					VALUES("address", "#{address}");
				}
				if (student.getMajor() != null && !student.getMajor().equals("")) {
					VALUES("major", "#{major}");
				}
				if (student.getCollege() != null && !student.getCollege().equals("")) {
					VALUES("college", "#{college}");
				}
			}
		}.toString();
	}
	
	// 动态更新
	public String updateStudent(Student student) {

		return new SQL() {
			{
				UPDATE(STUDENTTABLE);
				if (student.getNum() != null && !student.getNum().equals("")) {
					SET("num = #{num}");
				}
				if (student.getName() != null && !student.getName().equals("")) {
					SET("name = #{name}");
				}
				if (student.getBirthday() != null) {
					SET("birthday = #{birthday}");
				}
				if (student.getIdcard() != null && !student.getIdcard().equals("")) {
					SET("idcard = #{idcard}");
				}
				if (student.getSex() != null && !student.getSex().equals("")) {
					SET("sex = #{sex}");
				}
				if (student.getPassword() != null && !student.getPassword().equals("")) {
					SET("password = #{password}");
				}
				if (student.getTel() != null && !student.getTel().equals("")) {
					SET("tel = #{tel}");
				}
				if (student.getQq() != null && !student.getQq().equals("")) {
					SET("qq = #{qq}");
				}
				if (student.getEmail() != null && !student.getEmail().equals("")) {
					SET("email = #{email}");
				}
				if (student.getAddress() != null && !student.getAddress().equals("")) {
					SET("address = #{address}");
				}
				if (student.getMajor() != null && !student.getMajor().equals("")) {
					SET("major = #{major}");
				}
				if (student.getCollege() != null && !student.getCollege().equals("")) {
					SET("college = #{college}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
}
