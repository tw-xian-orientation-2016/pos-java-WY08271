public class Item {
    private String barcode;
    private String name;
    private String unit;
    private float price;

    public Item(String barcode, String name, String unit, float price) {
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public float getPrice() {
        return price;
    }
}
