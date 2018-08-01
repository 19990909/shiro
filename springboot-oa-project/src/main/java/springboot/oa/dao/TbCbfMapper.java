package springboot.oa.dao;

import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.TbCbf;
import springboot.oa.domain.TbCbfExample;

import java.util.HashMap;
import java.util.List;

public interface TbCbfMapper {
    long countByExample(TbCbfExample example);

    int deleteByExample(TbCbfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbCbf record);

    int insertSelective(TbCbf record);

    List<TbCbf> selectByExample(TbCbfExample example);

    TbCbf selectByPrimaryKey(Integer id);

        int updateByExampleSelective(@Param("record") TbCbf record, @Param("example") TbCbfExample example);

    int updateByExample(@Param("record") TbCbf record, @Param("example") TbCbfExample example);

    int updateByPrimaryKeySelective(TbCbf record);

    int updateByPrimaryKey(TbCbf record);

    List<TbCbf> selectPage(HashMap<String, Integer> map);

    List<TbCbf> selectPageByName(HashMap<String, Object> map);

    Integer selectLikeCount(String name);

}