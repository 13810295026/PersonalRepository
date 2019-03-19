package com.ceac.easystudy.mockexam.service;

import java.util.List;

import com.ceac.easystudy.mockexam.po.Subject;

public interface SubjectService {

	public List<Subject> findSubjects();
	
	public void removeCache();
}
