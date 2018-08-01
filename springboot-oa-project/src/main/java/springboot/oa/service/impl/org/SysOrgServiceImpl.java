package springboot.oa.service.impl.org;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springboot.oa.base.page.GenericDefaultPage;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.dao.org.SysOrgMapper;
import springboot.oa.domain.org.SysOrg;
import springboot.oa.domain.org.SysOrgExample;
import springboot.oa.domain.user.SysUser;
import springboot.oa.service.org.SysOrgService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
/**
 * Created by Administrator on 2018/4/25.
 */
@Service
public class SysOrgServiceImpl implements SysOrgService {
    @Autowired
    private SysOrgMapper sysOrgMapper;
    @Override
    public IGenericPage<SysOrg> findPage(Integer pageNo, Integer pageSize, SysOrg param, Map<String, Object> map) {
        SysOrgExample userExample = new SysOrgExample();
        SysOrgExample.Criteria criteria = userExample.createCriteria();
        userExample.setOrderByClause("ORG_REGION_ID");
        if (param == null) {
            int records = sysOrgMapper.countByExample(userExample);
            PageHelper.startPage(pageNo, pageSize);
            List<SysOrg> sysOrgList = sysOrgMapper.selectByExample(userExample);
            GenericDefaultPage<SysOrg> emptyPage = new GenericDefaultPage<SysOrg>(pageNo, pageSize, sysOrgList, records);
            return emptyPage;
        } else {
            if (!StringUtils.isEmpty(param.getOrgAddress())) { //组织地址
                criteria.andOrgAddressLike("%"+param.getOrgAddress()+"%");
            }
            if (!StringUtils.isEmpty(param.getOrgStatus())) { //状态
                criteria.andOrgStatusEqualTo(param.getOrgStatus());
            }
            if (!StringUtils.isEmpty(param.getOrgName())) { //组织名称
                criteria.andOrgNameLike("%"+param.getOrgName()+"%");
            }

            int records = sysOrgMapper.countByExample(userExample);
            PageHelper.startPage(pageNo, pageSize);
            List<SysOrg> sysOrgList = sysOrgMapper.selectByExample(userExample);
            GenericDefaultPage<SysOrg> emptyPage = new GenericDefaultPage<SysOrg>(pageNo, pageSize, sysOrgList, records);
            return emptyPage;
        }
    }

    @Override
    public IGenericPage<SysOrg> findPage(Map<String, Object> map) {
        return null;
    }

    @Override
    public Integer add(SysOrg sysOrg) {
        return sysOrgMapper.insertSelective(sysOrg);
    }

    @Override
    public Integer update(SysOrg sysOrg) {
        return sysOrgMapper.updateByPrimaryKeySelective(sysOrg);
    }

    @Override
    public Integer delete(String string) {
        return sysOrgMapper.deleteByPrimaryKey(string);
    }

    @Override
    public SysOrg getById(String id) {
        return sysOrgMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<String> get(BigDecimal count) {
        return null;
    }

    @Override
    public List<SysOrg> selectByObject(SysOrg object) {
        return null;
    }

    @Override
    public List<SysOrg> get() {
        return null;
    }

    /**
     * 根据用户名获取当前用户下关联的有效部门（即部门没有失效的）
     * @param user
     * @return
     */
    @Override
    public List<SysOrg> selectSysOrgByUser(SysUser user) {
        return sysOrgMapper.selectOrgByUser(user);
    }
}
