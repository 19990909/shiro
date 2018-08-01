package springboot.oa.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springboot.oa.base.page.GenericDefaultPage;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.dao.TbCbfMapper;
import springboot.oa.dao.TbDkxxMapper;
import springboot.oa.dao.TbJobMapper;
import springboot.oa.domain.*;
import springboot.oa.service.DkxxService;
import springboot.oa.vo.PageBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DkxxServiceImpl implements DkxxService {

	@Autowired
	private TbDkxxMapper mapper;

	@Autowired
	private TbJobMapper Jobmapper;

	@Autowired
	private TbCbfMapper Cbfmapper;

	@Override
	public IGenericPage<TbDkxx> findPage(Integer pageNo, Integer pageSize, TbDkxx param, Map<String, Object> map) {
		TbDkxxExample dkxxExample = new TbDkxxExample();
		TbDkxxExample.Criteria criteria = dkxxExample.createCriteria();
		if (param == null) {
			int records = mapper.countByExample(dkxxExample);
			PageHelper.startPage(pageNo, pageSize);
			List<TbDkxx> sysRoleList = mapper.selectByExample(dkxxExample);
			GenericDefaultPage<TbDkxx> emptyPage = new GenericDefaultPage<TbDkxx>(pageNo, pageSize, sysRoleList, records);
			return emptyPage;
		} else {
			if (!StringUtils.isEmpty(param.getXzdwId())) { //行政区划
				if(!"100000".equals(param.getXzdwId())){
					if(param.getXzdwId().endsWith("0000")){
						criteria.andXzdwIdLike(param.getXzdwId().substring(0,2)+"____");
					}else if(param.getXzdwId().endsWith("00")){
						criteria.andXzdwIdLike(param.getXzdwId().substring(0,4)+"__");
					}
				}
				criteria.andXzdwIdEqualTo(param.getXzdwId());
			}
			int records = mapper.countByExample(dkxxExample);
			PageHelper.startPage(pageNo, pageSize);
			List<TbDkxx> sysRoleList = mapper.selectByExample(dkxxExample);
			GenericDefaultPage<TbDkxx> emptyPage = new GenericDefaultPage<TbDkxx>(pageNo, pageSize, sysRoleList, records);
			return emptyPage;
		}
	}

	@Override
	public PageBean<TbDkxx> showDkxx(Integer pageNumber, Integer pageSize) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", (pageNumber - 1) * pageSize);
		map.put("pageSize", pageSize);
		List<TbDkxx> lists = mapper.selectAllByPage(map);

		PageBean<TbDkxx> pageBean = new PageBean<TbDkxx>();
		pageBean.setRows(lists);

		TbDkxxExample example = new TbDkxxExample();
		int total = mapper.selectByExample(example).size();
		pageBean.setTotal(total);

		return pageBean;

	}

	@Override
	public boolean addDkxx(TbDkxx dkxx) {
		// TODO Auto-generated method stub
		int add = mapper.insertSelective(dkxx);
		if(add > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		try{
			mapper.deleteByPrimaryKey(id);
			return true;
		}catch (Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteBybatch(Integer[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TbDkxx findDkxxById(Integer id) {
		return mapper.selectByPrimaryKey(id);

	}

	@Override
	public boolean udpateDkxx(TbDkxx dkxx) {
		// TODO Auto-generated method stub
		int update = mapper.updateByPrimaryKeySelective(dkxx);
		if(update > 0 ){
			return true;
		}
		return false;
	}

	@Override
	public List<Message> showAll() {

		// 获取所有

		return null;
	}

	@Override
	public List<TbJob> selectJob() {

		TbJobExample example = new TbJobExample();
		List<TbJob> jobs = Jobmapper.selectByExample(example);

		return jobs;
	}

	@Override
	public List<TbCbf> selectCbf() {
		TbCbfExample example = new TbCbfExample();
		List<TbCbf> cbfs = Cbfmapper.selectByExample(example);
		return cbfs;
	}

}
