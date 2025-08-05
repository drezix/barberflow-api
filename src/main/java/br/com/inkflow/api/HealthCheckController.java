package br.com.inkflow.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping
    public String check() {
        return "Backend do BarberFlow está no ar! Data: " + java.time.LocalDate.now();
    }
}