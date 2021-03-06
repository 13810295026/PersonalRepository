package com.ceac.easystudy.mockexercises.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ceac.easystudy.mockexercises.mapper.ExercisesMapper;
import com.ceac.easystudy.mockexercises.mapper.KnowledgeMapper;
import com.ceac.easystudy.mockexercises.po.ExercisesPojo;
import com.ceac.easystudy.mockexercises.po.KnowledgePojo;
import com.ceac.easystudy.mockexercises.service.ExercisesService;
import com.ceac.easystudy.mockexercises.vo.Exercises;
import com.ceac.easystudy.mockexercises.vo.OptionContent;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ExercisesServiceImpl implements ExercisesService {

	@Autowired
	KnowledgeMapper knowledgeMapper;

	@Autowired
	ExercisesMapper exercisesMapper;

	public List<Exercises> extract(String kid) {
		List<Exercises> list = new ArrayList<Exercises>();
		List<ExercisesPojo> randoms = new ArrayList<ExercisesPojo>();
		List<ExercisesPojo> pojos = new ArrayList<ExercisesPojo>();

		EntityWrapper<KnowledgePojo> ew = new EntityWrapper<KnowledgePojo>(new KnowledgePojo());
		ew.where("KnowledgeId={0}", kid).or("FatherId={0}", kid);
		List<KnowledgePojo> knowledges = knowledgeMapper.selectList(ew);

		for (KnowledgePojo knowledge : knowledges) {
			pojos.addAll(exercisesMapper.selectWithCache(knowledge.getKnowledgeId()));
		}

		Map<Integer, String> map = new HashMap<Integer, String>();
		if (pojos.size() <= 5) {
			randoms = pojos;
		} else {
			while (map.size() < 5) {
				int random = (int) (Math.random() * pojos.size());
				if (!map.containsKey(random)) {
					map.put(random, "");
					randoms.add(pojos.get(random));
				}
			}
		}

		int count = 1;
		ObjectMapper mapper = new ObjectMapper();
		// json中可能包含换行符
		mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		for (ExercisesPojo pojo : randoms) {
			Exercises exercises = new Exercises();
			List<OptionContent> options = new ArrayList<>();
			List<String> answers = new ArrayList<>();

			exercises.setQid(pojo.getQid());
			exercises.setQtype(pojo.getQtype());
			exercises.setDifficulty(pojo.getDifficulty());
			exercises.setKid(pojo.getKnowledgeId());
			exercises.setSort(count);
			exercises.setAnalysis(pojo.getAnswerParse());

			try {
				List<OptionContent> contents = mapper.readValue(pojo.getContent(),
						new TypeReference<List<OptionContent>>() {
						});

				for (OptionContent content : contents) {
					if ("|Text|Topic".equals(content.getType())) {
						exercises.setTopic(content.getValue());
					} else if ("|Text|Option".equals(content.getType())) {
						options.add(content);
					} else if ("|Text|RightKey".equals(content.getType())) {
						answers.add(content.getValue());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			exercises.setOptions(options);
			exercises.setAnswers(answers);

			count++;
			list.add(exercises);
		}

		return list;
	}
}
