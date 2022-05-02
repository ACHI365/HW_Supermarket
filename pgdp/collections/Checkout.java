package pgdp.collections;

public class Checkout {
   private Queue<PenguinCustomer> queue;
   private Queue<FishyProduct> BandBeforeCashier;
   private Queue<FishyProduct> BandAfterCashier;

    public Checkout() {
        this.queue = new LinkedQueue<>();
        this.BandBeforeCashier = new LinkedQueue<>();
        this.BandAfterCashier = new LinkedQueue<>();
    }

    public Queue<PenguinCustomer> getQueue() {
        return queue;
    }


    public Queue<FishyProduct> getBandBeforeCashier() {
        return BandBeforeCashier;
    }

    public Queue<FishyProduct> getBandAfterCashier() {
        return BandAfterCashier;
    }

    public int queueLength(){
        return queue.size();
    }

    public void serveNextCustomer(){ // get customer out of the queue


        var Customer = queue.dequeue();
        int FullPrice = 0;

        if (Customer == null) return;
            Customer.placeAllProductsOnBand(BandBeforeCashier); // customer places product on the band

            while (!BandBeforeCashier.isEmpty()){  //until the band is not clear, get all products to the belt
                var i = BandBeforeCashier.dequeue();
                if (i == null) break;
                FullPrice += i.getPrice(); //while moving to the belt add the prices of product
                BandAfterCashier.enqueue(i);
            }


            Customer.pay(FullPrice);

            Customer.takeAllProductsFromBand(BandAfterCashier); // customer takes product



    }


    @Override
    public String toString() {
        return "Checkout{" +
                "queue=" + queue +
                ", BandBeforeCashier=" + BandBeforeCashier +
                ", BandAfterCashier=" + BandAfterCashier +
                '}';
    }
}
