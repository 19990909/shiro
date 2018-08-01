package springboot.oa.controller.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springboot.oa.base.controller.BaseController;
import springboot.oa.domain.role.SysRoleFuncR;
import springboot.oa.service.role.SysRoleFuncRService;

import java.util.UUID;

/**
 * Created by Administrator on 2018/3/17.
 */
@RestController
@RequestMapping("/sysRoleFunc")
public class SysRoleFuncController extends BaseController {
    @Autowired
    SysRoleFuncRService sysRoleFuncRService;
    //添加功能角色中间表
    @CrossOrigin
    @RequestMapping(value="/addAll",method = RequestMethod.POST)
    public Object addRole(@RequestBody String req){
        SysRoleFuncR roleFuncR = null;
        try{
            roleFuncR = jsonTranster.readValue(req, SysRoleFuncR.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());

        }
        if(roleFuncR == null || StringUtils.isEmpty(roleFuncR.getRoleId())|| roleFuncR.getSysRoleFuncRList() == null){
            return addResultMapMsg(false,"参数roleId和sysRoleFuncRList不能为空");
        }
        try {
            SysRoleFuncR sysRoleFuncRReq = new SysRoleFuncR();
            sysRoleFuncRReq.setRoleId(roleFuncR.getRoleId());
            sysRoleFuncRService.deleteByObject(sysRoleFuncRReq);
            sysRoleFuncRService.addAll(roleFuncR.getSysRoleFuncRList());
            return addResultMapMsg(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,"添加失败");
        }
    }
}
