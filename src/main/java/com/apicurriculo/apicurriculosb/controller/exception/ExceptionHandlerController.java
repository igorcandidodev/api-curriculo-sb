package com.apicurriculo.apicurriculosb.controller.exception;

import com.apicurriculo.apicurriculosb.dto.StandardErrorDto;
import com.apicurriculo.apicurriculosb.exception.ObjectNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardErrorDto> exceptionHandler(Exception e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardErrorDto error = new StandardErrorDto(status.value(), "Internal Server Error", e.getMessage(), ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(ObjectNotFound.class)
    public ResponseEntity<StandardErrorDto> objectNotFound(ObjectNotFound e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardErrorDto error = new StandardErrorDto(status.value(), "Object Not Found", e.getMessage(), ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
