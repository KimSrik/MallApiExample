package com.example.demo.service;

import com.example.demo.dto.TodoDTO;

public interface TodoService {
	Long register(TodoDTO todoDTO);
	
	TodoDTO get(Long tno);
	
	void modify(TodoDTO todoDTO);
	
	void remove(Long tno);
}
