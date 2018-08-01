package springboot.oa.dao.function;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.function.SysFunction;
import springboot.oa.domain.function.SysFunctionExample;

public interface SysFunctionMapper {
    int countByExample(SysFunctionExample example);

    int deleteByExample(SysFunctionExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysFunction record);

    int insertSelective(SysFunction record);

    List<SysFunction> selectByExample(SysFunctionExample example);

    SysFunction selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysFunction record, @Param("example") SysFunctionExample example);

    int updateByExample(@Param("record") SysFunction record, @Param("example") SysFunctionExample example);

    int updateByPrimaryKeySelective(SysFunction record);

    int updateByPrimaryKey(SysFunction record);

    public List<SysFunction> selectSysFuncByArgs(Map<String, Object> map);

    List<Map<String,Object>> selectIdFromPidList(SysFunction record);

    List<Map<String,Object>> selectIdAndNameList();
}