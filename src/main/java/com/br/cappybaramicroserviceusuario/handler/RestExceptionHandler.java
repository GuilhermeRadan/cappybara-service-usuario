package com.br.cappybaramicroserviceusuario.handler;

import com.br.cappybaramicroserviceusuario.dto.ErrorDTO;
import com.br.cappybaramicroserviceusuario.exceptions.RegistroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    @ExceptionHandler(RegistroException.class)
    private ErrorDTO registroException(RegistroException exception){
        String status = "Status: " + HttpStatus.NOT_FOUND.value();
        return new ErrorDTO(exception.getMessage(), status);
    }
}
