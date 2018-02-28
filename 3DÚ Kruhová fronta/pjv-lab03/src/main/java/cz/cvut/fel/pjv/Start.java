
package cz.cvut.fel.pjv;

/**
 * @author Jirka Šebek
 */
public class Start {

    public static void main(String[] args) {

         
        /* homework */
        Queue queue = new CircularArrayQueue(10);

        queue.enqueue("Starkiller");
        queue.enqueue("C-3PO");
        queue.enqueue("Jabba the Hutt");
        queue.enqueue("HK-47");
        queue.enqueue("Darth Nihilus");
        queue.enqueue("Count Dooku");
        queue.enqueue("Jabba the Hutt13513");
        queue.enqueue("HK-476541651");
        queue.enqueue("Darth Nihilus5416156516");
        queue.enqueue("Count Dooku6519684651");
        queue.enqueue("Starkiller651651");
        queue.enqueue("C-3PO987988749-/");
        System.out.println("size: " + queue.size());
        System.out.println("Value dequeued from CircularArrayQueue: " + queue.dequeue());
        System.out.println("printing all elements: ");
        queue.printAllElements();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("Jango Fett");
        queue.enqueue("Starkiller651651");
        queue.enqueue("C-3PO987988749-/");
        System.out.println("size: " + queue.size());
    }
}
