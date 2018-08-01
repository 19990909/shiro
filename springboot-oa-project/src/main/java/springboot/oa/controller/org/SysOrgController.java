package springboot.oa.controller.org;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springboot.oa.base.controller.BaseController;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.domain.org.SysOrg;
import springboot.oa.domain.user.SysUser;
import springboot.oa.service.org.SysOrgService;
import springboot.oa.utils.ReqConfigObject;
import springboot.oa.utils.ResultRestBody;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
/*
 * Created by Administrator on 2018/4/25.
 */
@RestController
@RequestMapping("/sysOrg")
public class SysOrgController extends BaseController {

    @Autowired
    private SysOrgService sysOrgService;
    //组织的分页查询接口
    @CrossOrigin
    @RequestMapping(value="/select",method = RequestMethod.POST)
    public Object selectObject(@RequestBody String req){
        SysOrg sysOrg ;
        ReqConfigObject object ;
        try{
            sysOrg = gson.fromJson(req, SysOrg.class);
            object = gson.fromJson(req, ReqConfigObject.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(object == null || object.getPageNo()<0 || object.getPageSize() <0 || object.getPageNo() ==999999 || object.getPageSize() == 999999){
            return addResultMapMsg(false,"没有加分页条件pageNo和pageSize");
        }
        IGenericPage<SysOrg> findPage = sysOrgService.findPage(object.getPageNo(), object.getPageSize(), sysOrg, new HashMap<String, Object>());
        ResultRestBody<SysOrg> resultFpzjObject = new ResultRestBody<SysOrg>();
        resultFpzjObject.setTotalCount(findPage.getTotalCount());
        resultFpzjObject.setData(findPage.getThisPageElements());
        return resultFpzjObject;
    }


    //添加
    @CrossOrigin
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Object addSysOrg(@RequestBody String req){
        SysOrg sysOrg = null;
        try{
            sysOrg = jsonTranster.readValue(req, SysOrg.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());
        }
        if(sysOrg == null || StringUtils.isEmpty(sysOrg.getOrgName()) || StringUtils.isEmpty(sysOrg.getOrgRegionId())){
            return addResultMapMsg(false,"参数orgName和orgRegionId不能为空");
        }
        sysOrg.setId(UUID.randomUUID().toString());
        sysOrg.setCreatetime(new Date());
        sysOrg.setOrgCreateuser(getUser().getUserName());
        int add = sysOrgService.add(sysOrg);
        if(add == 0){
            return addResultMapMsg(false,"添加失败");
        }
        return addResultMapMsg(true,"添加成功");
    }

    //修改
    @CrossOrigin
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Object updateSysOrg(@RequestBody String req){
        SysOrg sysOrg = null;
        try{
            sysOrg = jsonTranster.readValue(req, SysOrg.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());

        }
        if(sysOrg == null || StringUtils.isEmpty(sysOrg.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        int update = sysOrgService.update(sysOrg);
        if(update == 0){
            return addResultMapMsg(false,"修改失败");
        }
        return addResultMapMsg(true,"修改成功");
    }


    //删除
    @CrossOrigin
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public Object deleteSysOrg(@RequestBody String req){
        SysOrg sysOrg = null;
        try{
            sysOrg = jsonTranster.readValue(req, SysOrg.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(sysOrg == null || StringUtils.isEmpty(sysOrg.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        int delete = sysOrgService.delete(sysOrg.getId().toString());
        if(delete == 0){
            return addResultMapMsg(false,"删除失败");
        }
        return addResultMapMsg(true,"删除成功");
    }

    //根据id获取
    @CrossOrigin
    @RequestMapping(value="/getById",method = RequestMethod.POST)
    public Object getById(@RequestBody String req){
        SysOrg sysOrg = null;
        try{
            sysOrg = jsonTranster.readValue(req, SysOrg.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(sysOrg == null || StringUtils.isEmpty(sysOrg.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        SysOrg returnSysOrg = sysOrgService.getById(sysOrg.getId()+"");

        if(returnSysOrg == null){
            return addResultMapMsg(false,"组织查询失败");
        }
        return addResultMapMsg(true,returnSysOrg);
    }

    @CrossOrigin
    @RequestMapping(value="/selectAllUsersByXzdw",method = RequestMethod.POST)
    public Object selectAllUsersByXzdw(@RequestBody String req){
        SysOrg sysOrg = null;
        try{
            sysOrg = jsonTranster.readValue(req, SysOrg.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(sysOrg == null || StringUtils.isEmpty(sysOrg.getOrgRegionId())){
            return addResultMapMsg(false,"orgRegionId未填入");
        }
        return null;
    }
    //查询当前用户所在的有效机构
    @CrossOrigin
    @RequestMapping(value="/getOrgByUser",method = RequestMethod.POST)
    public Object getOrgByUser(@RequestBody String req){
        SysUser sysUser = null;
        try{
            sysUser = jsonTranster.readValue(req, SysUser.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(sysUser == null || StringUtils.isEmpty(sysUser.getUserName())){
            return addResultMapMsg(false,"传入参数userName不能为空");
        }
        List<SysOrg> returnSysOrg = sysOrgService.selectSysOrgByUser(sysUser);

        if(returnSysOrg == null || returnSysOrg.isEmpty()){
            return addResultMapMsg(false,"组织查询失败");
        }
        return addResultMapMsg(true,returnSysOrg);
    }
}
