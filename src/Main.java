public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Human human1 = new Human("Иван", false);
        Human human2 = new Human("Мария", true);

        market.acceptToMarket(human1);
        market.acceptToMarket(human2);

        market.update();
        market.update();
    }
}


