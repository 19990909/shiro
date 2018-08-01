package springboot.oa.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.org.SysOrg;
import springboot.oa.domain.user.SysUser;
import springboot.oa.domain.user.SysUserExample;

public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    public List<SysUser> selectUserByArgs(Map<String, Object> map);

    public List<SysUser> selectUsersByOrg(SysOrg sysOrg);
}