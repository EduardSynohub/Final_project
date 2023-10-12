package pl.coderslab.domain.repair_service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/repair")
public class RepairServiceController {

    private final JpaRepairService jpaRepairService;

    public RepairServiceController(JpaRepairService jpaRepairService) {
        this.jpaRepairService = jpaRepairService;
    }

    @GetMapping("/all")
    public String showAllRepairServices(Model model) {
        List<RepairService> repairServices = jpaRepairService.getAll();
        model.addAttribute("repair_services", repairServices);
        return "repair_service/all";
    }

    @GetMapping("/create")
    public String showAddingForm(Model model) {
        model.addAttribute("repair_service", new RepairService());
        return "repair_service/create";
    }

    @Transactional
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveRepairService(@Valid RepairService repairService, BindingResult result) {
        if (result.hasErrors()) {
            return "repair_service/create";
        }
        jpaRepairService.create(repairService);
        return "redirect:/repair/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("repair_service", jpaRepairService.get(id));
        return "repair_service/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editRepairService(@Valid RepairService repairService, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "repair_service/edit";
        }
        jpaRepairService.create(repairService);
        return "redirect:/repair/all";
    }

    @GetMapping("/get/{id}")
    public String showRepairService(Model model, @PathVariable Long id){
        model.addAttribute("repair_service", jpaRepairService.get(id));
        return "repair_service/repair_service";
    }

    @GetMapping ("/delete/{id}")
    public String deleteRepairService(@PathVariable Long id) {
        jpaRepairService.delete(id);
        return "redirect:/repair/all";
    }
}
