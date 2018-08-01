package springboot.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springboot.oa.domain.TbFbf;
import springboot.oa.service.FbfService;
import springboot.oa.vo.PageBean;

@Controller
public class FbfController {

	@Autowired
	private FbfService fbfservice;

	@RequestMapping("/fbf/selectFbf")
	public String showFbf() {
		return "fbf/fbf";
	}

	@RequestMapping("/djson")
	public @ResponseBody PageBean<TbFbf> showAllFbf(Integer pageNumber, Integer pageSize, String fbfmc) {

		PageBean<TbFbf> pageBean = fbfservice.showFbf(pageNumber, pageSize, fbfmc );
		System.out.println(pageBean);

		return pageBean;

	}

	@RequestMapping("/fbf/addFbf")
	public String addFbf(Integer flag, TbFbf fbf, HttpServletResponse response) {
		if (flag == 1) {
			return "fbf/showAddFbf";

		} else {
			if (fbfservice.addFbf(fbf)) {
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

	@RequestMapping("/fbf/removeFbf")
	public String deleteFbf(Integer flag, Integer id, @RequestParam(required = false, value = "ids[]") Integer[] ids,
			HttpServletResponse response) {
		PrintWriter writer;
		try {
			writer = response.getWriter();

			boolean result = false;
			if (flag == 1) {
				result = fbfservice.deleteById(id);
				return "fbf/fbf";

			} else {
				result = fbfservice.deleteBybatch(ids);

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

	@RequestMapping("/fbf/updateFbf")
	public String udpateFbf(Integer flag, Integer id, TbFbf fbf, Model model, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();

			if (flag == 1) {// 跳转到修改信息页面
				model.addAttribute("fbf", fbfservice.findFbfById(id));
				return "fbf/showUpdateFbf";
			} else {

				if (fbfservice.updateFbf(fbf)) {
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

}
