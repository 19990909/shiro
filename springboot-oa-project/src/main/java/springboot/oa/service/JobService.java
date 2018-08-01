package springboot.oa.service;

import springboot.oa.domain.TbJob;
import springboot.oa.vo.PageBean;

public interface JobService {
	public PageBean<TbJob> showDept(Integer pageNumber, Integer pageSize, String qzlqrxm);

	public boolean addJob(TbJob job);

	public boolean deleteById(Integer id);
	public boolean deleteBybatch(Integer[] ids);
	
	public TbJob findJobById(Integer id);
	
	public boolean udpateJob(TbJob job);

}
