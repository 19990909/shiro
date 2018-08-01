package springboot.oa.controller.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springboot.oa.base.controller.BaseController;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.domain.role.SysRole;
import springboot.oa.domain.user.SysUser;
import springboot.oa.domain.user.SysUserRoleR;
import springboot.oa.service.role.SysRoleService;
import springboot.oa.service.user.SysUserRoleRService;
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
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController {
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysUserRoleRService sysUserRoleRService;
    //统计数据的查询接口
    @CrossOrigin
    @RequestMapping(value="/select",method = RequestMethod.POST)
    public Object selectObject(@RequestBody String req){
        SysRole role ;
        ReqConfigObject object ;
        try{
            role = gson.fromJson(req, SysRole.class);
            object = gson.fromJson(req, ReqConfigObject.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(object == null || object.getPageNo()<0 || object.getPageSize() <0 || object.getPageNo() ==999999 || object.getPageSize() == 999999){
            return addResultMapMsg(false,"没有加分页条件pageNo和pageSize");
        }
        IGenericPage<SysRole> findPage = sysRoleService.findPage(object.getPageNo(), object.getPageSize(), role, new HashMap<String, Object>());
        ResultRestBody<SysRole> resultFpzjObject = new ResultRestBody<SysRole>();
        resultFpzjObject.setTotalCount(findPage.getTotalCount());
        resultFpzjObject.setData(findPage.getThisPageElements());
        return resultFpzjObject;
    }
    //添加角色
    @CrossOrigin
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Object addRole(@RequestBody String req){
        SysRole role = null;
        try{
            role = jsonTranster.readValue(req, SysRole.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());

        }

        if(role == null || StringUtils.isEmpty(role.getRoleName()) || StringUtils.isEmpty(role.getSiteId())){
            return addResultMapMsg(false,"参数roleName和siteId不能为空");
        }
        SysUser user = getUser();
        String id = UUID.randomUUID().toString();
        role.setId(id);
        role.setCreateuser(user.getNickName());
        int add = sysRoleService.add(role);
        if(add == 0){
            return addResultMapMsg(false,"添加失败");
        }
        return addResultMapMsg(true,"添加成功");
    }

    //修改
    @CrossOrigin
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Object updateRole(@RequestBody String req){
        SysRole role = null;
        try{
            role = jsonTranster.readValue(req, SysRole.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());

        }
        if(role == null || StringUtils.isEmpty(role.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        int update = sysRoleService.update(role);
        if(update == 0){
            return addResultMapMsg(false,"修改失败");
        }
        return addResultMapMsg(true,"修改成功");
    }


    //删除
    @CrossOrigin
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public Object deleteRole(@RequestBody String req){
        SysRole role = null;
        try{
            role = jsonTranster.readValue(req, SysRole.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(role == null || StringUtils.isEmpty(role.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        try {
            sysRoleService.deleteRoleAndFunctions(role.getId().toString());
            return addResultMapMsg(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,"删除失败");
        }

    }

    //所有功能的查询接口
    @CrossOrigin
    @RequestMapping(value="/selectRoleByArgs",method = RequestMethod.POST)
    public Object selectRoleByArgs(@RequestBody String req){
        SysUserRoleR roleR = null;
        try{
            roleR = jsonTranster.readValue(req, SysUserRoleR.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());

        }
        List<SysRole> sysRoleList = sysRoleService.selectByObject(new SysRole());
        if(sysRoleList == null || sysRoleList.isEmpty()){
            return addResultMapMsg(false,"暂未查询到角色列表");
        }
        if(!StringUtils.isEmpty(roleR.getUserId())){
            SysUserRoleR userRoleR = new SysUserRoleR();
            userRoleR.setUserId(roleR.getUserId());
            Map<String,String> roleIdMap = changeMapBySysFunRole(sysUserRoleRService.selectByObject(userRoleR));
            if(!roleIdMap.isEmpty()){
                for(SysRole sysRole:sysRoleList){
                    String value = roleIdMap.get(sysRole.getId());
                    if("1".equals(value)){
                        sysRole.setRoleFlag(true);
                    }else{
                        sysRole.setRoleFlag(false);
                    }
                }
            }
        }

        return addResultMapMsg(true,sysRoleList);
    }

    public Map<String,String> changeMapBySysFunRole(List<SysUserRoleR> userRoleRList){
        Map<String,String> resultMap = new HashMap<String,String>();
        if(userRoleRList == null || userRoleRList.isEmpty()){
            return resultMap;
        }
        for(SysUserRoleR roleR:userRoleRList){
            resultMap.put(roleR.getRoleId(),"1");
        }
        return resultMap;
    }

}
