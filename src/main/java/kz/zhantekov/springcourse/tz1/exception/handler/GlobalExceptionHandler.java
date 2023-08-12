package kz.zhantekov.springcourse.tz1.exception.handler;

import kz.zhantekov.springcourse.tz1.exception.BadRequestException;
import kz.zhantekov.springcourse.tz1.exception.response.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex){
        ErrorResponse response = new ErrorResponse();
        response.setMessage("Validation Error");
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        response.setErrors(errors);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleEmailExistsException(BadRequestException ex){
        ErrorResponse response = new ErrorResponse();
        List<String> errors = List.of(ex.getError());
        response.setErrors(errors);
        response.setMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
