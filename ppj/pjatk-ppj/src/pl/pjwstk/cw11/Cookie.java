package pl.pjwstk.cw11;


public class Cookie {
    private String producer;
    private int mass;
    private String productCode;

    public Cookie(String producer, int mass, String productCode) {
        this.producer = producer;
        this.mass = mass;
        this.productCode = productCode;
    }

    public Cookie() {
    }

    public String getProducer() {
        return producer;
    }

    public int getMass() {
        return mass;
    }

    public String getProductCode() {
        return productCode;
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "producer='" + producer + '\'' +
                ", mass=" + mass +
                ", productCode='" + productCode + '\'' +
                '}';
    }
}
