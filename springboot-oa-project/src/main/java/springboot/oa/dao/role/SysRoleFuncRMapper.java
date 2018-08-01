package springboot.oa.dao.role;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.role.SysRoleFuncR;
import springboot.oa.domain.role.SysRoleFuncRExample;

public interface SysRoleFuncRMapper {
    int countByExample(SysRoleFuncRExample example);

    int deleteByExample(SysRoleFuncRExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysRoleFuncR record);

    int insertSelective(SysRoleFuncR record);

    List<SysRoleFuncR> selectByExample(SysRoleFuncRExample example);

    SysRoleFuncR selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysRoleFuncR record, @Param("example") SysRoleFuncRExample example);

    int updateByExample(@Param("record") SysRoleFuncR record, @Param("example") SysRoleFuncRExample example);

    int updateByPrimaryKeySelective(SysRoleFuncR record);

    int updateByPrimaryKey(SysRoleFuncR record);
}