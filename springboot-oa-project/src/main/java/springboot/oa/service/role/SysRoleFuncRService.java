package springboot.oa.service.role;

import springboot.oa.base.service.BaseService;
import springboot.oa.domain.role.SysRoleFuncR;

import java.util.List;

/**
 * Created by Administrator on 2018/3/16.
 */
public interface SysRoleFuncRService extends BaseService<SysRoleFuncR> {
    public void addAll(List<SysRoleFuncR> sysRoleFuncRList) throws Exception;
    public void deleteByObject(SysRoleFuncR funcR) throws Exception;
}
