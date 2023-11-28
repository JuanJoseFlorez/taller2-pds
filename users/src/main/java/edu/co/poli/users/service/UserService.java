package edu.co.poli.users.service;

import edu.co.poli.users.persistence.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    void delete(User user);
    List<User> findAll();
    User findById(Long id);

}
