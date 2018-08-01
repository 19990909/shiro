package springboot.oa.service.impl;

import org.apache.commons.lang3.StringUtils;
import springboot.oa.domain.TbJz;
import springboot.oa.domain.TbJzExample;
import springboot.oa.dao.TbJzMapper;
import springboot.oa.service.JzService;
import springboot.oa.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class JzServiceImpl implements JzService {

	@Autowired
	private TbJzMapper mapper;

	@Override
	public PageBean<TbJz> showJz(Integer pageNumber, Integer pageSize, String jzlx) {
		System.out.println(jzlx);

		if(!"".equals(jzlx)){
			// select * from tb_dept where name=#{name} limit #{rowStart},#{rowEnd}
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("jzlx", "%"+jzlx+"%");
			int rowStart = (pageNumber - 1) * pageSize;
			map.put("rowStart", rowStart);
			map.put("rowEnd", pageSize);
			List<TbJz> tbJzs = mapper.selectPageByName(map);
			PageBean<TbJz> pageBean = new PageBean<TbJz>();
			pageBean.setRows(tbJzs);
			Integer total = mapper.selectLikeCount("%"+jzlx+"%");
			System.out.println(total);
			pageBean.setTotal(total);
			return pageBean;
		} else {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int rowStart = (pageNumber - 1) * pageSize;
			map.put("rowStart", rowStart);
			map.put("rowEnd", pageSize);
			List<TbJz> tbJzs = mapper.selectPage(map);
			PageBean<TbJz> pageBean = new PageBean<TbJz>();
			pageBean.setRows(tbJzs);
			TbJzExample example = new TbJzExample();
			List<TbJz> tball = mapper.selectByExample(example);
			pageBean.setTotal(tball.size());
			return pageBean;
		}
	}

	@Override
	public boolean addJz(TbJz jz) {
		return mapper.insertSelective(jz) > 0;

	}

	@Override
	public boolean deleteById(Integer id) {
		return mapper.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public boolean deleteBybatch(Integer[] ids) {
		TbJzExample example = new TbJzExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		return mapper.deleteByExample(example) > 0;
	}

	@Override
	public TbJz findJzById(Integer id) {
		TbJz selectByPrimaryKey = mapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	@Override
	public boolean updateJz(TbJz jz) {
		TbJzExample example = new TbJzExample();
		example.createCriteria().andIdEqualTo(jz.getId());
		return mapper.updateByExampleSelective(jz, example) > 0;

	}

	@Override
	public Map<String, String> selectTbJzBm() {
		TbJzExample example = new TbJzExample();
		List<TbJz> tball = mapper.selectByExample(example);
		Map<String, String> map = new HashMap<String, String>();
		if(tball == null || tball.isEmpty()){
			return map;
		}
		for(TbJz jz:tball){
			Integer jzId = jz.getId();
			String jzbm = jz.getJzbm();
			if(jzId != 0 && !StringUtils.isEmpty(jzbm)){
				map.put(jzId+"",jzbm);
			}
		}
		return map;
	}

}
