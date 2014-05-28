import java.util.concurrent.Semaphore;

public class User extends Thread {

    private Semaphore semaphore;
    private String userName;
    private boolean isInvestor;
    
    public User(Semaphore semaphore, String userName, boolean isInvestor) {
        this.semaphore = semaphore;
        this.userName = userName;
        this.isInvestor = isInvestor;
    }

    public /*synchronized*/ void run() {
        System.out.println(userName + " started dealing with money...");
        try {
            System.out.println(userName + " waiting for the deposit box to be free for usage...");
            semaphore.acquire();
            System.out.println(userName + " got access to the deposit box...");
            for (int i = 0 ; i < 3 ; i++) {
                if (isInvestor)
                    DepositBox.addMoney(50,500);
                else
                    DepositBox.takeMoney(50,500);
                
                System.out.println(userName + " changed sum of money to: " + DepositBox.getMoney());
                Thread.sleep(DepositBox.sleepTimeSet(50,500));
            }
            if(DepositBox.getMoney()<=0){
            	System.out.println("The deposit box is empty.Let's add some money to it:)");
            	DepositBox.replenishMoney(50,500);
            }
            semaphore.release();
            System.out.println(userName + " finished working with the deposit box...");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}