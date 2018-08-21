package entity;

public class Knight extends Creation implements Randomable {
    Knight() {
        hp = getRandomNumberInRange(3, 13);
        power = getRandomNumberInRange(3, 13);

    }
}
