/*
Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
Вилки лежат на столе между каждой парой ближайших философов.
Каждый философ может либо есть, либо размышлять.
Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)

Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
 */

public class Main {
    public static void main(String[] args) {
        Fork[] forks = new Fork[5];
        Philosopher[] philosophers = new Philosopher[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork(i);
        }
        for(int i = 0; i < philosophers.length; i++) {
            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(forks[i], forks[forks.length - i], i);
            } else {
                philosophers[i] = new Philosopher(forks[i],forks[i+1],i);
            }
        }
        for (int i = 0; i < philosophers.length; i++) {
            new Thread(philosophers[i]).start();
        }

    }
}
