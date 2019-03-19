package com.ceac.easystudy.mockexercises.service;

import java.util.List;

import com.ceac.easystudy.mockexercises.vo.Knowledges;

public interface KnowledgeService {

	public List<Knowledges> findKnowledges(String sid);
	
	public void removeCache(String sid);
}
