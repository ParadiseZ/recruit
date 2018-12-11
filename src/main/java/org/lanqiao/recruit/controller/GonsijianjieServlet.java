package org.lanqiao.recruit.controller;

import com.google.gson.Gson;
import org.lanqiao.recruit.domain.CompanyUser;
import org.lanqiao.recruit.domain.GongSiJianJie;
import org.lanqiao.recruit.service.imp.GongsijianjieService;
import org.lanqiao.recruit.service.inter.IgongsijianjieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/gongsijianjie.do")
public class GonsijianjieServlet extends HttpServlet {
    IgongsijianjieService igongsijianjieService = new GongsijianjieService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pad1 = req.getParameter("pad1");
        String pad2 = req.getParameter("pad2");
        String pad3 = req.getParameter("pad3");
        String pad4 = req.getParameter("pad4");
        String use = req.getParameter("use");
        String jiazhi = req.getParameter("jiazhi");
        String rencai = req.getParameter("rencai");

        String belong = req.getParameter("women");

        List<String>  titleconStr = new ArrayList<>();
        titleconStr.add(pad2);
        titleconStr.add(pad3);
        titleconStr.add(pad4);
        String s = new Gson().toJson(titleconStr);
        List<String> twotitle = new ArrayList<>();
        twotitle.add(use);
        twotitle.add(jiazhi);
        twotitle.add(rencai);
        String  ss = new Gson().toJson(twotitle);
        HttpSession httpSession = req.getSession();
        List<CompanyUser> companyUserList = (List<CompanyUser>)httpSession.getAttribute("userImformation");
        int id = 0;
        for(CompanyUser companyUser:companyUserList){
            id = companyUser.getId();
        }
        GongSiJianJie gongSiJianJie = new GongSiJianJie(id,pad1,s,ss,belong);
        try {
            int II = igongsijianjieService.addGongsijianjie(gongSiJianJie);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/Company_profile.do?id="+id+"&belong=关于我们").forward(req,resp);
    }
}
