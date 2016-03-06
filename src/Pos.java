import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pos {
    private List<Item> items;
    private List<Promotion> promotions;
    private ArrayList<CartItem> cartItems = new ArrayList<>();

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public Pos(ItemService itemService, PromotionService promotionService) {
        this.items = itemService.getItems();
        this.promotions = promotionService.getPromotions();
    }

    public BarcodeCount scan(String tag) {
        String tagArray[] = tag.split("-");

        float count = tagArray.length > 1 ? Float.parseFloat(tagArray[1]) : 1;

        return new BarcodeCount(tagArray[0], count);
    }

    public Item findItem(String barcode) {

        Optional<Item> item = this.items.stream()
                .filter(i -> i.getBarcode().equals(barcode))
                .findFirst();

        return item.isPresent() ? item.get() : null;
    }

    public CartItem addCartItem(Item item, float count) {

        if (isRepeat(item)) {
            for (CartItem cartItem : cartItems) {
                if (cartItem.getBarcode().equals(item.getBarcode())) {
                    cartItem.setCount(count);
                    return cartItem;
                }
            }
        } else {
            CartItem cartItem = new CartItem(item, count);
            cartItems.add(cartItem);
            return cartItem;
        }
        return null;
    }

    public boolean isRepeat(Item item) {
        boolean result = false;

        for (CartItem cartItem : cartItems) {
            if (cartItem.getBarcode().equals(item.getBarcode())) {
                result = true;
            }
        }
        return result;
    }


    public String findType(CartItem cartItem) {

        Optional<Promotion> promotion = this.promotions.stream()
                .filter(d -> d.getBarcode().equals(cartItem.getBarcode()))
                .findFirst();

        return promotion.isPresent() ? promotion.get().getType() : null;
    }
}
