package com.josephdbx.springbootcourse.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.josephdbx.springbootcourse.entity.Project;

public interface ProjectService {

	public Iterable<Project> findAll();

	public Page<Project> findAll(Pageable pageable);

	public Optional<Project> findById(Long id);

	public Project save(Project project);

	public void deleteById(Long id);
}
