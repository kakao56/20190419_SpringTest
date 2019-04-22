package com.com.com.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.com.com.service.BoardService;

@Controller
public class BoardController {

	@Resource(name="service")
	private BoardService boardService;
	
	@RequestMapping("golist")
	public String goList(@RequestParam Map<String, Object> map, Model model, HttpSession session) {
		
		boardService.getList(map, model, session);
		
		return "list";
	}
}
