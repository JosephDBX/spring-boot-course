package com.josephdbx.springbootcourse.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.josephdbx.springbootcourse.entity.Role;

public interface RoleService {

	public Page<Role> findAll(Pageable pageable);

	public Optional<Role> findById(Long id);

	public Role save(Role role);

	public void deleteById(Long id);
}
