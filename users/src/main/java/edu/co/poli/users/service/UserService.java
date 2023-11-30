package edu.co.poli.users.service;

import edu.co.poli.users.persistence.entity.User;
import edu.co.poli.users.service.dto.UserInDTO;

import java.util.List;

public interface UserService {
    User save(UserInDTO user);
    String delete(User user);
    List<User> findAll();
    User findById(Long id);

}
