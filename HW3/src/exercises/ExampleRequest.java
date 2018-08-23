package exercises;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Getter
@Builder
public class ExampleRequest {
    private Integer amountOfExamples;
    private String operator;
    private Integer min = -1000;
    private Integer max = 1000;


    private @Singular("addRuleFirstTerm") List<NumRule> ruleFirst;

    private @Singular("addRuleSecondTerm") List<NumRule> ruleSecond;

}
