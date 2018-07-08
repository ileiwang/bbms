package cc.ileiwang.bbms.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Many;

import cc.ileiwang.bbms.domain.*;
import cc.ileiwang.bbms.dao.provider.*;

import static cc.ileiwang.bbms.util.common.BBMSConstants.*;

/**
 * @author Lei Wang
 * @email ileiwang@live.com
 * @blog www.ileiwang.cc
 * @version 2018年5月8日 下午5:18:17
 */
public interface StudentDAO {

	// 根据页码选择学生（分页使用）
	@SelectProvider(type = StudentDAOProvider.class, method = "selectWhitParam")
	@Results({ @Result(id = true, column = "id", property = "id"), @Result(column = "num", property = "num"),
			@Result(column = "name", property = "name"),
			@Result(column = "birthday", property = "birthday", javaType = java.util.Date.class),
			@Result(column = "idcard", property = "idcard"), @Result(column = "sex", property = "sex"),
			@Result(column = "password", property = "password"), @Result(column = "tel", property = "tel"),
			@Result(column = "qq", property = "qq"), @Result(column = "email", property = "email"),
			@Result(column = "address", property = "address"), @Result(column = "major", property = "major"),
			@Result(column = "college", property = "college"),
			@Result(column = "id", property = "books", many = @Many(select = "cc.ileiwang.bbms.dao.BookDAO.selectCurrentBorrowedByStudentId", fetchType = FetchType.LAZY)),
			@Result(column = "id", property = "remarks", many = @Many(select = "cc.ileiwang.bbms.dao.RemarkDAO.selectByStudentId", fetchType = FetchType.LAZY)) })
	List<Student> selectByPage(Map<String, Object> params);

	// 统计学生数
	@SelectProvider(type = StudentDAOProvider.class, method = "countStudent")
	int count(Map<String, Object> params);

	// 添加
	@SelectProvider(type = StudentDAOProvider.class, method = "insertStudent")
	void save(Student student);

	// 更新
	@SelectProvider(type = StudentDAOProvider.class, method = "updateStudent")
	void update(Student student);

	// 选择全部学生
	@Select("select * from " + STUDENTTABLE)
	@Results({ @Result(id = true, column = "id", property = "id"), @Result(column = "num", property = "num"),
			@Result(column = "name", property = "name"),
			@Result(column = "birthday", property = "birthday", javaType = java.util.Date.class),
			@Result(column = "idcard", property = "idcard"), @Result(column = "sex", property = "sex"),
			@Result(column = "password", property = "password"), @Result(column = "tel", property = "tel"),
			@Result(column = "qq", property = "qq"), @Result(column = "email", property = "email"),
			@Result(column = "address", property = "address"), @Result(column = "major", property = "major"),
			@Result(column = "college", property = "college"),
			@Result(column = "id", property = "books", many = @Many(select = "cc.ileiwang.bbms.dao.BookDAO.selectCurrentBorrowedByStudentId", fetchType = FetchType.LAZY)),
			@Result(column = "id", property = "remarks", many = @Many(select = "cc.ileiwang.bbms.dao.RemarkDAO.selectByStudentId", fetchType = FetchType.LAZY)) })
	List<Student> selectAllStudent();

	// 根据ID选择学生
	@Select("select * from " + STUDENTTABLE + " where id = #{id}")
	@Results({ @Result(id = true, column = "id", property = "id"), @Result(column = "num", property = "num"),
			@Result(column = "name", property = "name"),
			@Result(column = "birthday", property = "birthday", javaType = java.util.Date.class),
			@Result(column = "idcard", property = "idcard"), @Result(column = "sex", property = "sex"),
			@Result(column = "password", property = "password"), @Result(column = "tel", property = "tel"),
			@Result(column = "qq", property = "qq"), @Result(column = "email", property = "email"),
			@Result(column = "address", property = "address"), @Result(column = "major", property = "major"),
			@Result(column = "college", property = "college"),
			@Result(column = "id", property = "books", many = @Many(select = "cc.ileiwang.bbms.dao.BookDAO.selectCurrentBorrowedByStudentId", fetchType = FetchType.LAZY)),
			@Result(column = "id", property = "remarks", many = @Many(select = "cc.ileiwang.bbms.dao.RemarkDAO.selectByStudentId", fetchType = FetchType.LAZY)) })
	Student selectById(int id);

