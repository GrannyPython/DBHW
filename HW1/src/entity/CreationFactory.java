package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class CreationFactory {
    private static Random random = new Random();

    public static Creation create() {
        return getRandomCreation();
    }

    static private Creation createHobbit(){
        Creation creation = new Hobbit();
        creation.attackStrategy = AttackStrategies.CRYING_STRATEGY;
        return creation;
    }

    static private Creation createElf(){
        Creation creation = new Elf();
        creation.attackStrategy = AttackStrategies.VAMPIRE_STRATEGY;
        return creation;
    }

    static private Creation createKing(){
        Creation creation = new King();
        creation.attackStrategy = AttackStrategies.DRUNK_STRATEGY;
        return creation;
    }

    static private Creation createKnight(){
        Creation creation = new Knight();
        creation.attackStrategy = AttackStrategies.DRUNK_STRATEGY;
        return creation;
    }

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private static Creation getRandomCreation() {
        int randomValue = getRandomNumberInRange(0, 4);
        Creation creation = null;

        if(randomValue == 0){creation = createHobbit(); }
        if(randomValue == 1){creation = createElf(); }
        if(randomValue == 2){creation = createKing(); }
        if(randomValue == 3){creation = createKnight(); }

        return creation;
    }



    private static class AttackStrategies {
        static final BiConsumer<Creation, Creation> CRYING_STRATEGY = (current, enemy) -> {
            System.out.println(current.getClass().getSimpleName() + " crying and do nothing");
        };

        static final BiConsumer<Creation, Creation> VAMPIRE_STRATEGY = (current, enemy) -> {
            if (current.power > enemy.power) {
                System.out.println(current.getClass().getSimpleName() + " zeroed hp of enemy");
                enemy.hp = 0;
            } else {
                System.out.println(current.getClass().getSimpleName() + "power of enemy decreased");
                enemy.power--;
            }
        };

        static final BiConsumer<Creation, Creation> DRUNK_STRATEGY = (current, enemy) -> {
            int damage = getRandomNumberInRange(0, current.power);
            enemy.hp -= damage;
            System.out.println(current.getClass().getSimpleName() + " damaged " + damage + " enemy has " + enemy.hp + " hp");

        };
    }

}

