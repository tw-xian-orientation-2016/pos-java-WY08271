public class ReceiptItem {
    private CartItem cartItem;
    private float discountPrice;
    private float subTotal;

    public ReceiptItem(CartItem cartItem, float discountPrice, float subPrice) {
        this.cartItem = cartItem;
        this.discountPrice = discountPrice;
        this.subTotal = subPrice;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public float getCount() {
        return this.cartItem.getCount();
    }

    public float getPrice() {
        return this.cartItem.getPrice();
    }

    public String getName() {
        return this.cartItem.getName();
    }

    public String getUnit() {
        return this.cartItem.getUnit();
    }
}
