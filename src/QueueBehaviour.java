public interface QueueBehaviour {
    void takeInQueue(Human human);
    void releaseFromQueue();
    void takeOrder();
    void giveOrder();
}
