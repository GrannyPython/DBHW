package my_spring;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
//        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
//        iRobot.cleanRoom();
        BeerService beerService = ObjectFactory.getInstance().createObject(BeerService.class);
        beerService.drinkBeer();
        beerService.goToToilet();
    }
}
