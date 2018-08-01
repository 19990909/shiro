package springboot.oa.service;

import springboot.oa.domain.TbCbf;
import springboot.oa.domain.TbJob;
import springboot.oa.vo.PageBean;

import java.util.List;

public interface CbfService {

    public PageBean<TbCbf> showCbf(Integer pageNumber,Integer pageSize,String cbfmc);

    public boolean addCbf(TbCbf cbf);



    public boolean deleteById(Integer id);
    public boolean deleteBybatch(Integer[] ids);

    public TbCbf findCbfById(Integer id);

    public boolean updateCbf(TbCbf cbf);

    public List<TbJob> selectJob();
}
