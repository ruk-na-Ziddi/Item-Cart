package cart;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class CartTest {
    @Test
    public void shouldReturn2IfCartHasFourItems() throws Exception {
        Date date = new Date(117, 10, 10);
        Cart cart = new Cart();
        cart.add(new Item("Shoe", 10.0, date, 10));
        cart.add(new Item("Bat", 5.0, date, 10));
        assertThat(cart.getTotal(), is(15.0));
    }

    @Test
    public void shouldAddPriceOfValidItemsOnly() throws Exception {
        Cart cart = new Cart();

        Date jan_1_2017 = new Date(117, 1, 1);

        Item shoe = new Item("Shoe", 10.0, jan_1_2017, 10);
        cart.add(shoe);

        Item pen = new Item("Pen", 5.0, jan_1_2017, 10);
        cart.add(pen);

        Date jan_1_2016 = new Date(116, 1, 1);

        Item bread = new Item("Bread", 5.0, jan_1_2016, 10);
        cart.add(bread);

        assertThat(cart.getTotal(), is(15.0));
    }

    @Test
    public void shouldReturnPriceAfterDiscount() throws Exception {
        Cart cart = new Cart();

        Date jan_1_2017 = new Date(117, 1, 1);

        Item shoe = new Item("Shoe", 100.0, jan_1_2017, 10);
        cart.add(shoe);

        Item pen = new Item("Pen", 50.0, jan_1_2017, 10);
        cart.add(pen);

        assertThat(cart.getDiscountedTotal(), is(135.0));
    }

    @Test
    public void shouldGiveDisountedTotalLessThanDirectTotal() throws Exception {
        Cart cart = new Cart();

        Date jan_1_2017 = new Date(117, 1, 1);

        Item shoe = new Item("Shoe", 100.0, jan_1_2017, 10);
        cart.add(shoe);

        Item pen = new Item("Pen", 50.0, jan_1_2017, 10);
        cart.add(pen);

        assertTrue(cart.getDiscountedTotal() < cart.getTotal());
    }

    @Test
    public void shouldBeAbleToAddOneItemToCart() throws Exception {
        Cart cart = new Cart();
        Date jan_1_2017 = new Date(117, 1, 1);
        Item shoe = new Item("Shoe", 100.0, jan_1_2017, 10);
        cart.add(shoe);
        assertThat(cart.getTotal(), is(100.0));
        assertThat(cart.getDiscountedTotal(), is(90.0));
    }

    @Test
    public void whenSameItemIsAddedTwoTimesThenTotalShouldBeDoubleOfPrice() throws Exception {
        Cart cart = new Cart();
        Date jan_1_2017 = new Date(117, 1, 1);
        Item shoe = new Item("Shoe", 100.0, jan_1_2017, 10);
        cart.add(shoe);
        cart.add(shoe);
        assertThat(cart.getTotal(), is(200.0));
    }

    @Test
    public void shouldBeAbleToMoreThanOneItemAtOneTime() throws Exception {
        Cart cart = new Cart();
        Date jan_1_2017 = new Date(117, 1, 1);
        Item shoe = new Item("Shoe", 100.0, jan_1_2017, 10);
        cart.add(shoe, 3);
        assertThat(cart.getTotal(), is(300.0));
    }
}
