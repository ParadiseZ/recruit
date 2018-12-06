package org.lanqiao.recruit.dao.inter;

import java.sql.SQLException;

public interface IRegisterLoginDao {
    //添加企业用户到数据库
    public void addCuser(String username,String password) throws SQLException;
}
