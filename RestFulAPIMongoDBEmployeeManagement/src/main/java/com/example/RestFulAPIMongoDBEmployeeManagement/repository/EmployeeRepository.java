package com.example.RestFulAPIMongoDBEmployeeManagement.repository;

import com.example.RestFulAPIMongoDBEmployeeManagement.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
