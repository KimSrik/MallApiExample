package com.example.demo.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Todo;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

	@Autowired
	private TodoRepository todoRepository;
	
	@Test
	public void test() {
		log.info("----------------------");
		log.info("todoRepository");
	}
	
	/*
	@Test
	public void testInsert() {
		for(int i=1; i<=100; i++) {
			Todo todo = Todo.builder()
					.title("제목....." + i)
					.dueDate(LocalDate.of(2026, 2, 11))
					.writer("사용자")
					.build();
			
			todoRepository.save(todo);
		}
	}
	*/
	
	/*
	@Test
	public void testRead() {
		Long tno = 33L;
		
		Optional<Todo> result = todoRepository.findById(tno);
		
		Todo todo = result.orElseThrow();
		
		log.info("--------------- : " + todo);
	}
	*/
	
	@Test
	public void testModify() {
		Long tno = 33L;
		
		Optional<Todo> result = todoRepository.findById(tno);
		
		Todo todo = result.orElseThrow();
		todo.changeTitle("수정중");
		todo.changeComplete(true);
		todo.changeDueDate(LocalDate.of(2026, 04, 24));
		
		todoRepository.save(todo);
	}		
	
	@Test
	public void testDelete() {
		Long tno = 32L;
		
		todoRepository.deleteById(tno);
	}
	
}
