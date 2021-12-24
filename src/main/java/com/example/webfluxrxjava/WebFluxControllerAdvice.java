package com.example.webfluxrxjava;

import java.math.BigDecimal;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class WebFluxControllerAdvice {

  @ExceptionHandler(ConstraintViolationException.class)
  public Mono<Employee> handlerError(
    ConstraintViolationException exception,
    ServerHttpResponse serverHttpResponse) {
    return Mono.just(new Employee(0L, "ERROR", BigDecimal.ZERO))
      .map(x -> {
        serverHttpResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        return x;
      });
  }

}
