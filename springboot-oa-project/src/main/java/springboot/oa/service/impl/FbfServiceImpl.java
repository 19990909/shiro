package springboot.oa.service.impl;

import springboot.oa.domain.TbFbf;
import springboot.oa.domain.TbFbfExample;
import springboot.oa.dao.TbFbfMapper;
import springboot.oa.service.FbfService;
import springboot.oa.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class FbfServiceImpl implements FbfService {

	@Autowired
	private TbFbfMapper mapper;

	@Override
	public PageBean<TbFbf> showFbf(Integer pageNumber, Integer pageSize, String fbfmc) {
		System.out.println(fbfmc);
		
		if (!fbfmc.equals("")) {
			// select * from tb_dept where name=#{name} limit #{rowStart},#{rowEnd}
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("fbfmc", "%"+fbfmc+"%");
			int rowStart = (pageNumber - 1) * pageSize;
			map.put("rowStart", rowStart);
			map.put("rowEnd", pageSize);
			List<TbFbf> tbFbfs = mapper.selectPageByName(map);
			PageBean<TbFbf> pageBean = new PageBean<TbFbf>();
			pageBean.setRows(tbFbfs);
			Integer total = mapper.selectLikeCount("%"+fbfmc+"%");
			System.out.println(total);
			pageBean.setTotal(total);
			return pageBean;
		} else {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int rowStart = (pageNumber - 1) * pageSize;
			map.put("rowStart", rowStart);
			map.put("rowEnd", pageSize);
			List<TbFbf> tbFbfs = mapper.selectPage(map);
			PageBean<TbFbf> pageBean = new PageBean<TbFbf>();
			pageBean.setRows(tbFbfs);
			TbFbfExample example = new TbFbfExample();
			List<TbFbf> tball = mapper.selectByExample(example);
			pageBean.setTotal(tball.size());
			return pageBean;
		}
	}

	@Override
	public boolean addFbf(TbFbf fbf) {
		return mapper.insertSelective(fbf) > 0;

	}

	@Override
	public boolean deleteById(Integer id) {
		return mapper.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public boolean deleteBybatch(Integer[] ids) {
		TbFbfExample example = new TbFbfExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		return mapper.deleteByExample(example) > 0;
	}

	@Override
	public TbFbf findFbfById(Integer id) {
		TbFbf selectByPrimaryKey = mapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	@Override
	public boolean updateFbf(TbFbf fbf) {
		TbFbfExample example = new TbFbfExample();
		example.createCriteria().andIdEqualTo(fbf.getId());
		return mapper.updateByExampleSelective(fbf, example) > 0;

	}

}
