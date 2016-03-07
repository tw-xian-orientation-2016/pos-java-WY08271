import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PromotionTest {

    @Test
    public void it_has_two_property_when_promotion_create() {
        Promotion promotion = new Promotion("ITEM000001", "BUY_TWO_GET_ONE_FREE");
        String barcode = promotion.getBarcode();
        String type = promotion.getType();

        assertThat("ITEM000001", is(barcode));
        assertThat("BUY_TWO_GET_ONE_FREE", is(type));
    }
}