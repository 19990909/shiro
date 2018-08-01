package springboot.oa.service.user;


import springboot.oa.base.service.BaseService;
import springboot.oa.domain.user.SysUserMessage;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface SysUserMessageService extends BaseService<SysUserMessage> {
    public String addReturnId(SysUserMessage gzxx);
    public Integer updateByIds(SysUserMessage gzxx, List<Integer> ids);
    public List<SysUserMessage> getSysUserMessage(List<Integer> ids);


    public Integer addAllSjrSendMsg(SysUserMessage gzxx)  throws Exception;

    public Integer updateSysUserMessageList(List<SysUserMessage> gzxxList) throws Exception;

    public Integer reductSysUserMessageList(List<SysUserMessage> gzxxList) throws Exception;

    public Integer deleteSysUserMessageList(List<Integer> ids) throws Exception;

    public Integer changeSysUserMessageList(SysUserMessage gzxx)  throws Exception;
}
