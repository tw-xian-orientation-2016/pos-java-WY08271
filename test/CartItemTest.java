import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CartItemTest {

    @Test
    public void has_two_property_when_CartItem_create() {
        Item item = new Item("ITEM000001", "可口可乐", "瓶", 3.00F);
        CartItem cartItem = new CartItem(item, 2.00F);
        float count = cartItem.getCount();

        assertThat(2.00F, is(count));
    }
}