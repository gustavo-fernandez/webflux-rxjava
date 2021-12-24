package com.example.webfluxrxjava;

import org.springframework.data.repository.reactive.RxJava3CrudRepository;

public interface EmployeeRepository extends RxJava3CrudRepository<Employee, Long> {
}
