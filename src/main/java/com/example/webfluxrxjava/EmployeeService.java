package com.example.webfluxrxjava;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public Observable<Employee> findAll() {
    return employeeRepository.findAll()
      .toObservable();
  }

  public Maybe<Employee> findById(Long id) {
    return employeeRepository.findById(id);
  }
}
