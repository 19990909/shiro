package springboot.oa.service.impl.sjhj;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springboot.oa.base.page.GenericDefaultPage;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.dao.sjhj.SysOaSjhjMapper;
import springboot.oa.domain.sjhj.SysOaSjhj;
import springboot.oa.domain.sjhj.SysOaSjhjExample;
import springboot.oa.service.sjhj.SysOaSjhjService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
/**
 * Created by Administrator on 2018/3/25.
 */
@Service
public class SysOaSjhjServiceImpl implements SysOaSjhjService {
    @Autowired
    SysOaSjhjMapper sysOaSjhjMapper;
    @Override
    public IGenericPage<SysOaSjhj> findPage(Integer pageNo, Integer pageSize, SysOaSjhj param, Map<String, Object> map) {
        SysOaSjhjExample sjhjExample = new SysOaSjhjExample();
        SysOaSjhjExample.Criteria criteria = sjhjExample.createCriteria();
        sjhjExample.setOrderByClause("HJSJ");
        if (param == null) {
            int records = sysOaSjhjMapper.countByExample(sjhjExample);
            PageHelper.startPage(pageNo, pageSize);
            List<SysOaSjhj> sysRoleList = sysOaSjhjMapper.selectByExample(sjhjExample);
            GenericDefaultPage<SysOaSjhj> emptyPage = new GenericDefaultPage<SysOaSjhj>(pageNo, pageSize, sysRoleList, records);
            return emptyPage;
        } else {
            if (!StringUtils.isEmpty(param.getCityname())) { //城市名
                criteria.andCitynameLike("%" + param.getCityname() + "%");
            }
            if (!StringUtils.isEmpty(param.getProname())) { //
                criteria.andPronameLike("%" + param.getProname() + "%");
            }
            if (!StringUtils.isEmpty(param.getHjrxm())) { //汇交人姓名
                criteria.andHjrxmLike("%" + param.getHjrxm() + "%");
            }
            int records = sysOaSjhjMapper.countByExample(sjhjExample);
            PageHelper.startPage(pageNo, pageSize);
            List<SysOaSjhj> sysRoleList = sysOaSjhjMapper.selectByExample(sjhjExample);
            GenericDefaultPage<SysOaSjhj> emptyPage = new GenericDefaultPage<SysOaSjhj>(pageNo, pageSize, sysRoleList, records);
            return emptyPage;
        }
    }

    @Override
    public IGenericPage<SysOaSjhj> findPage(Map<String, Object> map) {
        return null;
    }

    @Override
    public Integer add(SysOaSjhj sysOaSjhj) {
        return sysOaSjhjMapper.insertSelective(sysOaSjhj);
    }

    @Override
    public Integer update(SysOaSjhj sysOaSjhj) {
        return sysOaSjhjMapper.updateByPrimaryKeySelective(sysOaSjhj);
    }

    @Override
    public Integer delete(String string) {
        return sysOaSjhjMapper.deleteByPrimaryKey(Integer.valueOf(string));
    }

    @Override
    public SysOaSjhj getById(String id) {
        return sysOaSjhjMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public List<String> get(BigDecimal count) {
        return null;
    }

    @Override
    public List<SysOaSjhj> selectByObject(SysOaSjhj object) {
        SysOaSjhjExample sjhjExample = new SysOaSjhjExample();
        SysOaSjhjExample.Criteria criteria = sjhjExample.createCriteria();
        sjhjExample.setOrderByClause("HJSJ");
        return sysOaSjhjMapper.selectByExample(sjhjExample);
    }

    @Override
    public List<SysOaSjhj> get() {
        return null;
    }
}
