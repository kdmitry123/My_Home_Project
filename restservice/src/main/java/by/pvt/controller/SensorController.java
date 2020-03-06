package by.pvt.controller;

import by.pvt.dto.SensorCmd;
import by.pvt.dto.SensorDto;
import by.pvt.pojo.Sensor;
import by.pvt.pojo.SensorValue;
import by.pvt.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SensorController {

    @Autowired
    SensorService sensorService;

    @PostMapping("/add")
    public void createNewSensor(@RequestBody SensorCmd sensorCmd) {
        sensorService.addSensor(sensorCmd);
    }

    @PostMapping("/addValue")
    public void addValue(@RequestBody SensorDto sensorDto){
        sensorService.addValue(sensorDto);
    }

    @GetMapping("/sensors")
    public List<SensorCmd> getSensors(){
        return  sensorService.getAllSensors();
    }

    @GetMapping("/sensor")
    public List<Sensor> getSensor(){
        return  sensorService.getAllSensor();
    }

    @GetMapping("/sensorsValue")
    public List<SensorValue> getSensorValue(){
        return  sensorService.getValue();
    }

    @GetMapping("/sensorValue")
    public List<SensorValue> getSensorValueById(Long id){
        return  sensorService.getValueById(id);
    }

}
