package cart;

import java.util.Date;

public class Item {
    private String name;
    private Double price;
    private Date endDate;
    private int discount;

    public Item(String name, Double price, Date endDate, int discount) {
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

    public Date getEndDate() {
        return endDate;
    }

    public Double getPriceAterDisount() {
        return price - (price * discount) / 100;
    }
}
