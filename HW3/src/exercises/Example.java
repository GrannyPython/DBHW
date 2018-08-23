package exercises;

public class Example {
    Integer firstTerm;
    Integer secondTerm;
    Operator operator;

    Example(Integer firstTerm, Integer secondTerm, Operator operator){
        this.firstTerm = firstTerm;
        this.secondTerm = secondTerm;
        this.operator = operator;
    }

    String getTask(){
        return firstTerm + " " + operator.getSign() + " " + secondTerm + " = ";
    }

    String getAnswer(){
        return String.valueOf((operator.getFunction().apply(firstTerm, secondTerm)));
    }

    @Override
    public String toString() {
        return getTask() + getAnswer();
    }
}
