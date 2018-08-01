package springboot.oa.service;

import springboot.oa.domain.TbSfqk;
import springboot.oa.vo.PageBean;

public interface SfqkService {

	public PageBean<TbSfqk> showSfqk(Integer pageNumber, Integer pageSize, String sfmc);

	public boolean addSfqk(TbSfqk sfqk);
	


	public boolean deleteById(Integer id);
	public boolean deleteBybatch(Integer[] ids);
	
	public TbSfqk findSfqkById(Integer id);
	
	public boolean updateSfqk(TbSfqk sfqk);
}
