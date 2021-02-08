package com.josephdbx.springbootcourse.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.josephdbx.springbootcourse.dao.RoleRepository;
import com.josephdbx.springbootcourse.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	@Transactional(readOnly = true)
	public Page<Role> findAll(Pageable pageable) {
		return roleRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Role> findById(Long id) {
		return roleRepository.findById(id);
	}

	@Override
	@Transactional
	public Role save(Role Role) {
		return roleRepository.save(Role);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		roleRepository.deleteById(id);
	}
}
