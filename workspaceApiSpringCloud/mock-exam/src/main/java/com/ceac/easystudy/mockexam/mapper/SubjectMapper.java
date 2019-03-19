package com.ceac.easystudy.mockexam.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ceac.easystudy.mockexam.po.Subject;

@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {
}
