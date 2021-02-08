package com.josephdbx.springbootcourse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josephdbx.springbootcourse.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
