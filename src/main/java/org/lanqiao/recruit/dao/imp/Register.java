package org.lanqiao.recruit.dao.imp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.recruit.dao.inter.IRegister;
import org.lanqiao.recruit.utils.JDBCUtils;

import java.sql.SQLException;

public class Register implements IRegister {
    public void addCuser(String username, String password) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into companyuser(username,password) value(?,?)";
        qr.update(sql,username,password);

    }
}
