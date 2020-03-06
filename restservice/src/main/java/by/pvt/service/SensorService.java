package by.pvt.service;

import by.pvt.dto.SensorCmd;
import by.pvt.dto.SensorDto;
import by.pvt.pojo.Sensor;
import by.pvt.pojo.SensorValue;
import by.pvt.repo.SensorRepository;
import by.pvt.repo.SensorValueRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SensorService {
    private static final Logger log = LogManager.getLogger();

    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    SensorValueRepository sensorValueRepository;



    public void addValue(SensorDto sensorDto){
        String serialNumber = sensorDto.getSerialNumber();
        Double value = sensorDto.getValue();
        if(sensorRepository.findBySerialnumber(serialNumber).isPresent()){
            Sensor sensor = sensorRepository.findBySerialnumber(serialNumber).get();
            SensorValue sensorValue = new SensorValue(sensor, value);
            sensorValueRepository.save(sensorValue);
        }
    }

    public void addSensor(SensorCmd sensorCmd){
        if(!sensorRepository.findBySerialnumber(sensorCmd.getSerialNumber()).isPresent()){
            Sensor sensor = new Sensor(sensorCmd.getSerialNumber());
            sensorRepository.save(sensor);
        }
    }

    public List<SensorCmd> getAllSensors(){
        final List<SensorCmd> list = new ArrayList<>();
        sensorRepository.findAll().forEach(sensor -> {
            SensorCmd cmd = new SensorCmd();
            cmd.serialNumber = sensor.getSerialnumber();
            list.add(cmd);
        });
        return list;
    }

    public List<Sensor> getAllSensor(){
        final List<Sensor> list = new ArrayList<>();
        sensorRepository.findAll().forEach(sensor -> {
            Sensor cmd = new Sensor();
            cmd.setId(sensor.getId());
            cmd.setSerialnumber(sensor.getSerialnumber());
            list.add(cmd);
        });
        return list;
    }

    public List<SensorValue> getValue(){
        final List<SensorValue> list = new ArrayList<>();

        sensorValueRepository.findAll().forEach(sensorValue -> {
            SensorValue sv = new SensorValue();
            sv.setSensor(sensorValue.getSensor());
            sv.setDate(sensorValue.getDate());
            sv.setValue(sensorValue.getValue());
            list.add(sv);
        });
        return list;
    }


    public List<SensorValue> getValueById(Long id){
        final List<SensorValue> list = new ArrayList<>();
        sensorValueRepository.findAll().forEach(sensorValue -> {
            SensorValue sv = new SensorValue();
            if(sensorValue.getSensor().getId().equals(id)){
                sv.setSensor(sensorValue.getSensor());
                sv.setDate(sensorValue.getDate());
                sv.setValue(sensorValue.getValue());
                list.add(sv);
            }
        });
        return list;
    }

}
