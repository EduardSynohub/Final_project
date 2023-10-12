package pl.coderslab.domain.restaurant;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.equipment.Equipment;
import pl.coderslab.domain.equipment.JpaEquipmentService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/rest")
public class RestaurantController {

    private final JpaRestaurantService jpaRestaurantService;
    private final JpaEquipmentService jpaEquipmentService;

    public RestaurantController(JpaRestaurantService jpaRestaurantService, JpaEquipmentService jpaEquipmentService) {
        this.jpaRestaurantService = jpaRestaurantService;
        this.jpaEquipmentService = jpaEquipmentService;
    }

    @GetMapping("/all")
    public String showAllRestaurants(Model model) {
        List<Restaurant> restaurants = jpaRestaurantService.getAll();
        model.addAttribute("restaurants", restaurants);
        return "restaurant/all";
    }

    @GetMapping("/create")
    public String showAddingForm(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "restaurant/create";
    }

    @Transactional
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveRestaurant(@Valid Restaurant restaurant, BindingResult result) {
        if (result.hasErrors()) {
            return "restaurant/create";
        }
//        List<Equipment> equipmentList = jpaEquipmentService.getAll();
        jpaRestaurantService.create(restaurant);
//        for (Equipment e : equipmentList) {
//            restaurant.addEquipment(e);
//        }
        return "redirect:/restaurant/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("restaurant", jpaRestaurantService.get(id));
        return "restaurant/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editRestaurant(@Valid Restaurant restaurant, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "restaurant/edit";
        }
        jpaRestaurantService.create(restaurant);
        return "redirect:/rest/all";
    }

    @GetMapping("/get/{id}")
    public String showRestaurant(Model model, @PathVariable Long id){
        model.addAttribute("restaurant", jpaRestaurantService.get(id));
        return "restaurant/restaurant";
    }

    @GetMapping ("/delete/{id}")
    public String deleteRestaurant(@PathVariable Long id) {
        jpaRestaurantService.delete(id);
        return "redirect:/rest/all";
    }
}
