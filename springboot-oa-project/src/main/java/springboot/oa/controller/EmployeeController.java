package springboot.oa.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.oa.domain.TbFbf;
import springboot.oa.domain.TbEmployee;
import springboot.oa.domain.TbJob;
import springboot.oa.service.EmployeeService;
import springboot.oa.vo.PageBean;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employee/selectEmployee")
	public String selectEmployee(HttpSession session) {

		List<TbFbf> deptList = employeeService.selectFbf();
		List<TbJob> jobList = employeeService.selectJob();
		session.setAttribute("deptList", deptList);
		session.setAttribute("jobList", jobList);

		return "employee/employee";
	}
	@RequestMapping("/employee/addEmployee")
	public String addEmployee() {
		return "employee/showAddEmployee";
	}

	@RequestMapping("/ejson")
	public @ResponseBody PageBean<TbEmployee> showAllEmployee(Integer pageNumber, Integer pageSize) {

		// 转一个我们封装的message 加 Bean

		System.out.println(pageNumber);
		System.out.println(pageSize);
		PageBean<TbEmployee> pageBean = employeeService.showEmployee(pageNumber, pageSize);
		System.out.println(pageBean);

		return pageBean;

	}

	// udpate
	// employee/updateEmployee?
	@RequestMapping("/employee/updateEmployee")
	public String updateEmployee(Integer flag, Integer id, Model model, String name, @RequestParam(required=false ,value="")TbEmployee employee, HttpServletResponse response) {
		System.out.println("udpate");
		if (flag == 1) {
			TbEmployee employee1 = employeeService.findEmployeeById(id);
			model.addAttribute("employee", employee1);
			return "employee/showUpdateEmployee";
		} else {
			System.out.println("employeee-------------");
			
			try {
				System.out.println(name);
				System.out.println(employee);
				response.getWriter().print("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}

	}

}
