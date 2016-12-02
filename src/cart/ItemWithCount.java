package cart;

public class ItemWithCount {
    private Item item;
    private Integer count;

    public ItemWithCount(Item item, Integer count) {
        this.item = item;
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public Item getItem() {
        return item;
    }
}
