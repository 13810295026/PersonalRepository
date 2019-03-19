package com.ceac.easystudy.mockexercises.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ceac.easystudy.mockexercises.mapper.KnowledgeMapper;
import com.ceac.easystudy.mockexercises.po.KnowledgePojo;
import com.ceac.easystudy.mockexercises.service.KnowledgeService;
import com.ceac.easystudy.mockexercises.vo.Knowledge;
import com.ceac.easystudy.mockexercises.vo.Knowledges;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

	@Autowired
	KnowledgeMapper knowledgeMapper;

	@Cacheable(value = "mock_redis", key = "'mock_knowledges_'+#sid")
	public List<Knowledges> findKnowledges(String sid) {
		List<Knowledges> list = new ArrayList<Knowledges>();
		List<KnowledgePojo> roots = new ArrayList<KnowledgePojo>();
		EntityWrapper<KnowledgePojo> ewRoot = new EntityWrapper<KnowledgePojo>(new KnowledgePojo());
		ewRoot.where("SubId={0}", sid).and("FatherId='root'").and("status='0'");
		ewRoot.orderBy("Sort");
		roots = knowledgeMapper.selectList(ewRoot);

		for (KnowledgePojo root : roots) {
			Knowledges knowledges = new Knowledges();
			knowledges.setKid(root.getKnowledgeId());
			knowledges.setName(root.getKnowledgeName());
			knowledges.setParentId(root.getFatherId());
			knowledges.setSid(sid);
			knowledges.setSort(root.getSort());

			List<Knowledge> sublist = new ArrayList<Knowledge>();
			EntityWrapper<KnowledgePojo> ew = new EntityWrapper<KnowledgePojo>(new KnowledgePojo());
			ew.where("FatherId={0}", root.getKnowledgeId());
			ew.orderBy("Sort");
			List<KnowledgePojo> subs = knowledgeMapper.selectList(ew);
			for (KnowledgePojo sub : subs) {
				Knowledge knowledge = new Knowledge();

				knowledge.setKid(sub.getKnowledgeId());
				knowledge.setName(sub.getKnowledgeName());
				knowledge.setParentId(sub.getFatherId());
				knowledge.setSid(root.getSubId());
				knowledge.setSort(sub.getSort());

				sublist.add(knowledge);
			}

			knowledges.setKnowledge(sublist);
			list.add(knowledges);
		}

		return list;
	}
	
	@CacheEvict(value = "mock_redis", key = "'mock_knowledges_'+#sid")
	public void removeCache(String sid) {
		System.out.println("已从Redis中移除mock_knowledges_" + sid);
	}
}
