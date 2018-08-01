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
import springboot.oa.dao.user.SysUserMapper;
import springboot.oa.dao.user.SysUserRoleRMapper;
import springboot.oa.domain.org.SysOrg;
import springboot.oa.domain.user.SysUser;
import springboot.oa.domain.user.SysUserExample;
import springboot.oa.domain.user.SysUserRoleRExample;
import springboot.oa.service.user.SysUserService;
import springboot.oa.utils.CommonUtils;
import springboot.oa.utils.PasswordUtil;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/16.
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysUserRoleRMapper sysUserRoleRMapper;
    @Override
    public IGenericPage<SysUser> findPage(Integer pageNo, Integer pageSize, SysUser param, Map<String, Object> map) {
        SysUserExample userExample = new SysUserExample();
        SysUserExample.Criteria criteria = userExample.createCriteria();
        userExample.setOrderByClause("CREATETIME");
        if (param == null) {
            int records = sysUserMapper.countByExample(userExample);
            PageHelper.startPage(pageNo, pageSize);
            List<SysUser> sysUserList = sysUserMapper.selectByExample(userExample);
            GenericDefaultPage<SysUser> emptyPage = new GenericDefaultPage<SysUser>(pageNo, pageSize, sysUserList, records);
            return emptyPage;
        } else {
            if (!StringUtils.isEmpty(param.getCreateuser())) { //创建人
                criteria.andCreateuserEqualTo(param.getCreateuser());
            }
            if (!StringUtils.isEmpty(param.getStatus())) { //状态
                criteria.andStatusEqualTo(param.getStatus());
            }
            if (!StringUtils.isEmpty(param.getNickName())) { //指标
                criteria.andNickNameLike("%" + param.getNickName() + "%");
            }
            int records = sysUserMapper.countByExample(userExample);
            PageHelper.startPage(pageNo, pageSize);
            List<SysUser> sysUserList = sysUserMapper.selectByExample(userExample);
            GenericDefaultPage<SysUser> emptyPage = new GenericDefaultPage<SysUser>(pageNo, pageSize, sysUserList, records);
            return emptyPage;
        }
    }

    @Override
    public IGenericPage<SysUser> findPage(Map<String, Object> map) {
        return null;
    }

    @Override
    public Integer add(SysUser sysUser) {
        sysUser.setCreatetime(new Date());
        return sysUserMapper.insertSelective(sysUser);
    }

    @Override
    public Integer update(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Integer delete(String string) {
        SysUserRoleRExample roleRExample = new SysUserRoleRExample();
        SysUserRoleRExample.Criteria roleRcriteria = roleRExample.createCriteria();
        roleRcriteria.andUserIdEqualTo(string);
        sysUserRoleRMapper.deleteByExample(roleRExample);
        return sysUserMapper.deleteByPrimaryKey(string);
    }

    @Override
    public SysUser getById(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<String> get(BigDecimal count) {
        return null;
    }

    @Override
    public List<SysUser> selectByObject(SysUser object) {
        SysUserExample userExample = new SysUserExample();
        SysUserExample.Criteria criteria = userExample.createCriteria();
        if(object != null){
            if (!StringUtils.isEmpty(object.getUserName())) { //用户名
                criteria.andUserNameEqualTo(object.getUserName());
            }
            if (!StringUtils.isEmpty(object.getStatus())) { //状态
                criteria.andStatusEqualTo(object.getStatus());
            }
            if (!StringUtils.isEmpty(object.getNickName())) { //指标
                criteria.andNickNameLike("%" + object.getNickName() + "%");
            }
        }
        return sysUserMapper.selectByExample(userExample);
    }

    @Override
    public List<SysUser> get() {
        return null;
    }

    @Override
    public boolean loginVerify(String username, String password) {
        boolean res = false;
        Map map = new HashMap();
        map.put("username",username);
        map.put("siteId", CommonUtils.ADMIN_SITE_ID);
        map.put("status",CommonUtils.USER_STATUS_OK);
        List<SysUser> userList = findUserRelectiveByArgs(map);
        if (userList != null) {
            SysUser user = userList.get(0);
            res = new PasswordUtil().verifyPassword(password, user.getPassword(), user.getId()+user.getUserName());
        }
        return res;
    }

    @Override
    public boolean passwordVerify(String password, String encodePassword, String salt) {
        return new PasswordUtil().verifyPassword(password, encodePassword, salt);
    }

    @Override
    public SysUser findUserByUserNameAndStatus(Map<String,String> map) {
        SysUserExample userExample = new SysUserExample();
        SysUserExample.Criteria criteria = userExample.createCriteria();
        if(map != null){
            String username = map.get("username");
            if(!StringUtils.isEmpty(username)){
                criteria.andUserNameEqualTo(username);
            }
            String status = map.get("status");
            if(!StringUtils.isEmpty(status)){
                criteria.andStatusEqualTo(status);
            }
        }
        List<SysUser> userList = sysUserMapper.selectByExample(userExample);
        if(userList == null || userList.isEmpty()){
            return null;
        }
        return userList.get(0);
    }
    @Override
    public List<SysUser> findUserRelectiveByArgs(Map<String,Object> map) {
        List<SysUser> userList = sysUserMapper.selectUserByArgs(map);
        if(userList == null || userList.isEmpty()){
            return null;
        }
        return userList;
    }

    @Override
    public List<SysUser> selectUsersByOrg(SysOrg sysOrg) {
        return sysUserMapper.selectUsersByOrg(sysOrg);
    }
}
