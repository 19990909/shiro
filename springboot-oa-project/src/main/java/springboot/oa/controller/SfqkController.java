package springboot.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.oa.domain.TbSfqk;
import springboot.oa.service.SfqkService;
import springboot.oa.vo.PageBean;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class SfqkController {

	@Autowired
	private SfqkService sfqkService;

	@RequestMapping("/sfqk/selectSfqk")
	public String showSfqk() {
		return "sfqk/sfqk";
	}

	@RequestMapping("/sjson")
	public @ResponseBody PageBean<TbSfqk> showAllSfqk(Integer pageNumber, Integer pageSize, String sfmc) {

		PageBean<TbSfqk> pageBean = sfqkService.showSfqk(pageNumber, pageSize, sfmc );
		System.out.println(pageBean);

		return pageBean;

	}

	@RequestMapping("/sfqk/addSfqk")
	public String addSfqk(Integer flag, TbSfqk sfqk, HttpServletResponse response) {
		if (flag == 1) {
			return "sfqk/showAddSfqk";

		} else {
			if (sfqkService.addSfqk(sfqk)) {
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

	@RequestMapping("/sfqk/removeSfqk")
	public String deleteSfqk(Integer flag, Integer id, @RequestParam(required = false, value = "ids[]") Integer[] ids,
			HttpServletResponse response) {
		PrintWriter writer;
		try {
			writer = response.getWriter();

			boolean result = false;
			if (flag == 1) {
				result = sfqkService.deleteById(id);
				return "sfqk/sfqk";

			} else {
				result = sfqkService.deleteBybatch(ids);

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

	@RequestMapping("/sfqk/updateSfqk")
	public String udpateSfqk(Integer flag, Integer id, TbSfqk sfqk, Model model, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();

			if (flag == 1) {// 跳转到修改信息页面
				model.addAttribute("sfqk", sfqkService.findSfqkById(id));
				return "sfqk/showUpdateSfqk";
			} else {

				if (sfqkService.updateSfqk(sfqk)) {
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
