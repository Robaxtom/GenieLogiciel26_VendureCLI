import picocli.CommandLine;

@CommandLine.Command(name = "vendure-cli", mixinStandardHelpOptions = true)
public class CommandLineApp implements Runnable {
  private CommandStrategy commandStrategy;

  @CommandLine.Option(names = {"-u", "--url"})
  private String url;

  @CommandLine.Option(
      names = {"-f", "--format"},
      defaultValue = "table")
  private String format;

  @CommandLine.Parameters(index = "0")
  private String commandName;

  public static void main(String[] args) {
    new CommandLine(new CommandLineApp()).execute(args);
  }

  public CommandStrategy getCommandStrategy(String s) {
    if (s == null) {
      return null;
    }

    return switch (s.toLowerCase()) {
      case "list" -> new ListCommand();
      case "cart" -> new CartCommand();
      default -> {
        System.out.println("Unknown command: " + s);
        yield null;
      }
    };
  }

  public OutputStrategy getOutputStrategy(String s) {
    if (s == null) {
      return null;
    }

    return switch (s.toLowerCase()) {
      case "table" -> new TableOutput();
      case "json" -> new JSONOutput();
      default -> new TableOutput();
    };
  }

  @Override
  public void run() {
    this.commandStrategy = getCommandStrategy(commandName);
    OutputStrategy outputStrategy = getOutputStrategy(format);
    VendureConnection connection = new VendureConnection();
    connection.resolveUrl(url);
    System.out.println("--- Connecting to " + connection.getUrl() + " ---");
    if (connection.getUrl() == null) {
      System.out.println("!Connexion failed!");
      return;
    }
    System.out.println(
        "--- Command : " + commandName + " ---\n" + "--- Format : " + format + " ---");
    if (commandStrategy != null) {
      commandStrategy.execute(connection, outputStrategy);
    }
  }
}
