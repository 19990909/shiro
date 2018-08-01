package springboot.oa.service.function;

import springboot.oa.base.service.BaseService;
import springboot.oa.domain.function.SysFunction;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/16.
 */
public interface SysFunctionService extends BaseService<SysFunction>{

    /**
     * 根据用户名和站点获取当前用户在当前站点中所拥有的功能列表
     * @param map
     * @return
     */
    public List<SysFunction> selectSysFuncByUserName(Map<String,Object> map);

    public void deleteFunctionAllLeaf(List<String> idList) throws Exception;

    /**
     * 递归查询自己及下级功能列表
     * @param rosList
     * @param reqList
     * @return
     * @throws Exception
     */
    public List<String> selectFunctionAllLeaf(List<String> rosList,List<String> reqList) throws Exception;

    /**
     * 获取所有的id和name，并封装成map
     * @return
     */
    public Map<String,String> getIdAndName();
}
