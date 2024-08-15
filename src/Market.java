import java.util.LinkedList;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour {
    private final Queue<Human> queue;

    public Market() {
        this.queue = new LinkedList<>();
    }


    private String correctForm(String maleForm, String femaleForm, boolean isFemale) {
        return isFemale ? femaleForm : maleForm;
    }

    @Override
    public void takeInQueue(Human human) {
        System.out.println(human.name() + " " + correctForm("вошел", "вошла", human.isFemale()) + " в очередь.");
        queue.add(human);
    }

    @Override
    public void releaseFromQueue() {
        Human human = queue.poll();
        if (human != null) {
            System.out.println(human.name() + " " + correctForm("вышел", "вышла", human.isFemale()) + " из очереди.");
        }
    }

    @Override
    public void takeOrder() {
        if (!queue.isEmpty()) {
            System.out.println(queue.peek().name() + " " + correctForm("сделал", "сделала", queue.peek().isFemale()) + " заказ.");
        }
    }

    @Override
    public void giveOrder() {
        if (!queue.isEmpty()) {
            System.out.println(queue.peek().name() + " " + correctForm("получил", "получила", queue.peek().isFemale()) + " заказ.");
        }
    }

    @Override
    public void acceptToMarket(Human human) {
        System.out.println(human.name() + " " + correctForm("вошел", "вошла", human.isFemale()) + " в магазин.");
        takeInQueue(human);
    }

    @Override
    public void releaseFromMarket(Human human) {
        System.out.println(human.name() + " " + correctForm("покинул", "покинула", human.isFemale()) + " магазин.");
    }

    @Override
    public void update() {
        takeOrder();
        giveOrder();
        if (!queue.isEmpty()) {
            Human human = queue.peek();
            if (human != null) {
                releaseFromQueue();
                releaseFromMarket(human);
            }
        }
    }
}



