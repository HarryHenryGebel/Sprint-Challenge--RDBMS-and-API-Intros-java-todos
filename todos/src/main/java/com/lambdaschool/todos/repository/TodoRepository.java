package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.models.Todo;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD repository connecting Todo to the rest of the application
 */
public interface TodoRepository extends CrudRepository<Todo, Long> {}
