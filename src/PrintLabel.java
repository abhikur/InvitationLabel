import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PrintLabel {

    public static void main(String[] args) throws IOException {
        if(args.length <2 || args.length>4) printUsage();
        ArgsFilter argsFilter = new ArgsFilter();
        HashMap<String, String> filters = argsFilter.filter(args);
        LabelMaker labelMaker = new LabelMaker(args[0]);
        labelMaker.make(filters);
        List<String> labels = labelMaker.getLabels();
        for (String label : labels) {
            System.out.println(label);
        }
    }

    private static void printUsage() {
        System.out.println("Usage :");
        System.out.println("./printLabel_fl.sh --file_record --filterCountry_countryName");
        System.out.println("./printLabel_fl.sh --file_record --filterCountry_countryName --filterAge_age");
        System.out.println("./printLabel_fl.sh --file_record -c_countryName");
        System.out.println("./printLabel_fl.sh --file_record -c_countryName -a_age");
    }



}