	// 根据学号选择学生
	@Select("select * from " + STUDENTTABLE + " where num = #{num}")
	@Results({ @Result(id = true, column = "id", property = "id"), @Result(column = "num", property = "num"),
			@Result(column = "name", property = "name"),
			@Result(column = "birthday", property = "birthday", javaType = java.util.Date.class),
			@Result(column = "idcard", property = "idcard"), @Result(column = "sex", property = "sex"),
			@Result(column = "password", property = "password"), @Result(column = "tel", property = "tel"),
			@Result(column = "qq", property = "qq"), @Result(column = "email", property = "email"),
			@Result(column = "address", property = "address"), @Result(column = "major", property = "major"),
			@Result(column = "college", property = "college"),
			@Result(column = "id", property = "books", many = @Many(select = "cc.ileiwang.bbms.dao.BookDAO.selectCurrentBorrowedByStudentId", fetchType = FetchType.LAZY)),
			@Result(column = "id", property = "remarks", many = @Many(select = "cc.ileiwang.bbms.dao.RemarkDAO.selectByStudentId", fetchType = FetchType.LAZY)) })
	Student selectByNum(@Param("num") String num);

	// 根据姓名选择学生
	@Select("select * from " + STUDENTTABLE + " where name = #{name}")
	@Results({ @Result(id = true, column = "id", property = "id"), @Result(column = "num", property = "num"),
			@Result(column = "name", property = "name"),
			@Result(column = "birthday", property = "birthday", javaType = java.util.Date.class),
			@Result(column = "idcard", property = "idcard"), @Result(column = "sex", property = "sex"),
			@Result(column = "password", property = "password"), @Result(column = "tel", property = "tel"),
			@Result(column = "qq", property = "qq"), @Result(column = "email", property = "email"),
			@Result(column = "address", property = "address"), @Result(column = "major", property = "major"),
			@Result(column = "college", property = "college"),
			@Result(column = "id", property = "books", many = @Many(select = "cc.ileiwang.bbms.dao.BookDAO.selectCurrentBorrowedByStudentId", fetchType = FetchType.LAZY)),
			@Result(column = "id", property = "remarks", many = @Many(select = "cc.ileiwang.bbms.dao.RemarkDAO.selectByStudentId", fetchType = FetchType.LAZY)) })
	Student selectByName(@Param("name") String name);

	// 根据学号密码查询
	@Select("select * from " + STUDENTTABLE + " where num = #{num} and password = #{password}")
	@Results({ @Result(id = true, column = "id", property = "id"), @Result(column = "num", property = "num"),
			@Result(column = "name", property = "name"),
			@Result(column = "birthday", property = "birthday", javaType = java.util.Date.class),
			@Result(column = "idcard", property = "idcard"), @Result(column = "sex", property = "sex"),
			@Result(column = "password", property = "password"), @Result(column = "tel", property = "tel"),
			@Result(column = "qq", property = "qq"), @Result(column = "email", property = "email"),
			@Result(column = "address", property = "address"), @Result(column = "major", property = "major"),
			@Result(column = "college", property = "college"),
			@Result(column = "id", property = "books", many = @Many(select = "cc.ileiwang.bbms.dao.BookDAO.selectCurrentBorrowedByStudentId", fetchType = FetchType.LAZY)),
			@Result(column = "id", property = "remarks", many = @Many(select = "cc.ileiwang.bbms.dao.RemarkDAO.selectByStudentId", fetchType = FetchType.LAZY)) })
	Student selectByNumAndPassword(@Param("num") String num, @Param("password") String password);

	// 查询一本图书所有的历史借阅者
	@Select("select * from student where id in (SELECT student_id FROM borrow where book_id = #{book_id} and isback = '1')")
	@Results({ @Result(id = true, column = "id", property = "id"), @Result(column = "num", property = "num"),
			@Result(column = "name", property = "name"),
			@Result(column = "birthday", property = "birthday", javaType = java.util.Date.class),
			@Result(column = "idcard", property = "idcard"), @Result(column = "sex", property = "sex"),
			@Result(column = "password", property = "password"), @Result(column = "tel", property = "tel"),
			@Result(column = "qq", property = "qq"), @Result(column = "email", property = "email"),
			@Result(column = "address", property = "address"), @Result(column = "major", property = "major"),
			@Result(column = "college", property = "college"),
			@Result(column = "id", property = "books", many = @Many(select = "cc.ileiwang.bbms.dao.BookDAO.selectCurrentBorrowedByStudentId", fetchType = FetchType.LAZY)),
			@Result(column = "id", property = "remarks", many = @Many(select = "cc.ileiwang.bbms.dao.RemarkDAO.selectByStudentId", fetchType = FetchType.LAZY)) })
	List<Student> selectStudentsByBookId(int book_id);

