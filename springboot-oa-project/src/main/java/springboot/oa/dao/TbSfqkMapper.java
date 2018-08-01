package springboot.oa.dao;

import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.TbSfqk;
import springboot.oa.domain.TbSfqkExample;

import java.util.HashMap;
import java.util.List;

public interface TbSfqkMapper {
	long countByExample(TbSfqkExample example);

	int deleteByExample(TbSfqkExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TbSfqk record);

	int insertSelective(TbSfqk record);

	List<TbSfqk> selectByExample(TbSfqkExample example);

	TbSfqk selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TbSfqk record, @Param("example") TbSfqkExample example);

	int updateByExample(@Param("record") TbSfqk record, @Param("example") TbSfqkExample example);

	int updateByPrimaryKeySelective(TbSfqk record);

	int updateByPrimaryKey(TbSfqk record);

	List<TbSfqk> selectPage(HashMap<String, Integer> map);

	List<TbSfqk> selectPageByName(HashMap<String, Object> map);
	
	Integer selectLikeCount(String name);

}