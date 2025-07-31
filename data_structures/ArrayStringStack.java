public class ArrayStringStack {
    private String[] stack = new String[1];
    private int currPos = 0;

    private void resize(int capacity){
        String[] copy = new String[capacity];
        for (int i = 0; i < stack.length; i++)
            copy[i] = stack[i];
        stack = copy;
    }

    public void push(String item){
        if (currPos == stack.length)
            resize(currPos*2);
        stack[currPos++] = item;
    }

    public String pop() {
        if (--currPos < stack.length/4)
            resize(stack.length/2);
        return stack[currPos];
    }

    public boolean isEmpty() {
        return currPos == 0;
    }
}
