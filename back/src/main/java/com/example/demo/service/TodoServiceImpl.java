package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Todo;
import com.example.demo.dto.PageRequestDTO;
import com.example.demo.dto.PageResponseDTO;
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
	
	public TodoDTO get(Long tno) {
		log.info("------------get start");
		
		Optional<Todo> result = todoRepository.findById(tno);
		
		Todo todo = result.orElseThrow();
		
		TodoDTO dto = modelMapper.map(todo, TodoDTO.class);
		// get메소드가 상세보기이기 때문에 글을 읽기 위해서 DB에서 데이터를 Entity형태로
		// 받아오게 되고, DTO로 변환한 후에 front로 넘겨줘야 한다.
		
		return dto;	
	}
	
	public void modify(TodoDTO todoDTO) {
		log.info("------------modify start");
		Optional<Todo> result = todoRepository.findById(todoDTO.getTno());
		
		Todo todo = result.orElseThrow();
		
		todo.changeTitle(todoDTO.getTitle());
		todo.changeDueDate(todoDTO.getDueDate());
		todo.changeComplete(todoDTO.isComplete());
		// boolean 타입은 get이 아닌 is 사용!!!
		
		todoRepository.save(todo);
	}
	
	public void remove(Long tno) {
		log.info("------------remove start");
		todoRepository.deleteById(tno);
	}
	
	public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {
		log.info("------------list start");
		Pageable pageable = PageRequest.of( pageRequestDTO.getPage() - 1 ,
				pageRequestDTO.getSize(),
				Sort.by("tno").descending());
		
		Page<Todo> result = todoRepository.findAll(pageable);
		
		List<TodoDTO> dtoList = result.getContent().stream()
				.map(todo -> modelMapper.map(todo, TodoDTO.class))
				.collect(Collectors.toList());
				// 컬렉션이니까 콜렉트로 
		
		long totalCount = result.getTotalElements();
		
		PageResponseDTO<TodoDTO> responseDTO = new PageResponseDTO<>(dtoList, pageRequestDTO, totalCount);
		
		return responseDTO;
	}
}
