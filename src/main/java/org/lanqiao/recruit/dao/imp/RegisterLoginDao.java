package org.lanqiao.recruit.dao.imp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.recruit.dao.inter.IRegisterLoginDao;
import org.lanqiao.recruit.domain.CompanyUser;
import org.lanqiao.recruit.domain.person_domain;
import org.lanqiao.recruit.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterLoginDao implements IRegisterLoginDao {
    //添加企业用户
    public void addCuser(CompanyUser companyUser) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into companyuser(username,password,phone,corporation,companyname,email,job) value(?,?,?,?,?,?,?)";
        qr.update(sql,companyUser.getUserName(),companyUser.getPassword(),companyUser.getPhone(),companyUser.getCorporation(),companyUser.getCompanyName(),companyUser.getEmail(),companyUser.getJob());
    }

    //修改企业用户信息
    public void modifyCuser(CompanyUser companyUser) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "update companyuser set username=?,password=?,phone=?,corporation=?,companyname=?,email=?,job=? where id=?";
        qr.update(sql,companyUser.getUserName(),companyUser.getPassword(),companyUser.getPhone(),companyUser.getCorporation(),companyUser.getCompanyName(),companyUser.getEmail(),companyUser.getJob(),companyUser.getId());
    }
    //检查用户名是否存在
    public boolean checkImfor(String username) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from companyuser where username=?";
        List<CompanyUser> cUserListCheck = qr.query(sql,new BeanListHandler<>(CompanyUser.class),username);
        sql="select * from person where pname=?";
        List<person_domain> person_domainList = qr.query(sql,new BeanListHandler<>(person_domain.class),username);
        if(cUserListCheck.isEmpty() && person_domainList.isEmpty()){
            return true;
        }else return false;
    }

    //用户名登录
    public Map usernameLogin(String username, String password) throws SQLException {
        Map resultMap = new HashMap();
        List<CompanyUser> companyUserList = null;
        List<person_domain> person_domainList = null;
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        BeanListHandler<CompanyUser> companyUser = new BeanListHandler<>(CompanyUser.class);
        BeanListHandler<person_domain> person_domain = new BeanListHandler<>(person_domain.class);
        String sql = "select * from companyuser where username=? and password=?";
        companyUserList = queryRunner.query(sql,companyUser,username,password);
        //查询企业用户表中是否有该用户
        if(companyUserList.isEmpty()){
            sql = "select * from companyuser where email=? and password=?";
            companyUserList = queryRunner.query(sql,companyUser,username,password);
            if(companyUserList.isEmpty()){
                sql="select * from companyuser where phone=? and password=?";
                companyUserList = queryRunner.query(sql,companyUser,username,password);
                if(companyUserList.isEmpty()){
                    sql = "select * from person where pname=? and password=?";
                    person_domainList = queryRunner.query(sql,person_domain,username,password);
                    //查询个人用户表中是否有该用户
                    if(person_domainList.isEmpty()){
                        sql = "select * from person where pemail=? and password=?";
                        person_domainList = queryRunner.query(sql,person_domain,username,password);
                        if(person_domainList.isEmpty()){
                            sql = "select * from person where phone=? and password=?";
                            person_domainList = queryRunner.query(sql,person_domain,username,password);
                            if(person_domainList.isEmpty()){
                                resultMap.put(0,0);
                                return resultMap;
                            }else {
                                resultMap.put(2,person_domainList);
                                return  resultMap;
                            }
                        }else {
                            resultMap.put(2,person_domainList);
                            return  resultMap;
                        }
                    }else{
                        //将该个人用户信息查询出来并保存
                        resultMap.put(2,person_domainList);
                        return  resultMap;
                    }
                }else {
                    resultMap.put(1,companyUserList);
                    return resultMap;
                }
            }else {
                resultMap.put(1,companyUserList);
                return resultMap;
            }
        }else {
            //将该企业用户查询出来并保存
            resultMap.put(1,companyUserList);
            return resultMap;
        }
    }

    //邮箱登录
    public Map emailLogin(String email, String password) throws SQLException {
        Map resultMap = new HashMap();
        List<CompanyUser> companyUserList = null;
        List<person_domain> person_domainList = null;
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        BeanListHandler<CompanyUser> companyUser = new BeanListHandler<>(CompanyUser.class);
        BeanListHandler<person_domain> person_domain = new BeanListHandler<>(person_domain.class);
        String sql = "select * from companyuser where email=? and password=?";
        companyUserList = queryRunner.query(sql,companyUser,email,password);
        //查询企业用户表中是否有该用户
        if(companyUserList.isEmpty()){
            sql = "select * from person where pemail=? and password=?";
            person_domainList = queryRunner.query(sql,person_domain,email,password);
            //查询个人用户表中是否有该用户
            if(person_domainList.isEmpty()){
                resultMap.put(0,0);
                return resultMap;
            }else{
                //将该个人用户信息查询出来并保存
                sql = "select * from person";
                person_domainList = queryRunner.query(sql,person_domain);
                resultMap.put(2,person_domainList);
                return  resultMap;
            }
        }else {
            //将该企业用户查询出来并保存
            sql = "select * from companyuser";
            companyUserList = queryRunner.query(sql,companyUser);
            resultMap.put(1,companyUserList);
            return resultMap;
        }
    }
}
