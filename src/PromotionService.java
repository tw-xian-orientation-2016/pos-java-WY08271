import java.util.Arrays;
import java.util.List;

public class PromotionService {
    private List<Promotion> promotions = Arrays.asList(new Promotion("ITEM000000", "BUY_TWO_GET_ONE_FREE"),
            new Promotion("ITEM000001", "BUY_TWO_GET_ONE_FREE"),
            new Promotion("ITEM000005", "BUY_TWO_GET_ONE_FREE"));

    public List<Promotion> getPromotions() {
        return this.promotions;
    }
}
