package pgdp.collections;

public class FishyProduct {
    private final String name;
    private final int price;

    public FishyProduct(String name, int price) {
        this.name = name;
        this.price = price;

        if (name == null || price <= 0)  // if vaules are invalid error is occurred
            ExceptionUtil.illegalArgument("penguins don’t give away anything, especially food");
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "FishyProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
