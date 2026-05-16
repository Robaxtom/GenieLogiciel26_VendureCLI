import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommandLineAppTest {
  CommandLineApp commandLineApp = new CommandLineApp();

  @Test
  void instantiateListCommand() {
    String input = "list";
    CommandStrategy commandStrategy = commandLineApp.getCommandStrategy(input);
    assertInstanceOf(ListCommand.class, commandStrategy);
  }

  @Test
  void instantiateListVariantsCommand() {
    String input = "listvariants";
    CommandStrategy commandStrategy = commandLineApp.getCommandStrategy(input);
    assertInstanceOf(ListVariantsCommand.class, commandStrategy);
  }

  @Test
  void instantiateJSONOutput() {
    String input = "json";
    OutputStrategy outputStrategy = commandLineApp.getOutputStrategy(input);
    assertInstanceOf(JSONOutput.class, outputStrategy);
  }

  @Test
  void instantiateTableOutput() {
    String input = "table";
    OutputStrategy outputStrategy = commandLineApp.getOutputStrategy(input);
    assertInstanceOf(TableOutput.class, outputStrategy);
  }
}
