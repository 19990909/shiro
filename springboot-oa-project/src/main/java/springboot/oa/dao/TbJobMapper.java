package springboot.oa.dao;

import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.TbJob;
import springboot.oa.domain.TbJobExample;

import java.util.HashMap;
import java.util.List;

public interface TbJobMapper {
    long countByExample(TbJobExample example);

    int deleteByExample(TbJobExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbJob record);

    int insertSelective(TbJob record);

    List<TbJob> selectByExample(TbJobExample example);

    TbJob selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbJob record, @Param("example") TbJobExample example);

    int updateByExample(@Param("record") TbJob record, @Param("example") TbJobExample example);

    int updateByPrimaryKeySelective(TbJob record);

    int updateByPrimaryKey(TbJob record);
    
    List<TbJob> selectPage(HashMap<String, Integer> map);

	List<TbJob> selectPageByName(HashMap<String, Object> map);
}