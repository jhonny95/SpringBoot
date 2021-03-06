package com.example.demo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.example.demo.controllers.EmployeeController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;;

@Component
public class EmployeeResourceAssembler implements ResourceAssembler<Employee, Resource<Employee>> {

	public Resource<Employee> toResource(Employee entity) {
		// TODO Auto-generated method stub
		return new Resource<Employee>(entity,
				linkTo(methodOn(EmployeeController.class).one(entity.getId())).withSelfRel(), 
				linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
	}
	
	

}
