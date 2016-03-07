import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ReceiptItemTest {

    @Test
    public void has_three_property_when_ReceiptItem_create() {
        Item item = new Item("ITEM000001", "可口可乐", "瓶", 3.00F);
        CartItem cartItem = new CartItem(item, 2.00F);
        ReceiptItem receiptItem = new ReceiptItem(cartItem, 2.00F, 2.00F);
        float discountPrice = receiptItem.getDiscountPrice();
        float subTotal = receiptItem.getSubTotal();

        assertThat(2.00F, is(discountPrice));
        assertThat(2.00F, is(subTotal));
    }
}