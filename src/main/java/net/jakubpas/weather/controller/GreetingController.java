package net.jakubpas.weather.controller;
import net.jakubpas.weather.Weather;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("indoor", getIndoor());
        model.addAttribute("outdoor", getOutdoor());
        return "temperature";
    }

    private String getIndoor() {
        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("/var/log/temperature.log"))) {
            line = reader.readLine();
            return line;
        } catch (IOException e) {
            return "";
        }
    }

    private String getOutdoor() {
        HttpHeaders httpHeaders = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Weather> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Weather> aResponse = restTemplate.exchange(
                "http://api.openweathermap.org/data/2.5/weather?id=7531836&appid=77cd0ebb0fe3ef249daca875ba1e65f0&units=metric"
                , HttpMethod.GET, entity, Weather.class);
        return Objects.requireNonNull(aResponse.getBody()).getMain().getTemperature();
    }
}