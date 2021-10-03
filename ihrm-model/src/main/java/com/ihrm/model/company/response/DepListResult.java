package com.ihrm.model.company.response;

import com.ihrm.model.company.Company;
import com.ihrm.model.company.Department;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DepListResult {

    private String companyId;
    private String companyName;
    private String companyManage;
    private List<Department> depts;

    public DepListResult(Company company,List<Department> depts){
        companyId=company.getId();
        companyName=company.getName();
        companyManage=company.getLegalRepresentative();
        this.depts=depts;
    }
}
