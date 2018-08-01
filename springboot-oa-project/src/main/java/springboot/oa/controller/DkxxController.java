package springboot.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springboot.oa.base.controller.BaseController;
import springboot.oa.base.page.IGenericPage;
import springboot.oa.domain.TbCbf;
import springboot.oa.domain.TbDkxx;
import springboot.oa.domain.TbJob;
import springboot.oa.service.DkxxService;
import springboot.oa.utils.ReqConfigObject;
import springboot.oa.utils.ResultRestBody;
import springboot.oa.vo.PageBean;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DkxxController extends BaseController{

	@Autowired
	private DkxxService dkxxService;

	@RequestMapping("/js/dkxx/selectDkxx")
	public String selectDkxx(HttpSession session) {

		List<TbCbf> cbfList = dkxxService.selectCbf();
		List<TbJob> jobList = dkxxService.selectJob();
		session.setAttribute("cbfList", cbfList);
		session.setAttribute("jobList", jobList);

		return "js/dkxx/js.dkxx";
	}
	@RequestMapping("/js/dkxx/addDkxx")
	public String addDkxx() {
		return "js/dkxx/showAddDkxx";
	}

	@RequestMapping("/kjson")
	public @ResponseBody PageBean<TbDkxx> showAllDkxx(Integer pageNumber, Integer pageSize) {

		// 转一个我们封装的message 加 Bean

		System.out.println(pageNumber);
		System.out.println(pageSize);
		PageBean<TbDkxx> pageBean = dkxxService.showDkxx(pageNumber, pageSize);
		System.out.println(pageBean);

		return pageBean;

	}

	// udpate
	// employee/updateEmployee?
	@RequestMapping("/js/dkxx/updateDkxx")
	public String updateDkxx(Integer flag, Integer id, Model model, String name, @RequestParam(required=false ,value="")TbDkxx dkxx, HttpServletResponse response) {
		System.out.println("udpate");
		if (flag == 1) {
			TbDkxx dkxx1 = dkxxService.findDkxxById(id);
			model.addAttribute("js/dkxx", dkxx1);
			return "js/dkxx/showUpdateDkxx";
		} else {
			System.out.println("js.dkxx-------------");
			
			try {
				System.out.println(name);
				System.out.println(dkxx);
				response.getWriter().print("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}

	}



	//统计数据的查询接口
	@CrossOrigin
	@RequestMapping(value="/dkxx/select",method = RequestMethod.POST)
	@ResponseBody
	public Object selectObject(@RequestBody String req){

		TbDkxx dkxx ;
		ReqConfigObject object ;
		try{
			dkxx = gson.fromJson(req, TbDkxx.class);
			object = gson.fromJson(req, ReqConfigObject.class);
		}catch (Exception e) {
			return addResultMapMsg(false,e.getMessage());
		}
		if(object == null || object.getPageNo()<0 || object.getPageSize() <0 || object.getPageNo() ==999999 || object.getPageSize() == 999999){
			return addResultMapMsg(false,"没有加分页条件pageNo和pageSize");
		}
		IGenericPage<TbDkxx> findPage = dkxxService.findPage(object.getPageNo(), object.getPageSize(), dkxx, new HashMap<String, Object>());
		ResultRestBody<TbDkxx> resultFpzjObject = new ResultRestBody<TbDkxx>();
		resultFpzjObject.setTotalCount(findPage.getTotalCount());
		resultFpzjObject.setData(findPage.getThisPageElements());
		return resultFpzjObject;
	}

	//添加
	@CrossOrigin
	@RequestMapping(value="/dkxx/add",method = RequestMethod.POST)
	@ResponseBody
	public Object addUser(@RequestBody String req){
		TbDkxx dkxx = null;
		try{
			dkxx = jsonTranster.readValue(req, TbDkxx.class);
		}catch (Exception e) {
			e.printStackTrace();
			return addResultMapMsg(false,e.getMessage());

		}
		if(dkxx == null || StringUtils.isEmpty(dkxx.getCid()) || StringUtils.isEmpty(dkxx.getQzbm())){
			return addResultMapMsg(false,"参数cid和qzbm不能为空");
		}
		String xzdwId = getUser().getXzdwId();
		dkxx.setXzdwId(xzdwId);
		dkxx.setXzdwName(getUser().getXzdwName());
		boolean add = dkxxService.addDkxx(dkxx);
		if(!add){
			return addResultMapMsg(false,"添加失败");
		}
		return addResultMapMsg(true,"添加成功");
	}

	//修改
	@CrossOrigin
	@RequestMapping(value="/dkxx/update",method = RequestMethod.POST)
	@ResponseBody
	public Object updateUser(@RequestBody String req){
		TbDkxx dkxx = null;
		try{
			dkxx = jsonTranster.readValue(req, TbDkxx.class);
		}catch (Exception e) {
			e.printStackTrace();
			return addResultMapMsg(false,e.getMessage());

		}
		if(dkxx == null || StringUtils.isEmpty(dkxx.getId())){
			return addResultMapMsg(false,"传入参数id不能为空");
		}
		String xzdwId = getUser().getXzdwId();
		dkxx.setXzdwId(xzdwId);
		dkxx.setXzdwName(getUser().getXzdwName());
		boolean update = dkxxService.udpateDkxx(dkxx);
		if(!update){
			return addResultMapMsg(false,"修改失败");
		}
		return addResultMapMsg(true,"修改成功");
	}


	//删除
	@CrossOrigin
	@RequestMapping(value="/dkxx/delete",method = RequestMethod.POST)
	@ResponseBody
	public Object deleteUser(@RequestBody String req){
		TbDkxx dkxx = null;
		try{
			dkxx = jsonTranster.readValue(req, TbDkxx.class);
		}catch (Exception e) {
			return addResultMapMsg(false,e.getMessage());
		}
		if(dkxx == null || StringUtils.isEmpty(dkxx.getId())){
			return addResultMapMsg(false,"传入参数id不能为空");
		}
		boolean delete = dkxxService.deleteById(dkxx.getId());
		if(!delete){
			return addResultMapMsg(false,"删除失败");
		}
		return addResultMapMsg(true,"删除成功");
	}

	@RequestMapping(value="/dkxx/selectCbfAndJob",method = RequestMethod.POST)
	@ResponseBody
	public Object selectCbfAndJob() {
		List<TbCbf> cbfList = dkxxService.selectCbf();
		List<TbJob> jobList = dkxxService.selectJob();
		if(cbfList == null && jobList == null){
			return addResultMapMsg(false,"查询失败");
		}
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("cbfList",cbfList);
		resultMap.put("jobList",jobList);
		return addResultMapMsg(true,resultMap);
	}

}
