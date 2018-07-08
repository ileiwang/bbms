package cc.ileiwang.bbms.dao.provider;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

import cc.ileiwang.bbms.domain.Admin;

import static cc.ileiwang.bbms.util.common.BBMSConstants.ADMINTABLE;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018��5��8�� ����5:20:47
*/
public class AdminDAOProvider {
	// ��ҳ��̬��ѯ
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(ADMINTABLE);
				if (params.get("admin") != null) {
					Admin admin = (Admin) params.get("admin");
					if (admin.getName() != null && !admin.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{admin.name},'%') ");
					}
				}
			}
		}.toString();

		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		return sql;
	}

	// ��̬��ѯ������
	public String countAdmin(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(ADMINTABLE);
				if (params.get("admin") != null) {
					Admin admin = (Admin) params.get("admin");
					if (admin.getName() != null && !admin.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{admin.name},'%') ");
					}
				}
			}
		}.toString();
	}

	// ��̬����
	public String insertAdmin(Admin admin) {

		return new SQL() {
			{
				INSERT_INTO(ADMINTABLE);
				if (admin.getNum() != null && !admin.getNum().equals("")) {
					VALUES("num", "#{num}");
				}
				if (admin.getName() != null && !admin.getName().equals("")) {
					VALUES("name", "#{name}");
				}
				if (admin.getBirthday() != null) {
					VALUES("birthday", "#{birthday}");
				}
				if (admin.getIdcard() != null && !admin.getIdcard().equals("")) {
					VALUES("idcard", "#{idcard}");
				}
				if (admin.getSex() != null && !admin.getSex().equals("")) {
					VALUES("sex", "#{sex}");
				}
				if (admin.getPassword() != null && !admin.getPassword().equals("")) {
					VALUES("password", "#{password}");
				}
				if (admin.getTel() != null && !admin.getTel().equals("")) {
					VALUES("tel", "#{tel}");
				}
				if (admin.getQq() != null && !admin.getQq().equals("")) {
					VALUES("qq", "#{qq}");
				}
				if (admin.getEmail() != null && !admin.getEmail().equals("")) {
					VALUES("email", "#{email}");
				}
				if (admin.getAddress() != null && !admin.getAddress().equals("")) {
					VALUES("address", "#{address}");
				}
			}
		}.toString();
	}

	// ��̬����
	public String updateAdmin(Admin admin) {

		return new SQL() {
			{
				UPDATE(ADMINTABLE);
				if (admin.getNum() != null && !admin.getNum().equals("")) {
					SET("num = #{num}");
				}
				if (admin.getName() != null && !admin.getName().equals("")) {
					SET("name = #{name}");
				}
				if (admin.getBirthday() != null) {
					SET("birthday = #{birthday}");
				}
				if (admin.getIdcard() != null && !admin.getIdcard().equals("")) {
					SET("idcard = #{idcard}");
				}
				if (admin.getSex() != null && !admin.getSex().equals("")) {
					SET("sex = #{sex}");
				}
				if (admin.getPassword() != null && !admin.getPassword().equals("")) {
					SET("password = #{password}");
				}
				if (admin.getTel() != null && !admin.getTel().equals("")) {
					SET("tel = #{tel}");
				}
				if (admin.getQq() != null && !admin.getQq().equals("")) {
					SET("qq = #{qq}");
				}
				if (admin.getEmail() != null && !admin.getEmail().equals("")) {
					SET("email = #{email}");
				}
				if (admin.getAddress() != null && !admin.getAddress().equals("")) {
					SET("address = #{address}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}
