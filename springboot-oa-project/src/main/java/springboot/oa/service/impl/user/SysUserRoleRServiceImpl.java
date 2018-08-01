package springboot.oa.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.dao.user.SysUserRoleRMapper;
import springboot.oa.domain.user.SysUserRoleR;
import springboot.oa.domain.user.SysUserRoleRExample;
import springboot.oa.service.user.SysUserRoleRService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/16.
 */
@Service
public class SysUserRoleRServiceImpl implements SysUserRoleRService {
    @Autowired
    SysUserRoleRMapper sysUserRoleRMapper;
    @Override
    public IGenericPage<SysUserRoleR> findPage(Integer pageNo, Integer pageSize, SysUserRoleR param, Map<String, Object> map) {
        return null;
    }

    @Override
    public IGenericPage<SysUserRoleR> findPage(Map<String, Object> map) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Integer add(SysUserRoleR sysUserRoleR) {
        return sysUserRoleRMapper.insertSelective(sysUserRoleR);
    }

    @Override
    public Integer update(SysUserRoleR sysUserRoleR) {
        return null;
    }

    @Override
    public Integer delete(String string) {
        return null;
    }

    @Override
    public SysUserRoleR getById(String id) {
        return null;
    }

    @Override
    public List<String> get(BigDecimal count) {
        return null;
    }

    @Override
    public List<SysUserRoleR> selectByObject(SysUserRoleR object) {
        SysUserRoleRExample roleExample = new SysUserRoleRExample();
        SysUserRoleRExample.Criteria criteria = roleExample.createCriteria();
        if(object != null){
            if (!StringUtils.isEmpty(object.getRoleId())) { //角色id
                criteria.andRoleIdEqualTo(object.getRoleId());
            }
            if (!StringUtils.isEmpty(object.getUserId())) { //用户id
                criteria.andUserIdEqualTo(object.getUserId());
            }
        }
        return sysUserRoleRMapper.selectByExample(roleExample);
    }

    @Override
    public List<SysUserRoleR> get() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void addAll(List<SysUserRoleR> roleRList) throws Exception {
        for(SysUserRoleR r:roleRList){
            add(r);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void deleteByObject(SysUserRoleR roleR) throws Exception {
        SysUserRoleRExample roleExample = new SysUserRoleRExample();
        SysUserRoleRExample.Criteria criteria = roleExample.createCriteria();
        if(roleR != null){
            if (!StringUtils.isEmpty(roleR.getRoleId())) { //角色id
                criteria.andRoleIdEqualTo(roleR.getRoleId());
            }
            if (!StringUtils.isEmpty(roleR.getUserId())) { //用户id
                criteria.andUserIdEqualTo(roleR.getUserId());
            }
        }
        sysUserRoleRMapper.deleteByExample(roleExample);
    }
}
