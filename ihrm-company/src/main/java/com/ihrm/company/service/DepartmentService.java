package com.ihrm.company.service;

import com.ihrm.common.entity.ResultCode;
import com.ihrm.common.exception.CommonException;
import com.ihrm.common.service.BaseService;
import com.ihrm.common.util.IdWorker;
import com.ihrm.company.dao.DepartmentDao;
import com.ihrm.model.company.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 部门操作业务逻辑层
 */
@Service
public class DepartmentService extends BaseService<Department> {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 添加部门
     */
    public void save(Department department) {
        department.setId(idWorker.nextId() + "");
        department.setCreateTime(new Date());
        departmentDao.save(department);
    }

    /**
     * 更新部门信息
     */
    public void update(Department department) {
        Optional<Department> department1 = departmentDao.findById(department.getId());
        if (department1.isEmpty()) throw new CommonException(ResultCode.FAIL);
        Department sourceDepartment = department1.get();
        sourceDepartment.setName(department.getName());
        sourceDepartment.setPid(department.getPid());
        sourceDepartment.setManagerId(department.getManagerId());
        sourceDepartment.setIntroduce(department.getIntroduce());
        sourceDepartment.setManager(department.getManager());
        departmentDao.save(sourceDepartment);
    }

    /**
     * 根据ID获取部门信息 *
     *
     * @param id 部门ID
     * @return 部门信息
     */
    public Department findById(String id) {
        return departmentDao.findById(id).get();
    }

    /**
     * 删除部门 *
     *
     * @param id 部门ID
     */
    public void delete(String id) {
        departmentDao.deleteById(id);
    }

    /**
     * 获取部门列表
     */
    public List<Department> findAll(String companyId) {
        Specification<Department> spec = getSpecification(companyId);
        return departmentDao.findAll(spec);
    }
}
