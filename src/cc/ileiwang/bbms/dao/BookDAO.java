package cc.ileiwang.bbms.dao;

import static cc.ileiwang.bbms.util.common.BBMSConstants.BOOKTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import cc.ileiwang.bbms.dao.provider.BookDAOProvider;
import cc.ileiwang.bbms.domain.Book;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月21日 下午9:08:18
*/
public interface BookDAO {
	@SelectProvider(type=BookDAOProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="author",property="author"),
		@Result(column="publisher",property="publisher"),
		@Result(column="isbn",property="isbn"),
		@Result(column="year",property="year"),
		@Result(column="words",property="words"),
		@Result(column="coverfilename",property="coverfilename"),
		@Result(column = "category_id", property = "category", 
		one = @One(select = "cc.ileiwang.bbms.dao.CategoryDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column="id",property="remarks",
		many=@Many(
				select="cc.ileiwang.bbms.dao.RemarkDAO.selectByBookId",
				fetchType=FetchType.LAZY))
	})
	List<Book> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=BookDAOProvider.class,method="countBook")
	int count(Map<String, Object> params);

	@SelectProvider(type=BookDAOProvider.class,method="insertBook")
	void save(Book book);
	
	@SelectProvider(type=BookDAOProvider.class,method="updateBook")
	void update(Book book);
	
	@Select("select * from "+BOOKTABLE)
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="author",property="author"),
		@Result(column="publisher",property="publisher"),
		@Result(column="isbn",property="isbn"),
		@Result(column="year",property="year"),
		@Result(column="words",property="words"),
		@Result(column="coverfilename",property="coverfilename"),
		@Result(column = "category_id", property = "category", 
		one = @One(
				select = "cc.ileiwang.bbms.dao.CategoryDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="remarks",
		many=@Many(
				select="cc.ileiwang.bbms.dao.RemarkDAO.selectByBookId",
				fetchType=FetchType.LAZY))
	})
	List<Book> selectAll();
	
	
	//查询某一类别所有图书
	@Select("select * from "+BOOKTABLE+" where category_id = #{category_id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="author",property="author"),
		@Result(column="publisher",property="publisher"),
		@Result(column="isbn",property="isbn"),
		@Result(column="year",property="year"),
		@Result(column="words",property="words"),
		@Result(column="coverfilename",property="coverfilename"),
		@Result(column = "category_id", property = "category", 
		one = @One(select = "cc.ileiwang.bbms.dao.CategoryDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column="id",property="remarks",
		many=@Many(
				select="cc.ileiwang.bbms.dao.RemarkDAO.selectByBookId",
				fetchType=FetchType.LAZY))
	})
	List<Book> selectByCategoryId(int category_id);
	
	
	//查询某一学生历史借阅记录
	@Select("select * from "+BOOKTABLE+" where id in (select book_id from borrow where student_id=#{student_id} and isback = '1')")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="author",property="author"),
		@Result(column="publisher",property="publisher"),
		@Result(column="isbn",property="isbn"),
		@Result(column="year",property="year"),
		@Result(column="words",property="words"),
		@Result(column="coverfilename",property="coverfilename"),
		@Result(column = "category_id", property = "category", 
		one = @One(select = "cc.ileiwang.bbms.dao.CategoryDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column="id",property="remarks",
		many=@Many(
				select="cc.ileiwang.bbms.dao.RemarkDAO.selectByBookId",
				fetchType=FetchType.LAZY))
	})
	List<Book> selectAlreadyBorrowedByStudentId(int student_id);
	
	//查询某一学生当前借阅
	@Select("select * from "+BOOKTABLE+" where id in (select book_id from borrow where student_id=#{student_id} and isback = '0')")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="author",property="author"),
		@Result(column="publisher",property="publisher"),
		@Result(column="isbn",property="isbn"),
		@Result(column="year",property="year"),
		@Result(column="words",property="words"),
		@Result(column="coverfilename",property="coverfilename"),
		@Result(column = "category_id", property = "category", 
		one = @One(select = "cc.ileiwang.bbms.dao.CategoryDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column="id",property="remarks",
		many=@Many(
				select="cc.ileiwang.bbms.dao.RemarkDAO.selectByBookId",
				fetchType=FetchType.LAZY))
	})
	List<Book> selectCurrentBorrowedByStudentId(int student_id);
	
	@Select("select * from "+BOOKTABLE+" where id = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="author",property="author"),
		@Result(column="publisher",property="publisher"),
		@Result(column="isbn",property="isbn"),
		@Result(column="year",property="year"),
		@Result(column="words",property="words"),
		@Result(column="coverfilename",property="coverfilename"),
		@Result(column = "category_id", property = "category",
		one = @One(select = "cc.ileiwang.bbms.dao.CategoryDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column="id",property="remarks",
		many=@Many(
				select="cc.ileiwang.bbms.dao.RemarkDAO.selectByBookId",
				fetchType=FetchType.LAZY))
	})
	Book selectById(int id);
	
	@Select("select * from "+BOOKTABLE+" where isbn = #{isbn}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="author",property="author"),
		@Result(column="publisher",property="publisher"),
		@Result(column="isbn",property="isbn"),
		@Result(column="year",property="year"),
		@Result(column="words",property="words"),
		@Result(column="coverfilename",property="coverfilename"),
		@Result(column = "category_id", property = "category", 
		one = @One(select = "cc.ileiwang.bbms.dao.CategoryDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column="id",property="remarks",
		many=@Many(
				select="cc.ileiwang.bbms.dao.RemarkDAO.selectByBookId",
				fetchType=FetchType.LAZY))
	})
	Book selectByIsbn(String isbn);
	
	
	@Select("select * from "+BOOKTABLE+" where name = #{name}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="author",property="author"),
		@Result(column="publisher",property="publisher"),
		@Result(column="isbn",property="isbn"),
		@Result(column="year",property="year"),
		@Result(column="words",property="words"),
		@Result(column="coverfilename",property="coverfilename"),
		@Result(column = "category_id", property = "category", 
		one = @One(select = "cc.ileiwang.bbms.dao.CategoryDAO.selectById", 
		fetchType = FetchType.EAGER)),
		@Result(column="id",property="remarks",
		many=@Many(
				select="cc.ileiwang.bbms.dao.RemarkDAO.selectByBookId",
				fetchType=FetchType.LAZY))
	})
	Book selectByName(String name);
	
	//删除
	@Delete("delete from "+BOOKTABLE+" where id = #{id} ")
	void deleteById(int id);
	@Delete("delete from "+BOOKTABLE+" where isbn = #{isbn} ")
	void deleteByIsbn(String isbn);
	@Delete("delete from "+BOOKTABLE+" where name = #{name} ")
	void deleteByName(String name);
	
	//图书借阅
	@Insert("insert into borrow (student_id,book_id) VALUES (${student_id},${book_id})")
	void borrow(@Param("student_id")int student_id,@Param("book_id")int book_id);
	
	//图书归还
	@Update("update borrow set isback = '1',backtime = CURRENT_TIMESTAMP where student_id = ${student_id} and book_id = ${book_id}")
	void back(@Param("student_id")int student_id,@Param("book_id")int book_id);
	
	//是否已被借阅
	//Book不为NULL为已被借阅
	@Select("select * from "+BOOKTABLE+" where id in (select book_id from borrow where isback = '0' and book_id = #{book_id})")
	Book isborrow(@Param("book_id")int book_id);
	
	//是否已被归还
	//Book为NULL说明已被归还
	@Select("select * from "+BOOKTABLE+" where id in (select book_id from borrow where isback = '0' and book_id = #{book_id})")
	Book isback(@Param("book_id")int book_id);
	
	//删除借阅记录
	 @Delete("delete from borrow where book_id = #{id}")
	 void deleteborrowrecord(int id);
	
	//保存想读图书
	@Insert("insert into wishbook (name,author,student_id) VALUES ('${name}','${author}',${student_id})")
	void savewishbook(@Param("name")String name,@Param("author")String author,@Param("student_id") int student_id);
	
	@Select("select name from wishbook where student_id=#{id}")
	List<String> selectBookNameByStudentId(int id);
}
