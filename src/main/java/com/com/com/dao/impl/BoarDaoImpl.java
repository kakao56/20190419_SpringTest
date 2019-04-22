package com.com.com.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.com.com.dao.BoardDao;

@Repository("dao")
public class BoarDaoImpl implements BoardDao{

	@Autowired
	private SqlSessionTemplate sst;
	
	//게시물 가져오기
	@Override
	public List<Map<String, Object>> getList(Map<String, Object> map) {
		return sst.selectList("mapper.getList", map);
	}

	//게시물 수 가져오기
	@Override
	public int getTotalCount(Map<String, Object> map) {
		return sst.selectOne("mapper.getTotalCount", map);
	}

}
