import org.junit.Assert;
import org.junit.Test;

public class AddressTest {

    @Test
    public void testGetCountry() throws Exception {
        Address address = new Address("Crooks Ton", "Vermont", "Romania");
        Assert.assertEquals(address.getCountry(), "Romania");
    }
}