package com.lambdaschool.todos.models;

import javax.persistence.*;

/**
 * The entity allowing interaction with the todos table
 */
@SuppressWarnings("RedundantSuppression")
@Entity
@Table(name = "todos")
public class Todo extends Auditable {
  /**
   * The primary key of the todos table
   */
  @Id
  @GeneratedValue
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
  @JoinColumn(name = "user_id")
  private User user;

  @SuppressWarnings({ "unused" })
  public Todo() {
    super();
  }

  public Todo(User user, String description) {
    super();
    this.user = user;
    this.description = description;
  }

  @SuppressWarnings("unused")
  public long getTodoId() {
    return todoId;
  }

  @SuppressWarnings("unused")
  public void setTodoId(long todoId) {
    this.todoId = todoId;
  }

  @SuppressWarnings("unused")
  public String getDescription() {
    return description;
  }

  @SuppressWarnings("unused")
  public void setDescription(String description) {
    this.description = description;
  }

  @SuppressWarnings("unused")
  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  @SuppressWarnings("unused")
  public User getUser() {
    return user;
  }

  @SuppressWarnings("unused")
  public void setUser(User user) {
    this.user = user;
  }
}
