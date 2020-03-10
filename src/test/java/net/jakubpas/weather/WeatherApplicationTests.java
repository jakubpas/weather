package net.jakubpas.weather;

import net.jakubpas.weather.controller.GreetingController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Objects;

@SpringBootTest
class WeatherApplicationTests {

	@Test
	String contextLoads() {
		HttpHeaders httpHeaders = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Weather> entity = new HttpEntity<>(httpHeaders);
		ResponseEntity<Weather> aResponse = restTemplate.exchange(
				"http://api.openweathermap.org/data/2.5/weather?id=7531836&appid=77cd0ebb0fe3ef249daca875ba1e65f0&units=metric"
				, HttpMethod.GET, entity, Weather.class);
		return Objects.requireNonNull(aResponse.getBody()).getMain().getTemperature();
	}

	@Test
	void parseTest() {
		assertEquals("19.93", GreetingController.parseDevice("src/main/resources/w1_slave"));
	}
}
