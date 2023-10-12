package pl.coderslab.domain.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.restaurant.JpaRestaurantService;
import pl.coderslab.domain.restaurant.Restaurant;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final JpaUserService jpaUserService;
    private final JpaRestaurantService jpaRestaurantService;

    public UserController(JpaUserService jpaUserService, JpaRestaurantService jpaRestaurantService) {
        this.jpaUserService = jpaUserService;
        this.jpaRestaurantService = jpaRestaurantService;
    }

    @GetMapping("/all")
    public String showAllUsers(Model model) {
        List<User> users = jpaUserService.getAll();
        model.addAttribute("users", users);
        return "user/all";
    }

    @GetMapping("/create")
    public String showAddingForm(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/create";
        }
        jpaUserService.create(user);
        return "redirect:/user/all";
    }

    @ModelAttribute("list_of_restaurant")
    public List<Restaurant> restaurantList() {
        return jpaRestaurantService.getAll();
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("user", jpaUserService.get(id));
        return "user/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }
        jpaUserService.update(user);
        return "redirect:/user/all";
    }

    @GetMapping("/get/{id}")
    public String showUser(Model model, @PathVariable Long id){
        model.addAttribute("user", jpaUserService.get(id));
        return "user/user";
    }

    @GetMapping ("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        jpaUserService.delete(id);
        return "redirect:/user/all";
    }
}
