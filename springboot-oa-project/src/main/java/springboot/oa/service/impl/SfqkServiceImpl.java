package springboot.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.oa.dao.TbSfqkMapper;
import springboot.oa.domain.TbSfqk;
import springboot.oa.domain.TbSfqkExample;
import springboot.oa.service.SfqkService;
import springboot.oa.vo.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class SfqkServiceImpl implements SfqkService {

	@Autowired
	private TbSfqkMapper mapper;

	@Override
	public PageBean<TbSfqk> showSfqk(Integer pageNumber, Integer pageSize, String sfmc) {
		System.out.println(sfmc);
		
		if (!sfmc.equals("")) {
			// select * from tb_dept where name=#{name} limit #{rowStart},#{rowEnd}
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("sfmc", "%"+sfmc+"%");
			int rowStart = (pageNumber - 1) * pageSize;
			map.put("rowStart", rowStart);
			map.put("rowEnd", pageSize);
			List<TbSfqk> tbSfqks = mapper.selectPageByName(map);
			PageBean<TbSfqk> pageBean = new PageBean<TbSfqk>();
			pageBean.setRows(tbSfqks);
			Integer total = mapper.selectLikeCount("%"+sfmc+"%");
			System.out.println(total);
			pageBean.setTotal(total);
			return pageBean;
		} else {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int rowStart = (pageNumber - 1) * pageSize;
			map.put("rowStart", rowStart);
			map.put("rowEnd", pageSize);
			List<TbSfqk> tbSfqks = mapper.selectPage(map);
			PageBean<TbSfqk> pageBean = new PageBean<TbSfqk>();
			pageBean.setRows(tbSfqks);
			TbSfqkExample example = new TbSfqkExample();
			List<TbSfqk> tball = mapper.selectByExample(example);
			pageBean.setTotal(tball.size());
			return pageBean;
		}
	}

	@Override
	public boolean addSfqk(TbSfqk sfqk) {
		return mapper.insertSelective(sfqk) > 0;

	}

	@Override
	public boolean deleteById(Integer id) {
		return mapper.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public boolean deleteBybatch(Integer[] ids) {
		TbSfqkExample example = new TbSfqkExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		return mapper.deleteByExample(example) > 0;
	}

	@Override
	public TbSfqk findSfqkById(Integer id) {
		TbSfqk selectByPrimaryKey = mapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	@Override
	public boolean updateSfqk(TbSfqk sfqk) {
		TbSfqkExample example = new TbSfqkExample();
		example.createCriteria().andIdEqualTo(sfqk.getId());
		return mapper.updateByExampleSelective(sfqk, example) > 0;

	}

}
