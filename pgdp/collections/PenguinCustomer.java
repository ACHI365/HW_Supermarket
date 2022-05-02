package pgdp.collections;

public class PenguinCustomer {
    private final String name;
    private int money;
    private final Stack<FishyProduct> products;

    public PenguinCustomer(String name, int money) {
        this.name = name;
        this.money = money;
        products = new LinkedStack<>();

        if (name == null || money < 0) ExceptionUtil.illegalArgument("penguins cannot have debts"); // if parameters are invalid error is occurred


    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public Stack<FishyProduct> getProducts() {
        return products;
    }

    public void addProductToBasket(FishyProduct goods){  //create LinkedStack of basket and put products there
        products.push(goods);
    }

    public void placeAllProductsOnBand(Queue<FishyProduct> queue){
        var belt = new DataStructureLink<>(new StackConnector<>(products), new QueueConnector<>(queue)); //create new DataStructureLink to move from stack to queue
        belt.moveAllFromAToB();
    }

    public void takeAllProductsFromBand(Queue<FishyProduct> queue){
        var band = new DataStructureLink<>(new QueueConnector<>(queue),new StackConnector<>(products)); // vice versa
        band.moveAllFromAToB();
    }

    public void pay(int paycheck){
            if (paycheck < 0 || money - paycheck < 0 || money < 0) ExceptionUtil.unsupportedOperation("Money cannot be negative.");
             money = money - paycheck;
    }

    public void goToCheckout(PenguinSupermarket VIP){  //find the smallest queue and go there
        VIP.getCheckoutWithSmallestQueue().getQueue().enqueue(this);
    }

    @Override
    public String toString() {
        return "PenguinCustomer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", products=" + products +
                '}';
    }

}
