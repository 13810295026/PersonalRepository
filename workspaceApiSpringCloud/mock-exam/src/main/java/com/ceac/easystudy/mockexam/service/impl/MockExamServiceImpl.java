package com.ceac.easystudy.mockexam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ceac.easystudy.mockexam.mapper.PaperMapper;
import com.ceac.easystudy.mockexam.po.Paper;
import com.ceac.easystudy.mockexam.service.MockExamService;
import com.ceac.easystudy.mockexam.vo.MockPaper;

@Service
public class MockExamServiceImpl implements MockExamService {

	@Autowired
	private PaperMapper paperMapper;

	@Cacheable(value = "mock_redis", key = "'mock_papers_'+#subId")
	public List<MockPaper> findMockPapers(String subId) {
		List<MockPaper> list = new ArrayList<>();

		// List<Paper> papers = paperMapper.find(subId);
		EntityWrapper<Paper> ew = new EntityWrapper<Paper>(new Paper());
		ew.where("SubId={0}", subId);
		List<Paper> papers = paperMapper.selectList(ew);
		for (Paper paper : papers) {
			MockPaper mockpaper = new MockPaper();
			mockpaper.setPid(paper.getPid());
			mockpaper.setSubId(paper.getSubId());
			mockpaper.setName(paper.getName());
			mockpaper.setLength(paper.getLength());
			mockpaper.setModifyTime(paper.getModifyTime());
			list.add(mockpaper);
		}
		return list;
	}

	@Cacheable(value = "mock_redis", key = "'mock_question_'+#pid")
	public String findQuestions(String pid) {
		return paperMapper.findQuestionsById(pid);
	}

	@CacheEvict(value = "mock_redis", key = "'mock_papers_'+#subId")
	public void removeCacheMockPapers(String subId) {
		System.out.println("已从Redis中移除Key:mock_papers_" + subId);
	}

	@CacheEvict(value = "mock_redis", key = "'mock_question_'+#pid")
	public void removeCacheQuestions(String pid) {
		System.out.println("已从Redis中移除Key:mock_question_" + pid);
	}
}
