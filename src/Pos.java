public class Pos {

    public BarcodeCount scan(String tag) {
        String tagArray[] = tag.split("-");

        float count = tagArray.length > 1 ? Float.parseFloat(tagArray[1]) : 1;

        return new BarcodeCount(tagArray[0], count);
    }

}
