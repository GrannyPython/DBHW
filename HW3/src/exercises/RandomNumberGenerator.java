package exercises;

import org.fluttercode.datafactory.impl.DataFactory;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomNumberGenerator {
    static DataFactory dataFactory = new DataFactory();

    static Integer generateNumber(Integer min, Integer max, NumRule rule) {

        Stream<Integer> limit = IntStream.range(min, max).boxed().limit(100);
        limit.filter(rule.getFiltFunc());

        return dataFactory.getNumberBetween(min, max);
    }
}
