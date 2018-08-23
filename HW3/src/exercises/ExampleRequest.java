package exercises;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ExampleRequest {
    private Integer amountOfExamples;
    private String operator;
    private Integer min;
    private Integer max;
    private List<NumRule> rule;

}
