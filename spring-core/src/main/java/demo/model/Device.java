package demo.model;

public class Device {
    private String make;
    private String model;

    public Device() {
    }

    public Device(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Device{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
