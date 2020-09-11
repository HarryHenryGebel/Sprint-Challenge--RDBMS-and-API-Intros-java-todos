package com.lambdaschool.todos.services;

import org.springframework.stereotype.Service;

@Service(value = "todoService")
public class TodoServiceImplementation implements TodoService {

  @Override
  public void markComplete(long todoid) {}
}
