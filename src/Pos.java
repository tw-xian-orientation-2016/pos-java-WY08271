import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pos {
    private List<Item> items;
    private List<Promotion> promotions;
    private ArrayList<CartItem> cartItems = new ArrayList<>();
    private ArrayList<ReceiptItem> receiptItems = new ArrayList<>();

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

    public ReceiptItem addReceiptItems(CartItem cartItem) {

        boolean isExist = findType(cartItem) != null;
        float saveCount = isExist ? (float) Math.floor(cartItem.getCount() / 3.00F) : 0.00F;

        float subTotal = calculateSubTotal(cartItem, saveCount);
        float discount = calculateDiscount(cartItem, saveCount);
        ReceiptItem receiptItem = new ReceiptItem(cartItem, discount, subTotal);
        receiptItems.add(receiptItem);

        return receiptItem;
    }

    public float calculateDiscount(CartItem cartItem, float saveCount) {
        return cartItem.getPrice() * saveCount;
    }

    public float calculateSubTotal(CartItem cartItem, float saveCount) {
        float count = cartItem.getCount() - saveCount;
        float price = cartItem.getPrice();

        return count * price;
    }

    public float calculateTotalPrice() {
        float totalPrice = 0.00F;

        for (ReceiptItem receiptItem : receiptItems) {
            totalPrice += receiptItem.getSubTotal();
        }

        return totalPrice;
    }

    public float calculateSavePrice() {
        float realTotalPrice = 0.00F;

        for (ReceiptItem receiptItem : receiptItems) {
            realTotalPrice += receiptItem.getDiscountPrice();
        }

        return realTotalPrice;
    }

    public String printReceipt() {

        String ticket = "***<没钱赚商店>收据***" + "\n---------------------\n";

        for (ReceiptItem receiptItem : receiptItems) {

            ticket += "名称:" + receiptItem.getName() + ",数量:"
                    + receiptItem.getCount()
                    + receiptItem.getUnit()
                    + ",单价:"
                    + priceFormat(receiptItem.getPrice())
                    + "(元),小计:"
                    + priceFormat(receiptItem.getSubTotal()) + "(元)\n";
        }

        ticket += "--------------\n" + "总计:" + priceFormat(calculateTotalPrice())
                + "(元)\n节省:" + priceFormat(calculateSavePrice())
                + "(元)\n****************";

        return ticket;
    }

    public static String priceFormat(float number) {
        return String.format("%.2f", number);
    }

    public String print(String tags[]) {
        for (String tag : tags) {
            BarcodeCount barcodeCount = this.scan(tag);
            Item item = this.findItem(barcodeCount.getBarcode());
            this.addCartItem(item, barcodeCount.getCount());
        }

        for (CartItem cartItem : cartItems) {
            addReceiptItems(cartItem);
        }

        return printReceipt();
    }
}
