package com.arun.didemo.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class EmployeeConfig {

    @Bean
    @Primary
    public Employee getArunEmployee() {
        return new Employee("Arun");
    }

    @Bean
    public Employee getPushpaEmployee() {
        return new Employee("Pushpa");
    }
}
