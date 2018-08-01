package springboot.oa.service;

import springboot.oa.domain.TbFbf;
import springboot.oa.vo.PageBean;

public interface FbfService {
	
	public PageBean<TbFbf> showFbf(Integer pageNumber,Integer pageSize,String fbfmc);

	public boolean addFbf(TbFbf fbf);
	


	public boolean deleteById(Integer id);
	public boolean deleteBybatch(Integer[] ids);
	
	public TbFbf findFbfById(Integer id);
	
	public boolean updateFbf(TbFbf fbf);
}
