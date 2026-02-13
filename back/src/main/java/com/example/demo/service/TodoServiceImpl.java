package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Todo;
import com.example.demo.dto.TodoDTO;
import com.example.demo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
	
	private final ModelMapper modelMapper;
	
	private final TodoRepository todoRepository;
	
	public Long register(TodoDTO todoDTO) {
		log.info("------------register start");
		
		Todo todo = modelMapper.map(todoDTO, Todo.class);
		// DTO를 Entity로...
		
		Todo savedTodo = todoRepository.save(todo);
		
		return savedTodo.getTno();
	}
}
