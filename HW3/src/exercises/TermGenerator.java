package exercises;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TermGenerator {

    static Random r = new Random();

    static Integer generateTerm(Integer min, Integer max, List<NumRule> numRules) {

        Supplier<Stream<Integer>> boxed = () -> r.ints(min, max).boxed().limit(1000);

        for (NumRule numRule : numRules) {
            Supplier<Stream<Integer>> finalBoxed = boxed;
            boxed = () -> finalBoxed.get().filter(numRule.getFiltFunc());
        }

        Integer number = boxed.get().findAny().orElseThrow(() -> new RuntimeException("Wrong configuration"));

        return number;
    }
}

