package springboot.oa.service;

import springboot.oa.domain.TbJz;
import springboot.oa.vo.PageBean;

import java.util.List;
import java.util.Map;

public interface JzService {

	public PageBean<TbJz> showJz(Integer pageNumber, Integer pageSize, String jzlx);

	public boolean addJz(TbJz jz);
	


	public boolean deleteById(Integer id);
	public boolean deleteBybatch(Integer[] ids);
	
	public TbJz findJzById(Integer id);
	
	public boolean updateJz(TbJz jz);

	public Map<String,String> selectTbJzBm();
}
