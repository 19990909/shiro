package springboot.oa.service.impl.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.dao.role.SysRoleFuncRMapper;
import springboot.oa.domain.role.SysRoleFuncR;
import springboot.oa.domain.role.SysRoleFuncRExample;
import springboot.oa.service.role.SysRoleFuncRService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2018/3/16.
 */
@Service
public class SysRoleFuncRServiceImpl implements SysRoleFuncRService {
    @Autowired
    SysRoleFuncRMapper sysRoleFuncRMapper;
    @Override
    public IGenericPage<SysRoleFuncR> findPage(Integer pageNo, Integer pageSize, SysRoleFuncR param, Map<String, Object> map) {
        return null;
    }

    @Override
    public IGenericPage<SysRoleFuncR> findPage(Map<String, Object> map) {
        return null;
    }

    @Override
    public Integer add(SysRoleFuncR sysRoleFuncR) {
        return sysRoleFuncRMapper.insertSelective(sysRoleFuncR);
    }

    @Override
    public Integer update(SysRoleFuncR sysRoleFuncR) {
        return null;
    }

    @Override
    public Integer delete(String string) {
        return null;
    }

    @Override
    public SysRoleFuncR getById(String id) {
        return null;
    }

    @Override
    public List<String> get(BigDecimal count) {
        return null;
    }

    @Override
    public List<SysRoleFuncR> selectByObject(SysRoleFuncR object) {
        SysRoleFuncRExample roleExample = new SysRoleFuncRExample();
        SysRoleFuncRExample.Criteria criteria = roleExample.createCriteria();
        if(object != null){
            if (!StringUtils.isEmpty(object.getRoleId())) { //角色id
                criteria.andRoleIdEqualTo(object.getRoleId());
            }
            if (!StringUtils.isEmpty(object.getFuncId())) { //
                criteria.andFuncIdEqualTo(object.getFuncId());
            }
        }
        return sysRoleFuncRMapper.selectByExample(roleExample);
    }

    @Override
    public List<SysRoleFuncR> get() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void addAll(List<SysRoleFuncR> sysRoleFuncRList) throws Exception {
        for(SysRoleFuncR funcR:sysRoleFuncRList){
            funcR.setId(UUID.randomUUID().toString());
            add(funcR);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void deleteByObject(SysRoleFuncR funcR) throws Exception {
        SysRoleFuncRExample roleExample = new SysRoleFuncRExample();
        SysRoleFuncRExample.Criteria criteria = roleExample.createCriteria();
        if(funcR != null){
            if (!StringUtils.isEmpty(funcR.getRoleId())) { //角色id
                criteria.andRoleIdEqualTo(funcR.getRoleId());
            }
            if (!StringUtils.isEmpty(funcR.getFuncId())) { //
                criteria.andFuncIdEqualTo(funcR.getFuncId());
            }
        }
        sysRoleFuncRMapper.deleteByExample(roleExample);
    }
}
