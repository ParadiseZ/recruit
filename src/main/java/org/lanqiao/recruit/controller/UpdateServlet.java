package org.lanqiao.recruit.controller;

import com.alibaba.fastjson.JSON;
import org.lanqiao.recruit.domain.person_domain;
import org.lanqiao.recruit.service.imp.RegisterLoginService;
import org.lanqiao.recruit.service.imp.personServiecImpl;
import org.lanqiao.recruit.service.inter.IPersonService;
import org.lanqiao.recruit.service.inter.IRegisterLoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/updateperson.do")
public class UpdateServlet extends HttpServlet {
    IPersonService iPersonService=new personServiecImpl();
    IRegisterLoginService registerLoginService = new RegisterLoginService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet( req, resp );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method=req.getParameter( "method" );
        resp.setCharacterEncoding("UTF-8");
      req.getRequestDispatcher("/updatePersonal.jsp").forward(req,resp);
        switch (method){
            case "getPersonal":
                getPersonal(req,resp);
               break;
            case "updateperson":
                updateperson(req,resp);
                break;
}
    }

    private void getPersonal(HttpServletRequest req, HttpServletResponse resp) {
    }

    public void getBid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String pid= (String) req.getAttribute( "pid" );


        person_domain ps = iPersonService.findalbyid( Integer.parseInt( pid ) );
        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = JSON.toJSONString(ps);
        out.print( result );*/
//        HttpSession session = req.getSession();
//        List<person_domain> personDomainList = (List<person_domain>)session.getAttribute("userImformation");
//        for(person_domain ps:personDomainList){
//        }
        req.getRequestDispatcher("/updatePersonal.jsp").forward(req,resp);
    }
    public void updateperson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/updatePersonal.jsp").forward(req,resp);
        String username = req.getParameter("username");
        System.out.println(username);
        String passsword = req.getParameter( "password" );
        System.out.println(passsword);
        String hone=req.getParameter("phone"  );
        String sex=req.getParameter( "sex" );
        String born=req.getParameter( "born" );
        System.out.println(born);
        String pid=req.getParameter("pid" );
        System.out.println(pid+"88");
        int id=Integer.parseInt(pid);
        System.out.println(id+"11111111111111111111111");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date bb=null;
        if(born !=null && !"".equals(born)){
            try {
                bb= sdf.parse(born);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        String ptime=req.getParameter("gtime"  );
        String pstate=req.getParameter( "position" );
        String school=req.getParameter( "pschool" );
        String major=req.getParameter("xueli"  );
        String exjob=req.getParameter( "exjob" );
        String psrecord=req.getParameter( "zhuanye" );
        String psal=req.getParameter("exsal"  );
        String padvantage=req.getParameter( "pad" );
        String pemail = req.getParameter( "emial" );
        System.out.println(padvantage);
         person_domain personDomain = new person_domain(id,hone,passsword,username,sex,bb,ptime,pstate,school,major,exjob,psrecord,psal,padvantage,pemail);
        System.out.println(personDomain);
            iPersonService.updatePerson(personDomain);
            Map resultMap = registerLoginService.usernameLogin(username,passsword);
            if(resultMap.containsKey(2)){
                List<person_domain> person_domainList = (List<person_domain>) resultMap.get(2);
                req.getSession().setAttribute("userImformation",person_domainList);
            }
        req.getRequestDispatcher( "/show.jsp" ).forward( req,resp );

    }
}