package com.com.com.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.com.com.dao.BoardDao;
import com.com.com.service.BoardService;
import com.com.com.util.PageUtil;

@Service("service")
public class BoardServiceImpl implements BoardService{

	@Resource(name="dao")
	private BoardDao boardDao;
	
	@Override
	public void getList(Map<String, Object> map, Model model, HttpSession session) {
		
		int nowPage, totalCount = 0;
		int pagePerSize = 20;
		int pagePerBlock = 5; 
		
		Object o_nowPage = map.get("nowPage");
		
		if(o_nowPage != null && o_nowPage != "") {
			
			try {
				nowPage = Integer.parseInt(o_nowPage.toString());
			} catch (Exception e) {
				System.out.println("페이지 선택오류");
				//e.printStackTrace();
				nowPage = 1;
			}
			
		}else {
			nowPage = 1;
		}
		
		totalCount = boardDao.getTotalCount(map);
		
		if(totalCount ==0) {
			return;
		}
			
		PageUtil page = new PageUtil(nowPage, totalCount, pagePerSize, pagePerBlock);
		
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		
		List<Map<String, Object>> list = boardDao.getList(map);
		
		model.addAttribute("list",list);
		model.addAttribute("pageCode",page.getPageCode());
		model.addAttribute("searchType",map.get("searchType"));
		model.addAttribute("searchValue", map.get("searchValue"));
		
	}

}
