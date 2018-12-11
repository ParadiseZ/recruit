package org.lanqiao.recruit.service.inter;

import org.lanqiao.recruit.domain.Recruit;

import java.util.List;

public interface ISearchFromBossService {
    public List<Recruit> searchImfor(String searchKind);
}
