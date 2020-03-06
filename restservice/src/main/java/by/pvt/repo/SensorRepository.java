package by.pvt.repo;

import by.pvt.pojo.Sensor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SensorRepository extends CrudRepository<Sensor, Long> {
    Optional<Sensor> findBySerialnumber(String str);
}
