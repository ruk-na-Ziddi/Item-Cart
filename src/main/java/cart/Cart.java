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
        if(has(item)){
            Integer newCount = items.get(item) + 1;
            items.put(item, newCount);
        }else{
            items.put(item, 1);
        }
    }

    private boolean has(Item item) {
        return items.containsKey(item);
    }

    public void add(Item item, int count) {
        if (has(item)){
            Integer newCount = items.get(item) + count;
            items.put(item, newCount);
        }else{
            items.put(item, count);
        }
    }
}
