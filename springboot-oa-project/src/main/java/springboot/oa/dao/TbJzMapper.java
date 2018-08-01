package springboot.oa.dao;

import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.TbJz;

import springboot.oa.domain.TbJzExample;

import java.util.HashMap;
import java.util.List;

public interface TbJzMapper {
	long countByExample(TbJzExample example);

	int deleteByExample(TbJzExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TbJz record);

	int insertSelective(TbJz record);

	List<TbJz> selectByExample(TbJzExample example);

	TbJz selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TbJz record, @Param("example") TbJzExample example);

	int updateByExample(@Param("record") TbJz record, @Param("example") TbJzExample example);

	int updateByPrimaryKeySelective(TbJz record);

	int updateByPrimaryKey(TbJz record);

	List<TbJz> selectPage(HashMap<String, Integer> map);

	List<TbJz> selectPageByName(HashMap<String, Object> map);
	
	Integer selectLikeCount(String name);

}