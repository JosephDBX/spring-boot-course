package com.josephdbx.springbootcourse.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.josephdbx.springbootcourse.dao.ProjectRepository;
import com.josephdbx.springbootcourse.entity.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Project> findAll(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Project> findById(Long id) {
		return projectRepository.findById(id);
	}

	@Override
	@Transactional
	public Project save(Project project) {
		return projectRepository.save(project);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		projectRepository.deleteById(id);
	}

}
