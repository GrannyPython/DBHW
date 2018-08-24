package my_spring;

public class ProxyCleanerImpl implements Cleaner{
    @InjectByType
    CleanerImpl cleaner ;

    public void clean() {
        cleaner.clean();
    }



}
