package springboot.oa.service.impl.user;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import springboot.oa.base.page.GenericDefaultPage;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.dao.user.SysUserMessageMapper;
import springboot.oa.domain.user.SysUserMessage;
import springboot.oa.domain.user.SysUserMessageExample;
import springboot.oa.service.user.SysUserMessageService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/**
 * Created by Administrator on 2017/9/21.
 */
@Service
public class SysUserMessageServiceImpl implements SysUserMessageService {
    @Autowired
    SysUserMessageMapper sysUserMessageMapper;
    @Override
    public IGenericPage<SysUserMessage> findPage(Integer pageNo, Integer pageSize, SysUserMessage param, Map<String, Object> map) {
        SysUserMessageExample gztzExample = new SysUserMessageExample();
        SysUserMessageExample.Criteria criteria = gztzExample.createCriteria();
        gztzExample.setOrderByClause("FSSJ DESC");
        if(param == null ){
            int records = sysUserMessageMapper.countByExample(gztzExample);
            PageHelper.startPage(pageNo,pageSize);
            List<SysUserMessage> SysUserMessages = sysUserMessageMapper.selectByExample(gztzExample);
            GenericDefaultPage<SysUserMessage> emptyPage = new GenericDefaultPage<SysUserMessage>(pageNo, pageSize, SysUserMessages,records);
            return emptyPage;
        }else{
//            if(!StringUtils.isEmpty(param.getSjr())){ //收件人
//                criteria.andSjrLike("%"+param.getSjr()+"%");
//            }

            if(!StringUtils.isEmpty(param.getBy3())){
                criteria.andBy3EqualTo(param.getBy3()); //by3字段
            }
            if(!StringUtils.isEmpty(param.getSjr())){ //收件人
                criteria.andSjrEqualTo(param.getSjr());
            }
            if(!StringUtils.isEmpty(param.getFjr())){ //发件人
                criteria.andFjrEqualTo(param.getFjr());
            }
            if(!StringUtils.isEmpty(param.getBy4())){
                criteria.andBy4EqualTo(param.getBy4()); //用于垃圾桶查询条件
            }
            if(!StringUtils.isEmpty(param.getXxlb())){ //信箱类别，1发件箱，2草稿箱，3回收站，4收件箱
                criteria.andXxlbEqualTo(param.getXxlb());
            }
            if(!StringUtils.isEmpty(param.getFszt())){ //发送状态，0未发送，1已发送，2发送失败
                criteria.andFsztEqualTo(param.getFszt());
            }
            if(!StringUtils.isEmpty(param.getDqzt())){ //读取状态，0未读，1已读
                criteria.andDqztEqualTo(param.getDqzt());
            }
            int records = sysUserMessageMapper.countByExample(gztzExample);
            PageHelper.startPage(pageNo,pageSize);
            List<SysUserMessage> SysUserMessages = sysUserMessageMapper.selectByExample(gztzExample);
            GenericDefaultPage<SysUserMessage> emptyPage = new GenericDefaultPage<SysUserMessage>(pageNo, pageSize, SysUserMessages,records);
            return emptyPage;
        }
    }

    @Override
    public IGenericPage<SysUserMessage> findPage(Map<String, Object> map) {
        return null;
    }

    @Override
    public Integer add(SysUserMessage sysUserMessage) {
        return sysUserMessageMapper.insert(sysUserMessage);
    }

    @Override
    public Integer update(SysUserMessage sysUserMessage) {
        return sysUserMessageMapper.updateByPrimaryKeySelective(sysUserMessage);
    }

    @Override
    public Integer delete(String string) {
        return sysUserMessageMapper.deleteByPrimaryKey(Integer.valueOf(string));
    }

