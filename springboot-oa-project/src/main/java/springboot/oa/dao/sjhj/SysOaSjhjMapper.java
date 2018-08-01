package springboot.oa.dao.sjhj;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.sjhj.SysOaSjhj;
import springboot.oa.domain.sjhj.SysOaSjhjExample;

public interface SysOaSjhjMapper {
    int countByExample(SysOaSjhjExample example);

    int deleteByExample(SysOaSjhjExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysOaSjhj record);

    int insertSelective(SysOaSjhj record);

    List<SysOaSjhj> selectByExample(SysOaSjhjExample example);

    SysOaSjhj selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysOaSjhj record, @Param("example") SysOaSjhjExample example);

    int updateByExample(@Param("record") SysOaSjhj record, @Param("example") SysOaSjhjExample example);

    int updateByPrimaryKeySelective(SysOaSjhj record);

    int updateByPrimaryKey(SysOaSjhj record);
}