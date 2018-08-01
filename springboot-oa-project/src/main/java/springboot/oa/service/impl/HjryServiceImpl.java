package springboot.oa.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.oa.dao.TbHjryMapper;
import springboot.oa.domain.TbHjry;
import springboot.oa.domain.TbHjryExample;
import springboot.oa.service.HjryService;
import springboot.oa.vo.PageBean;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HjryServiceImpl implements HjryService {

	@Autowired
	private TbHjryMapper mapper;

	@Override
	public PageBean<TbHjry> showHjry(Integer pageNumber, Integer pageSize, String hjryxm) {
		System.out.println(hjryxm);
		
		if (!"".equals(hjryxm)) {
			// select * from tb_dept where name=#{name} limit #{rowStart},#{rowEnd}
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("hjryxm", "%"+hjryxm+"%");
			int rowStart = (pageNumber - 1) * pageSize;
			map.put("rowStart", rowStart);
			map.put("rowEnd", pageSize);
			List<TbHjry> tbHjrys = mapper.selectPageByName(map);
			PageBean<TbHjry> pageBean = new PageBean<TbHjry>();
			pageBean.setRows(tbHjrys);
			Integer total = mapper.selectLikeCount("%"+hjryxm+"%");
			System.out.println(total);
			pageBean.setTotal(total);
			return pageBean;
		} else {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int rowStart = (pageNumber - 1) * pageSize;
			map.put("rowStart", rowStart);
			map.put("rowEnd", pageSize);
			List<TbHjry> tbHjrys = mapper.selectPage(map);
			PageBean<TbHjry> pageBean = new PageBean<TbHjry>();
			pageBean.setRows(tbHjrys);
			pageBean.setTotal(tbHjrys.size());
			return pageBean;

		}
	}

	@Override
	public boolean addHjry(TbHjry hjry) {
		return mapper.insertSelective(hjry) > 0;

	}

	@Override
	public boolean deleteById(Integer id) {
		return mapper.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public boolean deleteBybatch(Integer[] ids) {
		TbHjryExample example = new TbHjryExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		return mapper.deleteByExample(example) > 0;
	}

	@Override
	public TbHjry findHjryById(Integer id) {
		TbHjry selectByPrimaryKey = mapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	@Override
	public boolean updateHjry(TbHjry hjry) {
		TbHjryExample example = new TbHjryExample();
		example.createCriteria().andIdEqualTo(hjry.getId());
		return mapper.updateByExampleSelective(hjry, example) > 0;

	}

	@Override
	public Map<String, String> selectHjryXm() {
		TbHjryExample example = new TbHjryExample();
		List<TbHjry> hjryList = mapper.selectByExample(example);
		Map<String, String> map = new HashMap<String, String>();
		if(hjryList == null || hjryList.isEmpty()){
			return map;
		}
		for(TbHjry hjry:hjryList){
			Integer hjryId = hjry.getId();
			String hjrybm = hjry.getHjryxm();
			if(hjryId != 0 && !StringUtils.isEmpty(hjrybm)){
				map.put(hjryId+"",hjrybm);
			}
		}
		return map;
	}

}
