package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;

/**
 * The entity allowing interaction with the users table
 */
@SuppressWarnings("RedundantSuppression")
@Entity
@Table(name = "users")
public class User extends Auditable {
  /**
   * The primary key (long) of the users table.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private long userId;

  /**
   * The username (String). Cannot be null and must be unique
   */
  @Column(nullable = false, unique = true)
  private String username;

  /**
   * The password (String) for this user. Cannot be null. Never get displayed
   */
  @Column(nullable = false)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  /**
   * Primary email account of user. Could be used as the userid. Cannot be null and must be unique.
   */
  @Column(name = "primary_email", nullable = false, unique = true)
  @Email
  private String primaryEmail;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
  @JsonIgnoreProperties(value = "user", allowSetters = true)
  private Set<Todo> todos = new HashSet<>();

  /**
   * Default constructor used primarily by the JPA.
   */
  @SuppressWarnings("unused")
  public User() {
    super();
  }

  /**
   * Given the params, create a new user object
   * <p>
   * userid is autogenerated
   *
   * @param username     The username (String) of the user
   * @param password     The password (String) of the user
   * @param primaryEmail The primary email (String) of the user
   */
  public User(String username, String password, String primaryEmail) {
    setUsername(username);
    setPassword(password);
    this.primaryEmail = primaryEmail;
  }

  public Set<Todo> getTodos() {
    return todos;
  }

  public void setTodos(Set<Todo> todos) {
    this.todos = todos;
  }

  /**
   * Getter for userid
   *
   * @return the userid (long) of the user
   */
  public long getUserId() {
    return userId;
  }

  /**
   * Setter for userid. Used primary for seeding data
   *
   * @param userId the new userid (long) of the user
   */
  public void setUserId(long userId) {
    this.userId = userId;
  }

  /**
   * Getter for username
   *
   * @return the username (String) lowercase
   */
  public String getUsername() {
    if (username == null) { // this is possible when updating a user
      return null;
    } else {
      return username.toLowerCase();
    }
  }

  /**
   * setter for username
   *
   * @param username the new username (String) converted to lowercase
   */
  public void setUsername(String username) {
    this.username = username.toLowerCase();
  }

  /**
   * getter for primary email
   *
   * @return the primary email (String) for the user converted to lowercase
   */
  public String getPrimaryEmail() {
    if (primaryEmail == null) { // this is possible when updating a user
      return null;
    } else {
      return primaryEmail.toLowerCase();
    }
  }

  /**
   * setter for primary email
   *
   * @param primaryEmail the new primary email (String) for the user converted to lowercase
   */
  public void setPrimaryEmail(String primaryEmail) {
    this.primaryEmail = primaryEmail.toLowerCase();
  }

  /**
   * Getter for the password
   *
   * @return the password (String) of the user
   */
  public String getPassword() {
    return password;
  }

  /**
   * Setter for password
   *
   * @param password the new password (String) for the user
   */
  public void setPassword(String password) {
    this.password = password;
  }
}
