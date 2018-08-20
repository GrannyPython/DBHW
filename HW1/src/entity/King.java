package entity;

public class King extends Creation implements Randomable {
    King() {
        hp = getRandomNumberInRange(5, 15);
        power = getRandomNumberInRange(5, 15);

    }
}
