package springboot.oa.service.impl.role;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import springboot.oa.base.page.GenericDefaultPage;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.dao.role.SysRoleFuncRMapper;
import springboot.oa.dao.role.SysRoleMapper;
import springboot.oa.domain.role.SysRole;
import springboot.oa.domain.role.SysRoleExample;
import springboot.oa.domain.role.SysRoleFuncRExample;
import springboot.oa.service.role.SysRoleService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/16.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
   @Autowired
   SysRoleMapper sysRoleMapper;

    @Autowired
    SysRoleFuncRMapper sysRoleFuncRMapper;
    @Override
    public IGenericPage<SysRole> findPage(Integer pageNo, Integer pageSize, SysRole param, Map<String, Object> map) {
        SysRoleExample roleExample = new SysRoleExample();
        SysRoleExample.Criteria criteria = roleExample.createCriteria();
        roleExample.setOrderByClause("CREATETIME");
        if (param == null) {
            int records = sysRoleMapper.countByExample(roleExample);
            PageHelper.startPage(pageNo, pageSize);
            List<SysRole> sysRoleList = sysRoleMapper.selectByExample(roleExample);
            GenericDefaultPage<SysRole> emptyPage = new GenericDefaultPage<SysRole>(pageNo, pageSize, sysRoleList, records);
            return emptyPage;
        } else {
            if (!StringUtils.isEmpty(param.getCreateuser())) { //创建人
                criteria.andCreateuserEqualTo(param.getCreateuser());
            }
            if (!StringUtils.isEmpty(param.getRoleName())) { //
                criteria.andRoleNameLike("%" + param.getRoleName() + "%");
            }
            if (!StringUtils.isEmpty(param.getSiteId())) { //站点
                criteria.andSiteIdEqualTo(param.getSiteId());
            }
            int records = sysRoleMapper.countByExample(roleExample);
            PageHelper.startPage(pageNo, pageSize);
            List<SysRole> sysRoleList = sysRoleMapper.selectByExample(roleExample);
            GenericDefaultPage<SysRole> emptyPage = new GenericDefaultPage<SysRole>(pageNo, pageSize, sysRoleList, records);
            return emptyPage;
        }
    }

    @Override
    public IGenericPage<SysRole> findPage(Map<String, Object> map) {
        return null;
    }

    @Override
    public Integer add(SysRole sysRole) {
        sysRole.setCreatetime(new Date());
        return sysRoleMapper.insertSelective(sysRole);
    }

    @Override
    public Integer update(SysRole sysRole) {
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public Integer delete(String string) {
        return sysRoleMapper.deleteByPrimaryKey(string);
    }

    @Override
    public SysRole getById(String id) {
        return null;
    }

    @Override
    public List<String> get(BigDecimal count) {
        return null;
    }

    @Override
    public List<SysRole> selectByObject(SysRole object) {
        SysRoleExample roleExample = new SysRoleExample();
        SysRoleExample.Criteria criteria = roleExample.createCriteria();
        roleExample.setOrderByClause("CREATETIME");
        if(object != null){
            if (!StringUtils.isEmpty(object.getCreateuser())) { //创建人
                criteria.andCreateuserEqualTo(object.getCreateuser());
            }
            if (!StringUtils.isEmpty(object.getRoleName())) { //
                criteria.andRoleNameLike("%" + object.getRoleName() + "%");
            }
            if (!StringUtils.isEmpty(object.getSiteId())) { //站点
                criteria.andSiteIdEqualTo(object.getSiteId());
            }
        }
        return sysRoleMapper.selectByExample(roleExample);
    }

    @Override
    public List<SysRole> get() {
        return null;
    }

    @Override
    public List<String> selectSiteIdByUserName(Map<String, Object> map) {
        List<SysRole> roleList = sysRoleMapper.selectRoleByUserName(map);
        List<String> resultSiteId = new ArrayList<String>();
        if(roleList == null || roleList.isEmpty()){
            return null;
        }
        return resultSiteId;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void deleteRoleAndFunctions(String roleId) throws Exception {
        SysRoleFuncRExample funcRExample = new SysRoleFuncRExample();
        SysRoleFuncRExample.Criteria funcRcriteria = funcRExample.createCriteria();
        funcRcriteria.andRoleIdEqualTo(roleId);
        sysRoleFuncRMapper.deleteByExample(funcRExample);
        sysRoleMapper.deleteByPrimaryKey(roleId);
    }
}
