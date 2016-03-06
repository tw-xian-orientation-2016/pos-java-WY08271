import java.util.List;
import java.util.Optional;

public class Pos {
    private List<Item> items;
    private List<Promotion> promotions;

    public Pos(ItemService itemService, PromotionService promotionService){
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

}
