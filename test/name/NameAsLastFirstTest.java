package name;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameAsLastFirstTest {

    @Test
    public void testGetFullName() throws Exception {
        NameAsLastFirst Julius = new NameAsLastFirst("Julius", "Barrows");
        Assert.assertEquals(Julius.getFullName(), "Barrows, Julius");
    }
}