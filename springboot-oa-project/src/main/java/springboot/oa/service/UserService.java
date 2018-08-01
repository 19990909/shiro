package springboot.oa.service;



import springboot.oa.domain.TbUser;
import springboot.oa.vo.PageBean;

public interface UserService {
	
	//验证登录
	public TbUser login(TbUser user) ;

	
	//zhanshi suoyou
	public PageBean<TbUser> showAll(Integer pageNumber,Integer pageSize);
	
	public PageBean<TbUser> select(String username,String status );
	
	// 开始添加数据
	public boolean addUser(TbUser user);
	
	public TbUser findUserById(Integer id);
	
	public boolean updateUser(TbUser user);
	
	public boolean deleteById(Integer id);
	public boolean deleteBybatch(Integer[] ids);
	
}
