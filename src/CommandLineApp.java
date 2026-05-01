import picocli.CommandLine;

@CommandLine.Command(name = "vendure-cli", mixinStandardHelpOptions = true)
public class CommandLineApp implements Runnable{
    private CommandStrategy commandStrategy;

    @CommandLine.Option(names = {"-u", "--url"})
    private String url;

    @CommandLine.Option(names = {"-f", "--format"}, defaultValue = "table")
    private String format;

    @CommandLine.Parameters(index = "0")
    private String commandName;

    public static void main(String[] args) {
    }

    public CommandStrategy getCommandStrategy(String s){
        return null;
    }


    public OutputStrategy getOutputStrategy(String s){
        return null;
    }

    @Override
    public void run() {

    }
}

