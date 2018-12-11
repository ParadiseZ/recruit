package org.lanqiao.recruit.dao.imp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.recruit.dao.inter.ICompanyLook;
import org.lanqiao.recruit.domain.Company_profile;
import org.lanqiao.recruit.domain.company_content;
import org.lanqiao.recruit.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyLook implements ICompanyLook {
    @Override
    public List<Company_profile> lookCompany() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from company_profile";
        List<Company_profile> company_profiles = qr.query(sql,new BeanListHandler<>(Company_profile.class));
        return company_profiles;
    }

    @Override
    public company_content getTitle(int pid, String belong) throws SQLException  {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        return qr.query("select * from company_content where pid = ? and belong = ?",new BeanHandler<>(company_content.class), pid,belong);
    }
}
