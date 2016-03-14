import borderMaker.BorderMaker;
import person.Person;

import java.util.ArrayList;
import java.util.List;

public class LabelMaker {
    private BorderMaker borderMaker;
    List<List<String>> labels = new ArrayList<List<String>>();

    public LabelMaker(BorderMaker borderMaker) {
        this.borderMaker = borderMaker;
    }

    public void makeLabelForPerson(List<Person> guests) {
        for (Person person : guests) {
            labels.add(borderMaker.setBorder(person.fieldsForLabel()));
        }
    }


    public List<List<String>> getLabels() {
        return labels;
    }
}
