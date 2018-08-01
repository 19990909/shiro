package springboot.oa.controller.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springboot.oa.base.controller.BaseController;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.domain.function.SysFunction;
import springboot.oa.domain.role.SysRoleFuncR;
import springboot.oa.service.function.SysFunctionService;
import springboot.oa.service.role.SysRoleFuncRService;
import springboot.oa.utils.CommonUtils;
import springboot.oa.utils.ReqConfigObject;
import springboot.oa.utils.ResultRestBody;
import springboot.oa.utils.TreeUtils;

import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2018/3/17.
 */
@RestController
@RequestMapping("/sysFunction")
public class SysFunctionController extends BaseController{
    @Autowired
    SysFunctionService sysFunctionService;
    @Autowired
    SysRoleFuncRService sysRoleFuncRService;
    //功能的查询接口
    @CrossOrigin
    @RequestMapping(value="/select",method = RequestMethod.POST)
    public Object selectObject(@RequestBody String req){
        SysFunction function ;
        ReqConfigObject object ;
        try{
            function = gson.fromJson(req, SysFunction.class);
            object = gson.fromJson(req, ReqConfigObject.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(object == null || object.getPageNo()<0 || object.getPageSize() <0 || object.getPageNo() ==999999 || object.getPageSize() == 999999){
            return addResultMapMsg(false,"没有加分页条件pageNo和pageSize");
        }
        IGenericPage<SysFunction> findPage = sysFunctionService.findPage(object.getPageNo(), object.getPageSize(), function, new HashMap<String, Object>());
        ResultRestBody<SysFunction> resultFpzjObject = new ResultRestBody<SysFunction>();
        resultFpzjObject.setTotalCount(findPage.getTotalCount());
        resultFpzjObject.setData(findPage.getThisPageElements());
        return resultFpzjObject;
    }


    //所有功能的查询接口
    @CrossOrigin
    @RequestMapping(value="/selectFuncByArgs",method = RequestMethod.POST)
    public Object selectFunction(@RequestBody String req){
        SysFunction function = null;
        try{
            function = jsonTranster.readValue(req, SysFunction.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());

        }
        List<SysFunction> sysFunctionList = sysFunctionService.selectByObject(function);
        if(sysFunctionList == null || sysFunctionList.isEmpty()){
            return addResultMapMsg(false,"暂未查询到功能列表");
        }
//        Map<String,String> idAndNameMap = sysFunctionService.getIdAndName();
        Map<String,String> funcIdMap = new HashMap<String, String>();
        if(!StringUtils.isEmpty(function.getRoleId())){
            SysRoleFuncR roleFuncR = new SysRoleFuncR();
            roleFuncR.setRoleId(function.getRoleId());
            funcIdMap = changeMapBySysFunRole(sysRoleFuncRService.selectByObject(roleFuncR));

        }

        for(SysFunction sysFunction:sysFunctionList){
//            if(!idAndNameMap.isEmpty()){ //重新赋值pidName
//                String pidName = idAndNameMap.get(sysFunction.getPid());
//                sysFunction.setPidName(pidName);
//            }

            if(!funcIdMap.isEmpty()){ //用于角色授权，返回选中和不选中状态。
                String value = funcIdMap.get(sysFunction.getId());
                if("1".equals(value)){
                    sysFunction.setChecked(true);
                }else{
                    sysFunction.setChecked(false);
                }
            }

        }

        return addResultMapMsg(true,sysFunctionList);
    }

    public Map<String,String> changeMapBySysFunRole(List<SysRoleFuncR> funcRoleRS){
        Map<String,String> resultMap = new HashMap<String,String>();
        if(funcRoleRS == null || funcRoleRS.isEmpty()){
            return resultMap;
        }
        for(SysRoleFuncR roleR:funcRoleRS){
            resultMap.put(roleR.getFuncId(),"1");
        }
        return resultMap;
    }

    //添加功能
    @CrossOrigin
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Object addFunction(@RequestBody String req){
        SysFunction function = null;
        try{
            function = jsonTranster.readValue(req, SysFunction.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());

        }
        if(function == null || StringUtils.isEmpty(function.getName()) ||StringUtils.isEmpty(function.getFuncType()) || StringUtils.isEmpty(function.getPid())){
            return addResultMapMsg(false,"参数funcName、funcType和pid不能为空");
        }
        String id = UUID.randomUUID().toString();
        function.setId(id);
        function.setIsleaf(false);
        function.setIsParent(true);
        function.setOpen(false);
        int add = sysFunctionService.add(function);
        if(add == 0){
            return addResultMapMsg(false,"添加失败");
        }
        return addResultMapMsg(true,"添加成功");
    }

    //修改
    @CrossOrigin
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Object updateFunction(@RequestBody String req){
        SysFunction function = null;
        try{
            function = jsonTranster.readValue(req, SysFunction.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());

        }
        if(function == null || StringUtils.isEmpty(function.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        SysFunction dbFunc = sysFunctionService.getById(function.getId());
        if(dbFunc != null){ //为了查询pid对应功能的name
            SysFunction dbPidFunc = sysFunctionService.getById(dbFunc.getPid());
            function.setPidName(dbPidFunc.getName());
        }
        function.setIsParent(true);
        int update = sysFunctionService.update(function);
        if(update == 0){
            return addResultMapMsg(false,"修改失败");
        }
        return addResultMapMsg(true,"修改成功");
    }


    //删除
    @CrossOrigin
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public Object deleteFunction(@RequestBody String req){
        SysFunction function = null;
        try{
            function = jsonTranster.readValue(req, SysFunction.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(function == null || StringUtils.isEmpty(function.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        int delete = sysFunctionService.delete(function.getId().toString());

        if(delete == 0){
            return addResultMapMsg(false,"删除失败");
        }
        return addResultMapMsg(true,"删除成功");
    }

    //根据id获取
    @CrossOrigin
    @RequestMapping(value="/getById",method = RequestMethod.POST)
    public Object getByIdFunction(@RequestBody String req){
        SysFunction function = null;
        try{
            function = jsonTranster.readValue(req, SysFunction.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(function == null || StringUtils.isEmpty(function.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        SysFunction functionResult = sysFunctionService.getById(function.getId());

        if(functionResult == null){
            return addResultMapMsg(false,"查询详情失败");
        }
        String pid = functionResult.getPid();
        if(!"1".equals(pid)) { //如果不是菜单管理，则去查询下pid记录，拿到它的名字，赋值给当前的这条记录
            SysFunction function1 = sysFunctionService.getById(pid);
            functionResult.setPidName(function1.getName());
        }
        return addResultMapMsg(true,functionResult);
    }


    //删除自己，及下级功能
    @CrossOrigin
    @RequestMapping(value="/deleteToLeaf",method = RequestMethod.POST)
    public Object deleteFunctionAllLeaf(@RequestBody String req){
        SysFunction function = null;
        try{
            function = jsonTranster.readValue(req, SysFunction.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(function == null || StringUtils.isEmpty(function.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        List<String> rosList = new ArrayList<String>();
        rosList.add(function.getId());
        List<String> reqList = new ArrayList<String>();
        reqList.add(function.getId());
        try {
            List<String> resultList = sysFunctionService.selectFunctionAllLeaf(rosList,reqList);
            sysFunctionService.deleteFunctionAllLeaf(resultList);
            return addResultMapMsg(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,"删除失败");
        }
    }


    @CrossOrigin
    @RequestMapping(value="/getMenus",method= RequestMethod.POST)
    public Object addTempCaptials(@RequestBody String req) {
        Map map;
        try {
            map = jsonTranster.readValue(req, Map.class);
        } catch (IOException e) {
            return addResultMapMsg(false, e.getMessage());
        }
        Object object = map.get("username");
        if (object == null) {
            return addResultMapMsg(false, "未传入username");
        }
        String username = object.toString();
        Map<String,Object> argsMap = new HashMap<String,Object>();
        argsMap.put("username",username);
        argsMap.put("siteId", CommonUtils.ADMIN_SITE_ID);
        List<SysFunction> sysFuncList = sysFunctionService.selectSysFuncByUserName(argsMap);
        if(sysFuncList.isEmpty()){
            return addResultMapMsg(false,sysFuncList);
        }
        Map<String,Object> resultMap =  new HashMap<String,Object>();
        List<SysFunction> funcsMkAndGn = new ArrayList<SysFunction>(); //模块和功能都放进去
        List<SysFunction> funcsMk = new ArrayList<SysFunction>(); //功能
//        List<SysFunc> funcsCz = new ArrayList<SysFunc>(); //操作
        for(SysFunction func:sysFuncList){
            if("1".equals(func.getFuncType())){
                resultMap.put("sysTitle",func);
            }else if("2".equals(func.getFuncType()) || "3".equals(func.getFuncType())){
                funcsMkAndGn.add(func);
            }
        }

        for(SysFunction func:funcsMkAndGn){
            if("2".equals(func.getFuncType())){

                TreeUtils.createTree(funcsMkAndGn,func,"id","pid","sysFuncList");
                funcsMk.add(func);
            }
        }
        resultMap.put("sysModel",funcsMk);
        return addResultMapMsg(true,resultMap);
    }
}
