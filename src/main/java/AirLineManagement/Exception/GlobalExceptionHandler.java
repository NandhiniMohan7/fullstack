package AirLineManagement.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FlightNotAvailableException.class)
	public ResponseEntity<Object> handleUserNotFoundException(FlightNotAvailableException user,WebRequest request)
	{
		ExceptionResponse exception=new ExceptionResponse(new Date(),user.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
	}
}
