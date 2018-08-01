package springboot.oa.shiro.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springboot.oa.base.controller.BaseController;
import springboot.oa.domain.user.SysUser;
import springboot.oa.service.user.SysUserService;
import springboot.oa.utils.CommonUtils;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller //如果用RestController，比如login.html就会只显示值，必须用controller注解才可以显示页面
public class LoginCheckController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(LoginCheckController.class);

	@Autowired
	private SysUserService sysUserService;

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
		return "login";
    }

    /**
     * 本地登录页面账户密码提交验证ajax请求方式
     * @param
     * @return
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    @RequestMapping(value="/loginVerify",method=RequestMethod.POST)
	@ResponseBody
    public Object loginForm(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
			return addResultMapMsg(false,"用户名和密码不能为空");
		}
    	UsernamePasswordToken upt = new UsernamePasswordToken(username,password);
    	Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(upt);
		} catch (Exception e) {
			if(CommonUtils.NO_PERMISSION_EXCEPTION.equals(e.getMessage())){
				return addResultMapMsg(false,"当前用户无当前系统登录权限");
			}
			if(CommonUtils.NO_USER_EXCEPTION.equals(e.getMessage())){
				return addResultMapMsg(false,"用户不存在");
			}
			return addResultMapMsg(false,"密码错误");
		}
		Session session = subject.getSession();
		Map map = new HashMap();
		map.put("username",username);
		map.put("status",CommonUtils.USER_STATUS_OK);
		SysUser user = this.sysUserService.findUserByUserNameAndStatus(map);
		user.setPassword("");
		session.setAttribute(CommonUtils.SESSION_USER, user);
		return addResultMapMsg(true,"登录成功");
    }

    /**
     * 登录首页
     * @return
     */
    @RequestMapping(value={"/homeIndex","/"},method=RequestMethod.GET)
	public String home(HttpServletRequest request){
    	SysUser user = (SysUser) request.getSession().getAttribute(CommonUtils.SESSION_USER);
    	if(user == null){
    		return "login";
		}
		return "index";
	}
 
    /**
     * 本地登出页面
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes ){ 
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
    	Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {  
        	subject.logout();  
        }
		return "redirect:/login";
    }
}
