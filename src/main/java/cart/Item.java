package cart;

import java.time.LocalDate;

public class Item {
    private String name;
    private Double price;
    private LocalDate endDate;
    private int discount;

    public Item(String name, Double price, LocalDate endDate, int discount) {
        this.name = name;
        this.price = price;
        this.endDate = endDate;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }


    public Double getPrice() {
        return price;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Double getPriceAterDisount() {
        return price - (price * discount) / 100;
    }
}
