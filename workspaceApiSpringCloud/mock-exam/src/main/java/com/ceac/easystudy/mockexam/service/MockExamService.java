package com.ceac.easystudy.mockexam.service;

import java.util.List;

import com.ceac.easystudy.mockexam.vo.MockPaper;

public interface MockExamService {

	public List<MockPaper> findMockPapers(String subId);

	public String findQuestions(String pid);

	public void removeCacheMockPapers(String subId);

	public void removeCacheQuestions(String pid);
}
