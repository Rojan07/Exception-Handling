package com.java.exceptionhandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.java.exceptionhandling.entity.TeacherModel;
import com.java.exceptionhandling.services.TeacherServices;

@RestController
@RequestMapping("/api")

public class TeacherController {

	@Autowired
	TeacherServices ts;

	@PostMapping("/save")
	public TeacherModel saveTeacher(@RequestBody TeacherModel t) {
		System.out.print("save teacher record");
		TeacherModel tu = ts.saveTeacher(t);
		return tu;
	}

	@PostMapping("/add")
	public List<TeacherModel> addTeacher(@RequestBody List<TeacherModel> teachers) {
		List<TeacherModel> Teacherlist = ts.saveTeachers(teachers);
		return Teacherlist;

	}

	@GetMapping("/get")
	public List<TeacherModel> getAllTeacher() {
		List<TeacherModel> list = ts.getAllTeacher();
		return list;

	}

	@GetMapping("/pick/{id}")
	public TeacherModel getTeacherById(@PathVariable("id") int id) {
		TeacherModel teach = ts.getTeacherById(id);
		return teach;
	}

	@GetMapping("/go/{name}")
	public TeacherModel getTeacherByName(@PathVariable("name") String name) {
		TeacherModel teachname = ts.getByTeacherName(name);
		return teachname;
	}

	@DeleteMapping("/delete/{id}")
	public void deleteTeacher(@PathVariable("id") int id) {
		ts.deleteTeacher(id);
	}
}
