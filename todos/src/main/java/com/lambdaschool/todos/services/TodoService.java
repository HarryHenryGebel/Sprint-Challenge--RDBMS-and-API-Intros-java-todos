package com.lambdaschool.todos.services;

import org.springframework.stereotype.Component;

public interface TodoService {
  void markComplete(long todoid);
}
