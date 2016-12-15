package cart;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

public class Cart {
    private HashMap<Item, Integer> items;

    public Cart() {
        items = new HashMap<>();
    }

    public Double getTotal(){
        Date date = Date.from(Instant.now());
        return items.keySet().stream()
                .filter(item -> item.getEndDate().after(date))
                .map(item -> item.getPrice() * items.get(item))
                .reduce(Double::sum).get();
    }

    public Double getDiscountedTotal() {
        Date date = Date.from(Instant.now());
        return items.keySet().stream()
                .filter(item -> item.getEndDate().after(date))
                .map(item -> item.getPriceAterDisount() * items.get(item))
                .reduce(Double::sum).get();
    }

    public void add(Item item) {
        items.put(item,items.computeIfPresent(item, (item1, integer) -> integer + 1));
        items.putIfAbsent(item, 1);
    }

    public void add(Item item, int count) {
        items.put(item,items.computeIfPresent(item, (item1, integer) -> integer + count));
        items.putIfAbsent(item, count);
    }
}
