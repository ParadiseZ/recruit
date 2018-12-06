package org.lanqiao.recruit.dao.imp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.recruit.dao.inter.IRegisterLogin;
import org.lanqiao.recruit.domain.CompanyUser;
import org.lanqiao.recruit.domain.person_domain;
import org.lanqiao.recruit.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class RegisterLogin implements IRegisterLogin{
    //添加企业用户
    public void addCuser(String username, String password) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into companyuser(username,password) value(?,?)";
        qr.update(sql,username,password);
    }

    //用户名登录
    public Map usernameLogin(String username, String password) throws SQLException {
        Map resultMap = null;
        boolean resultLogin = false;
        List<CompanyUser> companyUserList = null;
        List<person_domain> person_domainList = null;
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        BeanListHandler<CompanyUser> companyUser = new BeanListHandler<>(CompanyUser.class);
        BeanListHandler<person_domain> person_domain = new BeanListHandler<>(person_domain.class);
        String sql = "select ?,? from companyuser";
        companyUserList = queryRunner.query(sql,companyUser,username,password);
        if(companyUserList.isEmpty()){
            sql = "select ?,? from person";
            person_domainList = queryRunner.query(sql,person_domain,username,password);
            if(person_domainList.isEmpty()){
                resultMap.put(0,0);
                return resultMap;
            }else{
                sql = "select * from person";
                person_domainList = queryRunner.query(sql,person_domain);
                resultMap.put(2,person_domainList);
                return  resultMap;
            }
        }else {
            sql = "select * from companyuser";
            companyUserList = queryRunner.query(sql,companyUser);
            resultMap.put(1,companyUserList);
            return resultMap;
        }
    }

}
