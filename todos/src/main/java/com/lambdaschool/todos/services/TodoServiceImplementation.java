package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "todoService")
public class TodoServiceImplementation implements TodoService {
  private final TodoRepository todoRepository;

  public TodoServiceImplementation(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @Override
  public void markComplete(long todoId) {
    Todo todo = todoRepository
      .findById(todoId)
      .orElseThrow(
        () ->
          new EntityNotFoundException(
            String.format("No Todo found with ID %d", todoId)
          )
      );

    todo.setCompleted(true);
    todoRepository.save(todo);
  }
}
