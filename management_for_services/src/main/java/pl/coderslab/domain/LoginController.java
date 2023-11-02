package pl.coderslab.domain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.domain.restaurant.JpaRestaurantService;
import pl.coderslab.domain.restaurant.Restaurant;
import pl.coderslab.domain.user.JpaUserService;
import pl.coderslab.domain.user.User;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {

    private final JpaUserService jpaUserService;
    private final JpaRestaurantService jpaRestaurantService;

    public LoginController(JpaUserService jpaUserService, JpaRestaurantService jpaRestaurantService) {
        this.jpaUserService = jpaUserService;
        this.jpaRestaurantService = jpaRestaurantService;
    }

    @ModelAttribute("list_of_restaurant")
    public List<Restaurant> restaurantList() {
        return jpaRestaurantService.getAll();
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }

    @GetMapping("/create")
    public String showAddingForm(Model model) {
        model.addAttribute("user", new User());
        return "user/registration";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/registration";
        }
        jpaUserService.saveUser(user);
        return "redirect:/home";
    }
}
