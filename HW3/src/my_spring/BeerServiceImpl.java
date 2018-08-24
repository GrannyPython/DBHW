package my_spring;

/**
 * @author Evgeny Borisov
 */
public class BeerServiceImpl implements BeerService {
    @Override
    public void drinkBeer() {
        System.out.println("Blanche is the best");
    }

    @Override
    @Benchmark
    public void goToToilet() {
        System.out.println("pssssssssss");
    }
}
