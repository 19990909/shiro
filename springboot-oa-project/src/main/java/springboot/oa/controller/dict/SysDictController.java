package springboot.oa.controller.dict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springboot.oa.base.controller.BaseController;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.domain.dict.SysDict;
import springboot.oa.service.dict.SysDictService;
import springboot.oa.utils.ReqConfigObject;
import springboot.oa.utils.ResultRestBody;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Administrator on 2018/4/25.
 */
@RestController
@RequestMapping("/sysDict")
public class SysDictController extends BaseController {

    @Autowired
    private SysDictService sysDictService;
    //功能的查询接口
    @CrossOrigin
    @RequestMapping(value="/select",method = RequestMethod.POST)
    public Object selectObject(@RequestBody String req){
        SysDict function ;
        ReqConfigObject object ;
        try{
            function = gson.fromJson(req, SysDict.class);
            object = gson.fromJson(req, ReqConfigObject.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(object == null || object.getPageNo()<0 || object.getPageSize() <0 || object.getPageNo() ==999999 || object.getPageSize() == 999999){
            return addResultMapMsg(false,"没有加分页条件pageNo和pageSize");
        }
        IGenericPage<SysDict> findPage = sysDictService.findPage(object.getPageNo(), object.getPageSize(), function, new HashMap<String, Object>());
        ResultRestBody<SysDict> resultFpzjObject = new ResultRestBody<SysDict>();
        resultFpzjObject.setTotalCount(findPage.getTotalCount());
        resultFpzjObject.setData(findPage.getThisPageElements());
        return resultFpzjObject;
    }


    //添加
    @CrossOrigin
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Object addSysDict(@RequestBody String req){
        SysDict sysDict = null;
        try{
            sysDict = jsonTranster.readValue(req, SysDict.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());
        }
        if(sysDict == null || StringUtils.isEmpty(sysDict.getDictType()) || StringUtils.isEmpty(sysDict.getDictValue())){
            return addResultMapMsg(false,"参数dictType和dictValue不能为空");
        }
        sysDict.setId(UUID.randomUUID().toString());
        sysDict.setDictCreateuser(getUser().getUserName());
        int add = sysDictService.add(sysDict);
        if(add == 0){
            return addResultMapMsg(false,"添加失败");
        }
        return addResultMapMsg(true,"添加成功");
    }

    //修改
    @CrossOrigin
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Object updateSysDict(@RequestBody String req){
        SysDict sysDict = null;
        try{
            sysDict = jsonTranster.readValue(req, SysDict.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());

        }
        if(sysDict == null || StringUtils.isEmpty(sysDict.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        int update = sysDictService.update(sysDict);
        if(update == 0){
            return addResultMapMsg(false,"修改失败");
        }
        return addResultMapMsg(true,"修改成功");
    }


    //删除
    @CrossOrigin
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public Object deleteSysDict(@RequestBody String req){
        SysDict sysDict = null;
        try{
            sysDict = jsonTranster.readValue(req, SysDict.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(sysDict == null || StringUtils.isEmpty(sysDict.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        int delete = sysDictService.delete(sysDict.getId().toString());
        if(delete == 0){
            return addResultMapMsg(false,"删除失败");
        }
        return addResultMapMsg(true,"删除成功");
    }

    //根据id获取
    @CrossOrigin
    @RequestMapping(value="/getById",method = RequestMethod.POST)
    public Object getById(@RequestBody String req){
        SysDict sysDict = null;
        try{
            sysDict = jsonTranster.readValue(req, SysDict.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(sysDict == null || StringUtils.isEmpty(sysDict.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        SysDict returnSysDict = sysDictService.getById(sysDict.getId()+"");

        if(returnSysDict == null){
            return addResultMapMsg(false,"组织查询失败");
        }
        return addResultMapMsg(true,returnSysDict);
    }
}
