package com.example.webfluxrxjava;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  public Flux<Employee> findAll() {
    return Flux.fromIterable(List.of(new Employee(1L, "Javier", BigDecimal.TEN)));
  }

}
