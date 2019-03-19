package com.ceac.easystudy.mockexercises.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ceac.easystudy.mockexercises.po.KnowledgePojo;

@Mapper
public interface KnowledgeMapper extends BaseMapper<KnowledgePojo> {
}
