package com.hugosamayoa.Ejemplo.controller;


import com.hugosamayoa.Ejemplo.model.User;
import com.hugosamayoa.Ejemplo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getALLUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping
    public String createUser(@RequestBody User user){
        User result = userService.saveUser(user);
        if ("ERROR_NOMBRE_REPETIDO".equals(result.getFirstName())) {
            return "El nombre ya está agregado";
        }
        if ("ERROR_APELLIDO_REPETIDO".equals(result.getLastName())) {
            return "El apellido ya está agregado";
        }
        if ("ERROR_EMAIL_REPETIDO".equals(result.getEmail())) {
            return "El email ya está agregado";
        }
        return "Usuario agregado correctamente";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody User user){
        User result = userService.updateUser(id, user);
        if (result == null) {
            return "Usuario no encontrado";
        }
        if ("ERROR_NOMBRE_REPETIDO".equals(result.getFirstName())) {
            return "El nombre ya está agregado";
        }
        if ("ERROR_APELLIDO_REPETIDO".equals(result.getLastName())) {
            return "El apellido ya está agregado";
        }
        if ("ERROR_EMAIL_REPETIDO".equals(result.getEmail())) {
            return "El email ya está agregado";
        }
        return "Usuario actualizado correctamente";
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
