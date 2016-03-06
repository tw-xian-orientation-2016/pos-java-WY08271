public class ReceiptItem {
    private CartItem cartItem;
    private float discountPrice;
    private float subTotal;

    public ReceiptItem(CartItem cartItem, float discountPrice, float subPrice) {
        this.cartItem = cartItem;
        this.discountPrice = discountPrice;
        this.subTotal = subPrice;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public float getSubTotal() {
        return subTotal;
    }
}
