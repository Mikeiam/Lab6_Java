import java.util.concurrent.Semaphore;//used to check if resource is free for usage

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        new User(semaphore, "Mike", true).start();
        new User(semaphore, "Vova", false).start();
        new User(semaphore, "Lena", false).start();
        new User(semaphore, "Bot", true).start();
        new User(semaphore, "Morgan", false).start();
        
    }
} 