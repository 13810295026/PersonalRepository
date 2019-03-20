package com.ceac.easystudy.mockexercises.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Exercises {

	// 返回json中把字段名起别名返回
	@JsonProperty(value = "Qid")
	private String qid;
	@JsonProperty(value = "Qtype")
	private String qtype;
	@JsonProperty(value = "Difficulty")
	private String difficulty;
	@JsonProperty(value = "KnowledgeId")
	private String kid;
	@JsonProperty(value = "QNum")
	private Integer sort;
	@JsonProperty(value = "Topic")
	private String topic;
	@JsonProperty(value = "AnswerParse")
	private String analysis;
	@JsonProperty(value = "Answers")
	private List<String> answers;
	@JsonProperty(value = "Options")
	private List<OptionContent> options;

	public String getQid() {
		return qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getKid() {
		return kid;
	}

	public void setKid(String kid) {
		this.kid = kid;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	public List<OptionContent> getOptions() {
		return options;
	}

	public void setOptions(List<OptionContent> options) {
		this.options = options;
	}
}
