package edu.co.poli.users.service;

import edu.co.poli.users.persistence.entity.User;
import edu.co.poli.users.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImple implements UserService{

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        userRepository.save(user);

        return user;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}
