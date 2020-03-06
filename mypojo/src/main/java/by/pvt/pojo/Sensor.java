package by.pvt.pojo;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "sensor")
public class Sensor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialnumber;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public Sensor() {
    }

    public Sensor(String serialnumber) {
        this.serialnumber = serialnumber;
    }

}
