package springboot.oa.dao;

import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.TbFbf;
import springboot.oa.domain.TbFbfExample;

import java.util.HashMap;
import java.util.List;

public interface TbFbfMapper {
	long countByExample(TbFbfExample example);

	int deleteByExample(TbFbfExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TbFbf record);

	int insertSelective(TbFbf record);

	List<TbFbf> selectByExample(TbFbfExample example);

	TbFbf selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TbFbf record, @Param("example") TbFbfExample example);

	int updateByExample(@Param("record") TbFbf record, @Param("example") TbFbfExample example);

	int updateByPrimaryKeySelective(TbFbf record);

	int updateByPrimaryKey(TbFbf record);

	List<TbFbf> selectPage(HashMap<String, Integer> map);

	List<TbFbf> selectPageByName(HashMap<String, Object> map);
	
	Integer selectLikeCount(String name);

}