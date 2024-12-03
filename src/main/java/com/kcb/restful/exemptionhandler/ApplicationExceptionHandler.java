package com.kcb.restful.exemptionhandler;

import com.kcb.restful.config.ServiceConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
@RestController
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    private final ServiceConfig configProperties;

    public ApplicationExceptionHandler(ServiceConfig configProperties) {
        this.configProperties = configProperties;
    }

    @ExceptionHandler(ProcessingException.class)
    public Mono<ResponseEntity<Object>> handleValidationExceptions(ProcessingException ex) {
      return Mono.just(new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<Object>> handleAllExceptions(Exception ex) {
      return Mono.just(new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
