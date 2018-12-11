package org.lanqiao.recruit.controller;

import com.google.gson.Gson;
import org.lanqiao.recruit.dao.imp.CompanyLook;
import org.lanqiao.recruit.dao.inter.ICompanyLook;
import org.lanqiao.recruit.domain.Company_profile;
import org.lanqiao.recruit.domain.company_content;
import org.lanqiao.recruit.service.imp.CompanyLookService;
import org.lanqiao.recruit.service.inter.ICompanyLookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Company_profile.do")
public class Company_profileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICompanyLookService iCompanyLookService = new CompanyLookService();
        company_content company_content = null;
        ICompanyLook iCompanyLook = new CompanyLook();
        List<Company_profile> company_profileList = null;
            try {
            company_profileList = iCompanyLookService.selectAll();
                String id = req.getParameter("id");
                int _id = 0;
                if (id != null) {
                    _id = Integer.parseInt(id);
                }
                String belong = req.getParameter("belong");
                company_content = iCompanyLook.getTitle(_id, belong);
                company_content.setTwotitlelist((List<String>)new Gson().fromJson(company_content.getTwotitle(),List.class));
                company_content.setTwoconlist((List<String>)new Gson().fromJson(company_content.getTwocon(),List.class));
                System.out.println(company_content);
            } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("company_profileList",company_profileList);
        req.setAttribute("company_content", company_content);
        req.getRequestDispatcher("/gongsijianjie/tengxun/index.jsp").forward(req,resp);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("最受尊敬的互联网企业·不断倾听和满足用户需求，引导并超越用户需求，赢得用户尊敬·通过提升品牌形象，使员工具有高度企业荣誉感，赢得员工尊敬·推动互联网行业的健康发展，与合作伙伴共成长，赢得行业尊敬·注重企业责任，用心服务，关爱社会、回馈社会，赢得社会尊敬");
        list.add("通过互联网服务提升人类生活品质·使产品和服务像水和电融入人们的生活，为人们带来便捷和愉悦·关注不同地域、群体，并针对不同对象提供差异化的产品和服务·打造开放共赢平台，与合作伙伴共同营造健康的互联网生态环境");
        list.add(" 关心员工成长·为员工提供良好的工作环境和激励机制·完善员工培养体系和职业发展通道，使员工与企业同步成长·充分尊重和信任员工，不断引导和鼓励，使其获得成就的喜悦");
        String s = new Gson().toJson(list);
        System.out.println(s);
    }

}
