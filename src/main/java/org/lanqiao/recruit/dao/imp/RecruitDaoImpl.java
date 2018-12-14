package org.lanqiao.recruit.dao.imp;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.recruit.dao.inter.IRecruitDao;
import org.lanqiao.recruit.domain.Recruit;
import org.lanqiao.recruit.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class RecruitDaoImpl implements IRecruitDao {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public List<Recruit> getRecruitList() {
        String sql = "SELECT * from recruit";
        List<Recruit> recruitList = null;
        try {
            recruitList = qr.query(sql,new BeanListHandler<>(Recruit.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recruitList;
    }

    @Override
    public void addRecruit(Recruit recruit) {
        String sql = "INSERT INTO recruit (job,neednum,sal,location,companyname,jobduty,datetime,promulgator) VALUES (?,?,?,?,?,?,?,?)";
        try {
            qr.update(sql,recruit.getJob(),recruit.getNeednum(),recruit.getSal(),recruit.getLocation(),recruit.getCompanyname(),recruit.getJobduty(),recruit.getDatatime(),recruit.getPromulgator());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
