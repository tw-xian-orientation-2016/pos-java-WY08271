public class CartItem {
    private Item item;
    private float count;

    public CartItem(Item item, float count) {
        this.item = item;
        this.count = count;
    }

    public float getCount() {
        return count;
    }

    public Item getItem() {
        return item;
    }
}
