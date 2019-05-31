package jp.co.netprotections.common;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author h.dat
 * 全体アプリのExceptionを扱う
 * Constraint validateの対処
 *
 */
@ControllerAdvice
public class GlobalExeptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(
	  ConstraintViolationException ex, WebRequest request) {
	    return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	 
	}
	
	
}
