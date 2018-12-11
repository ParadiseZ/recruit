package org.lanqiao.recruit.service.imp;

import org.lanqiao.recruit.dao.imp.SearchFromBoss;
import org.lanqiao.recruit.dao.inter.ISearchFromBoss;
import org.lanqiao.recruit.domain.Recruit;
import org.lanqiao.recruit.service.inter.ISearchFromBossService;

import java.sql.SQLException;
import java.util.List;

public class SearchFromBossService implements ISearchFromBossService {
    ISearchFromBoss searchFromBoss = new SearchFromBoss();
    @Override
    public List<Recruit> searchImfor(String searchKind) {
        List<Recruit> recruitList = null;
        try {
            recruitList = searchFromBoss.searcResult(searchKind);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recruitList;
    }
}
