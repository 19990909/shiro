package springboot.oa.service.user;

import springboot.oa.base.service.BaseService;
import springboot.oa.domain.user.SysUserRoleR;

import java.util.List;

/**
 * Created by Administrator on 2018/3/16.
 */
public interface SysUserRoleRService extends BaseService<SysUserRoleR> {
    public void addAll(List<SysUserRoleR> roleRList) throws Exception;
    public void deleteByObject(SysUserRoleR roleR) throws Exception;
}
