package exercises;

import java.util.function.Predicate;

public enum NumRule {
    EVEN( (number) -> number % 2 != 0),
    NEVEN( (number) -> number % 2 == 0);

    Predicate<Integer> filtFunc;

    NumRule(Predicate<Integer> filtFunc){
        this.filtFunc = filtFunc;
    }

}
