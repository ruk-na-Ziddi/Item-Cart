package cart;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class CartTest {
    private Cart cart;
    private LocalDate jan_1_2018;
    private Item shoe;
    private Item bat;
    private Item pen;
    private LocalDate jan_1_2016;
    private Item bread;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();

        jan_1_2016 = LocalDate.of(2016, 1, 1);
        jan_1_2018 = LocalDate.of(2018, 1, 1);

        shoe = new Item("Shoe", 100.0, jan_1_2018, 10);
        bat = new Item("Bat", 5.0, jan_1_2018, 10);
        pen = new Item("Pen", 5.0, jan_1_2018, 10);
        bread = new Item("Bread", 5.0, jan_1_2016, 10);
    }

    @Test
    public void shouldReturn2IfCartHasFourItems() throws Exception {
        cart.add(shoe);
        cart.add(bat);
        assertThat(cart.getTotal(), is(105.0));
    }

    @Test
    public void shouldAddPriceOfValidItemsOnly() throws Exception {
        cart.add(shoe);
        cart.add(pen);
        cart.add(bread);
        assertThat(cart.getTotal(), is(105.0));
    }

    @Test
    public void shouldReturnPriceAfterDiscount() throws Exception {
        cart.add(shoe);
        cart.add(pen);
        assertThat(cart.getDiscountedTotal(), is(94.5));
    }

    @Test
    public void shouldGiveDisountedTotalLessThanDirectTotal() throws Exception {
        cart.add(shoe);
        cart.add(pen);
        assertTrue(cart.getDiscountedTotal() < cart.getTotal());
    }

    @Test
    public void shouldBeAbleToAddOneItemToCart() throws Exception {
        cart.add(shoe);
        assertThat(cart.getTotal(), is(100.0));
        assertThat(cart.getDiscountedTotal(), is(90.0));
    }

    @Test
    public void whenSameItemIsAddedTwoTimesThenTotalShouldBeDoubleOfPrice() throws Exception {
        cart.add(shoe);
        cart.add(shoe);
        assertThat(cart.getTotal(), is(200.0));
    }

    @Test
    public void shouldBeAbleToMoreThanOneItemAtOneTime() throws Exception {
        cart.add(shoe, 3);
        assertThat(cart.getTotal(), is(300.0));
    }
}
