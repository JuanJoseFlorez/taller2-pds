package edu.co.poli.users.controller;

import edu.co.poli.users.helper.Response;
import edu.co.poli.users.helper.ResponseBuild;
import edu.co.poli.users.persistence.entity.User;
import edu.co.poli.users.service.UserService;
import edu.co.poli.users.service.dto.UserInDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ResponseBuild builder;

    @PostMapping
    public Response save(@Valid @RequestBody UserInDTO user, BindingResult result) {
        if(result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        return builder.success(userService.save(user));
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if(user==null){
            return builder.failed("Not found");
        }
        String message = userService.delete(user);
        if(message == "Eliminado correctamente"){
            return builder.success(message);
        }
        return builder.failed(message);
    }

    private List<Map<String, String>> formatMessage(BindingResult result) {
        return result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
    }
}
