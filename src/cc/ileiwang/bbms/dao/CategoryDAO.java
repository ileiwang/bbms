package cc.ileiwang.bbms.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import cc.ileiwang.bbms.dao.provider.CategoryDAOProvider;
import cc.ileiwang.bbms.domain.Category;

import static cc.ileiwang.bbms.util.common.BBMSConstants.CATEGORYTABLE;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月21日 下午6:55:34
*/
public interface CategoryDAO {
	
	@SelectProvider(type=CategoryDAOProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="summary",property="summary"),
		@Result(column="id",property="books",
		many=@Many(
				select="cc.ileiwang.bbms.dao.BookDAO.selectByCategoryId",
				fetchType=FetchType.LAZY))
	})
	List<Category> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=CategoryDAOProvider.class,method="countCategory")
	int count(Map<String, Object> params);

	@SelectProvider(type=CategoryDAOProvider.class,method="insertCategory")
	void save(Category category);
	
	@SelectProvider(type=CategoryDAOProvider.class,method="updateCategory")
	void update(Category category);
	
	@Select("select * from "+CATEGORYTABLE)
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="summary",property="summary"),
		@Result(column="id",property="books",
		many=@Many(
				select="cc.ileiwang.bbms.dao.BookDAO.selectByCategoryId",
				fetchType=FetchType.LAZY))
	})
	List<Category> selectAll();
	
	@Select("select * from "+CATEGORYTABLE+" where id = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="summary",property="summary"),
		@Result(column="id",property="books",
		many=@Many(
				select="cc.ileiwang.bbms.dao.BookDAO.selectByCategoryId",
				fetchType=FetchType.LAZY))
	})
	Category selectById(int id);
	
	@Select("select * from "+CATEGORYTABLE+" where name = #{name}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="summary",property="summary"),
		@Result(column="id",property="books",
		many=@Many(
				select="cc.ileiwang.bbms.dao.BookDAO.selectByCategoryId",
				fetchType=FetchType.LAZY))
	})
	Category selectByName(String name);
	
	
	@Delete("delete from "+CATEGORYTABLE+" where id = #{id} ")
	void deleteById(int id);
	
	@Delete("delete from "+CATEGORYTABLE+" where name = #{name} ")
	void deleteByName(String name);
	
	

}
