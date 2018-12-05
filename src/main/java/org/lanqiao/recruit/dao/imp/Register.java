package org.lanqiao.recruit.dao.imp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.recruit.dao.inter.IRegister;
import org.lanqiao.recruit.utils.JDBCUtils;

public class Register implements IRegister {
    public void addCuser(String username, String password, String userKind) {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into companyuser(corporation,password) value(?,?)";
//        qr.query(sql);

    }
}
