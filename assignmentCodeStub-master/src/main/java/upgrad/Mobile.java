package upgrad;

import org.bson.Document;

public class Mobile {
    private String ProductId;
    private String Title;
    private String Manufacturer;
    private String NetworkTechnology;
    private String Dimensions;
    private String Weight;
    private String Display;
    private String Bluetooth;
    private String Sensors;
    private String OS;
    private String Chipset;
    private String CPU;
    private String GPU;
    private String Memory;
    private String Camera;
    private String Battery;

    public Mobile(String productId, String title, String manufacturer, String networkTechnology, String dimensions, String weight, String display, String bluetooth, String sensors, String OS, String chipset, String CPU, String GPU, String memory, String camera, String battery) {
        ProductId = productId;
        this.Title = title;
        Manufacturer = manufacturer;
        NetworkTechnology = networkTechnology;
        Dimensions = dimensions;
        Weight = weight;
        Display = display;
        Bluetooth = bluetooth;
        Sensors = sensors;
        this.OS = OS;
        Chipset = chipset;
        this.CPU = CPU;
        this.GPU = GPU;
        Memory = memory;
        Camera = camera;
        Battery = battery;
    }

    public Document createDBObject() {
        Document mobile = new Document();
        mobile.append("ProductId", this.getProductId());
        mobile.append("title", this.getTitle());
        mobile.append("Manufacturer", this.getManufacturer());
        mobile.append("NetworkTechnology", this.getNetworkTechnology());
        mobile.append("Dimensions", this.getDimensions());
        mobile.append("Weight", this.getWeight());
        mobile.append("Display", this.getDisplay());
        mobile.append("Bluetooth", this.getBluetooth());
        mobile.append("Sensors", this.getSensors());
        mobile.append("OS", this.getOS());
        mobile.append("Chipset", this.getChipset());
        mobile.append("CPU", this.getCPU());
        mobile.append("GPU", this.getGPU());
        mobile.append("Memory", this.getMemory());
        mobile.append("Camera", this.getMemory());
        mobile.append("Battery", this.getBattery());
        return mobile;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public String getNetworkTechnology() {
        return NetworkTechnology;
    }

    public void setNetworkTechnology(String networkTechnology) {
        NetworkTechnology = networkTechnology;
    }

    public String getDimensions() {
        return Dimensions;
    }

    public void setDimensions(String dimensions) {
        Dimensions = dimensions;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getDisplay() {
        return Display;
    }

    public void setDisplay(String display) {
        Display = display;
    }

    public String getBluetooth() {
        return Bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        Bluetooth = bluetooth;
    }

    public String getSensors() {
        return Sensors;
    }

    public void setSensors(String sensors) {
        Sensors = sensors;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getChipset() {
        return Chipset;
    }

    public void setChipset(String chipset) {
        Chipset = chipset;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getMemory() {
        return Memory;
    }

    public void setMemory(String memory) {
        Memory = memory;
    }

    public String getCamera() {
        return Camera;
    }

    public void setCamera(String camera) {
        Camera = camera;
    }

    public String getBattery() {
        return Battery;
    }

    public void setBattery(String battery) {
        Battery = battery;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "ProductId='" + ProductId + '\'' +
                ", title='" + Title + '\'' +
                ", Manufacturer='" + Manufacturer + '\'' +
                ", NetworkTechnology='" + NetworkTechnology + '\'' +
                ", Dimensions='" + Dimensions + '\'' +
                ", Weight='" + Weight + '\'' +
                ", Display='" + Display + '\'' +
                ", Bluetooth='" + Bluetooth + '\'' +
                ", Sensors='" + Sensors + '\'' +
                ", OS='" + OS + '\'' +
                ", Chipset='" + Chipset + '\'' +
                ", CPU='" + CPU + '\'' +
                ", GPU='" + GPU + '\'' +
                ", Memory='" + Memory + '\'' +
                ", Camera='" + Camera + '\'' +
                ", Battery='" + Battery + '\'' +
                '}';
    }
}
