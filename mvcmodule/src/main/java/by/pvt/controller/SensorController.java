package by.pvt.controller;

import by.pvt.pojo.SensorValue;
import by.pvt.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sensor")
public class SensorController {

    @Autowired
    SensorService sensorService;

    @GetMapping("/{sn}")
    public String showProductItem(@PathVariable String sn, Model model) {
        List<SensorValue> items = sensorService.searchValueBySerialNumber(sn);
        model.addAttribute("items", items);
        return "sensorPage";
    }
}
