package entity;

import java.util.Random;

public interface Randomable {

    default int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
