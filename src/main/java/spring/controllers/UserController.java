package spring.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.model.Role;
import spring.model.User;
import spring.service.RoleService;
import spring.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView toNewForm() {
        User user = new User();
        ModelAndView modelView = new ModelAndView("userform");
        modelView.addObject("user", user);
//        modelView.addObject("allRoles", roleService.getAll());
        return modelView;
    }
    //// EXPERIMENTAL SHIT
    @ModelAttribute("allRoles")
    public List<Role> initializeProfiles() {
        return roleService.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        if (user.getId() > 0) {
            userService.updateUser(user);
        } else {
            userService.addUser(user);
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.deleteUser(user.getId());
        return "redirect:/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    //тут творится магия! Передавай хоть инт, хоть стринг, будет работать как надо
    public String toEditForm(@RequestParam(value = "id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "user-form";
    }

/*    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/list";
    }*/
}