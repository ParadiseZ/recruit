package org.lanqiao.recruit.dao.inter;

import org.lanqiao.recruit.domain.Recruit;

import java.sql.SQLException;
import java.util.List;

public interface ISearchFromBoss {
    //模糊搜索公司或职位
    public List<Recruit> searcResult(String searchKin) throws SQLException;
}
