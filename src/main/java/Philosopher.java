

public class Philosopher implements Runnable{
    private String state;
    private Fork forkLeft;
    private Fork forkRight;
    private int index;
    private int countEating = 0;
    private boolean eat;

    public Philosopher(Fork forkLeft, Fork forkRight, int index) {
        this.forkLeft = forkLeft;
        this.forkRight = forkRight;
        this.index = index;
        eat = false;
    }

    @Override
    public void run() {
        while (countEating < 3){
            if(forkLeft.getState().equals("Free") && forkRight.getState().equals("Free") && !eat){
                forkLeft.setState("notFree");
                forkRight.setState("notFree");
                System.out.println("Философ № " + index + " поел c помощью " + forkLeft + " " + forkRight);
                eat = !eat;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                countEating++;
                forkLeft.setState("Free");
                forkRight.setState("Free");
            } else{
                System.out.println("Философ № " + index + " размышляет");
                eat = !eat;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("Филосов № " + index + " наелся до отвала");
    }
}
