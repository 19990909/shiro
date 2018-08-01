package springboot.oa.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springboot.oa.base.controller.BaseController;
import springboot.oa.domain.user.SysUserRoleR;
import springboot.oa.service.user.SysUserRoleRService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/3/17.
 */
@RestController
@RequestMapping("/sysUserRole")
public class SysUserRoleRController extends BaseController {
    @Autowired
    SysUserRoleRService sysUserRoleRService;

    //添加功能角色中间表
    @CrossOrigin
    @RequestMapping(value="/addAll",method = RequestMethod.POST)
    public Object addRole(@RequestBody String req){
        SysUserRoleR userRoleR = null;
        try{
            userRoleR = jsonTranster.readValue(req, SysUserRoleR.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());

        }
        if(userRoleR == null || StringUtils.isEmpty(userRoleR.getUserId())|| userRoleR.getListSysUserRoleR() == null){
            return addResultMapMsg(false,"参数userId和listSysUserRoleR不能为空");
        }
        try {
            SysUserRoleR userRoleRReq = new SysUserRoleR();
            userRoleRReq.setUserId(userRoleR.getUserId());
            sysUserRoleRService.deleteByObject(userRoleRReq);
            List<SysUserRoleR> sysUserRoleRList = new ArrayList<SysUserRoleR>();
            for(String roleId:userRoleR.getListSysUserRoleR()){
                SysUserRoleR userRole = new SysUserRoleR();
                userRole.setId(UUID.randomUUID().toString());
                userRole.setUserId(userRoleR.getUserId());
                userRole.setRoleId(roleId);
                sysUserRoleRList.add(userRole);
            }
            sysUserRoleRService.addAll(sysUserRoleRList);
            return addResultMapMsg(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,"添加失败");
        }
    }

}
