package exercises;

public class MultiplyExampleGenerator implements ExampleGenerator {


    @Override
    public Example generateExample(Integer firstTerm, Integer secondTerm) {
        return new Example(firstTerm, secondTerm, Operator.MULTIPLY);
    }
}
