package springboot.oa.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import springboot.oa.domain.user.SysUser;
import springboot.oa.service.user.SysUserService;
import springboot.oa.utils.CommonUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 验证密码是否正确
 * @author ZML
 *
 */
public class UserOAuthMatcher extends HashedCredentialsMatcher {

	@Autowired
	private SysUserService sysUserService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

		//boolean matches = super.doCredentialsMatch(token, info);
		if(token instanceof UsernamePasswordToken){
			//根据用户的登陆信息创建一个token
			UsernamePasswordToken userToken = (UsernamePasswordToken) token;
			//String accountCredentials = (String) info.getCredentials();
			Map map = new HashMap();
			map.put("username",userToken.getUsername());
			map.put("siteId", CommonUtils.ADMIN_SITE_ID);
			map.put("status",CommonUtils.USER_STATUS_OK);
			List<SysUser> userList = sysUserService.findUserRelectiveByArgs(map);
			if(userList  == null){
				return false;
			}
			SysUser user = userList.get(0);
			char[] passwordchars =userToken.getPassword();
			String password = new String(passwordchars);
			//验证令牌
			boolean res = sysUserService.passwordVerify(password,user.getPassword(),user.getId()+user.getUserName());
			return res;
		}
		return false;
    }
}
