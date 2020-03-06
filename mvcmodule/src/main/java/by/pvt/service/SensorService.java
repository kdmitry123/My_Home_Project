package by.pvt.service;

import by.pvt.pojo.SensorValue;
import by.pvt.repo.SensorRepository;
import by.pvt.repo.SensorValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SensorService {

    @Autowired
    SensorValueRepository sensorValueRepository;

    @Autowired
    SensorRepository sensorRepository;


    @Transactional
    public List<SensorValue> searchValueBySerialNumber(String sn){
        return sensorValueRepository.findValuesBySerialNumber(sn);
    }
}
