package com.com.com.dao;

import java.util.List;
import java.util.Map;

public interface BoardDao {

	List<Map<String, Object>> getList(Map<String, Object> map);

	int getTotalCount(Map<String, Object> map);

}
