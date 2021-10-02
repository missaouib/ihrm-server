package com.ihrm.company.service;

import com.ihrm.common.entity.ResultCode;
import com.ihrm.common.exception.CommonException;
import com.ihrm.common.util.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.model.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 添加企业
     *
     * @param company 企业信息
     */
    public Company add(Company company) {
        company.setId(idWorker.nextId() + "");
        company.setCreateTime(new Date());
        company.setState(1); //启用
        company.setAuditState("0"); //待审核
        company.setBalance(0d);
        return companyDao.save(company);
    }

    public Company update(Company company) {
        Optional<Company> byId = companyDao.findById(company.getId());
        if(byId.isEmpty()) throw new CommonException(ResultCode.FAIL);
        return companyDao.save(company);
    }

    public Company findById(String id) {
        Optional<Company> byId = companyDao.findById(id);
        if(byId.isEmpty()) throw new CommonException(ResultCode.FAIL);
        return companyDao.findById(id).get();
    }

    public void deleteById(String id) {
        Optional<Company> byId = companyDao.findById(id);
        if(byId.isEmpty()) throw new CommonException(ResultCode.FAIL);
        companyDao.deleteById(id);
    }

    public List<Company> findAll() {
        return companyDao.findAll();
    }
}
