   package com.java.exceptionhandling.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.exceptionhandling.entity.TeacherModel;



@Repository
public interface TeacherRepo extends JpaRepository<TeacherModel, Integer> {
	
	Optional<TeacherModel> findByName(String name); 


}

