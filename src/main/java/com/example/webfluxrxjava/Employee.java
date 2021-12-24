package com.example.webfluxrxjava;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {

  @EqualsAndHashCode.Include
  private Long id;
  private String fullName;
  private BigDecimal salary;

}
