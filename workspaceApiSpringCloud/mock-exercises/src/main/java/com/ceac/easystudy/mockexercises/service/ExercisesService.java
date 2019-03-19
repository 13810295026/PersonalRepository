package com.ceac.easystudy.mockexercises.service;

import java.util.List;

import com.ceac.easystudy.mockexercises.vo.Exercises;

public interface ExercisesService {

	public List<Exercises> extract(String kid);
}
