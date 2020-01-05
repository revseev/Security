package spring.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.model.Role;
import spring.model.User;
import spring.service.RoleService;
import spring.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @GetMapping
    public String toIndex() {
        return "index";
    }

    @GetMapping(value = "/list")
    public String toList(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping(value = "/new")
    public ModelAndView toUserForm() {
        User user = new User();
        ModelAndView modelView = new ModelAndView("userform");
        modelView.addObject("user", user);
        modelView.addObject("edit", false);
//        modelView.addObject("allRoles", roleService.getAll());
        return modelView;
    }
    //// EXPERIMENTAL SHIT
    @ModelAttribute("allRoles")
    public List<Role> initializeProfiles() {
        return roleService.getAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@ModelAttribute("user") User user) {
        if (user.getId() > 0) {
            userService.updateUser(user);
        } else {
            userService.addUser(user);
        }
        return "redirect:/list";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.deleteUser(user.getId());
        return "redirect:/list";
    }

    @GetMapping(value = "/edit")
    public String toEditForm(@RequestParam(value = "id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("edit", true);
        return "userform";
    }

/*    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/list";
    }*/
}