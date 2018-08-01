package springboot.oa.service;

import springboot.oa.domain.TbHjry;
import springboot.oa.vo.PageBean;

import java.util.Map;

public interface HjryService {

	public PageBean<TbHjry> showHjry(Integer pageNumber, Integer pageSize, String hjryxm);

	public boolean addHjry(TbHjry hjry);
	


	public boolean deleteById(Integer id);
	public boolean deleteBybatch(Integer[] ids);
	
	public TbHjry findHjryById(Integer id);
	
	public boolean updateHjry(TbHjry hjry);

	Map<String,String> selectHjryXm();
}
