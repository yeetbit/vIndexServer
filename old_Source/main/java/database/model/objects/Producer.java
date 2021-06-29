package src.database.model.objects;

public class Producer {
    
    private int producerId;
    private String producerName;
    private int producerCountry;
    private int producerRegion;
    private int producerAdress1;
    private int producerAdress2;
    private int producerAdress3;
    private int producerAdress4;
    private String producerPhone;

    public Producer(){
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public int getProducerCountry() {
        return producerCountry;
    }

    public void setProducerCountry(int producerCountry) {
        this.producerCountry = producerCountry;
    }

    public int getProducerRegion() {
        return producerRegion;
    }

    public void setProducerRegion(int producerRegion) {
        this.producerRegion = producerRegion;
    }

    public int getProducerAdress1() {
        return producerAdress1;
    }

    public void setProducerAdress1(int producerAdress1) {
        this.producerAdress1 = producerAdress1;
    }

    public int getProducerAdress2() {
        return producerAdress2;
    }

    public void setProducerAdress2(int producerAdress2) {
        this.producerAdress2 = producerAdress2;
    }

    public int getProducerAdress3() {
        return producerAdress3;
    }

    public void setProducerAdress3(int producerAdress3) {
        this.producerAdress3 = producerAdress3;
    }

    public int getProducerAdress4() {
        return producerAdress4;
    }

    public void setProducerAdress4(int producerAdress4) {
        this.producerAdress4 = producerAdress4;
    }

    public String getProducerPhone() {
        return producerPhone;
    }

    public void setProducerPhone(String producerPhone) {
        this.producerPhone = producerPhone;
    }

    
    
}
