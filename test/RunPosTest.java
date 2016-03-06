import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class RunPosTest {

    @Test
    public void output_when_input_some_tags() {

        Pos pos = new Pos(new ItemService(), new PromotionService());
        String[] tags = {
                "ITEM000001",
                "ITEM000001",
                "ITEM000001",
                "ITEM000001",
                "ITEM000001",
                "ITEM000003-2",
                "ITEM000005",
                "ITEM000005",
                "ITEM000005"
        };

        String result = "***<没钱赚商店>收据***\n" +
                "---------------------\n" +
                "名称:雪碧,数量:5.0瓶,单价:3.00(元),小计:12.00(元)\n" +
                "名称:荔枝,数量:2.0斤,单价:15.00(元),小计:30.00(元)\n" +
                "名称:方便面,数量:3.0袋,单价:4.50(元),小计:9.00(元)\n" +
                "--------------\n" +
                "总计:51.00(元)\n" +
                "节省:7.50(元)" +
                "\n****************";
        assertThat(RunPos.main(tags), equalTo(result));
    }
}