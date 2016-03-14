package borderMaker;

import java.util.List;

public class BorderMaker {

    public String setBorder(List<List<String>> guestInfo) {
        int lengthOfBorder = findLengthOfBorder(guestInfo);
        String borderedLabel = border("+", '-', lengthOfBorder)+"\n";

        for (int i = 0; i < guestInfo.size(); i++) {
            for (String field : guestInfo.get(i)) {
                borderedLabel += border("|", field, lengthOfBorder)+"\n";
            }
            if (i < guestInfo.size() - 1)
                borderedLabel += border("|", '-', lengthOfBorder)+"\n";
        }
        borderedLabel += border("+", '-', lengthOfBorder);
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
