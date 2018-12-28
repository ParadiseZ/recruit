package org.lanqiao.recruit.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.lanqiao.recruit.domain.CompanyUser;
import org.lanqiao.recruit.domain.CountOfUserNum;
import org.lanqiao.recruit.domain.ManagerUser;
import org.lanqiao.recruit.domain.person_domain;
import org.lanqiao.recruit.service.imp.ManagerService;
import org.lanqiao.recruit.service.inter.IManagerService;
import org.lanqiao.recruit.utils.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/manager.do")
public class ManagerServlet extends HttpServlet {
    IManagerService managerService = new ManagerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String methodGet = req.getParameter("methodM");
        HttpSession httpSession = req.getSession();
        if(methodGet!=null&&!"".equals(methodGet)){
            if("managerLogin".equals(methodGet)){
                String mUsername = req.getParameter("username");
                String mpassword = req.getParameter("password");
                getAndSetNum_user(req, resp);
                getImforFromService(req,resp,httpSession,mUsername,mpassword);
            }
            if("findPuserImfor".equals(methodGet)){
                List<person_domain> person_domainList = (List<person_domain>)managerService.getImforUser("pUser");
                req.setAttribute("userImfor",person_domainList);
                req.getRequestDispatcher("/member-list.jsp").forward(req,resp);
            }
            if("findCuserImfor".equals(methodGet)){
                List<CompanyUser> companyUserList = (List<CompanyUser>)managerService.getImforUser("cUser");
                req.setAttribute("userImforC",companyUserList);
                req.getRequestDispatcher("/member-del.jsp").forward(req,resp);
            }
            if("deletePuserImdor".equals(methodGet)){
                String idGet = req.getParameter("ID");
                int id = Integer.parseInt(idGet);
                managerService.deleteImfor("pUser",id);
                int pUserNum = managerService.countNumOfUser("pUser",null);
                PrintWriter out = resp.getWriter();
                String pUserNumStr = JSON.toJSONString(pUserNum);
                out.print(pUserNumStr);
            }
            if("deleteCuserImfor".equals(methodGet)){
                String idGet = req.getParameter("ID");
                int id = Integer.parseInt(idGet);
                managerService.deleteImfor("cUser",id);
                int cUserNum = managerService.countNumOfUser("cUser",null);
                PrintWriter out = resp.getWriter();
                String cUserNumStr = JSON.toJSONString(cUserNum);
                out.print(cUserNumStr);
            }
            if("searchPuserImfor".equals(methodGet)){
                String username = req.getParameter("input-username");
                String currentPage = req.getParameter("currentPage");
                int pageNum = Integer.parseInt(currentPage);
                int pUserNum = managerService.countNumOfUser("pUser",username);
                if(pUserNum==0){
                    pUserNum=1;
                }
                PageModel pm = new PageModel(pageNum,pUserNum,7);
                List<person_domain> person_domainList = ( List<person_domain>)managerService.findImforUser(pm.getStartIndex(),pm.getPageSize(),"pUser",username);
                pm.setRecords(person_domainList);
                req.setAttribute("userImfor",person_domainList);
                req.setAttribute("pm",pm);
                req.getRequestDispatcher("/member-list.jsp").forward(req,resp);
            }
            if("searchCuserImfor".equals(methodGet)){
                String username = req.getParameter("input-username");
                String currentPage = req.getParameter("currentPage");
                int pageNum = Integer.parseInt(currentPage);
                int cUserNum = managerService.countNumOfUser("cUser",username);
                if(cUserNum==0){
                    cUserNum=1;
                }
                PageModel pm = new PageModel(pageNum,cUserNum,7);
                List<CompanyUser> companyUserList = ( List<CompanyUser>)managerService.findImforUser(pm.getStartIndex(),pm.getPageSize(),"cUser",username);
                pm.setRecords(companyUserList);
                req.setAttribute("userImforC",companyUserList);
                req.setAttribute("pm",pm);
                req.getRequestDispatcher("/member-del.jsp").forward(req,resp);
            }
            if("deleteAllpUser".equals(methodGet)){
                String attr =  req.getParameter("attr");
                JSONArray jsonA = JSONArray.fromObject(JSON.parse(attr));
                int arrary[] = new int[jsonA.size()];
                for(int i = 0; i<jsonA.size() ;i++){
                    arrary[i] = Integer.parseInt(jsonA.get(i).toString());
                }
                managerService.deleteAll("pUser",arrary);
                PrintWriter out = resp.getWriter();
                String is = JSON.toJSONString("eppea");
                out.print(is);
            }
            if("deleteAllcUser".equals(methodGet)){
                String attr =  req.getParameter("attr");
                JSONArray jsonA = JSONArray.fromObject(JSON.parse(attr));
                int arrary[] = new int[jsonA.size()];
                for(int i = 0; i<jsonA.size() ;i++){
                    arrary[i] = Integer.parseInt(jsonA.get(i).toString());
                }
                managerService.deleteAll("cUser",arrary);
                PrintWriter out = resp.getWriter();
                String is = JSON.toJSONString("eppea");
                out.print(is);
            }
            if("findPageImforpUser".equals(methodGet)){
                String currentPage = req.getParameter("currentPage");
                int pageNum = Integer.parseInt(currentPage);
                int pUserNum = managerService.countNumOfUser("pUser",null);
                PageModel pm = new PageModel(pageNum,pUserNum,7);
                List<person_domain> person_domainList = (List<person_domain>)managerService.getPageImfor("pUser",pm.getStartIndex(),pm.getPageSize());
                pm.setRecords(person_domainList);
                req.setAttribute("userImfor",person_domainList);
                req.setAttribute("pm",pm);
                req.getRequestDispatcher("/member-list.jsp").forward(req,resp);
            }
            if("findPageImforcUser".equals(methodGet)){
                String currentPage = req.getParameter("currentPage");
                int pageNum = Integer.parseInt(currentPage);
                int pUserNum = managerService.countNumOfUser("cUser",null);
                PageModel pm = new PageModel(pageNum,pUserNum,7);
                List<CompanyUser> companyUserList = (List<CompanyUser>)managerService.getPageImfor("cUser",pm.getStartIndex(),pm.getPageSize());

                pm.setRecords(companyUserList);
                req.setAttribute("userImforC",companyUserList);
                req.setAttribute("pm",pm);
                req.getRequestDispatcher("/member-del.jsp").forward(req,resp);
            }
            if("resetpUserPwd".equals(methodGet)){
                String idGet = req.getParameter("ID");
                int idReset = Integer.parseInt(idGet);
                managerService.resetPwd("pUser",idReset);
            }
            if("resetcUserPwd".equals(methodGet)){
                String idGet = req.getParameter("ID");
                int idReset = Integer.parseInt(idGet);
                managerService.resetPwd("cUser",idReset);
            }
        }
    }

    //获取管理员信息
    public void getImforFromService(HttpServletRequest req, HttpServletResponse resp,HttpSession httpSession,String username,String password){
        ManagerUser mm = managerService.getImforFromDao(username,password);
        if(mm!=null&&!"".equals(mm)){
            httpSession.setAttribute("managerUser",mm);
            try {
                req.getRequestDispatcher("/managerIndex.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            httpSession.setAttribute("error","您的用户名或密码错误！");
            try {
                resp.sendRedirect("/managerLogin.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    };

    //获取用户数量
    public CountOfUserNum getAndSetNum_user(HttpServletRequest req, HttpServletResponse resp){
        HttpSession httpSession = req.getSession();
        int pUserNum = managerService.countNumOfUser("pUser",null);
        int cUserNum = managerService.countNumOfUser("cUser",null);
        int mUserNum = managerService.countNumOfUser("mUser",null);
        CountOfUserNum countOfUserNum = new CountOfUserNum(pUserNum,cUserNum,mUserNum);
        httpSession.setAttribute("countOfUserNum",countOfUserNum);
        return countOfUserNum;
    }
}
