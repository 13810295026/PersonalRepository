package com.ceac.easystudy.mockexercises.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Knowledges {

	// 返回json中把字段名起别名返回
	@JsonIgnore
	private String id;
	@JsonProperty(value = "KnowledgeId")
	private String kid;
	@JsonProperty(value = "KnowledgeName")
	private String name;
	@JsonProperty(value = "SubId")
	private String sid;
	@JsonProperty(value = "FatherId")
	private String parentId;
	@JsonProperty(value = "Sort")
	private Integer sort;
	@JsonProperty(value = "ChildKnowledgees")
	private List<Knowledge> knowledge;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKid() {
		return kid;
	}

	public void setKid(String kid) {
		this.kid = kid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public List<Knowledge> getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(List<Knowledge> knowledge) {
		this.knowledge = knowledge;
	}
}
