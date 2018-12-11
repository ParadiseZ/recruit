package org.lanqiao.recruit.service.imp;

import org.lanqiao.recruit.dao.imp.CompanyLook;
import org.lanqiao.recruit.dao.inter.ICompanyLook;
import org.lanqiao.recruit.domain.Company_profile;
import org.lanqiao.recruit.service.inter.ICompanyLookService;

import java.sql.SQLException;
import java.util.List;

public class CompanyLookService implements ICompanyLookService {
    @Override
    public List<Company_profile> selectAll( ) throws SQLException {
        ICompanyLook iCompanyLook = new CompanyLook();
        return iCompanyLook.lookCompany();
    }
}
