package by.pvt.service;


import by.pvt.pojo.Sensor;
import by.pvt.repo.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class SensorCatalogService {

    private static Logger log = Logger.getLogger("SensorCatalogService");

    @Autowired
    SensorRepository sensorRepository;


    @Transactional
    public List<Sensor> searchAllSensors() {
        return sensorRepository.findSensors();
    }

}
