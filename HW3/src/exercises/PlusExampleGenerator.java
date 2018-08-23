package exercises;

public class PlusExampleGenerator implements ExampleGenerator {


    @Override
    public Example generateExample(Integer firstTerm, Integer secondTerm) {
        return new Example(firstTerm, secondTerm, Operator.PLUS);
    }
}
