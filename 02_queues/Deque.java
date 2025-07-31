import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Item[] array;
    private int left = 0;
    private int right = 0;

    // construct an empty deque
    public Deque() {
        array = (Item[]) new Object[4];
    }

    // is the deque empty?
    public boolean isEmpty(){return true;}

    // return the number of items on the deque
    public int size(){
        return right - left;
    }

    // add the item to the front
    public void addFirst(Item item) {
        array[left % array.length] = item;
        left--;
    }

    // add the item to the back
    public void addLast(Item item) {
        right++;
        array[right % array.length] = item;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        left++;
        return array[left % array.length];
    }

    // remove and return the item from the back
    public Item removeLast() {
        Item last = array[right % array.length];
        right--;
        return last;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new DequeIterator();
    }

    class DequeIterator implements Iterator<Item> {
        int idx = left;

        @Override
        public boolean hasNext()
        {
            return idx != right;
        }

        @Override
        public Item next()
        {
            idx++;
            return array[idx % array.length];
        }

    }

    private void resize(int size) {
        Item[] newArray = (Item[])new Object[size];
    }

    // unit testing (required)
    public static void main(String[] args){
        System.out.println("UNIT TESTS");

        System.out.println("Constructor:");
        Deque<String> sut = new Deque<String>();
        System.out.println(sut.left == 0);
        System.out.println(sut.right == 0);
        System.out.println();

        System.out.println("Size:");
        System.out.println(sut.size() == 0);
        sut.addFirst("Hi");
        sut.addLast("Hi1");
        System.out.println(sut.size() == 2);
        System.out.println();

        System.out.println("addFirst, removeFirst, addLast, removeLast");
        System.out.println("Hi".equals(sut.removeFirst()));
        System.out.println("Hi1".equals(sut.removeFirst()));
        sut.addFirst("Hi2");
        sut.addLast("Hi3");
        sut.addFirst("Hi1");
        sut.addLast("Hi4");
        System.out.println("Hi4".equals(sut.removeLast()));
        System.out.println("Hi3".equals(sut.removeLast()));
        System.out.println();

        System.out.println("Iterator");
        Iterator<String> i = sut.iterator();
        String ans = "";
        while (i.hasNext()) {
            String s = i.next();
            ans += s;
        }
        System.out.println("Hi1Hi2".equals(ans));
    }

}
