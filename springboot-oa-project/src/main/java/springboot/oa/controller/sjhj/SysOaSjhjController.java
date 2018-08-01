package springboot.oa.controller.sjhj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springboot.oa.base.controller.BaseController;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.domain.sjhj.SysOaSjhj;
import springboot.oa.service.sjhj.SysOaSjhjService;
import springboot.oa.utils.ExcelByPOI;
import springboot.oa.utils.ReqConfigObject;
import springboot.oa.utils.ResultRestBody;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
/**
 * Created by Administrator on 2018/3/25.
 */
@RestController
@RequestMapping("/sjhj")
public class SysOaSjhjController extends BaseController {
    @Autowired
    SysOaSjhjService sysOaSjhjService;
    //统计数据的查询接口
    @CrossOrigin
    @RequestMapping(value="/select",method = RequestMethod.POST)
    public Object selectObject(@RequestBody String req){
       
        SysOaSjhj sjhj ;
        ReqConfigObject object ;
        try{
            sjhj = gson.fromJson(req, SysOaSjhj.class);
            object = gson.fromJson(req, ReqConfigObject.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(object == null || object.getPageNo()<0 || object.getPageSize() <0 || object.getPageNo() ==999999 || object.getPageSize() == 999999){
            return addResultMapMsg(false,"没有加分页条件pageNo和pageSize");
        }
        IGenericPage<SysOaSjhj> findPage = sysOaSjhjService.findPage(object.getPageNo(), object.getPageSize(), sjhj, new HashMap<String, Object>());
        ResultRestBody<SysOaSjhj> resultFpzjObject = new ResultRestBody<SysOaSjhj>();
        resultFpzjObject.setTotalCount(findPage.getTotalCount());
        resultFpzjObject.setData(findPage.getThisPageElements());
        return resultFpzjObject;
    }

    //添加
    @CrossOrigin
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Object addUser(@RequestBody String req){
        SysOaSjhj sjhj = null;
        try{
            sjhj = jsonTranster.readValue(req, SysOaSjhj.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());

        }
        if(sjhj == null || StringUtils.isEmpty(sjhj.getHjrxmId()) || StringUtils.isEmpty(sjhj.getHjjzdmId())){
            return addResultMapMsg(false,"参数hjrxmId和hjjzdmId不能为空");
        }
        sjhj.setHjsj(new Date());
        int add = sysOaSjhjService.add(sjhj);
        if(add == 0){
            return addResultMapMsg(false,"添加失败");
        }
        return addResultMapMsg(true,"添加成功");
    }

    //修改
    @CrossOrigin
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Object updateUser(@RequestBody String req){
        SysOaSjhj sjhj = null;
        try{
            sjhj = jsonTranster.readValue(req, SysOaSjhj.class);
        }catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false,e.getMessage());

        }
        if(sjhj == null || StringUtils.isEmpty(sjhj.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        int update = sysOaSjhjService.update(sjhj);
        if(update == 0){
            return addResultMapMsg(false,"修改失败");
        }
        return addResultMapMsg(true,"修改成功");
    }


    //删除
    @CrossOrigin
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public Object deleteUser(@RequestBody String req){
        SysOaSjhj sjhj = null;
        try{
            sjhj = jsonTranster.readValue(req, SysOaSjhj.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(sjhj == null || StringUtils.isEmpty(sjhj.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        int delete = sysOaSjhjService.delete(sjhj.getId().toString());
        if(delete == 0){
            return addResultMapMsg(false,"删除失败");
        }
        return addResultMapMsg(true,"删除成功");
    }

    //根据id获取
    @CrossOrigin
    @RequestMapping(value="/getById",method = RequestMethod.POST)
    public Object getById(@RequestBody String req){
        SysOaSjhj sjhj = null;
        try{
            sjhj = jsonTranster.readValue(req, SysOaSjhj.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(sjhj == null || StringUtils.isEmpty(sjhj.getId())){
            return addResultMapMsg(false,"传入参数id不能为空");
        }
        SysOaSjhj returnUser = sysOaSjhjService.getById(sjhj.getId()+"");

        if(returnUser == null){
            return addResultMapMsg(false,"用户查询失败");
        }
        return addResultMapMsg(true,returnUser);
    }

    //数据汇交数据导出
    @CrossOrigin
    @RequestMapping(value="/downloadFile",method = RequestMethod.GET)
    public Object getById(){
        SysOaSjhj sysOaSjhj = new SysOaSjhj();
        List<SysOaSjhj> sysOaSjhjList = sysOaSjhjService.selectByObject(sysOaSjhj);

        if(sysOaSjhjList == null || sysOaSjhjList.isEmpty()){
            return addResultMapMsg(false,"暂无数据导出");
        }
        File file = getFileFromResources("classpath:excelmodel/sjhjModel.xlsx");
        if(file == null){
            return addResultMapMsg(false,"模板文件未找到");
        }
        int i = 1;
        List<String[]> dataList = new ArrayList<String[]>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(SysOaSjhj sysOaSjhj1:sysOaSjhjList){
            String dataStr = i +"/"+ sysOaSjhj1.getProvinceCode() +"/"+ sysOaSjhj1.getProname() +"/"+
                    sysOaSjhj1.getCityCode() +"/"+ sysOaSjhj1.getCityname() +"/"+ sysOaSjhj1.getHjrxm()
                    +"/"+ sysOaSjhj1.getHjjzdm() +"/"+ ((sysOaSjhj1.getHjsj() != null)?sdf.format(sysOaSjhj1.getHjsj()):"暂无");
            dataList.add(dataStr.split("/"));
            i++;
        }
        String datePartern = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileRelPath = "/sjhj/" + datePartern.substring(0,8) + "/" + datePartern + "_sjhj.xlsx";
        boolean createExcel = ExcelByPOI.writeInModelExcelForSjhj(file,uploadBaseUrl+fileRelPath,dataList,4,0);
        if(createExcel){
            return addResultMapMsg(true,downpath+fileRelPath);
        }
        return addResultMapMsg(false,"导出失败");
    }


}
