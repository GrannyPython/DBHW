package exercises;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Platform platform = new Platform();

        List<Example> result = new ArrayList<>();

        List<ExampleRequest> exampleRequests = parseCustromerWish();
        for (ExampleRequest exampleRequest : exampleRequests) {
            result.addAll(platform.doJob(exampleRequest));
        }
        result.forEach(System.out::println);
    }

    private static List<ExampleRequest> parseCustromerWish() {
        List<ExampleRequest> requestList = new ArrayList<>();

//        requestList.add(ExampleRequest.builder().amountOfExamples(1).operator("+").min(-10).max(10).build());
//        requestList.add(ExampleRequest.builder().amountOfExamples(1).operator("-").min(-20).max(20).build());
//        requestList.add(ExampleRequest.builder().amountOfExamples(1).operator("*").min(-30).max(30).build());

        requestList.add(ExampleRequest.builder().amountOfExamples(1).operator("*")
                .addRuleFirstTerm(NumRule.NEVEN).addRuleFirstTerm(NumRule.LESS_THAN_ZERO)
                .addRuleSecondTerm(NumRule.EVEN).addRuleSecondTerm(NumRule.LESS_THAN_ZERO)
                .min(-100).max(100).build());

        return requestList;
    }
}
