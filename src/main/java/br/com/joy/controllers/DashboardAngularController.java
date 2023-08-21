package br.com.joy.controllers;

import br.com.joy.entities.dtos.FaithfulDTO;
import br.com.joy.services.DashboardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/dashboard")
@AllArgsConstructor
public class DashboardAngularController {

    private final DashboardService dashboardService;
    @GetMapping("/country/{country}")
    public ResponseEntity<Integer> getNumberPeopleSameCountry(@PathVariable String country) {
        return ResponseEntity.ok(dashboardService.getNumberPeopleSameCountry(country));
    }

    @GetMapping("/country/list")
    public ResponseEntity<Set<String>> getAllCountry() {
        return ResponseEntity.ok(dashboardService.getAllCountry());
    }

    @GetMapping("/country/list/{country}")
    public ResponseEntity<List<FaithfulDTO>> getPeopleSameCountry(@PathVariable String country) {
        return ResponseEntity.ok(dashboardService.getPeopleSameCountry(country));
    }

}

