public class BarcodeCount {
    private String barcode;
    private float count;

    public BarcodeCount(String barcode, float count){
        this.barcode = barcode;
        this.count = count;
    }

    public float getCount() {
        return count;
    }

    public String getBarcode() {
        return barcode;
    }
}
