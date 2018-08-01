package springboot.oa.service.user;

import springboot.oa.base.service.BaseService;
import springboot.oa.domain.org.SysOrg;
import springboot.oa.domain.user.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/16.
 */
public interface SysUserService extends BaseService<SysUser> {
    /**
     * 登录验证账号密码
     * @param username
     * @param password
     * @return
     */
    boolean loginVerify(String username, String password);

    /**
     * 密码校验
     * @param password
     * @param encodePassword
     * @param salt
     * @return
     */
    boolean passwordVerify(String password, String encodePassword, String salt);

    /**
     * 逻辑查询根据用户名查询用户
     * @param
     * @return
     */
    public SysUser findUserByUserNameAndStatus(Map<String,String> map);

    public List<SysUser> findUserRelectiveByArgs(Map<String,Object> map);

    public List<SysUser> selectUsersByOrg(SysOrg sysOrg);

}
