package springboot.oa.service.impl;

import springboot.oa.domain.TbUser;
import springboot.oa.domain.TbUserExample;
import springboot.oa.domain.TbUserExample.Criteria;
import springboot.oa.dao.TbUserMapper;
import springboot.oa.service.UserService;
import springboot.oa.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper mapper;

	@Override
	public TbUser login(TbUser user) {
		TbUserExample example = new TbUserExample();
		example.createCriteria().andUsernameEqualTo(user.getLoginname()).andPasswordEqualTo(user.getPassword());
		List<TbUser> users = mapper.selectByExample(example);
		if (users.size() > 0 && users != null) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public PageBean<TbUser> showAll(Integer pageNumber, Integer pageSize) {

		TbUserExample example = new TbUserExample();
		List<TbUser> users = mapper.selectByExample(example);
		int startRow = pageSize * (pageNumber - 1);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("pageSize", pageSize);
		List<TbUser> selectByPage = mapper.selectByPage(map);
		PageBean<TbUser> bean = new PageBean<TbUser>();
		bean.setTotal(users.size());
		bean.setRows(selectByPage);
		return bean;
	}

	@Override
	public PageBean<TbUser> select(String username, String status) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();

		if ("".equals(status)) {
			criteria.andUsernameLike("%" + username + "%");
		} else {
			criteria.andStatusEqualTo(Integer.parseInt(status));
			criteria.andUsernameLike("%" + username + "%");
		}

		List<TbUser> users = mapper.selectByExample(example);

		// 创建一个分页的JavaBean对象
		PageBean<TbUser> bean = new PageBean<TbUser>();
		bean.setTotal(users.size());
		bean.setRows(users);

		return bean;
	}

	@Override
	public boolean addUser(TbUser user) {

		try {
			Date date = new Date();
			SimpleDateFormat date2 = new SimpleDateFormat("yyyy-MM-dd");

			String format = date2.format(date);
			Date date3 = date2.parse(format);
			user.setCreatedate(date3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int insert = mapper.insert(user);
		return insert > 0;

	}

	@Override
	public TbUser findUserById(Integer id) {
		TbUser user = mapper.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public boolean updateUser(TbUser user) {
		TbUserExample example = new TbUserExample();
		example.createCriteria().andIdEqualTo(user.getId());
		return mapper.updateByExampleSelective(user, example) > 0;

	}

	@Override
	public boolean deleteById(Integer id) {
		return mapper.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public boolean deleteBybatch(Integer[] ids) {
		TbUserExample example = new TbUserExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		return mapper.deleteByExample(example) > 0;
	}

}
