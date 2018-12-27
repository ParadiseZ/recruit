package org.lanqiao.recruit.service.inter;


import org.lanqiao.recruit.domain.Recruit;

import java.util.List;

public interface IRecruitService {
    public List<Recruit> getRecruitList();
    public void addRecruit(Recruit recruit);
}
