import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] samples;


    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        samples = new double[trials];

        for (int i = 0; i < trials; i++){
            Percolation experiment = new Percolation(n);
            while(!experiment.percolates()){
                int row = StdRandom.uniformInt(n);
                int col = StdRandom.uniformInt(n);
                experiment.open(row, col);
            }
            samples[i] = (double) experiment.numberOfOpenSites() / (n*n);
        }

    }

    // sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(samples);
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddev(samples);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(){
        return mean() - 1.96 * stddev() / Math.sqrt(samples.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        return mean() + 1.96 * stddev() / Math.sqrt(samples.length);
    }

   // test client (see below)
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, trials);
        System.out.print("Mean: ");
        System.out.println(stats.mean());
        System.out.print("Stddev: ");
        System.out.println(stats.stddev());
        System.out.print("95% Confidential interval: ");
        System.out.print(stats.confidenceLo());
        System.out.print(" - ");
        System.out.println(stats.confidenceHi());
   }
}