package com.ceac.easystudy.mockexam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ceac.easystudy.mockexam.mapper.SubjectMapper;
import com.ceac.easystudy.mockexam.po.Subject;
import com.ceac.easystudy.mockexam.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectMapper subjectMapper;

	@Cacheable(value = "mock_redis", key = "'mock_subjects'")
	public List<Subject> findSubjects() {
		EntityWrapper<Subject> ew = new EntityWrapper<Subject>(new Subject());
		ew.where("`status`=0");
		return subjectMapper.selectList(ew);
	}

	@CacheEvict(value = "mock_redis", key = "'mock_subjects'")
	public void removeCache() {
		System.out.println("已从Redis中移除Key:mock_subjects");
	}
}
