package br.com.joy.controllers;

import br.com.joy.entities.dtos.FaithfulDTO;
import br.com.joy.entities.formsobjects.FaithfulForm;
import br.com.joy.entities.formsobjects.FaithfulRegistrationCount;
import br.com.joy.services.FaithfulService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/faithful")
@AllArgsConstructor
public class FaithfulController {

    private final FaithfulService faithfulService;
    private final MessageSource messageSource;


    @GetMapping
    public String createFaithfulForm(Model model) {
        model.addAttribute("faithful", new FaithfulForm());
        return "index";
    }

    @GetMapping("/faith/last30days")
    @ResponseBody
    public List<FaithfulRegistrationCount> getLast30DaysRegistrations() {
//        return faithfulService.getLast30DaysRegistrations();
        List<FaithfulRegistrationCount> mock = new ArrayList<>();
        mock.add(new FaithfulRegistrationCount(LocalDate.now().minusDays(8), 1L));
        mock.add(new FaithfulRegistrationCount(LocalDate.now().minusDays(7), 4L));
        mock.add(new FaithfulRegistrationCount(LocalDate.now().minusDays(6), 23L));
        mock.add(new FaithfulRegistrationCount(LocalDate.now().minusDays(5), 12L));
        mock.add(new FaithfulRegistrationCount(LocalDate.now().minusDays(4), 23L));
        mock.add(new FaithfulRegistrationCount(LocalDate.now().minusDays(3), 25L));
        mock.add(new FaithfulRegistrationCount(LocalDate.now().minusDays(2), 34L));
        mock.add(new FaithfulRegistrationCount(LocalDate.now().minusDays(1), 45L));
        mock.add(new FaithfulRegistrationCount(LocalDate.now(), 47L));
        return mock;
    }

    @PostMapping
    public String createFiel(@ModelAttribute("faithful") FaithfulForm faithfulForm, BindingResult bindingResult, Model model, Locale locale) {
        if (bindingResult.hasErrors()) {
//            return "redirect:/faithful";
            return "index";
        }

        FaithfulDTO faithfulDTO = convertToDTO(faithfulForm);
        faithfulService.saveFaithfull(faithfulDTO);
        model.addAttribute("successMessage", messageSource.getMessage("registration.success",null, locale));
        return "index";
    }

    private FaithfulDTO convertToDTO(FaithfulForm faithfulForm) {
        return new FaithfulDTO(
                faithfulForm.getId(),
                faithfulForm.getFullName(),
                faithfulForm.getPhoneNumber(),
                faithfulForm.getBirthDay(),
                faithfulForm.getOriginCity(),
                faithfulForm.getCountry(),
                faithfulForm.getOriginNetwork(),
                faithfulForm.getCreatedDate()
        );
    }
}

