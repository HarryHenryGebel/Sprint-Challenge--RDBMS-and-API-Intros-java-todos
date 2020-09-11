package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * The CRUD repository connecting Todo to the rest of the application
 */
@Component
public interface TodoRepository extends CrudRepository<Todo, Long> {}
