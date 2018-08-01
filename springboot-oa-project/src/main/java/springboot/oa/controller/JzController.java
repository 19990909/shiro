package springboot.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.oa.base.controller.BaseController;
import springboot.oa.domain.TbJz;
import springboot.oa.service.JzService;
import springboot.oa.vo.PageBean;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class JzController extends BaseController{

	@Autowired
	private JzService jzservice;

	@RequestMapping("/jz/selectJz")
	public String showJz() {
		return "jz/jz";
	}

	@RequestMapping("/zjson")
	public @ResponseBody PageBean<TbJz> showAllJz(Integer pageNumber, Integer pageSize, String jzlx) {

		PageBean<TbJz> pageBean = jzservice.showJz(pageNumber, pageSize,jzlx );
		System.out.println(pageBean);

		return pageBean;

	}

	@RequestMapping("/jz/addJz")
	public String addJz(Integer flag, TbJz jz, HttpServletResponse response) {
		if (flag == 1) {
			return "jz/showAddJz";

		} else {
			if (jzservice.addJz(jz)) {
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

	@RequestMapping("/jz/removeJz")
	public String deleteJz(Integer flag, Integer id, @RequestParam(required = false, value = "ids[]") Integer[] ids,
			HttpServletResponse response) {
		PrintWriter writer;
		try {
			writer = response.getWriter();

			boolean result = false;
			if (flag == 1) {
				result = jzservice.deleteById(id);
				return "jz/jz";

			} else {
				result = jzservice.deleteBybatch(ids);

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

	@RequestMapping("/jz/updateJz")
	public String udpateJz(Integer flag, Integer id, TbJz jz, Model model, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();

			if (flag == 1) {// 跳转到修改信息页面
				model.addAttribute("jz", jzservice.findJzById(id));
				return "jz/showUpdateJz";
			} else {

				if (jzservice.updateJz(jz)) {
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
	@RequestMapping(value = "/jz/selectTbJzBm",method = RequestMethod.POST)
	@ResponseBody
	public Object selectTbJzBm(){
		Map<String,String> resultMap = jzservice.selectTbJzBm();
		if(resultMap.isEmpty()){
			return addResultMapMsg(false,"查询失败");
		}
		return addResultMapMsg(true,resultMap);
	}

}
