package com.josephdbx.springbootcourse.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project implements Serializable {

	private static final long serialVersionUID = 6803153096145469366L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;

	@ManyToOne
	private User user;

	@Column(length = 50, nullable = false, unique = true)
	private String name;

	@Column(length = 10, nullable = false)
	private String stage; // NOTSTARTED, COMPLETED, INPROGRESS

	@Column(length = 250, nullable = false)
	private String description;

	public Project() {
		super();
	}

	public Project(User user, String name, String stage, String description) {
		super();
		this.user = user;
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
