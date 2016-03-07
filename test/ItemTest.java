import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void has_four_property_when_Iten_create() {
        Item item = new Item("ITEM000001", "可口可乐", "瓶", 3.00F);
        String barcode = item.getBarcode();
        String name = item.getName();
        String unit = item.getUnit();
        float price = item.getPrice();

        assertThat("ITEM000001", is(barcode));
        assertThat("可口可乐", is(name));
        assertThat("瓶", is(unit));
        assertThat(3.00F, is(price));
    }

}