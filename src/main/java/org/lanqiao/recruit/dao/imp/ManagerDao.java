package org.lanqiao.recruit.dao.imp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.recruit.dao.inter.IManagerDao;
import org.lanqiao.recruit.domain.CompanyUser;
import org.lanqiao.recruit.domain.CountOfUserNum;
import org.lanqiao.recruit.domain.ManagerUser;
import org.lanqiao.recruit.domain.person_domain;
import org.lanqiao.recruit.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ManagerDao implements IManagerDao {

    @Override
    public ManagerUser getImfor(String username,String passowrd) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from manager where mname=? and mpassword=?";
        List<ManagerUser> managerUserList = queryRunner.query(sql,new BeanListHandler<>(ManagerUser.class),username,passowrd);
        ManagerUser managerUser = null;
        if (managerUserList.isEmpty()){
            return managerUser;
        }else {
            for(ManagerUser mu:managerUserList){
                managerUser = mu;
            }
            return managerUser;
        }
    }

    @Override
    public List getImforUser(String userKind) throws SQLException {
       QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
       String sql = null;
       if("pUser".equals(userKind)){
           sql = "select * from person";
           List<person_domain> person_domainList = queryRunner.query(sql,new BeanListHandler<>(person_domain.class));
           return person_domainList;
       }else{
           sql = "select * from companyuser";
           List<CompanyUser> companyUserList = queryRunner.query(sql,new BeanListHandler<>(CompanyUser.class));
           return companyUserList;
       }
    }

    @Override
    public void deleteImfor(String userKind, int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = null;
        if("pUser".equals(userKind)){
            sql = "delete from person where pid=?";
            queryRunner.update(sql,id);
        }else {

            System.out.println("success");
            sql = "delete from companyuser where id=?";
            queryRunner.update(sql,id);
        }
    }

    @Override
    public List findImforUser(String userKind,String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = null;
        String userName = "%"+username+"%";
        if("pUser".equals(userKind)){
            sql = "select * from person where pname like ?";
            List<person_domain> person_domainList = queryRunner.query(sql,new BeanListHandler<>(person_domain.class),userName);
            return person_domainList;
        }else{
            sql = "select * from companyuser where username like ?";
            List<CompanyUser> companyUserList = queryRunner.query(sql,new BeanListHandler<>(CompanyUser.class),userName);
            return companyUserList;
        }
    }

    @Override
    public int getCount(String userKind) throws SQLException {
            QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
            String sql = null;
            long numOfGet = 0;
            int num = 0;
            if("pUser".equals(userKind)){
                sql = "select count(*) from person";
                numOfGet = (long)qr.query(sql,new ScalarHandler<>(1));
                num = (int)numOfGet;
                return num;
            }else if("cUser".equals(userKind)){
                sql = "select count(*) from companyuser";
                numOfGet = (long)qr.query(sql,new ScalarHandler<>(1));
                num = (int)numOfGet;
                return num;
            }else {
                sql = "select count(*) from manager";
                numOfGet = (long)qr.query(sql,new ScalarHandler<>(1));
                num = (int)numOfGet;
                return num;
            }
    }

    @Override
    public void deleteAll(String userKin, int[] a) throws SQLException {
        String sql = null;
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        if("pUser".equals(userKin)){
            for(int k:a){
                sql = "delete from person where pid=?";
                queryRunner.update(sql,k);
            }
        }
        if("cUser".equals(userKin)){
            for(int k:a){
                sql = "delete from companyuser where id=?";
                queryRunner.update(sql,k);
            }
        }
    }

    @Override
    public List getPageImfor(String userKind, int startIndex, int pageSize) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = null;
        if("pUser".equals(userKind)){
            sql = "select * from person limit ?,?";
            List<person_domain> person_domainList = queryRunner.query(sql,new BeanListHandler<>(person_domain.class),startIndex,pageSize);
            return person_domainList;
        }else{
            sql = "select * from companyuser limit ?,?";
            List<CompanyUser> companyUserList = queryRunner.query(sql,new BeanListHandler<>(CompanyUser.class),startIndex,pageSize);
            return companyUserList;
        }
    }
}
