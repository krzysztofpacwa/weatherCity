package pl.pacwa.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pacwa.weather.service.WeatherService;

@Controller
@RequestMapping({"/"})
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String gerWeather(Model model) {
        model.addAttribute("weatherCity", this.weatherService.getWeathersInfo());
        model.addAttribute("weatherIcon", this.weatherService.getImage());
        model.addAttribute("city", new WeatherService());
        return "index";
    }

    @PostMapping({"city"})
    public String wathersCity(@RequestParam String city) {
        this.weatherService.setCity(city);
        return "redirect:/";
    }
}
