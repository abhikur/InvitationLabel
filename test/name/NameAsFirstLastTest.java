package name;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameAsFirstLastTest {

    @Test
    public void testGetFullName() throws Exception {
        NameAsFirstLast Julius = new NameAsFirstLast("Julius", "Barrows");
        Assert.assertEquals(Julius.getFullName(), "Julius Barrows");
    }
}