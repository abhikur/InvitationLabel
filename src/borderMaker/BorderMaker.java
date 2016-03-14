package borderMaker;

import java.util.ArrayList;
import java.util.List;

public class BorderMaker {

    public List<String> setBorder(List<List<String>> guestInfo) {
        int lengthOfBorder = findLengthOfBorder(guestInfo);
        List<String> borderedLabel = new ArrayList<String>();

        borderedLabel.add(border("+", '-', lengthOfBorder));
        for (int i = 0; i < guestInfo.size(); i++) {
            for (String field : guestInfo.get(i)) {
                borderedLabel.add(border("|", field, lengthOfBorder));
            }
            if (i < guestInfo.size() - 1)
                borderedLabel.add(border("|", '-', lengthOfBorder));
        }
        borderedLabel.add(border("+", '-', lengthOfBorder));
        return borderedLabel;
    }

    private int findLengthOfBorder(List<List<String>> guestInfo) {
        int length = 0;
        for (List<String> fields : guestInfo) {
            for (String eachField : fields) {
                if (eachField.length() > length) length = eachField.length();
            }
        }
        return length;
    }

    public String border(String edge, String toFill, int size) {
        String preparedBorder = edge + " ";
        for (int i = 0; i < size; i++) {
            if (i < toFill.length())
                preparedBorder += toFill.split("")[i + 1];
            else
                preparedBorder += " ";
        }
        preparedBorder += " " + edge;
        return preparedBorder;
    }

    public String border(String edge, char toFill, int size) {
        String preparedBorder = edge + toFill;
        for (int i = 0; i < size; i++) {
            preparedBorder += toFill;
        }
        preparedBorder += toFill + edge;
        return preparedBorder;
    }
}
