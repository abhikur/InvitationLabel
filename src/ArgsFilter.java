import java.util.HashMap;

public class ArgsFilter {


    private String[] args;

    public ArgsFilter(String[] args) {

        this.args = args;
    }

    public boolean isNeedHelp() {
        return (args.length < 2 || args.length > 4);

    }
    public HashMap<String, String> filter() {

        HashMap<String, String> filters = new HashMap<String, String>();
        for (String arg : args) {
            if (arg.contains("--filterCountry") || arg.contains("-c"))
                filters.put("countryFilter", arg.split("_")[1]);
            if (arg.contains("--filterAge") || arg.contains("-a"))
                filters.put("ageFilter", arg.split("_")[1]);
            if(arg.contains("--file"))
                filters.put("fileFilter", arg.split("_")[1]);
        }
        return filters;
    }
}
