package name;

import org.junit.Assert;
import org.junit.Test;

public class NameAsFirstLastTest {

    @Test
    public void testGetFullName() throws Exception {
        NameAsFirstLast Julius = new NameAsFirstLast("Julius", "Barrows");
        Assert.assertEquals(Julius.getFullName("Ms"), "Ms Julius Barrows");
    }
}