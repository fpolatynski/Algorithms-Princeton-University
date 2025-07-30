public class ArrayStringStack {
    private String[] stack;
    private int currPos = 0;

    public ArrayStringStack(int size){
        stack = new String[size];
    }

    public void push(String item){
        stack[currPos++] = item;
    }

    public String pop() {
        return stack[--currPos];
    }

    public boolean isEmpty() {
        return currPos == 0;
    }
}
