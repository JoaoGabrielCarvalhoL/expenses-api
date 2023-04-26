package br.com.carv.expenses.handler;

import br.com.carv.expenses.exception.ExpenseNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class ExpenseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse("Internal Server Error",
                HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExpenseNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(ExpenseNotFoundException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse("Bad Request", HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {
        List<FieldError> errors = exception.getBindingResult().getFieldErrors();
        String field = errors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String errorMessage = errors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        ExceptionMessageValidator exceptionMessageValidator = new ExceptionMessageValidator("Bad Request",
                status.value(), "Check the field(s) error(s)", field , errorMessage,
                LocalDateTime.now());

        return new ResponseEntity<>(exceptionMessageValidator, headers, status);

    }
}
