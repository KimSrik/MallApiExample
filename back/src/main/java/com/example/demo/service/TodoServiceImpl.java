package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.TodoDTO;

import lombok.extern.log4j.Log4j2;


@Service
@Transactional
@Log4j2
public class TodoServiceImpl implements TodoService {
	public Long register(TodoDTO todoDTO) {
		log.info("------------register start");
		
		return null;
	}
}
