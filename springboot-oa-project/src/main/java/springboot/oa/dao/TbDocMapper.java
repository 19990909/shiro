package springboot.oa.dao;

import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.TbDoc;
import springboot.oa.domain.TbDocExample;

import java.util.List;


public interface TbDocMapper {
    long countByExample(TbDocExample example);

    int deleteByExample(TbDocExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDoc record);

    int insertSelective(TbDoc record);

    List<TbDoc> selectByExampleWithBLOBs(TbDocExample example);

    List<TbDoc> selectByExample(TbDocExample example);

    TbDoc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDoc record, @Param("example") TbDocExample example);

    int updateByExampleWithBLOBs(@Param("record") TbDoc record, @Param("example") TbDocExample example);

    int updateByExample(@Param("record") TbDoc record, @Param("example") TbDocExample example);

    int updateByPrimaryKeySelective(TbDoc record);

    int updateByPrimaryKeyWithBLOBs(TbDoc record);

    int updateByPrimaryKey(TbDoc record);
}