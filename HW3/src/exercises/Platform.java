package exercises;//package exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Platform {

    private Map<String, ExampleGenerator> generators = new HashMap<>();
    {
        generators.put("+", new PlusExampleGenerator());
        generators.put("-", new MinusExampleGenerator());
        generators.put("*", new MultiplyExampleGenerator());
    }



    public List<Example> doJob(ExampleRequest request) {

        List<Example> list = new ArrayList<>();

        for (int i = 0; i < request.getAmountOfExamples(); i++) {

            Integer firstTerm = TermGenerator.generateTerm(request.getMin(), request.getMax(), request.getRuleFirst());
            Integer secondTerm = TermGenerator.generateTerm(firstTerm, request.getMax(), request.getRuleSecond());

            ExampleGenerator generator = generators.get(request.getOperator());
            list.add(generator.generateExample(firstTerm, secondTerm));
        }

        return list;

    }

}
