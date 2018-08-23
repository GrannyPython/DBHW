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

        requestList.add(ExampleRequest.builder().amountOfExamples(1).operator("+").build());
        requestList.add(ExampleRequest.builder().amountOfExamples(1).operator("-").build());
        requestList.add(ExampleRequest.builder().amountOfExamples(1).operator("*").build());

        return requestList;
    }
}
