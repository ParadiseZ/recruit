package org.lanqiao.recruit.controller;

import org.lanqiao.recruit.domain.Recruit;
import org.lanqiao.recruit.service.imp.RecruitServiceImpl;
import org.lanqiao.recruit.service.inter.IRecruitService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/recruit.do")
public class RecruitServlet extends HttpServlet {
    IRecruitService recruitService = new RecruitServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "getRecruitList":
                getRecruitList(req,resp);
                break;
            case "addRecruit":
                addRecruit(req,resp);
                break;
        }
    }

    private void addRecruit(HttpServletRequest req, HttpServletResponse resp) {
        Recruit recruit = new Recruit();

        HttpSession httpSession = req.getSession();

//         Int类型强转换  String类型直接写
//          recruit.setNeednum(Integer.valueOf(req.getParameter("sal")));
//        recruit.setSal(req.getParameter("sal"));
//        recruit.setId(Integer.valueOf(req.getParameter("id")));
        recruit.setSal(req.getParameter("sal"));
        recruit.setNeednum(Integer.valueOf(req.getParameter("neednum")));
        recruit.setJob(req.getParameter("job"));
        recruit.setCompanyname(req.getParameter("companyname"));
        recruit.setJobduty(req.getParameter("jobduty"));
        recruit.setLocation(req.getParameter("location"));
        recruit.setPromulgator(req.getParameter("promulgator"));


        System.out.println(recruit);
        recruitService.addRecruit(recruit);
        getRecruitList(req,resp);
    }

    private void getRecruitList(HttpServletRequest req, HttpServletResponse resp) {
        List<Recruit> recruitList = recruitService.getRecruitList();
        req.setAttribute("recruitList",recruitList);
        try {
            req.getRequestDispatcher("/jobList.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
