package springboot.oa.service.impl;

import springboot.oa.domain.*;
import springboot.oa.dao.TbEmployeeMapper;
import springboot.oa.dao.TbFbfMapper;
import springboot.oa.dao.TbJobMapper;
import springboot.oa.service.EmployeeService;
import springboot.oa.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private TbEmployeeMapper mapper;

	@Autowired
	private TbJobMapper Jobmapper;

	@Autowired
	private TbFbfMapper Deptmapper;

	@Override
	public PageBean<TbEmployee> showEmployee(Integer pageNumber, Integer pageSize) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", (pageNumber - 1) * pageSize);
		map.put("pageSize", pageSize);
		List<TbEmployee> lists = mapper.selectAllByPage(map);

		PageBean<TbEmployee> pageBean = new PageBean<TbEmployee>();
		pageBean.setRows(lists);

		TbEmployeeExample example = new TbEmployeeExample();
		int total = mapper.selectByExample(example).size();
		pageBean.setTotal(total);

		return pageBean;

	}

	@Override
	public boolean addEmployee(TbEmployee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBybatch(Integer[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TbEmployee findEmployeeById(Integer id) {
		return mapper.selectByPrimaryKey(id);

	}

	@Override
	public boolean udpateEmployee(TbEmployee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Message> showAll() {

		// 获取所有

		return null;
	}

	@Override
	public List<TbJob> selectJob() {

		TbJobExample example = new TbJobExample();
		List<TbJob> jobs = Jobmapper.selectByExample(example);

		return jobs;
	}

	@Override
	public List<TbFbf> selectFbf() {
		TbFbfExample example = new TbFbfExample();
		List<TbFbf> depts = Deptmapper.selectByExample(example);
		return depts;
	}

}
