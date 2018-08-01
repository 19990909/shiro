package springboot.oa.dao.org;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.org.SysOrgUserR;
import springboot.oa.domain.org.SysOrgUserRExample;

public interface SysOrgUserRMapper {
    int countByExample(SysOrgUserRExample example);

    int deleteByExample(SysOrgUserRExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysOrgUserR record);

    int insertSelective(SysOrgUserR record);

    List<SysOrgUserR> selectByExample(SysOrgUserRExample example);

    SysOrgUserR selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysOrgUserR record, @Param("example") SysOrgUserRExample example);

    int updateByExample(@Param("record") SysOrgUserR record, @Param("example") SysOrgUserRExample example);

    int updateByPrimaryKeySelective(SysOrgUserR record);

    int updateByPrimaryKey(SysOrgUserR record);
}