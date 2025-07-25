import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champion = "";
        String current;
        double i = 1;
        while (!StdIn.isEmpty()){
            current = StdIn.readString();
            if (StdRandom.bernoulli(1/i)) {
                champion = current;
            }
            i += 1;
        }
        StdOut.println(champion);
    }
}