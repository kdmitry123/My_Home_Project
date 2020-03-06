package by.pvt.controller;

import by.pvt.pojo.Sensor;
import by.pvt.service.SensorCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/catalog")
public class SensorCatalogController {

    private static Logger log = Logger.getLogger("SensorCatalogController");

    @Autowired
    SensorCatalogService sensorCatalogService;

    @RequestMapping(method = RequestMethod.GET)
    public String showCatalog( Model model ) {
        log.info("Call showCatalog()");
        List<Sensor> items = sensorCatalogService.searchAllSensors();
        model.addAttribute("items", items);
        return "catalogPage";
    }
}
