package org.lanqiao.recruit.service.imp;


import org.lanqiao.recruit.dao.imp.GongSiJianJieDao;
import org.lanqiao.recruit.dao.inter.IGongSiJianJie;
import org.lanqiao.recruit.domain.GongSiJianJie;
import org.lanqiao.recruit.service.inter.IgongsijianjieService;

import java.sql.SQLException;

public class GongsijianjieService implements IgongsijianjieService {
    IGongSiJianJie iGongSiJianJie = new GongSiJianJieDao();

    @Override
    public Integer addGongsijianjie(GongSiJianJie gongSiJianJie) throws SQLException {
        return iGongSiJianJie.addData(gongSiJianJie);
    }

    @Override
    public GongSiJianJie selectByTitlecon(String titlecon) throws SQLException {
        return iGongSiJianJie.selectByTitlecon(titlecon);
    }
}
