package springboot.oa.service.impl;

import springboot.oa.dao.TbJobMapper;
import springboot.oa.domain.TbCbf;
import springboot.oa.domain.TbCbfExample;
import springboot.oa.dao.TbCbfMapper;
import springboot.oa.domain.TbJob;
import springboot.oa.domain.TbJobExample;
import springboot.oa.service.CbfService;
import springboot.oa.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class CbfServiceImpl implements CbfService {

    @Autowired
    private TbCbfMapper mapper;

    @Autowired
    private TbJobMapper Jobmapper;

    @Override
    public PageBean<TbCbf> showCbf(Integer pageNumber, Integer pageSize, String cbfmc) {
        System.out.println(cbfmc);

        if (!cbfmc.equals("")) {
            // select * from tb_dept where name=#{name} limit #{rowStart},#{rowEnd}
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("cbfmc", "%"+cbfmc+"%");
            int rowStart = (pageNumber - 1) * pageSize;
            map.put("rowStart", rowStart);
            map.put("rowEnd", pageSize);
            List<TbCbf> tbCbfs = mapper.selectPageByName(map);
            PageBean<TbCbf> pageBean = new PageBean<TbCbf>();
            pageBean.setRows(tbCbfs);
            Integer total = mapper.selectLikeCount("%"+cbfmc+"%");
            System.out.println(total);
            pageBean.setTotal(total);
            return pageBean;
        } else {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int rowStart = (pageNumber - 1) * pageSize;
            map.put("rowStart", rowStart);
            map.put("rowEnd", pageSize);
            List<TbCbf> tbCbfs = mapper.selectPage(map);
            PageBean<TbCbf> pageBean = new PageBean<TbCbf>();
            pageBean.setRows(tbCbfs);
            TbCbfExample example = new TbCbfExample();
            List<TbCbf> tball = mapper.selectByExample(example);
            pageBean.setTotal(tball.size());
            return pageBean;
        }
    }

    @Override
    public boolean addCbf(TbCbf cbf) {
        return mapper.insertSelective(cbf) > 0;

    }

    @Override
    public boolean deleteById(Integer id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean deleteBybatch(Integer[] ids) {
        TbCbfExample example = new TbCbfExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return mapper.deleteByExample(example) > 0;
    }

    @Override
    public TbCbf findCbfById(Integer id) {
        TbCbf selectByPrimaryKey = mapper.selectByPrimaryKey(id);
        return selectByPrimaryKey;
    }

    @Override
    public boolean updateCbf(TbCbf cbf) {
        TbCbfExample example = new TbCbfExample();
        example.createCriteria().andIdEqualTo(cbf.getId());
        return mapper.updateByExampleSelective(cbf, example) > 0;

    }

    @Override
    public List<TbJob> selectJob() {
        TbJobExample example = new TbJobExample();
        List<TbJob> jobs = Jobmapper.selectByExample(example);

        return jobs;
    }

}
