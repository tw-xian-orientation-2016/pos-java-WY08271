public class RunPos {
    public static String main(String[] tags) {
        Pos pos = new Pos(new ItemService(), new PromotionService());

        return pos.print(tags);
    }
}
