package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.student;
import com.example.demo.repository.studentrepository;

@Service

public class studentservice {

	@Autowired
	studentrepository sr;
	
	public student insert_stu(student st) {
		return sr.save(st);
	}
	
	public Iterable<student> addall(List<student> st) {
		return sr.saveAll(st);
	}
	
	public List<student> fetchall(){
		return (List<student>) sr.findAll();
	}
	
	public Optional<student> fetchbyid(int id) {
		return sr.findById(id);
	}
	
	public String delbyid(int id) {
		sr.deleteById(id);
		return "successfully deleted : "+id;
	}
	
	public student upd(student st) {
		int id = st.getId();
		student u = sr.findById(id).get();
		u.setName(st.getName());
		u.setBranch(st.getBranch());
		u.setEmail(st.getEmail());
		return sr.save(u);
	}
}
