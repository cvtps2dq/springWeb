package ru.cv2.springweb.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.cv2.springweb.DTO.UserRoleDTO;
import ru.cv2.springweb.services.UserRoleService;

import java.util.UUID;

@Controller
@RequestMapping("/mvc/role")
public class RoleMVC {
    private final UserRoleService roleService;

    public RoleMVC(UserRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute(roleService.getAll());
        return "allRoles";
    }

    @GetMapping("/id/{id}")
    public String getById(@PathVariable UUID id, Model model){
        model.addAttribute(roleService.getRoleById(id));
        return "roleId";
    }

    @PostMapping("/edit")
    public String editRole(@RequestBody UserRoleDTO updatedRole, Model model){
        model.addAttribute(roleService.updateUserRole(updatedRole.getId(), updatedRole));
        return "editRole";
    }

    @PostMapping("/delete/{uuid}")
    public String deleteRole(@PathVariable UUID uuid, Model model){
        roleService.deleteRole(uuid);
        model.addAttribute("deleted role.");
        return "deletedRole";
    }

    @PostMapping("/add")
    public String addRole(@RequestBody UserRoleDTO role, Model model){
        model.addAttribute(roleService.saveRole(role));
        return "addOffer";
    }
}
