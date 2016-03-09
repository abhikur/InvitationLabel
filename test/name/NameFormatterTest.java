package name;

import org.junit.Assert;
import org.junit.Test;

public class NameFormatterTest {

    @Test
    public void testGetNameWhenFirstLastFormatIsPassed() throws Exception {
        Name name = NameFormatter.getNameAsPerFormat("Julius", "Barrows", "-fl");
        Assert.assertEquals(name.getFullName(), "Julius Barrows");
    }

    @Test
    public void testGetNameWhenLastFirstFormatIsPassed() throws Exception {
        Name name = NameFormatter.getNameAsPerFormat("Julius", "Barrows", "-lf");
        Assert.assertEquals(name.getFullName(), "Barrows, Julius");
    }
}