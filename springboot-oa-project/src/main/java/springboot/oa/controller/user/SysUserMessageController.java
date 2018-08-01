package springboot.oa.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import springboot.oa.base.controller.BaseController;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.domain.user.SysUserMessage;
import springboot.oa.service.user.SysUserMessageService;
import springboot.oa.utils.ReqConfigObject;
import springboot.oa.utils.ResultRestBody;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2017/9/21.
 */
@RestController
@RequestMapping("/message")
public class SysUserMessageController extends BaseController {
    @Autowired
    SysUserMessageService sysUserMessageService;
    /**
     * 工作信箱发送
     * @param
     * @return
     */
    @Value("${file.upload.downpath}")
    private String downPath;
    @CrossOrigin
    @RequestMapping(value= "/send" ,method= RequestMethod.POST )
    public Object sendSysUserMessage(HttpServletRequest request){
        String id = request.getParameter("id"); //主键
        String sjr =  request.getParameter("sjr");
        String zt =  request.getParameter("zt"); //主题
        String zw =  request.getParameter("zw"); //正文
//        String xxlb = sq.getXxlb(); //信箱类别，1发件箱，2草稿箱，3回收站
        if(StringUtils.isEmpty(sjr)){
            return addResultMapMsg(false,"收件人不能为空");
        }
        if(StringUtils.isEmpty(zt) || StringUtils.isEmpty(zw)){
            return addResultMapMsg(false,"主题和正文不能为空");
        }
        SysUserMessage sq = new SysUserMessage();
        String uploadFileUrl = "";
        if(!StringUtils.isEmpty(id)){
            /**
             * 这里出现一个bug，如果草稿箱中带有附件的邮件，什么也没有操作，如果发送走
             * 进该接口，直接走下边的删除，会删掉附件，所以这里先把附件拿出来
             */
            SysUserMessage dbBagMessag = sysUserMessageService.getById(id);
            uploadFileUrl = dbBagMessag.getUploadpath();
            sq.setUploadpath(uploadFileUrl);
            sysUserMessageService.delete(id); //如果草稿箱中发送，则需要传入id,根据id来删除草稿箱的记录，重新建立一条
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> fileList = multipartRequest.getFiles("file");
        if(fileList != null && fileList.size() != 0 && !StringUtils.isEmpty(fileList.get(0).getOriginalFilename())){
            try {
                uploadFileUrl = saveFileToNative("message",fileList.get(0));
                if(StringUtils.isEmpty(uploadFileUrl)){
                    return addResultMapMsg(false,"上传文件失败");
                }
                sq.setUploadpath(downPath+uploadFileUrl);
            } catch (Exception e) {
                e.printStackTrace();
                return addResultMapMsg(false,e.getMessage());
            }
        }
        sq.setSjr(sjr);
        sq.setZt(zt);
        sq.setZw(zw);
        sq.setFszt("1"); //已发送 //发送状态，0未发送，1已发送，2发送失败
        sq.setFjr(getUser().getUserName());
        sq.setDqzt("0"); //读取状态，0未读，1已读
        sq.setFssj(new Date()); //发送时间
        Integer add = null;
        try {
            add = sysUserMessageService.addAllSjrSendMsg(sq);
        } catch (Exception e) {
            e.printStackTrace();
            return addResultMapMsg(false, "发送失败");
        }
        if(add==null || add == 0){
            return addResultMapMsg(false, "发送失败");
        }
        return addResultMapMsg(true, "发送成功");
    }

    /**
     * 工作信箱草稿箱保存
     * @param
     * @return
     */
    @CrossOrigin
    @RequestMapping(value= "/saveInBag" ,method= RequestMethod.POST )
    public Object saveInBagSysUserMessage(HttpServletRequest request){
        String id = request.getParameter("id"); //主键
        String sjr =  request.getParameter("sjr");
        String zt =  request.getParameter("zt"); //主题
        String zw =  request.getParameter("zw"); //正文
        if(StringUtils.isEmpty(sjr) && StringUtils.isEmpty(zt) && StringUtils.isEmpty(zw)){
            return addResultMapMsg(false,"不能保存参数为空的信息");
        }
        SysUserMessage sq = new SysUserMessage();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> fileList = multipartRequest.getFiles("file");
        String uploadFileUrl ="";
        if(fileList != null && fileList.size() != 0 && !StringUtils.isEmpty(fileList.get(0).getOriginalFilename())){
            try {
                uploadFileUrl = saveFileToNative("message",fileList.get(0));
                if(StringUtils.isEmpty(uploadFileUrl)){
                    return addResultMapMsg(false,"上传文件失败");
                }
                sq.setUploadpath(downPath+uploadFileUrl);
            } catch (Exception e) {
                e.printStackTrace();
                return addResultMapMsg(false,e.getMessage());
            }
        }

        sq.setSjr(sjr);
        sq.setZt(zt);
        sq.setZw(zw);
        sq.setBy3("1"); //发件人记录标志
        sq.setXxlb("2");  //信箱类别，1发件箱，2草稿箱，3回收站
        sq.setFszt("0"); //已发送 //发送状态，0未发送，1已发送，2发送失败
        sq.setFjr(getUser().getUserName());
        sq.setDqzt("0"); //读取状态，0未读，1已读
        sq.setFssj(new Date()); //发送时间
        if(StringUtils.isEmpty(id)){
            Integer add = sysUserMessageService.add(sq);
            if(add==null || add == 0){
                return addResultMapMsg(false, "添加失败");
            }
            return addResultMapMsg(true, "添加成功");
        }else{
            Integer upload = sysUserMessageService.update(sq);
            if(upload==null || upload == 0){
                return addResultMapMsg(false, "修改失败");
            }
            return addResultMapMsg(true,"添加成功");
        }
    }
    /**
     * 工作信箱的逻辑删除，到回收站等
     * by4为当前用户名，by5为当前邮件位置，用于将来可以恢复邮件，后台能知道要改回哪个位置
     * {"by4":"username","by5":"1","id":"3"，“xxlb”:"3"}
     * @param req
     * @return
     */
    @CrossOrigin
    @RequestMapping(value= "/update" ,method= RequestMethod.POST )
    public Object updateSysUserMessage(@RequestBody String req){
        SysUserMessage sq;
        try {
            sq = jsonTranster.readValue(req, SysUserMessage.class);
        } catch (IOException e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(sq == null || sq.getUserMessageList() == null){
            return addResultMapMsg(false,"传入参数userMessageList不能为空");
        }

        int update = 0;
        try {
            update = sysUserMessageService.updateSysUserMessageList(sq.getUserMessageList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(update == 0){
            return addResultMapMsg(false, "修改失败");
        }
        return addResultMapMsg(true, "修改成功");
    }

    /**
     * 工作信箱的删除
     * @param req
     * @return
     */
    @CrossOrigin
    @RequestMapping(value= "/delete" ,method= RequestMethod.POST )
    public Object deleteSysUserMessage(@RequestBody String req){
        SysUserMessage sq;
        try {
            sq = jsonTranster.readValue(req, SysUserMessage.class);
        } catch (IOException e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(sq == null || sq.getIds() == null){
            return addResultMapMsg(false,"传入参数、ids不能为空");
        }
        int delete = 0;
        try {
            delete = sysUserMessageService.deleteSysUserMessageList(sq.getIds());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(delete == 0){
            return addResultMapMsg(false, "删除失败");
        }
        return addResultMapMsg(true, "删除成功");
    }

    /**
     * 工作信箱的查询
     * @param req
     * @return
     */
    @CrossOrigin
    @RequestMapping(value= "/select" ,method= RequestMethod.POST )
    public Object selectSysUserMessage(@RequestBody String req){
        SysUserMessage sq;
        ReqConfigObject object ;
        try{
            sq = gson.fromJson(req, SysUserMessage.class);
            object = gson.fromJson(req, ReqConfigObject.class);
        }catch (Exception e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(object == null || object.getPageNo()<0 || object.getPageSize() <0 || object.getPageNo() ==999999 || object.getPageSize() == 999999){
            return addResultMapMsg(false,"没有加分页条件pageNo和pageSize");
        }
        IGenericPage<SysUserMessage> findPage = sysUserMessageService.findPage(object.getPageNo(), object.getPageSize(), sq, new HashMap<String,Object>());
        ResultRestBody<SysUserMessage> resultFpzjObject = new ResultRestBody<SysUserMessage>();
        resultFpzjObject.setTotalCount(findPage.getTotalCount());
        resultFpzjObject.setData(findPage.getThisPageElements());
        return resultFpzjObject;
    }

    /**
     * 工作信箱的垃圾桶还原功能
     * @param req
     * @return
     */
    @CrossOrigin
    @RequestMapping(value= "/reduct" ,method= RequestMethod.POST )
    public Object reductSysUserMessage(@RequestBody String req){
        SysUserMessage sq;
        try {
            sq = jsonTranster.readValue(req, SysUserMessage.class);
        } catch (IOException e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(sq == null || sq.getUserMessageList() == null){
            return addResultMapMsg(false,"传入参数userMessageList不能为空");
        }
        int update = 0;
        try {
            update = sysUserMessageService.reductSysUserMessageList(sq.getUserMessageList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(update == 0){
            return addResultMapMsg(false, "邮件还原失败");
        }
        return addResultMapMsg(true, "邮件还原成功");
    }

    /**
     * 工作信箱转发
     * @param req
     * @return
     */
    @CrossOrigin
    @RequestMapping(value= "/changeSjr" ,method= RequestMethod.POST )
    public Object changeSysUserMessage(@RequestBody String req){
        SysUserMessage sq;
        try {
            sq = jsonTranster.readValue(req, SysUserMessage.class);
        } catch (IOException e) {
            return addResultMapMsg(false,e.getMessage());
        }
        if(sq == null || sq.getIds() == null || StringUtils.isEmpty(sq.getSjr())){
            return addResultMapMsg(false,"传入参数ids、sjr不能为空");
        }
        int update = 0;
        try {
            update = sysUserMessageService.changeSysUserMessageList(sq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(update == 0){
            return addResultMapMsg(false, "邮件转发失败");
        }
        return addResultMapMsg(true, "邮件转发成功");
    }
}
