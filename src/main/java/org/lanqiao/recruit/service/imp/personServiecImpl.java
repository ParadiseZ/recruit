package org.lanqiao.recruit.service.imp;

import org.lanqiao.recruit.dao.imp.personaler;
import org.lanqiao.recruit.dao.inter.IPersonal;
import org.lanqiao.recruit.domain.person_domain;
import org.lanqiao.recruit.service.inter.IPersonService;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class personServiecImpl implements IPersonService {
    IPersonal dao =  new personaler() ;
    @Override
    public List <person_domain> addpuser(String username, String password) {
        try {
            dao.addPuser( username,password );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//通过用户名查找数据库中的信息
    @Override
    public void findalbyYonghuming() {
        try {
            dao.personalmessage();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//判断该用户是否登陆
    @Override
    public boolean checkinfor(String pname, String password) {
        boolean bb = false;
        try {
           bb = dao.checkmessage(pname, password );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bb;
    }
//将注册完善的信息写到数据库
    @Override
    public void addperson(person_domain personDomain) {
        try {
            dao.instermessage(personDomain );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //修改个人信息
    @Override
    public boolean updatePerson(String phone, String password, String psex, String ptime, String pstate, String pmajor, String pexjob, String psrecord, String psal, String padvantage, String pemail) {
        boolean upp=true;
        try {
            upp =dao.updateperson( phone, password, psex,  ptime, pstate,  pmajor, pexjob, psrecord, psal, padvantage, pemail );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
