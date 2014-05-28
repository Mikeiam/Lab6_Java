
public class DepositBox {
    private static /*volatile*/ int money = 10000;

    public static void addMoney(int min,int max){
    	money = money + (int)(Math.random() * (max - 2*min));
    }

    public static void takeMoney(int min,int max){
    	money = money - (int)(Math.random() * (2*max - min));
    }

    public static int getMoney(){
        return money;
    }
    public static void replenishMoney(int min,int max){
    	money =(int)(Math.random() * (max - 2*min+15)) * (int)(Math.random() * (max - 2*min+15)) ;
    }
    public static int sleepTimeSet(int min,int max){
    	return min + (int)(Math.random() * (max - min + 1));
    }
}
