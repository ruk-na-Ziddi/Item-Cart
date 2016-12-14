package cart;

import org.junit.Test;

import java.time.Instant;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ItemTest {
    @Test
    public void shouldGiveDiscontedPriceOfItem() throws Exception {
        Date date = Date.from(Instant.now());
        Item shoe = new Item("Shoe", 100.0, date, 10);

        assertThat(shoe.getPriceAterDisount(), is(90.0));
    }

    @Test
    public void shouldItemsDiscountedPriceBeLessThanRealPrice() throws Exception {
        Date date = Date.from(Instant.now());
        Item watch = new Item("Sonata", 100.0, date, 10);

        assertTrue(watch.getPriceAterDisount() < watch.getPrice());
    }
}
