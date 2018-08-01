package springboot.oa.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springboot.oa.base.controller.BaseController;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.domain.org.SysOrg;
import springboot.oa.domain.user.SysUser;
import springboot.oa.service.user.SysUserService;
import springboot.oa.utils.CommonUtils;
import springboot.oa.utils.PasswordUtil;
import springboot.oa.utils.ReqConfigObject;
import springboot.oa.utils.ResultRestBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/**
 * Created by Administrator on 2018/3/17.
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {
    @Autowired
    SysUserService sysUserService;
    //统计数据的查询接口
    @CrossOrigin
    @RequestMapping(value="/select",method = RequestMethod.POST)
    public Object selectObject(@RequestBody String req){
        SysUser user ;
        ReqConfigObject object ;
        try{
            user = gson.fromJson(req, SysUser.class);
            object = gson.fromJson(req, ReqConfigObject.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(object == null || object.getPageNo()<0 || object.getPageSize() <0 || object.getPageNo() ==999999 || object.getPageSize() == 999999){
            return addResultMapMsg(false,"没有加分页条件pageNo和pageSize");
        }
        IGenericPage<SysUser> findPage = sysUserService.findPage(object.getPageNo(), object.getPageSize(), user, new HashMap<String, Object>());
        ResultRestBody<SysUser> resultFpzjObject = new ResultRestBody<SysUser>();
        resultFpzjObject.setTotalCount(findPage.getTotalCount());
        resultFpzjObject.setData(findPage.getThisPageElements());
        return resultFpzjObject;
    }

    //添加用户
    @CrossOrigin
    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    public Object addUser(@RequestBody String req){
        SysUser user = null;
        try{
            user = jsonTranster.readValue(req, SysUser.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());

        }
        if(user == null || StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())){
            return addResultMapMsg(false,"参数userName和password不能为空");
        }
        SysUser userNow = getUser();
        String id = UUID.randomUUID().toString();
        String encodePassword = new PasswordUtil().encodePassword(user.getPassword(),id+user.getUserName());
        user.setId(id);
        user.setPassword(encodePassword);
        user.setCreateuser(userNow.getNickName());
        int add = sysUserService.add(user);
        if(add == 0){
            return addResultMapMsg(false,"添加失败");
        }
        return addResultMapMsg(true,"添加成功");
    }

    //修改
    @CrossOrigin
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Object updateUser(@RequestBody String req){
        SysUser user = null;
        try{
            user = jsonTranster.readValue(req, SysUser.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());

        }
        if(user == null || StringUtils.isEmpty(user.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        if(!StringUtils.isEmpty(user.getUserName())){ //修改用户名
            SysUser checkUser = new SysUser();
            checkUser.setUserName(user.getUserName());
            List<SysUser> userList = sysUserService.selectByObject(checkUser);
            if(userList != null && !userList.isEmpty()){
                SysUser sysNowUser = sysUserService.getById(user.getId());
                if(!user.getUserName().equals(sysNowUser.getUserName())){
                    return addResultMapMsg(false,"当前用户已占用");
                }
            }
        }
        if(!StringUtils.isEmpty(user.getPassword())){ //修改密码
            String encodePassword = new PasswordUtil().encodePassword(user.getPassword(),user.getId()+user.getUserName());
            user.setPassword(encodePassword);
        }
        int update = sysUserService.update(user);
        if(update == 0){
            return addResultMapMsg(false,"修改失败");
        }
        return addResultMapMsg(true,"修改成功");
    }


    //删除
    @CrossOrigin
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public Object deleteUser(@RequestBody String req){
        SysUser user = null;
        try{
            user = jsonTranster.readValue(req, SysUser.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(user == null || StringUtils.isEmpty(user.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        int delete = sysUserService.delete(user.getId().toString());
        if(delete == 0){
            return addResultMapMsg(false,"删除失败");
        }
        return addResultMapMsg(true,"删除成功");
    }

    //删除
    @CrossOrigin
    @RequestMapping(value="/getById",method = RequestMethod.POST)
    public Object getById(@RequestBody String req){
        SysUser user = null;
        try{
            user = jsonTranster.readValue(req, SysUser.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(user == null || StringUtils.isEmpty(user.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        SysUser returnUser = sysUserService.getById(user.getId());

        if(returnUser == null){
            return addResultMapMsg(false,"用户查询失败");
        }
        return addResultMapMsg(true,returnUser);
    }

    //返回用户名
    @CrossOrigin
    @RequestMapping(value="/getAllUsersInCurr",method = RequestMethod.GET)
    public Object getAllUsersInCurr(){
        Map reqMap = new HashMap();
        reqMap.put("status", CommonUtils.USER_STATUS_OK);
        reqMap.put("siteId",CommonUtils.ADMIN_SITE_ID);
        List<SysUser> sysUserList = sysUserService.findUserRelectiveByArgs(reqMap);
        if(sysUserList == null || sysUserList.isEmpty()){
            return addResultMapMsg(false,"当前系统下无可发送消息的用户");
        }
        return addResultMapMsg(true,sysUserList);
    }

    //检查用户是否存在
    @CrossOrigin
    @RequestMapping(value="/checkUser",method = RequestMethod.POST)
    public Object checkUser(@RequestBody String req){
        SysUser user = null;
        try{
            user = jsonTranster.readValue(req, SysUser.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(user == null || StringUtils.isEmpty(user.getUserName())){
            return addResultMapMsg(false,"传入userName不能为空");
        }
        List<SysUser> sysUserList = sysUserService.selectByObject(user);

        if(sysUserList == null || sysUserList.isEmpty()){
            return addResultMapMsg(true,"当前用户名可以使用");
        }
        return addResultMapMsg(false,"当前用户名已存在");
    }

    //根据组织机构id返回组织下的用户
    @CrossOrigin
    @RequestMapping(value="/selectUsersByOrg",method = RequestMethod.POST)
    public Object selectUsersByOrg(@RequestBody String req){
        SysOrg sysOrg = null;
        try{
            sysOrg = jsonTranster.readValue(req, SysOrg.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(sysOrg == null || StringUtils.isEmpty(sysOrg.getId())){
            return addResultMapMsg(false,"传入组织机构id不能为空");
        }
        List<SysUser> sysUserList = sysUserService.selectUsersByOrg(sysOrg);

        if(sysUserList == null || sysUserList.isEmpty()){
            return addResultMapMsg(true,"查询失败");
        }
        return addResultMapMsg(false,sysUserList);
    }
}
