# Supermarket
First create linkedstack and linkedqueue and then using them and their link make classes of customers, product and supermakets in order to serve everyone.

An interface DataStructure, which defines the following methods:
a method size() that returns the number of stored elements as int.
a method isEmpty(), which returns a boolean, whether the data structure is empty. (You can also use a default method here)
A generic interface Stack, which extends DataStructure and defines the following methods:
a method push(T), which adds an object of the generic type T to the stack.
a method pop(), which removes an object of the generic type T from the stack. If the stack is empty, it returns null.
A generic interface Queue, which extends DataStructure and defines the following methods:
a method enqueue(T), which adds an object of the generic type T to the queue.
a method dequeue(), which removes an object of the generic type T from the queue. If the queue is empty, it returns null.


 Implement the generic LinkedStack class, which implements the Stack, and use the List class for this 

 Implement the generic LinkedQueue class, which implements the Queue, and use the List class for this 

Connect data structures
Next, we want to connect data structures together in order to effectively move elements from one data structure to another. TWe need this for the next subtask, so we want to find a good solution for it without using the existing interfaces overloaded with methods or made method names less descriptive.

Implement the generic interface DataStructureConnector 1 of 1 tests passing
The following methods should be included:

hasNextElement() returns whether the data structure still contains elements.
addElement(T) adds an element of the generic type T to the data structure.
removeNextElement() takes the next element (of the generic type T) from the data structure. If the data structure does not contain any more elements, null is returned.

 Create the generic StackConnector class that implements DataStructureConnector for Interface Stack

Create the generic QueueConnector class that implements DataStructureConnector for Interface Queue
Create the class generic DataStructureLink



The PenguinCustomer class
The PenguinCustomer puts FishyProducts in his shopping cart, waits at the checkout and finally pays. For this we need the following attributes:

name (String)
available money (int, penguins still don't take it too seriously)
the products in the shopping cart (Stack<FishyProduct>, penguins always stack the goods)
Implement the class PenguinCustomer with the mentioned attributes and provide the getters:

getName()
getMoney()
getProducts()
A few more methods are also necessary:

with addProductToBasket(FishyProduct) a penguin can add the transferred product to his product stack. (This can also be multiple).
with placeAllProductsOnBand(Queue<FishyProduct>) the penguin places all its products on the belt at the checkout (the transferred queue). Use a DataStructureLink for this.
with takeAllProductsFromBand(Queue<FishyProduct>) the penguin takes all products from the tape at the till (the transferred queue) into its product stack. Use a DataStructureLink for this.
with pay(int) the penguin pays the transferred amount. The amount must not be negative and the available money must not be negative as well (penguins cannot have debts).
Make all attributes - if possible - final so that their value is only set once when the PenguinCustomer(String name, int initialMoney) constructor is called. Check the values for validity. So neither the name null nor the money available should be negative (penguins cannot have debts). Override the toString method so that the return value contains the most important characteristics of a PenguinCustomer.

Example in the test case: new FishyProduct("Micro Mac with Soft Fish", 1254) and new PenguinCustomer("Tux", 1337). In the first test only name and money are checked, in the second the FishyProduct is placed in the shopping cart (addProductToBasket).

 Public test case works 3 of 3 tests passing


Penguinsupermarket
Checkout
Create the class Checkout, which represents a cash register in our supermarket. It consists of:

a queue from PenguinCustomers
a queue of FishyProducts in front of the cashier on the belt
a queue of FishyProducts after the cashier on the tape
Implement the class Checkout with a parameterless constructor and the named attributes and provide the getters:

getQueue()
getBandBeforeCashier()
getBandAfterCashier()
queueLength() method directly returns the length of the queue. serveNextCustomer() method should be implemented so that the next penguin is served. The procedure is as follows:

the first PenguinCustomer leaves the queue,
puts all his products on the belt in front of the cashier (bandBeforeCashier),
the cashier scans all the products and calculates the price, moving the products to the rear belt (bandAfterCashier).
the PenguinCustomer takes all products from the back belt into the shopping cart (product stack)
and the PenguinCustomer is asked to pay. (An error may arise here, if he cannot do that, that's how it should be)
If there is no penguin to operate, nothing happens when it is called (it waits). Overwrite toString here as well.

Example in the test case: new FishyProduct("Micro Mac with Soft Fish", 1254) and new PenguinCustomer("Tux", 1337). "Tux" has the product in the shopping cart and is at the checkout. ServeNextCustomer() is called. He then has the product and is no longer at the checkout.

e class PenguinSupermarket that represents our supermarket. It consists of:

an array of Checkouts (theoretically you can use something else here too.)
Implement the class PenguinSupermarket with the mentioned attributes and provide the getters:

getCheckouts(), which in any case provides an array of all open Checkouts (registers).
In the constructor, the PenguinSupermarket receives the number of registers (must be greater than 0). There should be other methods for this purpose:

getCheckoutWithSmallestQueue() returns the first of all Checkouts (foremost in the array), which has the smallest queue length. Now write the goToCheckout(PenguinSupermarket) method for the PenguinCustomer class, which can be called the PenguinCustomer places itself in the shortest queue of the handed over supermarket.
closeCheckout(index) closes the cash register at the index passed (starting from 0). If one does not exist, an error message should be output; and also print an error if this is the last remaining cash register. When a cash register is closed, the register is removed from the array of registers (the array becomes smaller), and the penguins have to look for another cash register. However, this happens in the reverse order of the queue, the last are then the first. You can do this with DataStructureLink and goToCheckout(PenguinSupermarket).
serveCustomers() calls serveNextCustomer() once for each register.
