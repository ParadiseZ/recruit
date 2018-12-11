package org.lanqiao.recruit.dao.imp;

import com.google.gson.Gson;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.recruit.dao.inter.IGongSiJianJie;
import org.lanqiao.recruit.domain.GongSiJianJie;
import org.lanqiao.recruit.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GongSiJianJieDao implements IGongSiJianJie {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public Integer addData(org.lanqiao.recruit.domain.GongSiJianJie gongSiJianJie) throws SQLException {
        String sql = "insert into company_content(pid,titlecon,twocon,twotitle,belong) values(?,?,?,?,?)";
        qr.update(sql,gongSiJianJie.getPid(),gongSiJianJie.getTwotitle(),gongSiJianJie.getTwocon(),gongSiJianJie.getTitlecon(),gongSiJianJie.getBelong());
        return Integer.valueOf(qr.query("select max(pid) from company_content",new ScalarHandler<>(1)).toString());
    }

    @Override
    public GongSiJianJie selectByTitlecon(String titlecon) throws SQLException {
        String sql  = "select titlecon,twocon from company_content where titlecon=?";
        return qr.query(sql,new BeanHandler<GongSiJianJie>(GongSiJianJie.class));
    }
}
