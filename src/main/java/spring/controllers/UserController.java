package spring.controllers;

//import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

//    @Autowired
//    private UserService service;

    @RequestMapping(/*value = "", */method = RequestMethod.GET)
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(Model model) {
//        List<User> users = service.getAllUsers();
//        model.addAttribute("users", users);
        return "user-list";
    }

/*	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public String getCarsPage(@RequestParam(value = "locale", required = false, defaultValue = "en") String locale, Model m) {
		if (locale.equalsIgnoreCase("ru")) {
			m.addAttribute("title", "Список машин");
		} else {
			m.addAttribute("title", "Car list");
		}
//		List<Car> cars = CarService.getCars();
		m.addAttribute("carList", cars);

		return "cars";
	}*/
}