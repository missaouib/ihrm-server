package com.ihrm.company.controller;

import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.model.company.Company;
import com.ihrm.model.company.Department;
import com.ihrm.model.company.response.DepListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/company")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CompanyService companyService;

    /**
     * 添加部门
     */
    @PostMapping("/department")
    public Result add(@RequestBody Department department) throws Exception {
        department.setCompanyId(parseCompanyId());
        departmentService.save(department);
        return Result.SUCCESS();
    }

    /**
     * 修改部门信息
     */
    @PutMapping("/department/{id}")
    public Result update(@PathVariable(name = "id") String id, @RequestBody Department department) throws Exception {
        department.setId(id);
        departmentService.update(department);
        return Result.SUCCESS();
    }

    /**
     * 删除部门
     */
    @DeleteMapping(value = "/department/{id}")
    public Result delete(@PathVariable(name = "id") String id) throws Exception {
        departmentService.delete(id);
        return Result.SUCCESS();
    }

    /**
     * 根据id查询
     */
    @GetMapping(value = "/department/{id}")
    public Result findById(@PathVariable(name = "id") String id) throws Exception {
        Department department = departmentService.findById(id);
        return new Result(ResultCode.SUCCESS, department);
    }

    /**
     * 组织架构列表
     */
    @GetMapping(value = "/department")
    public Result findAll() throws Exception {
        String companyId = parseCompanyId();
        Company company = companyService.findById(companyId);
        List<Department> departmentList = departmentService.findAll(companyId);
        return new Result(ResultCode.SUCCESS, new DepListResult(company, departmentList));
    }
}
