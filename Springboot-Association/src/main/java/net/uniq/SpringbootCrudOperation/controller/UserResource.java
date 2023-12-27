package net.uniq.SpringbootCrudOperation.controller;


import java.net.URI;
import java.util.List;



import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import net.uniq.SpringbootCrudOperation.entity.User;
import net.uniq.SpringbootCrudOperation.exception.UserNotFoundException;
import net.uniq.SpringbootCrudOperation.service.UserDaoService;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	// GET /users
	// retrieveAllUsers
	// http://localhost:8080/users/
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	// GET /users/{id}
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {

		User user = service.findOne(id);
		System.out.println(user);
		if (user == null)
			throw new UserNotFoundException("id-" + id);

		return user;
	}
	
	//http://localhost:8080/userResource/users/hateoas/7

	@GetMapping("/users/hateoas/{id}")
	public EntityModel<User> retrieveUser_hateoas(@PathVariable int id) {
		User user = service.findOne(id);

		if (user == null)
			throw new UserNotFoundException("id-" + id);

		// "all-users", SERVER_PATH + "/users" // retrieveAllUsers EntityModel<User>
		EntityModel<User> resource = EntityModel.of(user);

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

		resource.add(linkTo.withRel("all-users"));

		// HATEOAS
		return resource;
	}

	// input - details of user
	// output - Created & Return the Created URI

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@jakarta.validation.Valid @RequestBody User user) {

		User saveduser = service.save(user);

		// CREATED
		// /user/{id} savedUser.getId()

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId())
				.toUri();
		
		

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);

		if (user == null)
			throw new UserNotFoundException("id-" + id);
	}

	
	
}
