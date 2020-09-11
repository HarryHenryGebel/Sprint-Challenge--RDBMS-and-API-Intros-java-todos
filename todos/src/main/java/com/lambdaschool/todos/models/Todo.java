package com.lambdaschool.todos.models;

import javax.persistence.*;

/**
 * The entity allowing interaction with the todos table
 */
@Entity
@Table(name = "todos")
public class Todo extends Auditable {
  /**
   * The primary key of the todos table
   */
  @Id
  @GeneratedValue()
  @Column(name = "todo_id", nullable = false)
  private long todoId;

  /**
   * The description of the item
   */
  @Column(nullable = false)
  private String description;

  /**
   * Completed status of the item
   */
  @Column(columnDefinition = "boolean default false")
  private boolean completed;

  /**
   * The user id of the owner of the item
   */
  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private long userId;

  public Todo() {
  }

  public Todo(long todoId, String description, boolean completed, long userId) {
    this.todoId = todoId;
    this.description = description;
    this.completed = completed;
    this.userId = userId;
  }

  public long getTodoId() {
    return todoId;
  }

  public void setTodoId(long todoId) {
    this.todoId = todoId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }
}
