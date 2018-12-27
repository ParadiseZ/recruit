package org.lanqiao.recruit.dao.imp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.recruit.dao.inter.ISearchFromBoss;
import org.lanqiao.recruit.domain.Recruit;
import org.lanqiao.recruit.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class SearchFromBoss implements ISearchFromBoss {
    @Override
    public List<Recruit> searcResult(String searchKind) throws SQLException {
        String userName = "%"+searchKind+"%";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from recruit where job like ? or companyname like ?";
        List<Recruit> recruitList = queryRunner.query(sql,new BeanListHandler<>(Recruit.class),userName,userName);
        return recruitList;
    }
}
