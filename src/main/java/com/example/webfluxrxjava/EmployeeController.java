package com.example.webfluxrxjava;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import javax.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
public class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping("/api/employee")
  public Observable<Employee> findAll(ServerHttpResponse serverHttpResponse) {
    return employeeService.findAll()
      .map(x -> {
        serverHttpResponse.setStatusCode(HttpStatus.NOT_FOUND);
        return x;
      });
  }

  @GetMapping("/api/employee/{id}")
  public Maybe<Employee> findById(@Min(1) @PathVariable Long id) {
    return employeeService.findById(id)
      .switchIfEmpty(Maybe.error(new RuntimeException("Not found")));
  }

}
