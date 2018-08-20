package entity;

public class GameMaster {

    static void startFighting() {
        Creation creation = CreationFactory.create();
        Creation creation1 = CreationFactory.create();

        boolean bothAlive = true;

        while (bothAlive) {
            System.out.println("first player turn");
            creation.kick(creation1);
            if (creation1.isAlive()) {
                System.out.println("second player turn");
                creation1.kick(creation);
            }

            bothAlive = creation.isAlive() && creation1.isAlive();
        }

        System.out.println("entity.Game finished");

    }
}
