package edu.co.poli.users.service;

import edu.co.poli.users.clientFeign.BookingsClient;
import edu.co.poli.users.model.Booking;
import edu.co.poli.users.persistence.entity.User;
import edu.co.poli.users.persistence.repository.UserRepository;
import edu.co.poli.users.service.dto.UserInDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImple implements UserService{

    private final UserRepository userRepository;
    private final BookingsClient bookingsClient;

    @Override
    public User save(UserInDTO user) {
        ModelMapper modelMapper = new ModelMapper();
        return userRepository.save(modelMapper.map(user, User.class));
    }

    @Override
    public String delete(User user) {
        List<Booking> booking= bookingsClient.findByUserId(user.getId());
        System.out.println(booking);
        if(booking==null||booking.isEmpty()){
            userRepository.delete(user);
            return "Eliminado correctamente";
        }
        return "Este usuario tiene reservas asociadas";
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
