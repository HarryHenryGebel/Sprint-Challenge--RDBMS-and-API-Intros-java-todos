package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * The CRUD repository connecting User to the rest of the application
 */
@Component
public interface UserRepository extends CrudRepository<User, Long> {}
