import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PosTest {

    @Test
    public void can_split_barcode_and_count() {
        ItemService itemServiceMock = mock(ItemService.class);
        List<Item> items = Arrays.asList(new Item("ITEM000000", "可口可乐", "瓶", 3.00F),
                new Item("ITEM000001", "雪碧", "瓶", 3.00F));
        when(itemServiceMock.getItems()).thenReturn(items);

        PromotionService promotionService = new PromotionService();
        Pos pos = new Pos(itemServiceMock, promotionService);
        BarcodeCount barcodeCount = pos.scan("ITEM000001-2");

        assertThat("ITEM000001", is(barcodeCount.getBarcode()));
        assertThat(2.0F, is(barcodeCount.getCount()));
    }

    @Test
    public void can_split_barcode_and_fix_count() {
        ItemService itemServiceMock = mock(ItemService.class);
        List<Item> items = Arrays.asList(new Item("ITEM000000", "可口可乐", "瓶", 3.00F),
                new Item("ITEM000001", "雪碧", "瓶", 3.00F));
        when(itemServiceMock.getItems()).thenReturn(items);

        PromotionService promotionService = new PromotionService();
        Pos pos = new Pos(itemServiceMock, promotionService);
        BarcodeCount barcodeCount = pos.scan("ITEM000002");

        assertThat("ITEM000002", is(barcodeCount.getBarcode()));
        assertThat(1.0F, is(barcodeCount.getCount()));
    }

    @Test
    public void find_item_exist_when_findItem() {
        ItemService itemServiceMock = mock(ItemService.class);
        List<Item> items = Arrays.asList(new Item("ITEM000000", "可口可乐", "瓶", 3.00F),
                new Item("ITEM000001", "雪碧", "瓶", 3.00F));
        when(itemServiceMock.getItems()).thenReturn(items);

        PromotionService promotionService = new PromotionService();
        Pos pos = new Pos(itemServiceMock, promotionService);

        Item itemExpectResult = pos.findItem("ITEM000001");
        Item itemResult = new Item("ITEM000001", "雪碧", "瓶", 3.00F);

        assertSame(itemExpectResult, itemResult);
    }

    @Test
    public void find_item_not_exist_when_findItem() {
        ItemService itemServiceMock = mock(ItemService.class);
        List<Item> items = Arrays.asList(new Item("ITEM000000", "可口可乐", "瓶", 3.00F),
                new Item("ITEM000001", "雪碧", "瓶", 3.00F));
        when(itemServiceMock.getItems()).thenReturn(items);

        PromotionService promotionService = new PromotionService();
        Pos pos = new Pos(itemServiceMock, promotionService);

        Item itemExpectResult = pos.findItem("ITEM000003");

        assertSame(itemExpectResult, null);
    }

    @Test
    public void no_item_when_add_careItems() {
        ItemService itemServiceMock = mock(ItemService.class);
        List<Item> items = Arrays.asList(new Item("ITEM000000", "可口可乐", "瓶", 3.00F),
                new Item("ITEM000001", "雪碧", "瓶", 3.00F));
        when(itemServiceMock.getItems()).thenReturn(items);

        PromotionService promotionService = new PromotionService();
        Pos pos = new Pos(itemServiceMock, promotionService);

        Item item = new Item("ITEM000001", "雪碧", "瓶", 3.00F);
        pos.addCartItem(item, 1.00F);

        assertThat(1, equalTo(pos.getCartItems().size()));
    }

    @Test
    public void have_item_when_add_careItems() {
        ItemService itemServiceMock = mock(ItemService.class);
        List<Item> items = Arrays.asList(new Item("ITEM000000", "可口可乐", "瓶", 3.00F),
                new Item("ITEM000001", "雪碧", "瓶", 3.00F));
        when(itemServiceMock.getItems()).thenReturn(items);

        PromotionService promotionService = new PromotionService();
        Pos pos = new Pos(itemServiceMock, promotionService);


        Item item = new Item("ITEM000001", "雪碧", "瓶", 3.00F);
        pos.addCartItem(item, 1.00F);
    }
}