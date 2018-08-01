package springboot.oa.service;

import springboot.oa.base.page.IGenericPage;
import springboot.oa.domain.Message;
import springboot.oa.domain.TbCbf;
import springboot.oa.domain.TbDkxx;
import springboot.oa.domain.TbJob;
import springboot.oa.vo.PageBean;

import java.util.List;
import java.util.Map;

public interface DkxxService {

	public IGenericPage<TbDkxx> findPage(Integer pageNo, Integer pageSize, TbDkxx param, Map<String, Object> map);
	public PageBean<TbDkxx> showDkxx(Integer pageNumber, Integer pageSize);

	public boolean addDkxx(TbDkxx dkxx);

	public boolean deleteById(Integer id);
	public boolean deleteBybatch(Integer[] ids);
	
	public TbDkxx findDkxxById(Integer id);
	
	public boolean udpateDkxx(TbDkxx dkxx);
	
	
	public List<Message> showAll();
	
	public List<TbCbf> selectCbf();
	public List<TbJob> selectJob();
	
	
}
