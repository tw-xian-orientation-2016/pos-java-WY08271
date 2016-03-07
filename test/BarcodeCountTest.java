import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BarcodeCountTest {

    @Test
    public void has_two_property_when_BarcodeCount_create() {
        BarcodeCount barcodeCount = new BarcodeCount("ITEM000001", 1.0F);
        String barcode = barcodeCount.getBarcode();
        float count = barcodeCount.getCount();

        assertThat("ITEM000001", is(barcode));
        assertThat(1.0F, is(count));
    }
}