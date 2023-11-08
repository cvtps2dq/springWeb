package ru.cv2.springweb.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.cv2.springweb.DTO.UserDTO;
import ru.cv2.springweb.DTO.UserRoleDTO;
import ru.cv2.springweb.services.UserService;

import java.util.UUID;

@Controller
@RequestMapping("/mvc/user")
public class UserMVC {
    private final UserService userService;

    public UserMVC(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute(userService.getAll());
        return "allRoles";
    }

    @GetMapping("/name/{name}")
    public String getById(@PathVariable String name, Model model){
        model.addAttribute(userService.getUserByName(name));
        return "userName";
    }

    @GetMapping("/id/{id}")
    public String getByName(@PathVariable UUID id, Model model){
        model.addAttribute(userService.getUserById(id));
        return "userId";
    }

    @PostMapping("/edit")
    public String editUser(@RequestBody UserDTO updatedUser, Model model){
        model.addAttribute(userService.editUser(updatedUser, updatedUser.getId()));
        return "editUser";
    }

    @PostMapping("/delete/{uuid}")
    public String deleteUser(@PathVariable UUID uuid, Model model){
        userService.deleteUser(uuid);
        model.addAttribute("deleted user.");
        return "deletedUser";
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UserDTO role, Model model){
        model.addAttribute(userService.saveUser(role));
        return "addUser";
    }
}
