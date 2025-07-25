import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private WeightedQuickUnionUF uf;
    private int dimention; // dimention of a squared grid
    private int count = 0; // Count of open cells
    private int begin;
    private int end;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        begin = n * n;
        end = begin + 1;
        dimention = n;
        // Creates Union Find data structure for all cells in grid
        uf = new WeightedQuickUnionUF(n*n + 2);
        // Creates grid with all open cells
        grid = new int[n][n];
        for (int row = 0; row < n; row++){
            for (int col = 0; col < n; col++)
                grid[row][col] = false;
        }
        // Initialise starting connections
        for (int i = 0; i < n; i++){
            // connect first row to begin
            uf.union(begin, i);
            // connect last row to end
            uf.union(end, n-i-1)
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col)

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if (row < grid.length && col < grid.length && row >= 0 && col >= 0)
            return grid[row][col];
        else
            throw new IllegalArgumentException("row or col out of range");
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col)

    // returns the number of open sites
    public int numberOfOpenSites()

    // does the system percolate?
    public boolean percolates()

    // test client (optional)
    public static void main(String[] args)
}