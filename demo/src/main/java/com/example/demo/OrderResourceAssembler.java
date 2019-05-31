package com.example.demo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.example.demo.controllers.OrderController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;;

@Component
public class OrderResourceAssembler implements ResourceAssembler<Order, Resource<Order>> {

	@Override
	public Resource<Order> toResource(Order entity) {
		Resource<Order>orderResource = new Resource<Order>(entity,
				linkTo(methodOn(OrderController.class).one(entity.getId())).withSelfRel(),
				linkTo(methodOn(OrderController.class).all()).withRel("orders"));
		if(entity.getStatus()==Status.IN_PROGRESS) {
			orderResource.add(linkTo(methodOn(OrderController.class).cancel(entity.getId())).withRel("cancel"));
			orderResource.add(linkTo(methodOn(OrderController.class).complete(entity.getId())).withRel("complete"));
		}
		
		return orderResource;
	}

}
