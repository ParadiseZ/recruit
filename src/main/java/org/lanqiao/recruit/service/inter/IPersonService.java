package org.lanqiao.recruit.service.inter;

import org.lanqiao.recruit.domain.person_domain;

import java.util.Date;
import java.util.List;

public interface IPersonService {
    public List <person_domain> addpuser(String username, String password);
    public  person_domain findalbyid(int i);
    public  boolean checkinfor(String pname, String password);

    public void addperson(person_domain personDomain);
    public boolean updatePerson(person_domain personDomain);
}
