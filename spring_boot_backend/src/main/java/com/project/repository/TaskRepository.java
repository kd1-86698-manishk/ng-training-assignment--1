package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pojo.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

