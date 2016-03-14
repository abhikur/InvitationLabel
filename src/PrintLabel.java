import borderMaker.BorderMaker;
import com.sun.deploy.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PrintLabel {

    public static void main(String[] args) throws IOException {
        ArgsFilter argsFilter = new ArgsFilter(args);
        if(argsFilter.isNeedHelp()) {
            printUsage();
            return;
        }
        HashMap<String, String> filters = argsFilter.filter();

        Guests guests = new Guests();
        BorderMaker borderMaker = new BorderMaker();
        String option = args[0];
        RecordParser recordParser = new RecordParser(guests);
        LabelMaker labelMaker = new LabelMaker(borderMaker);

        String[] parsedRecord = recordParser.parse(filters.get("fileFilter"));
        recordParser.storePersonAsPerOption(option,parsedRecord);
        labelMaker.makeLabelForPerson(guests.filterRecord(filters));
        List<List<String>> labels = labelMaker.getLabels();
        for (List<String> label : labels) {
            System.out.println(StringUtils.join(label, "\n"));
        }
    }


    private static void printUsage() {
        System.out.println("Usage :");
        System.out.println("./printLabel_fl.sh --file_record");
        System.out.println("./printLabel_fl.sh --file_record --filterCountry_countryName");
        System.out.println("./printLabel_fl.sh --file_record --filterCountry_countryName --filterAge_age");
        System.out.println("./printLabel_fl.sh --file_record -c_countryName");
        System.out.println("./printLabel_fl.sh --file_record -c_countryName -a_age");
    }


}
