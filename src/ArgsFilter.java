import java.util.HashMap;

public class ArgsFilter {
    public HashMap<String, String> filter(String[] args) {
        HashMap<String, String> filters = new HashMap<String, String>();
        for (String arg : args) {
            if (arg.contains("--filterCountry") || arg.contains("-c"))
                filters.put("countryFilter", arg.split("_")[1]);
            if (arg.contains("--filterAge") || arg.contains("-a"))
                filters.put("ageFilter", arg.split("_")[1]);
            if(arg.contains("--file"))
                filters.put("file", arg.split("_")[1]);
        }
        return filters;
    }
}
