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
	void parseTest() {
		assertEquals("19.93", GreetingController.parseDevice("src/main/resources/w1_slave"));
	}
}
