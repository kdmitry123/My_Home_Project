package by.pvt.dto;

public class SensorDto {
    public Long id;
    public String serialNumber;

    public SensorDto() {
    }

    public SensorDto(Long id, String serialNumber) {
        this.id = id;
        this.serialNumber = serialNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
