package com.josephdbx.springbootcourse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josephdbx.springbootcourse.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
