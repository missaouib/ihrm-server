package com.ihrm.system.dao;

import com.ihrm.model.system.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 企业数据访问接口
 */
@Repository
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
}