    @Override
    public SysUserMessage getById(String id) {
        return sysUserMessageMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public List<String> get(BigDecimal count) {
        return null;
    }

    @Override
    public List<SysUserMessage> selectByObject(SysUserMessage object) {
        return null;
    }

    @Override
    public List<SysUserMessage> get() {
        return null;
    }


    @Override
    public String addReturnId(SysUserMessage message) {
        int insert = sysUserMessageMapper.insertSelective(message);
        if(insert <= 0){
            return null;
        }
        return message.getId()+"";
    }

    @Override
    public Integer updateByIds(SysUserMessage gzxx, List<Integer> ids) {
        SysUserMessageExample gztzExample = new SysUserMessageExample();
        SysUserMessageExample.Criteria criteria = gztzExample.createCriteria();
        criteria.andIdIn(ids);
        return sysUserMessageMapper.updateByExampleSelective(gzxx,gztzExample);
    }

    @Override
    public List<SysUserMessage> getSysUserMessage(List<Integer> ids) {
        SysUserMessageExample gztzExample = new SysUserMessageExample();
        SysUserMessageExample.Criteria criteria = gztzExample.createCriteria();
        criteria.andIdIn(ids);
        return sysUserMessageMapper.selectByExample(gztzExample);
    }

    /**
     * 对每一个收件人，都添加一条记录
     * @param gzxx
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Integer addAllSjrSendMsg(SysUserMessage gzxx) throws Exception{
        gzxx.setBy3("1"); //发件人查询条件，默认为1，表示当前信息为发件人信息，由于收件人sjr可能为多个，需要用这条记录,便于发件人查看
        gzxx.setXxlb("1"); //对发件人来说，该邮件当前进入发件箱
        gzxx.setBy6("1"); //直接接收
        int insert = sysUserMessageMapper.insertSelective(gzxx);
        if(insert == 0){
            return 0;
        }
        SysUserMessage sjrGzxx = gzxx;
        String sjr = sjrGzxx.getSjr();
        String[] sjrArrary = null;
        if(sjr.indexOf(",") != -1){
            sjrArrary = sjr.split(",");
        }else{ //只有一个元素的话，就添加一个
            sjrArrary = new String[]{sjr};
        }
        for(int i = 0;i<sjrArrary.length;i++){
            sjrGzxx.setSjr(sjrArrary[i]);
            sjrGzxx.setBy3("0"); //收件人查询条件，默认0
            sjrGzxx.setXxlb("4"); //信箱类别，1发件箱，2草稿箱，3回收站,4 收件箱
            sjrGzxx.setBy6("1"); //直接接收，非转发接收
            sysUserMessageMapper.insertSelective(sjrGzxx);
        }
        return 1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Integer updateSysUserMessageList(List<SysUserMessage> gzxxList) throws Exception {
        if(gzxxList.isEmpty()){
            return 0;
        }
        for(SysUserMessage gzxx:gzxxList){
            int update = sysUserMessageMapper.updateByPrimaryKeySelective(gzxx);
            if(update == 0){
                throw new Exception("更新时发生异常");
            }
        }
        return 1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Integer reductSysUserMessageList(List<SysUserMessage> gzxxList) throws Exception {
        if(gzxxList.isEmpty()){
            return 0;
        }
        for(SysUserMessage gzxx:gzxxList){
            if(StringUtils.isEmpty(gzxx.getBy5())){
                throw new Exception("by5为空，不能进行还原");
            }
            gzxx.setXxlb(gzxx.getBy5());
            gzxx.setBy5("");
            gzxx.setBy4("");
            sysUserMessageMapper.updateByPrimaryKeySelective(gzxx);
        }
        return 1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Integer deleteSysUserMessageList(List<Integer> ids) throws Exception {
        SysUserMessageExample gztzExample = new SysUserMessageExample();
        SysUserMessageExample.Criteria criteria = gztzExample.createCriteria();
        criteria.andIdIn(ids);
        return sysUserMessageMapper.deleteByExample(gztzExample);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Integer changeSysUserMessageList(SysUserMessage sysUserMessage) throws Exception {
        List<SysUserMessage> gzxxList = getSysUserMessage(sysUserMessage.getIds());
        if(gzxxList == null || gzxxList.isEmpty()){
            return 0;
        }
        String[] sjrArray = sysUserMessage.getSjr().split(",");
        for(SysUserMessage gzxx:gzxxList){
            gzxx.setBy3("1"); //发件人查询条件，默认为1，表示当前信息为发件人信息，由于收件人sjr可能为多个，需要用这条记录,便于发件人查看
            gzxx.setXxlb("1"); //对发件人来说，该邮件当前进入发件箱
            gzxx.setBy6("0"); //转发接收件
            gzxx.setId(null);
            int insert = sysUserMessageMapper.insertSelective(gzxx);
            if(insert == 0){
                throw new Exception("转发中出现异常");
            }
            SysUserMessage sjrGzxx = gzxx;
            for(int i = 0;i<sjrArray.length;i++){
                sjrGzxx.setSjr(sjrArray[i]);
                sjrGzxx.setBy3("0"); //收件人查询条件，默认0
                sjrGzxx.setXxlb("4"); //信箱类别，1发件箱，2草稿箱，3回收站,4 收件箱
                sjrGzxx.setBy6("0"); //转发接收件
                sysUserMessageMapper.insertSelective(sjrGzxx);
            }
        }
        return 1;
    }
}
