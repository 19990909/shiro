package springboot.oa.service.role;

import springboot.oa.base.service.BaseService;
import springboot.oa.domain.role.SysRole;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/16.
 */
public interface SysRoleService extends BaseService<SysRole> {

    /**
     * 根据用户名和站点，获取数据，如果没有获取到数据，说明当前用户不具有当前站点的登录权限
     * @param map
     * @return
     */
    List<String> selectSiteIdByUserName(Map<String,Object> map);

    public void deleteRoleAndFunctions(String roleId) throws Exception;

}
