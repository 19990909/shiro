package springboot.oa.service;

import java.util.List;
import springboot.oa.domain.Message;
import springboot.oa.domain.TbFbf;
import springboot.oa.domain.TbEmployee;
import springboot.oa.domain.TbJob;
import springboot.oa.vo.PageBean;

public interface EmployeeService {

	public PageBean<TbEmployee> showEmployee(Integer pageNumber,Integer pageSize);

	public boolean addEmployee(TbEmployee employee);

	public boolean deleteById(Integer id);
	public boolean deleteBybatch(Integer[] ids);
	
	public TbEmployee findEmployeeById(Integer id);
	
	public boolean udpateEmployee(TbEmployee employee);
	
	
	public List<Message> showAll();
	
	public List<TbJob> selectJob();
	public List<TbFbf> selectFbf();
	
	
}
