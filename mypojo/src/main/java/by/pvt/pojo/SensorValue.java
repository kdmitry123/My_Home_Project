package by.pvt.pojo;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "sensorvalue")
public class SensorValue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "sensorid")
    private Sensor sensor;

    @CreationTimestamp
    private LocalDateTime date;

    private Double value;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public SensorValue() {
    }

    public SensorValue(Sensor sensor, Double value) {
        this.sensor = sensor;
        this.value = value;
    }

}
