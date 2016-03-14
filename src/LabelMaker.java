import borderMaker.BorderMaker;
import person.Person;

import java.util.ArrayList;
import java.util.List;

public class LabelMaker {
    private BorderMaker borderMaker;
    List<String> labels = new ArrayList<String>();

    public LabelMaker(BorderMaker borderMaker) {
        this.borderMaker = borderMaker;
    }

    public void makeLabelForGuests(List<Person> guests) {
        for (Person person : guests) {
            labels.add(borderMaker.setBorder(person.fieldsForLabel()));
        }
    }


    public List<String> getLabels() {
        return labels;
    }
}
