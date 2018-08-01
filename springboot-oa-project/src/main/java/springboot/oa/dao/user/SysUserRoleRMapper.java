package springboot.oa.dao.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.user.SysUserRoleR;
import springboot.oa.domain.user.SysUserRoleRExample;

public interface SysUserRoleRMapper {
    int countByExample(SysUserRoleRExample example);

    int deleteByExample(SysUserRoleRExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysUserRoleR record);

    int insertSelective(SysUserRoleR record);

    List<SysUserRoleR> selectByExample(SysUserRoleRExample example);

    SysUserRoleR selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUserRoleR record, @Param("example") SysUserRoleRExample example);

    int updateByExample(@Param("record") SysUserRoleR record, @Param("example") SysUserRoleRExample example);

    int updateByPrimaryKeySelective(SysUserRoleR record);

    int updateByPrimaryKey(SysUserRoleR record);
}