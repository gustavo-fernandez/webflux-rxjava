package com.example.webfluxrxjava;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping("/api/employee")
  public Mono<ApiResponse<List<Employee>>> findAll() {
    return employeeService.findAll()
      .collectList()
      .map(empList -> ApiResponse.<List<Employee>>builder()
        .code("A01")
        .data(empList)
        .message("Lista Ok")
        .build());
  }

}
