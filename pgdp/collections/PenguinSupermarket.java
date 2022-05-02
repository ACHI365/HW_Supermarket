package pgdp.collections;


public class PenguinSupermarket {

    private Checkout[] checkouts;

    public PenguinSupermarket(int x) {
        if (x <= 0) ExceptionUtil.illegalArgument("must be greater than 0");
        checkouts = new Checkout[x]; // create an array with length of inserted variable

        //initialize all checkouts
        for (int i = 0; i < x; i++){
            checkouts[i] = new Checkout();
        }
    }

    public Checkout[] getCheckouts() {
        return checkouts;
    }

    public Checkout getCheckoutWithSmallestQueue(){
        //create new queue
        Queue<Checkout> minimals = new LinkedQueue<>();
        int min = Integer.MAX_VALUE;
        //find minimal length of checkout
        for (Checkout checkout : checkouts) {
            if (checkout.queueLength() <= min) {
                min = checkout.queueLength();
            }

        }

        //put all checkouts with minimal queue in the queue
        for (Checkout checkout : checkouts){
            if (checkout.queueLength() == min){
                minimals.enqueue(checkout);
            }
        }
        // take out first checkout
        return minimals.dequeue();
    }

    public void closeCheckout(int index){
        if (index < 0 || index >= checkouts.length) ExceptionUtil.illegalArgument("Does not exist");
        else if (checkouts.length == 1) ExceptionUtil.unsupportedOperation("Only one left");

        else {
            // create new array and copy all checkouts there, except unwanted one
            Checkout[] temp = new Checkout[checkouts.length - 1];

            for (int i = 0, k = 0; i < checkouts.length; i++){
                if (i == index){
                    continue;
                }
                temp[k++] = checkouts[i];
            }



            // create new LinkedQueue and new LinkedStack
            var tempStack0 = new LinkedStack<PenguinCustomer>();

            var tempStack = new StackConnector<>(tempStack0);

            var tempQueue = new QueueConnector<>(checkouts[index].getQueue());

            var HasToChange = new DataStructureLink<>(tempQueue, tempStack);
            //put customers into stack

            HasToChange.moveAllFromAToB();

            var HasToChangeAgain = new DataStructureLink<>(tempStack, tempQueue);
            //put customers from stack to new queue

            HasToChangeAgain.moveAllFromAToB();


            checkouts = temp;
            // put new customers in existing checkouts
            while (tempQueue.hasNextElement()){
                tempQueue.removeNextElement().goToCheckout(this);
            }


        }

    }

    public void serveCustomers(){
        // all checkouts should serve the next customer
        for (Checkout checkout : checkouts) {
            checkout.serveNextCustomer();
        }
    }

}
