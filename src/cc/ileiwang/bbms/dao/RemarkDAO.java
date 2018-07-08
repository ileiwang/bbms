package cc.ileiwang.bbms.dao;

import static cc.ileiwang.bbms.util.common.BBMSConstants.REMARKTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import cc.ileiwang.bbms.dao.provider.RemarkDAOProvider;
import cc.ileiwang.bbms.domain.Remark;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月21日 下午9:08:41
*/
public interface RemarkDAO {
	@SelectProvider(type=RemarkDAOProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="title",property="title"),
		@Result(column="content",property="content"),
		@Result(column = "student_id", property = "student", 
		one = @One(select = "cc.ileiwang.bbms.dao.StudentDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column = "book_id", property = "book", 
		one = @One(select = "cc.ileiwang.bbms.dao.BookDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column="rtime",property="rtime",javaType = java.util.Date.class)
	})
	List<Remark> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=RemarkDAOProvider.class,method="countRemark")
	int count(Map<String, Object> params);

	@SelectProvider(type=RemarkDAOProvider.class,method="insertRemark")
	void save(Remark remark);
	
	@SelectProvider(type=RemarkDAOProvider.class,method="updateRemark")
	void update(Remark remark);
	
	@Select("select * from "+REMARKTABLE)
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="title",property="title"),
		@Result(column="content",property="content"),
		@Result(column = "student_id", property = "student", 
		one = @One(select = "cc.ileiwang.bbms.dao.StudentDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column = "book_id", property = "book", 
		one = @One(select = "cc.ileiwang.bbms.dao.BookDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column="rtime",property="rtime",javaType = java.util.Date.class)
	})
	List<Remark> selectAll();
	
	@Select("select * from "+REMARKTABLE+" where id = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="title",property="title"),
		@Result(column="content",property="content"),
		@Result(column = "student_id", property = "student", 
		one = @One(select = "cc.ileiwang.bbms.dao.StudentDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column = "book_id", property = "book", 
		one = @One(select = "cc.ileiwang.bbms.dao.BookDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column="rtime",property="rtime",javaType = java.util.Date.class)
	})
	Remark selectById(int id);
	
	@Select("select * from "+REMARKTABLE+" where student_id = #{student_id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="title",property="title"),
		@Result(column="content",property="content"),
		@Result(column = "student_id", property = "student", 
		one = @One(select = "cc.ileiwang.bbms.dao.StudentDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column = "book_id", property = "book", 
		one = @One(select = "cc.ileiwang.bbms.dao.BookDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column="rtime",property="rtime",javaType = java.util.Date.class)
	})
	List<Remark> selectByStudentId(int student_id);
	
	@Select("select * from "+REMARKTABLE+" where book_id = #{book_id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="title",property="title"),
		@Result(column="content",property="content"),
		@Result(column = "student_id", property = "student", 
		one = @One(select = "cc.ileiwang.bbms.dao.StudentDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column = "book_id", property = "book", 
		one = @One(select = "cc.ileiwang.bbms.dao.BookDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column="rtime",property="rtime",javaType = java.util.Date.class)
	})
	List<Remark> selectByBookId(int book_id);
	
	//删除操作
	@Delete("delete from "+REMARKTABLE+" where id = #{id} ")
	void deleteById(int id);
	@Delete("delete from "+REMARKTABLE+" where student_id = #{student_id} ")
	void deleteByStudentId(int student_id);
	@Delete("delete from "+REMARKTABLE+" where book_id = #{book_id} ")
	void deleteByBookId(int book_id);

}
