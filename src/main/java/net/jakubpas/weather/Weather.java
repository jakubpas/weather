package net.jakubpas.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable {

    @JsonProperty("main")
    private Main main;

    public Main getMain() {
        return main;
    }

    public static class Main implements Serializable{

        @JsonProperty("temp")
        private String temperature;

        public String getTemperature() {
            return temperature;
        }
    }
}