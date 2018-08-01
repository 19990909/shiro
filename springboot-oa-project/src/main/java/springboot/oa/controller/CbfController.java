package springboot.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springboot.oa.domain.TbCbf;

import springboot.oa.domain.TbJob;
import springboot.oa.service.CbfService;

import springboot.oa.vo.PageBean;

@Controller
public class CbfController {

    @Autowired
    private CbfService cbfService;

   /* @RequestMapping("/cbf/selectCbf")*/
    /*public String selectCbf(HttpSession session) {


        List<TbJob> jobList = cbfService.selectJob();

        session.setAttribute("jobList", jobList);

        return "cbf/cbf";
    }*/


    @RequestMapping("/cbf/selectCbf")
    public String showCbf() {

        return "cbf/cbf";
    }

    @RequestMapping("/cjson")
    public @ResponseBody PageBean<TbCbf> showAllFbf(Integer pageNumber, Integer pageSize, String cbfmc) {

        PageBean<TbCbf> pageBean = cbfService.showCbf(pageNumber, pageSize, cbfmc );
        System.out.println(pageBean);

        return pageBean;

    }

    @RequestMapping("/cbf/addCbf")
    public String addCbf(Integer flag, TbCbf cbf, HttpServletResponse response) {
        if (flag == 1) {
            return "cbf/showAddCbf";

        } else {
            if (cbfService.addCbf(cbf)) {
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

    @RequestMapping("/cbf/removeCbf")
    public String deleteCbf(Integer flag, Integer id, @RequestParam(required = false, value = "ids[]") Integer[] ids,
                            HttpServletResponse response) {
        PrintWriter writer;
        try {
            writer = response.getWriter();

            boolean result = false;
            if (flag == 1) {
                result = cbfService.deleteById(id);
                return "cbf/cbf";

            } else {
                result = cbfService.deleteBybatch(ids);

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

    // /cbf/updateCbf

    @RequestMapping("/cbf/updateCbf")
    public String udpateCbf(Integer flag, Integer id, TbCbf cbf, Model model, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = response.getWriter();

            if (flag == 1) {// 跳转到修改信息页面
                model.addAttribute("cbf",cbfService.findCbfById(id));
                return "cbf/showUpdateCbf";
            } else {

                if (cbfService.updateCbf(cbf)) {
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
