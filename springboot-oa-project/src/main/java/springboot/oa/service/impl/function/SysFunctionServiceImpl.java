package springboot.oa.service.impl.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.dao.function.SysFunctionMapper;
import springboot.oa.domain.function.SysFunction;
import springboot.oa.domain.function.SysFunctionExample;
import springboot.oa.service.function.SysFunctionService;
import java.math.BigDecimal;
import java.util.*;
/**
 * Created by Administrator on 2018/3/16.
 */
@Service
public class SysFunctionServiceImpl implements SysFunctionService {

    @Autowired
    SysFunctionMapper sysFunctionMapper;

    @Override
    public IGenericPage<SysFunction> findPage(Integer pageNo, Integer pageSize, SysFunction param, Map<String, Object> map) {
        return null;
    }

    @Override
    public IGenericPage<SysFunction> findPage(Map<String, Object> map) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Integer add(SysFunction sysFunction) {
        sysFunction.setCreatetime(new Date());
        return sysFunctionMapper.insertSelective(sysFunction);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Integer update(SysFunction sysFunction) {
        return sysFunctionMapper.updateByPrimaryKeySelective(sysFunction);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Integer delete(String string) {
        return sysFunctionMapper.deleteByPrimaryKey(string);
    }

    @Override
    public SysFunction getById(String id) {
        return sysFunctionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<String> get(BigDecimal count) {
        return null;
    }

    @Override
    public List<SysFunction> selectByObject(SysFunction object) {
        SysFunctionExample roleExample = new SysFunctionExample();
        SysFunctionExample.Criteria criteria = roleExample.createCriteria();
        roleExample.setOrderByClause("CREATETIME,FUNC_DESC");
        if(object != null){
            if (!StringUtils.isEmpty(object.getSiteId())) { //站点
                criteria.andSiteIdEqualTo(object.getSiteId());
            }
            if (!StringUtils.isEmpty(object.getId())) { //主键
                criteria.andIdEqualTo(object.getId());
            }
        }
        return sysFunctionMapper.selectByExample(roleExample);
    }

    @Override
    public List<SysFunction> get() {
        return null;
    }

    @Override
    public List<SysFunction> selectSysFuncByUserName(Map<String, Object> map) {
        return sysFunctionMapper.selectSysFuncByArgs(map);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void deleteFunctionAllLeaf(List<String> idList) throws Exception {
        if(idList == null || idList.isEmpty()){
            throw new Exception("idList不能为空");
        }
        SysFunctionExample functionExample = new SysFunctionExample();
        SysFunctionExample.Criteria criteria = functionExample.createCriteria();
        criteria.andIdIn(idList);
        sysFunctionMapper.deleteByExample(functionExample);
    }

    /**
     * 递归查询所有的叶子id
     * @param rosList
     * @return
     * @throws Exception
     */
    @Override
    public List<String> selectFunctionAllLeaf(List<String> rosList,List<String> reqList) throws Exception {
        SysFunction function = new SysFunction();
        function.setIdList(reqList);
        List<Map<String,Object>> resultMap = sysFunctionMapper.selectIdFromPidList(function);
        List<String> reqLeafList = new ArrayList<String>();
        if(resultMap != null && !resultMap.isEmpty()){
            for(Map<String,Object> mapPid: resultMap){
                String id = mapPid.get("ID").toString();
                rosList.add(id); //用来存储这一次查询到的结果
                reqLeafList.add(id); //用来做下一次查询
            }
        }
        if(reqLeafList.isEmpty()){
            return rosList;
        }
        return selectFunctionAllLeaf(rosList,reqLeafList);
    }

    @Override
    public Map<String, String> getIdAndName() {
        List<Map<String, Object>> resultList =  sysFunctionMapper.selectIdAndNameList();
        Map<String, String> resultMap = new HashMap<String, String>();
        if(resultList != null && !resultList.isEmpty()){
            for(Map<String, Object> map:resultList){
                Object idObj = map.get("ID");
                Object nameObj = map.get("NAME");
                if(idObj != null && nameObj != null){
                    resultMap.put(idObj.toString(),nameObj.toString());
                }
            }
        }
        return resultMap;
    }
}
