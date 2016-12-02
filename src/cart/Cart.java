package cart;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Cart {
    private List<ItemWithCount> items;

    public Cart(List<ItemWithCount> items) {
        this.items = items;
    }

    public Double getTotal() {
        Date date = Date.from(Instant.now());
        return items.stream()
                .filter(itemWithCount -> itemWithCount.getItem().getEndDate().after(date))
                .map(itemWithCount -> itemWithCount.getItem().getPrice() * itemWithCount.getCount())
                .reduce(Double::sum).get();
    }

    public Double getDiscountedTotal() {
        Date date = Date.from(Instant.now());
        return items.stream()
                .filter(itemWithCount -> itemWithCount.getItem().getEndDate().after(date))
                .map(itemWithCount -> itemWithCount.getItem().getPriceAterDisount() * itemWithCount.getCount())
                .reduce(Double::sum).get();
    }
}
