import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PosTest {

    @Test
    public void can_split_barcode_and_count() {
        Pos pos = new Pos();
        BarcodeCount barcodeCount = pos.scan("ITEM000001-2");

        assertThat("ITEM000001", is(barcodeCount.getBarcode()));
        assertThat(2.0F, is(barcodeCount.getCount()));
    }

    @Test
    public void can_split_barcode_and_fix_count() {
        Pos pos = new Pos();
        BarcodeCount barcodeCount = pos.scan("ITEM000002");

        assertThat("ITEM000002", is(barcodeCount.getBarcode()));
        assertThat(1.0F, is(barcodeCount.getCount()));
    }
}