package springboot.oa.dao;

import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.TbHjry;
import springboot.oa.domain.TbHjryExample;

import java.util.HashMap;
import java.util.List;

public interface TbHjryMapper {
	long countByExample(TbHjryExample example);

	int deleteByExample(TbHjryExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TbHjry record);

	int insertSelective(TbHjry record);

	List<TbHjry> selectByExample(TbHjryExample example);

	TbHjry selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TbHjry record, @Param("example") TbHjryExample example);

	int updateByExample(@Param("record") TbHjry record, @Param("example") TbHjryExample example);

	int updateByPrimaryKeySelective(TbHjry record);

	int updateByPrimaryKey(TbHjry record);

	List<TbHjry> selectPage(HashMap<String, Integer> map);

	List<TbHjry> selectPageByName(HashMap<String, Object> map);
	
	Integer selectLikeCount(String name);

}