package springboot.oa.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.TbDkxx;
import springboot.oa.domain.TbDkxxExample;

public interface TbDkxxMapper {
    int countByExample(TbDkxxExample example);

    int deleteByExample(TbDkxxExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDkxx record);

    int insertSelective(TbDkxx record);

    List<TbDkxx> selectByExample(TbDkxxExample example);

    TbDkxx selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDkxx record, @Param("example") TbDkxxExample example);

    int updateByExample(@Param("record") TbDkxx record, @Param("example") TbDkxxExample example);

    int updateByPrimaryKeySelective(TbDkxx record);

    int updateByPrimaryKey(TbDkxx record);

    List<TbDkxx> selectAllByPage(HashMap<String, Integer> map);
}