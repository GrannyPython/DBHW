package entity;

import java.util.function.BiConsumer;

abstract class Creation {
    int hp;
    int power;

    BiConsumer<Creation, Creation> attackStrategy;

    boolean isAlive() {
        if (hp > 0) {
            System.out.println(this.getClass().getSimpleName() + " still alive, hp=" + hp);
            return true;
        } else {
            System.out.println(this.getClass().getSimpleName() + " died");
            return false;
        }
    }

    public void kick(Creation enemy) {
        attackStrategy.accept(this, enemy);
    }


}
