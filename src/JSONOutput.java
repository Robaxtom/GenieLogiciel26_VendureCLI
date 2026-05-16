import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JSONOutput extends OutputStrategy {

  @JsonIgnore
  @Override
  void display(List<?> items) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(items));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}
