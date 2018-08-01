package springboot.oa.dao.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import springboot.oa.domain.user.SysUserMessage;
import springboot.oa.domain.user.SysUserMessageExample;

public interface SysUserMessageMapper {
    int countByExample(SysUserMessageExample example);

    int deleteByExample(SysUserMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUserMessage record);

    int insertSelective(SysUserMessage record);

    List<SysUserMessage> selectByExample(SysUserMessageExample example);

    SysUserMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUserMessage record, @Param("example") SysUserMessageExample example);

    int updateByExample(@Param("record") SysUserMessage record, @Param("example") SysUserMessageExample example);

    int updateByPrimaryKeySelective(SysUserMessage record);

    int updateByPrimaryKey(SysUserMessage record);
}