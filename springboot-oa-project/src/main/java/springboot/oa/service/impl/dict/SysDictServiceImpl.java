package springboot.oa.service.impl.dict;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springboot.oa.base.page.GenericDefaultPage;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.dao.dict.SysDictMapper;
import springboot.oa.domain.dict.SysDict;
import springboot.oa.domain.dict.SysDictExample;
import springboot.oa.service.dict.SysDictService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by lsf on 2018/4/25.
 */
@Service
public class SysDictServiceImpl implements SysDictService {
    @Autowired
    private SysDictMapper sysDictMapper;
    @Override
    public IGenericPage<SysDict> findPage(Integer pageNo, Integer pageSize, SysDict param, Map<String, Object> map) {
        SysDictExample userExample = new SysDictExample();
        SysDictExample.Criteria criteria = userExample.createCriteria();
        userExample.setOrderByClause("DICT_TYPE");
        if (param == null) {
            int records = sysDictMapper.countByExample(userExample);
            PageHelper.startPage(pageNo, pageSize);
            List<SysDict> sysOrgList = sysDictMapper.selectByExample(userExample);
            GenericDefaultPage<SysDict> emptyPage = new GenericDefaultPage<SysDict>(pageNo, pageSize, sysOrgList, records);
            return emptyPage;
        } else {
            if (!StringUtils.isEmpty(param.getDictType())) { //词典类别
                criteria.andDictTypeEqualTo(param.getDictType());
            }
            if (!StringUtils.isEmpty(param.getDictStatus())) { //状态
                criteria.andDictStatusEqualTo(param.getDictStatus());
            }
            if (!StringUtils.isEmpty(param.getDictCreateuser())) { //创建人
                criteria.andDictCreateuserEqualTo(param.getDictCreateuser());
            }

            int records = sysDictMapper.countByExample(userExample);
            PageHelper.startPage(pageNo, pageSize);
            List<SysDict> sysOrgList = sysDictMapper.selectByExample(userExample);
            GenericDefaultPage<SysDict> emptyPage = new GenericDefaultPage<SysDict>(pageNo, pageSize, sysOrgList, records);
            return emptyPage;
        }
    }

    @Override
    public IGenericPage<SysDict> findPage(Map<String, Object> map) {
        return null;
    }

    @Override
    public Integer add(SysDict sysDict) {
        return sysDictMapper.insertSelective(sysDict);
    }

    @Override
    public Integer update(SysDict sysDict) {
        return sysDictMapper.updateByPrimaryKeySelective(sysDict);
    }

    @Override
    public Integer delete(String string) {
        return sysDictMapper.deleteByPrimaryKey(string);
    }

    @Override
    public SysDict getById(String id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<String> get(BigDecimal count) {
        return null;
    }

    @Override
    public List<SysDict> selectByObject(SysDict object) {
        SysDictExample userExample = new SysDictExample();
        SysDictExample.Criteria criteria = userExample.createCriteria();
        userExample.setOrderByClause("DICT_TYPE");
        if(object != null){
            if (!StringUtils.isEmpty(object.getDictType())) { //词典类别
                criteria.andDictTypeEqualTo(object.getDictType());
            }
            if (!StringUtils.isEmpty(object.getDictStatus())) { //状态
                criteria.andDictStatusEqualTo(object.getDictStatus());
            }
            if (!StringUtils.isEmpty(object.getDictCreateuser())) { //创建人
                criteria.andDictCreateuserEqualTo(object.getDictCreateuser());
            }
        }
        return sysDictMapper.selectByExample(userExample);
    }

    @Override
    public List<SysDict> get() {
        return null;
    }
}
