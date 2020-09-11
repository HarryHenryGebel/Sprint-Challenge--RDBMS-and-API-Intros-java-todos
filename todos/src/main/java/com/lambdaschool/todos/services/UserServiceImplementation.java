package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repository.UserRepository;
import com.lambdaschool.todos.views.UserNameCountTodos;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the UserService Interface
 */
@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {
  /**
   * Connects this service to the User table.
   */
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User findUserById(long id) throws EntityNotFoundException {
    return userRepository
      .findById(id)
      .orElseThrow(
        () -> new EntityNotFoundException("User id " + id + " not found!")
      );
  }

  @Override
  public List<User> findAll() {
    List<User> list = new ArrayList<>();
    /*
     * findAll returns an iterator set.
     * iterate over the iterator set and add each element to an array list.
     */
    userRepository.findAll().iterator().forEachRemaining(list::add);
    return list;
  }

  @Transactional
  @Override
  public void delete(long id) {
    userRepository
      .findById(id)
      .orElseThrow(
        () -> new EntityNotFoundException("User id " + id + " not found!")
      );
    userRepository.deleteById(id);
  }

  @Transactional
  @Override
  public User save(User user) {
    user.setUsername(user.getUsername().toLowerCase());
    user.setPassword(user.getPassword());
    user.setPrimaryEmail(user.getPrimaryEmail().toLowerCase());

    return userRepository.save(user);
  }

  @Override
  public List<UserNameCountTodos> getCountUserTodos() {
    return null;
  }
}
