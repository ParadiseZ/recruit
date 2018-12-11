package org.lanqiao.recruit.controller;

import org.lanqiao.recruit.domain.Recruit;
import org.lanqiao.recruit.service.imp.SearchFromBossService;
import org.lanqiao.recruit.service.inter.ISearchFromBossService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search.do")
public class SearchGetImfor extends HttpServlet {
    ISearchFromBossService searchFromBossService = new SearchFromBossService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("searchImfor".equals(method)){
            String userKindS = req.getParameter("searchInput");
            List<Recruit> recruitList = searchFromBossService.searchImfor(userKindS);
            req.getSession().setAttribute("searchImformation",recruitList);
            req.getRequestDispatcher("/zhiwei.jsp").forward(req,resp);
        }
    }
}
