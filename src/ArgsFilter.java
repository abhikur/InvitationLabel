import java.util.HashMap;

public class ArgsFilter {


    private String[] args;

    public ArgsFilter(String[] args) {

        this.args = args;
    }

    public boolean isNeedHelp() {
        return (args.length < 2);

    }
    public HashMap<String, String> filter() {

        HashMap<String, String> filters = new HashMap<String, String>();
        for (String arg : args) {
            if (arg.contains("--filter"))
                filters.put(arg.split("_")[0], arg.split("_")[1]);
            if (!arg.contains("--"))
                filters.put("file", arg);
        }
        return filters;
    }
}
