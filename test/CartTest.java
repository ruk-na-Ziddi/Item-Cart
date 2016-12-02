import cart.Cart;
import cart.Item;
import cart.ItemWithCount;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class CartTest {
    @Test
    public void shouldReturn2IfCartHasFourItems() throws Exception {
        List<ItemWithCount> items = new ArrayList();

        Date date = new Date(117, 10, 10);

        items.add(new ItemWithCount(new Item("Shoe", 10.0, date, 10), 1));
        items.add(new ItemWithCount(new Item("Bat", 5.0, date, 10), 1));

        Cart cart = new Cart(items);
        assertThat(cart.getTotal(), is(15.0));
    }

    @Test
    public void shouldAddPriceOfValidItemsOnly() throws Exception {
        List<ItemWithCount> items = new ArrayList();
        Date jan_1_2017 = new Date(117, 1, 1);

        Item shoe = new Item("Shoe", 10.0, jan_1_2017, 10);
        items.add(new ItemWithCount(shoe, 1));

        Item pen = new Item("Pen", 5.0, jan_1_2017, 10);
        items.add(new ItemWithCount(pen, 1));

        Date jan_1_2016 = new Date(116, 1, 1);

        Item bread = new Item("Bread", 5.0, jan_1_2016, 10);
        items.add(new ItemWithCount(bread, 1));

        Cart cart = new Cart(items);
        assertThat(cart.getTotal(), is(15.0));
    }

    @Test
    public void shouldReturnPriceAfterDiscount() throws Exception {
        List<ItemWithCount> items = new ArrayList();
        Date jan_1_2017 = new Date(117, 1, 1);

        Item shoe = new Item("Shoe", 100.0, jan_1_2017, 10);
        items.add(new ItemWithCount(shoe, 1));

        Item pen = new Item("Pen", 50.0, jan_1_2017, 10);
        items.add(new ItemWithCount(pen, 1));

        Cart cart = new Cart(items);
        assertThat(cart.getDiscountedTotal(), is(135.0));
    }

    @Test
    public void shouldGiveDisountedTotalLessThanDirectTotal() throws Exception {
        List<ItemWithCount> items = new ArrayList();
        Date jan_1_2017 = new Date(117, 1, 1);

        Item shoe = new Item("Shoe", 100.0, jan_1_2017, 10);
        items.add(new ItemWithCount(shoe, 1));

        Item pen = new Item("Pen", 50.0, jan_1_2017, 10);
        items.add(new ItemWithCount(pen, 1));

        Cart cart = new Cart(items);
        assertTrue(cart.getDiscountedTotal() < cart.getTotal());
    }
}
