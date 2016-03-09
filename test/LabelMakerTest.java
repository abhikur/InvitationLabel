import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LabelMakerTest {

    @Test
    public void testGetLabels() throws Exception {
        String[] args = {"-fl", "--file_./resource/Dummy","-c_Bangladesh"};
        List<String> expected = new ArrayList<String>();
        expected.add("Ms Melody Dooley, Bangladesh, 31");
        ArgsFilter argsFilter = new ArgsFilter();
        HashMap<String, String> filters = argsFilter.filter(args);
        LabelMaker labelMaker = new LabelMaker(args[0]);
        labelMaker.make(filters);
        assertEquals(labelMaker.getLabels(), expected);
    }
}