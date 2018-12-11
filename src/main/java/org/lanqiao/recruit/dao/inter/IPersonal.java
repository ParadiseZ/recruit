package org.lanqiao.recruit.dao.inter;

import org.lanqiao.recruit.domain.person_domain;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IPersonal {
    //添加个人用户到数据库
    public void addPuser(String pname,String password) throws SQLException;
    public person_domain personalmessage(int i) throws SQLException;
    public void instermessage(person_domain personDomain) throws SQLException;
    public boolean checkmessage(String pname,String password) throws SQLException;
    public boolean updateperson(person_domain personDomain) throws SQLException;
}
