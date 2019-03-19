package com.ceac.easystudy.mockexercises.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ceac.easystudy.mockexercises.po.ExercisesPojo;

@Mapper
public interface ExercisesMapper extends BaseMapper<ExercisesPojo> {

	@Cacheable(value = "mock_redis", key = "'mock_exercises_'+#p0")
	@Select("select * from exercises_question where KnowledgeId=#{kid}")
	public List<ExercisesPojo> selectWithCache(@Param("kid") String kid);
}
