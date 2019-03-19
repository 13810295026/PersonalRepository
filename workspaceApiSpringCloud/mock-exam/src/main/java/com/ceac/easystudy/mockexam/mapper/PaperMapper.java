package com.ceac.easystudy.mockexam.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ceac.easystudy.mockexam.po.Paper;

@Mapper
public interface PaperMapper extends BaseMapper<Paper> {

	@Select("select QuestionContent from mockexam_paperquestion where PId=#{pid}")
	public String findQuestionsById(String pid);
}
