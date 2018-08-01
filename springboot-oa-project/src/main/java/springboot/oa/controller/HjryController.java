package springboot.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.oa.base.controller.BaseController;
import springboot.oa.domain.TbHjry;
import springboot.oa.service.HjryService;
import springboot.oa.vo.PageBean;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class HjryController extends BaseController{

	@Autowired
	private HjryService hjryService;

	@RequestMapping("/hjry/selectHjry")
	public String showhjry() {
		return "hjry/hjry";
	}

	@RequestMapping("/pjson")
	public @ResponseBody PageBean<TbHjry> showAllHjry(Integer pageNumber, Integer pageSize, String hjryxm) {

		PageBean<TbHjry> pageBean = hjryService.showHjry(pageNumber, pageSize, hjryxm);
		System.out.println(pageBean);

		return pageBean;

	}

	@RequestMapping("/hjry/addHjry")
	public String addHjry(Integer flag, TbHjry hjry, HttpServletResponse response) {
		if (flag == 1) {
			return "hjry/showAddHjry";

		} else {
			if (hjryService.addHjry(hjry)) {
				try {
					response.getWriter().print("success");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					response.getWriter().print("error");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	@RequestMapping("/hjry/removeHjry")
	public String deleteHjry(Integer flag, Integer id, @RequestParam(required = false, value = "ids[]") Integer[] ids,
			HttpServletResponse response) {
		PrintWriter writer;
		try {
			writer = response.getWriter();

			boolean result = false;
			if (flag == 1) {
				result = hjryService.deleteById(id);
				return "hjry/hjry";

			} else {
				result = hjryService.deleteBybatch(ids);

			}
			if (result) {
				writer.print("success");
			} else {
				writer.print("error");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// /dept/updateDept

	@RequestMapping("/hjry/updateHjry")
	public String udpateHjry(Integer flag, Integer id, TbHjry hjry, Model model, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();

			if (flag == 1) {// 跳转到修改信息页面
				model.addAttribute("hjry", hjryService.findHjryById(id));
				return "hjry/showUpdateHjry";
			} else {

				if (hjryService.updateHjry(hjry)) {
					writer.print("success");
				} else {
					writer.print("error");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/hjry/selectHjryXm",method = RequestMethod.POST)
	@ResponseBody
	public Object selectHjryXm(){
		Map<String,String> resultMap = hjryService.selectHjryXm();
		if(resultMap.isEmpty()){
			return addResultMapMsg(false,"查询失败");
		}
		return addResultMapMsg(true,resultMap);
	}
}
