package springboot.oa.dao.org;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.org.SysOrg;
import springboot.oa.domain.org.SysOrgExample;
import springboot.oa.domain.user.SysUser;

public interface SysOrgMapper {
    int countByExample(SysOrgExample example);

    int deleteByExample(SysOrgExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysOrg record);

    int insertSelective(SysOrg record);

    List<SysOrg> selectByExample(SysOrgExample example);

    SysOrg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysOrg record, @Param("example") SysOrgExample example);

    int updateByExample(@Param("record") SysOrg record, @Param("example") SysOrgExample example);

    int updateByPrimaryKeySelective(SysOrg record);

    int updateByPrimaryKey(SysOrg record);

    List<SysOrg> selectOrgByUser(SysUser sysUser);
}