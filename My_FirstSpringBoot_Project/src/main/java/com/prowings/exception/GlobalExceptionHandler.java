package com.prowings.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus(code = HttpStatus.BAD_GATEWAY)
	@ExceptionHandler(InvalidAccountException.class)
	public ErrorResponse handleInvalidAccountException(InvalidAccountException e, WebRequest request)
	{
		ErrorResponse er = new ErrorResponse();
		er.setDetails(e.getLocalizedMessage());
		er.setMessage(e.getMessage());
		er.setPath("/account/{id}");
		return er;
	}
	
//	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(NoSuchElementException.class)
//	public ErrorResponse handleNoSuchElementException(NoSuchElementException e, WebRequest request)
//	{
//		ErrorResponse er = new ErrorResponse();
//		er.setDetails(e.getLocalizedMessage());
//		er.setMessage(e.getMessage());
//		er.setPath("/students/{id}");
//		return er;
//	}
}
