package com.example.application.solution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeSolutionRepository extends JpaRepository<EmployeeSolution, Long>, JpaSpecificationExecutor<EmployeeSolution> {
}
