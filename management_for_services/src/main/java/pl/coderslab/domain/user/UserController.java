package pl.coderslab.domain.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.restaurant.Restaurant;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final JpaUserService jpaUserService;

    public UserController(JpaUserService jpaUserService) {
        this.jpaUserService = jpaUserService;
    }

    @GetMapping("/all")
    public String showAllUsers(Model model) {
        List<User> users = jpaUserService.getAll();
        model.addAttribute("users", users);
        return "all_users";
    }

    @GetMapping("/create")
    public String showAddingForm(Model model) {
        model.addAttribute("user", new User());
        return "create_user";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "create_user";
        }
        jpaUserService.create(user);
        return "redirect:/user/all";
    }

    @ModelAttribute("list_of_restaurant")
    public List<Restaurant> restaurantList() {
        return restaurantRepository.findAll();
    }
}
