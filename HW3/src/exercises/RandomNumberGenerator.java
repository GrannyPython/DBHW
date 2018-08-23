package exercises;

import org.fluttercode.datafactory.impl.DataFactory;

public class RandomNumberGenerator {
    static DataFactory dataFactory = new DataFactory();

    static Integer generateNumber(Integer min, Integer max){
        return dataFactory.getNumberBetween(min, max);
    }
}
