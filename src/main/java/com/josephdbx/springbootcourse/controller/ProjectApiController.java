package com.josephdbx.springbootcourse.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.josephdbx.springbootcourse.entity.Project;
import com.josephdbx.springbootcourse.service.ProjectService;

@RestController
@RequestMapping("/api/projects/deprecated")
public class ProjectApiController {

	@Autowired
	private ProjectService projectService;

	@GetMapping(params = { "page", "size" })
	public ResponseEntity<?> getProjects(@RequestParam("page") int page, @RequestParam("size") int size) {
		// List<Project> projects =
		// StreamSupport.stream(projectService.findAll().spliterator(),
		// false).collect(Collectors.toList());
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(projectService.findAll(pageable));
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> create(@RequestBody @Validated Project project) {
		return ResponseEntity.status(HttpStatus.CREATED).body(projectService.save(project));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long projectId) {
		Optional<Project> oProject = projectService.findById(projectId);

		if (!oProject.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(oProject);
	}

	@PatchMapping(path = "/{id}", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody @Validated Project patchProject,
			@PathVariable(value = "id") Long projectId) {
		Optional<Project> oProject = projectService.findById(projectId);

		if (!oProject.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		if (patchProject.getName() != null) {
			oProject.get().setName(patchProject.getName());
		}
		if (patchProject.getStage() != null) {
			oProject.get().setStage(patchProject.getStage());
		}
		if (patchProject.getDescription() != null) {
			oProject.get().setDescription(patchProject.getDescription());
		}

		// BeanUtils.copyProperties(project, oProject.get());

		return ResponseEntity.status(HttpStatus.CREATED).body(projectService.save(oProject.get()));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long projectId) {
		Optional<Project> oProject = projectService.findById(projectId);

		if (!oProject.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		projectService.deleteById(projectId);
		return ResponseEntity.noContent().build();
	}
}
