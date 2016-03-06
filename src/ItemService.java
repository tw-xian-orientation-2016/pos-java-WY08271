import java.util.Arrays;
import java.util.List;

public class ItemService {
    private List<Item> items;

    public void ItemService() {
        this.items = Arrays.asList(new Item("ITEM000000", "可口可乐", "瓶", 3.00F),
                new Item("ITEM000001", "雪碧", "瓶", 3.00F),
                new Item("ITEM000002", "苹果", "斤", 5.50F),
                new Item("ITEM000003", "荔枝", "斤", 15.00F),
                new Item("ITEM000004", "电池", "个", 2.00F),
                new Item("ITEM000005", "方便面", "袋", 4.50F));
    }

    public List<Item> getItems() {
        return items;
    }
}
