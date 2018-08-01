package springboot.oa.service.org;

import springboot.oa.base.service.BaseService;
import springboot.oa.domain.org.SysOrg;
import springboot.oa.domain.user.SysUser;
import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */
public interface SysOrgService extends BaseService<SysOrg> {

    public List<SysOrg> selectSysOrgByUser(SysUser user);
}
