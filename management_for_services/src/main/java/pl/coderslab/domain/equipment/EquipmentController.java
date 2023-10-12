package pl.coderslab.domain.equipment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/equip")
public class EquipmentController {

    private final JpaEquipmentService jpaEquipmentService;

    public EquipmentController(JpaEquipmentService jpaEquipmentService) {
        this.jpaEquipmentService = jpaEquipmentService;
    }

    @GetMapping("/all")
    public String showAllEquipment(Model model) {
        List<Equipment> equipments = jpaEquipmentService.getAll();
        model.addAttribute("equipments", equipments);
        return "equipment/all";
    }

    @GetMapping("/create")
    public String showAddingForm(Model model) {
        model.addAttribute("equipment", new Equipment());
        return "equipment/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveEquipment(@Valid Equipment equipment , BindingResult result) {
        if (result.hasErrors()) {
            return "equipment/create";
        }
        jpaEquipmentService.create(equipment);
        return "redirect:/equip/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("equipment", jpaEquipmentService.get(id));
        return "equipment/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editEquipment(@Valid Equipment equipment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "equipment/edit";
        }
        jpaEquipmentService.create(equipment);
        return "redirect:/equip/all";
    }

    @GetMapping("/get/{id}")
    public String showEquipment(Model model, @PathVariable Long id){
        model.addAttribute("equipment", jpaEquipmentService.get(id));
        return "equipment/equipment";
    }

    @GetMapping ("/delete/{id}")
    public String deleteEquipment(@PathVariable Long id) {
        jpaEquipmentService.delete(id);
        return "redirect:/equip/all";
    }
}
