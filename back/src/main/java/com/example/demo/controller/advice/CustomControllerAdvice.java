package com.example.demo.controller.advice;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomControllerAdvice {
	
	// 찾는 값이 없는 경우를 예외처리하여 오류메시지 표기
	@ExceptionHandler(NoSuchElementException.class)
	protected ResponseEntity<?> notExist(NoSuchElementException e){
		String msg = e.getMessage();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("msg", msg));
	}
	
	// 검증에 실패 했을 때 예외처리하여 오류메시지 표기
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<?> handleIllegalArgumentException(MethodArgumentNotValidException e) {
		String msg = e.getMessage();
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(Map.of("msg", msg));
	}
}
