package br.com.joy.controllers;

import br.com.joy.entities.dtos.ChartDataDTO;
import br.com.joy.entities.dtos.CountryDTO;
import br.com.joy.entities.dtos.FaithfulDTO;
import br.com.joy.services.DashboardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/dashboardExternal")
@AllArgsConstructor
public class DashboardExternalController {

    @Autowired
    private final DashboardService dashboardService;

    @GetMapping("/country/{country}")
    public ResponseEntity<ChartDataDTO> getNumberPeopleSameCountry(@PathVariable("country") String country) {
        return ResponseEntity.ok(dashboardService.getNumberPeopleSameCountry(country.replaceAll(" ", "_")));
    }


    @GetMapping("/country/list")
    public ResponseEntity <ChartDataDTO> getAllCountry() {
        return ResponseEntity.ok(dashboardService.getAllCountry());
    }

    @GetMapping("/country/list/{country}")
    public ResponseEntity<List<FaithfulDTO>> getPeopleSameCountry(@PathVariable("country") String country) {
        return ResponseEntity.ok(dashboardService.getPeopleSameCountry(country));
    }

    @GetMapping("/city/list")
    public ResponseEntity<Set<String>> getAllCities() {
        return ResponseEntity.ok(dashboardService.getAllCities());
    }

    @GetMapping("/city/list/{city}")
    public ResponseEntity<List<FaithfulDTO>> getPeopleSameCity(@PathVariable("city") String city) {
        return ResponseEntity.ok(dashboardService.getPeopleSameCity(city));
    }

    @GetMapping("/people")
    public ResponseEntity<List<FaithfulDTO>> getAllCreatedThisMonth() {
        return ResponseEntity.ok(dashboardService.getAllCreatedThisMonth());
    }

    @GetMapping("/countByCountry")
    public ResponseEntity<List<CountryDTO>> countByCountry() {
        return ResponseEntity.ok(dashboardService.countByCountry());
    }
}
