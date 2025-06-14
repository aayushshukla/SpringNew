package com.infosys.demo.repos;

import com.infosys.demo.beans.Courses;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Courses, Integer> {
}
