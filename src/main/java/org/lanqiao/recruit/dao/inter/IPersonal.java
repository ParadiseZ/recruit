package org.lanqiao.recruit.dao.inter;

import org.lanqiao.recruit.domain.person_domain;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IPersonal {
    //添加个人用户到数据库
    public void addPuser(String pname,String password) throws SQLException;


    public List <person_domain> personalmessage() throws SQLException;
    public void instermessage(person_domain personDomain) throws SQLException;
    public boolean checkmessage(String pname,String password) throws SQLException;
    public boolean updateperson(String phone,String password,String psex,String ptime,String pstate,String pmajor, String pexjob, String psrecord,String psal,String padvantage,String pemail) throws SQLException;
}
