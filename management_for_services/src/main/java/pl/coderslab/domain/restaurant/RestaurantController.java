package pl.coderslab.domain.restaurant;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.CurrentUser;
import pl.coderslab.domain.breakdown.Breakdown;
import pl.coderslab.domain.breakdown.JpaBreakdownService;
import pl.coderslab.domain.equipment.Equipment;
import pl.coderslab.domain.equipment.JpaEquipmentService;
import pl.coderslab.domain.repair_service.JpaRepairService;
import pl.coderslab.domain.repair_service.RepairService;
import pl.coderslab.domain.user.JpaUserService;
import pl.coderslab.domain.user.User;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/rest")
public class RestaurantController {

    private final JpaRestaurantService jpaRestaurantService;
    private final JpaEquipmentService jpaEquipmentService;
    private final JpaUserService jpaUserService;
    private final JpaRepairService jpaRepairService;
    private final JpaBreakdownService jpaBreakdownService;

    public RestaurantController(JpaRestaurantService jpaRestaurantService, JpaEquipmentService jpaEquipmentService, JpaUserService jpaUserService, JpaRepairService jpaRepairService, JpaBreakdownService jpaBreakdownService) {
        this.jpaRestaurantService = jpaRestaurantService;
        this.jpaEquipmentService = jpaEquipmentService;
        this.jpaUserService = jpaUserService;
        this.jpaRepairService = jpaRepairService;
        this.jpaBreakdownService = jpaBreakdownService;
    }

    @ModelAttribute("restaurant_id")
    public Long restaurantId(@AuthenticationPrincipal CurrentUser customUser) {
        return customUser.getUser().getRestaurant().getId();
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
        jpaRestaurantService.create(restaurant);
        return "redirect:/rest/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("restaurant", jpaRestaurantService.get(id));
        return "restaurant/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editRestaurant(@Valid Restaurant restaurant, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "restaurant/edit";
        }
        if(restaurant.getName().equals(jpaRestaurantService.get(restaurant.getId()).get().getName())) {
            restaurant.setName(jpaRestaurantService.get(restaurant.getId()).get().getName());
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
    public String deleteRestaurant(@PathVariable Long id, HttpSession session, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Breakdown> breakdowns = jpaBreakdownService.getAll();
        for (Breakdown b : breakdowns) {
            if (b.getRestaurant().getId().equals((jpaRestaurantService.get(id)).get().getId())) {
                jpaBreakdownService.delete(b.getId());
            }
        }
        List<User> users = jpaUserService.getAll();
        for (User u : users) {
            if (u.getRestaurant().getId().equals((jpaRestaurantService.get(id)).get().getId())) {
                jpaUserService.delete(u.getId());
            }
        }
        jpaRestaurantService.delete(id);
        if (currentUser.getUser().getRestaurant().getId().equals(id)) {
            session.invalidate();
        }
        return "redirect:/rest/all";
    }


    @GetMapping("/addEquipment")
    public String addingFormEquipment(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        String username = customUser.getUsername();
        Long restaurantId = jpaUserService.getRestaurantId(username);
        model.addAttribute("restaurantId", restaurantId);
        return "restaurant/add-equipment-to-restaurant";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/addEquipment")
    public String addEquip(@RequestParam Long restaurantId, @RequestParam Long equipmentId) {
        jpaRestaurantService.addEquipmentToRestaurant(equipmentId, restaurantId);
        return "redirect:/rest/all";
    }

    @GetMapping("/addRepairService")
    public String addingFormForRepairService(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        String username = customUser.getUsername();
        Long restaurantId = jpaUserService.getRestaurantId(username);
        model.addAttribute("restaurantId", restaurantId);
        return "restaurant/add-repair-service-to-restaurant";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/addRepairService")
    public String addRepairService(@RequestParam Long restaurantId, @RequestParam Long repairServiceId) {
        jpaRestaurantService.addRepairServiceToRestaurant(repairServiceId, restaurantId);
        return "redirect:/rest/all";
    }

    @ModelAttribute("list_of_equipment_in_restaurant")
    public List<Equipment> equipmentList() {
        return jpaEquipmentService.getAll();
    }

    @ModelAttribute("list_of_repair_services")
    public List<RepairService> repairServiceList() {
        return jpaRepairService.getAll();
    }

    @GetMapping("/deleteRepairService/{restaurantId}/{repairServiceId}")
    public String deletingFormForRepairService(@PathVariable Long restaurantId, @PathVariable Long repairServiceId) {
        jpaRestaurantService.deleteRepairServiceFromRestaurant(repairServiceId, restaurantId);
        return "redirect:/rest/get/{restaurantId}";
    }

    @GetMapping("/deleteEquipment/{restaurantId}/{equipmentId}")
    public String deletingFormForEquipment(@PathVariable Long restaurantId, @PathVariable Long equipmentId) {
        jpaRestaurantService.deleteEquipmentFromRestaurant(equipmentId, restaurantId);
        return "redirect:/rest/get/{restaurantId}";
    }
}
