package springboot.oa.service.impl;

import springboot.oa.domain.TbJob;
import springboot.oa.domain.TbJobExample;
import springboot.oa.dao.TbJobMapper;
import springboot.oa.service.JobService;
import springboot.oa.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private TbJobMapper mapper;

	@Override
	public PageBean<TbJob> showDept(Integer pageNumber, Integer pageSize, String qzlqrxm) {
		if (!qzlqrxm.equals("")) {
			// select * from tb_dept where name=#{name} limit #{rowStart},#{rowEnd}
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("name", qzlqrxm);
			int rowStart = (pageNumber - 1) * pageSize;
			map.put("rowStart", rowStart);
			map.put("rowEnd", pageSize);
			List<TbJob> tbJobs = mapper.selectPageByName(map);
			PageBean<TbJob> pageBean = new PageBean<TbJob>();
			pageBean.setRows(tbJobs);
			TbJobExample example = new TbJobExample();
			List<TbJob> tball = mapper.selectByExample(example);
			pageBean.setTotal(tball.size());
			return pageBean;
		} else {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int rowStart = (pageNumber - 1) * pageSize;
			map.put("rowStart", rowStart);
			map.put("rowEnd", pageSize);
			List<TbJob> tbJobs = mapper.selectPage(map);
			PageBean<TbJob> pageBean = new PageBean<TbJob>();
			pageBean.setRows(tbJobs);
			TbJobExample example = new TbJobExample();
			List<TbJob> tball = mapper.selectByExample(example);
			pageBean.setTotal(tball.size());
			return pageBean;
		}
	}

	@Override
	public boolean addJob(TbJob job) {
		return mapper.insertSelective(job) > 0;
	}

	@Override
	public boolean deleteById(Integer id) {
		return mapper.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public boolean deleteBybatch(Integer[] ids) {
		TbJobExample example = new TbJobExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		return mapper.deleteByExample(example) > 0;
	}

	@Override
	public TbJob findJobById(Integer id) {
		TbJob selectByPrimaryKey = mapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	@Override
	public boolean udpateJob(TbJob job) {
		TbJobExample example = new TbJobExample();
		example.createCriteria().andIdEqualTo(job.getId());
		return mapper.updateByExampleSelective(job, example) > 0;
		}

	
	
}
