package com.com.com.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface BoardService {

	void getList(Map<String, Object> map, Model model, HttpSession session);

}
