public class Promotion {
    private String barcode;
    private String type;

    public Promotion(String barcode, String type) {
        this.barcode = barcode;
        this.type = type;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getType() {
        return type;
    }
}
