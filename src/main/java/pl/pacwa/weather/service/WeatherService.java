package pl.pacwa.weather.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pacwa.weather.model.Weather;
import pl.pacwa.weather.model.WeatherOne;

@Service
public class WeatherService {
    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    public static final String API_KEY = "231a749c1e59269bb12320eb9cb7ecc7";
    public static final String NEW_URL = "&appid=231a749c1e59269bb12320eb9cb7ecc7";
    public static final String ICONS_URL = "http://openweathermap.org/img/wn/";
    private String city = "Katowice";

    public WeatherService() {
    }

    @EventListener({ApplicationReadyEvent.class})
    public Weather getWeathersInfo() {
        RestTemplate restTemplate = new RestTemplate();
        Weather weathers = (Weather)restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="
                + this.getCity() + "&appid=231a749c1e59269bb12320eb9cb7ecc7", Weather.class, new Object[0]);
        return weathers;
    }

    public String getImage() {
        String icon = ((WeatherOne)this.getWeathersInfo().getWeather().get(0)).getIcon();
        return "http://openweathermap.org/img/wn/" + icon + "@2x.png";
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
