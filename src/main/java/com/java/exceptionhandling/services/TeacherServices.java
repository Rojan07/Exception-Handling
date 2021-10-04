package com.java.exceptionhandling.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.java.exceptionhandling.entity.TeacherModel;
import com.java.exceptionhandling.exception.ResourceNotFoundException;
import com.java.exceptionhandling.repo.TeacherRepo;

@Service
public class TeacherServices {
	@Autowired
	TeacherRepo teacherrepo;

	public TeacherModel saveTeacher(TeacherModel teacher) {
		TeacherModel tech = teacherrepo.save(teacher);
		return tech;
	}

	public List<TeacherModel> saveTeachers(List<TeacherModel> teachers) {
		List<TeacherModel> tech = teacherrepo.saveAll(teachers);
		return tech;

	}

	public List<TeacherModel> getAllTeacher() {
		List<TeacherModel> list = teacherrepo.findAll();
		return list;
	}

	public TeacherModel getTeacherById(int id) {
		Optional<TeacherModel> t = teacherrepo.findById(id);
		TeacherModel te;
		if (t.isPresent()) {
			te = t.get();
		} else {
			throw new ResourceNotFoundException("The id" + id + " is not found");
		}

		return te;
	}

	public TeacherModel getByTeacherName(String name) {
		Optional<TeacherModel> t1 = teacherrepo.findByName(name);
		TeacherModel te;
		if (t1.isPresent()) {
			te = t1.get();
		} else {
			throw new ResourceNotFoundException(" The name" + name + " is not found");
		}
		return te;
	}

	public void deleteTeacher(int id) {
		teacherrepo.deleteById(id);

	}

}