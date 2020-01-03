package spring.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import spring.model.User;
import spring.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService service;


    @RequestMapping(method = RequestMethod.GET)
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(Model model) {
        List<User> users = service.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String toNewForm() {
        return "user-form";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@ModelAttribute("user") User user) {
        service.deleteUser(user.getId());
        return "redirect:/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    //тут творится магия! Передавай хоть инт, хоть стринг, будет работать как надо
    public String toEditForm(@RequestParam(value = "id") long id, Model model) {
        model.addAttribute("user", service.getUser(id));
        return "user-form";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user) {
        service.updateUser(user);
        return "redirect:/list";
    }
}