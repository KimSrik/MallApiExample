package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PageRequestDTO;
import com.example.demo.dto.PageResponseDTO;
import com.example.demo.dto.TodoDTO;
import com.example.demo.service.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/todo")
public class TodoController {
	
	private final TodoService service;
	// implements 에서 정의한 부분을 불러올 수 있다.
	
	@GetMapping("/{tno}")
	public TodoDTO get(@PathVariable(name = "tno") Long tno) {
		return service.get(tno);
	}
	
	@GetMapping("/list")
	public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {
		log.info(pageRequestDTO); 
		
		return service.list(pageRequestDTO);
	}
	

}
