package org.lanqiao.recruit.dao.inter;

import org.lanqiao.recruit.domain.Company_profile;
import org.lanqiao.recruit.domain.company_content;

import java.sql.SQLException;
import java.util.List;

public interface ICompanyLook {
    //查看公司左边导航栏
    public List<Company_profile> lookCompany() throws SQLException;

    public company_content getTitle (int pid,String belong)throws SQLException ;
}
