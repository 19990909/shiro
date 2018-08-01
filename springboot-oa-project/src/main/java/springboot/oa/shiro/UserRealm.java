package springboot.oa.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import springboot.oa.domain.function.SysFunction;
import springboot.oa.domain.user.SysUser;
import springboot.oa.service.function.SysFunctionService;
import springboot.oa.service.role.SysRoleService;
import springboot.oa.service.user.SysUserService;
import springboot.oa.utils.CommonUtils;

import java.util.*;

/**
 * 验证用户登录
 * 
 * @author Administrator
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysFunctionService sysFunctionService;

	@Autowired
    SysRoleService sysRoleService;

	public UserRealm() {
		setName("UserRealm");
		// 采用MD5加密
		setCredentialsMatcher(new HashedCredentialsMatcher("md5"));
	}

	//权限资源角色
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUser user = (SysUser)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Map<String,Object> argsMap = new HashMap<String,Object>();
		argsMap.put("username",user.getUserName());
		argsMap.put("status",CommonUtils.USER_STATUS_OK);
		argsMap.put("funcType", CommonUtils.FUNC_TYPE_SYSTEM_BUTTON); //按钮
		argsMap.put("siteId",CommonUtils.ADMIN_SITE_ID);
		List<SysFunction> sysFuncList = sysFunctionService.selectSysFuncByUserName(argsMap); //获取所有按钮的功能记录
		if(sysFuncList != null){
			Set<String> permissonSet = new HashSet<String>();
			for(SysFunction func:sysFuncList){
				if(!StringUtils.isEmpty(func.getFuncUrl())){
					permissonSet.add(func.getFuncUrl());
				};
			}
			info.setStringPermissions(permissonSet);
		}
		return info;
	}
	
	//登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
        Map map = new HashMap();
        map.put("username",upt.getUsername());
        map.put("status",CommonUtils.USER_STATUS_OK);
		SysUser user = this.sysUserService.findUserByUserNameAndStatus(map);
		if(user == null){
			throw new AuthenticationException(CommonUtils.NO_USER_EXCEPTION);
		}
		map.put("siteId",CommonUtils.ADMIN_SITE_ID);
		List<String> siteIds = sysRoleService.selectSiteIdByUserName(map);
        if(siteIds == null){ //说明没有当前站点的权限
            throw new AuthenticationException(CommonUtils.NO_PERMISSION_EXCEPTION);
        }

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
				user, //用户名
				user.getPassword(), //密码
				ByteSource.Util.bytes(user.getId()+user.getUserName()),//salt=username+salt
				getName());  //realm name
		return info;
	}
}