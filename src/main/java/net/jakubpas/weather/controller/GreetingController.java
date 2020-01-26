package net.jakubpas.weather.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("temperature", readTemperature());
        return "temperature";
    }

    private String readTemperature() {
        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("/var/log/temperature.log"))) {
            line = reader.readLine();
            return line;
        } catch (IOException e) {
            return "";
        }
    }
}