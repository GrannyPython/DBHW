package exercises;

public class MinusExampleGenerator implements ExampleGenerator {


    @Override
    public Example generateExample(Integer firstTerm, Integer secondTerm) {
        return new Example(firstTerm, secondTerm, Operator.MINUS);
    }
}