	// 查询一本图书当前的借阅者
	@Select("select * from student where id in (SELECT student_id FROM borrow where book_id = #{book_id} and isback = '0')")
	@Results({ @Result(id = true, column = "id", property = "id"), @Result(column = "num", property = "num"),
			@Result(column = "name", property = "name"),
			@Result(column = "birthday", property = "birthday", javaType = java.util.Date.class),
			@Result(column = "idcard", property = "idcard"), @Result(column = "sex", property = "sex"),
			@Result(column = "password", property = "password"), @Result(column = "tel", property = "tel"),
			@Result(column = "qq", property = "qq"), @Result(column = "email", property = "email"),
			@Result(column = "address", property = "address"), @Result(column = "major", property = "major"),
			@Result(column = "college", property = "college"),
			@Result(column = "id", property = "books", many = @Many(select = "cc.ileiwang.bbms.dao.BookDAO.selectCurrentBorrowedByStudentId", fetchType = FetchType.LAZY)),
			@Result(column = "id", property = "remarks", many = @Many(select = "cc.ileiwang.bbms.dao.RemarkDAO.selectByStudentId", fetchType = FetchType.LAZY)) })
	Student selectStudentByBookId(int book_id);

	// 查询一本图书所有的历史借阅者
	@Select("select * from student where id in (SELECT student_id FROM wishbook)")
	@Results({ @Result(id = true, column = "id", property = "id"), @Result(column = "num", property = "num"),
			@Result(column = "name", property = "name"),
			@Result(column = "birthday", property = "birthday", javaType = java.util.Date.class),
			@Result(column = "idcard", property = "idcard"), @Result(column = "sex", property = "sex"),
			@Result(column = "password", property = "password"), @Result(column = "tel", property = "tel"),
			@Result(column = "qq", property = "qq"), @Result(column = "email", property = "email"),
			@Result(column = "address", property = "address"), @Result(column = "major", property = "major"),
			@Result(column = "college", property = "college"),
			@Result(column = "id", property = "books", many = @Many(select = "cc.ileiwang.bbms.dao.BookDAO.selectCurrentBorrowedByStudentId", fetchType = FetchType.LAZY)),
			@Result(column = "id", property = "remarks", many = @Many(select = "cc.ileiwang.bbms.dao.RemarkDAO.selectByStudentId", fetchType = FetchType.LAZY)) })
	List<Student> selectStudentsFromWishbook();
	
	
	// 根据ID删除学生
	@Delete("delete from " + STUDENTTABLE + " where id = #{id} ")
	void deleteById(int id);

	// 根据学号删除学生
	@Delete("delete from " + STUDENTTABLE + " where num = #{num} ")
	void deleteByNum(String num);

	@Delete("delete from " + STUDENTTABLE + " where name = #{name} ")
	void deleteByName(String name);

	@Update("update " + STUDENTTABLE + " set password = '${password}' where id = ${student_id}")
	void changepasswd(@Param("student_id")int student_id, @Param("password")String password);

	@Select("select password from " + STUDENTTABLE + " where num = '${num}' and name = '${name}'")
	String findpasswd(@Param("num") String num, @Param("name") String name);

	// 根据课程号删除所有学生（从学生-课程表里获取所有学生ID）
	// @Delete("delete from "+STUDENTTABLE+" where id in (select student_id from
	// stucou_item where course_id = #{course_id})")
	// void deleteByCourseId(int course_id);

	// 添加课程
	// @InsertProvider(type=StudentDAOProvider.class,method="saveCourse")
	// void saveCourse(int student_id,int course_id);

	// @Delete("delete from "+STUCOUTABLE+" where course_id = '1'")
	// void savCourse(int student_id,int course_id);

	// 选课
	// @Insert("insert into "+STUCOUTABLE+" (student_id,course_id) VALUES
	// (${student_id},${course_id})")
	// void chooseCourse(@Param("student_id") int student_id,@Param("course_id") int
	// course_id);
	//
	// //退选
	// @Delete("delete from "+STUCOUTABLE+" where student_id = ${student_id} and
	// course_id = ${course_id}")
	// void unchooseCourse(@Param("student_id") int student_id,@Param("course_id")
	// int course_id);
}
