package exercises;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (first, second) -> first + second),
    MINUS("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second);

    private String sign;
    private BiFunction<Integer, Integer, Integer> function;

    public String getSign() {
        return sign;
    }

    public BiFunction<Integer, Integer, Integer> getFunction() {
        return function;
    }

    Operator(String s, BiFunction<Integer, Integer, Integer> function) {
        this.sign = s;
        this.function = function;
    }
}
