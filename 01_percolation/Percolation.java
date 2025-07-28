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
        grid = new boolean[n][n];
        for (int row = 0; row < n; row++){
            for (int col = 0; col < n; col++)
                grid[row][col] = false;
        }
        // Initialise starting connections
        for (int i = 0; i < n; i++){
            // connect first row to begin
            uf.union(begin, i);
            // connect last row to end
            uf.union(end, n*n-i-1);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        // Check if its not open
        if (!grid[row][col]){
            // Open site
            count += 1;
            grid[row][col] = true;
            // Create connections for all open neighbors
            if (row > 0 && grid[row - 1][col]) 
                uf.union(row_col2uf_idx(row, col), row_col2uf_idx(row - 1, col)); 
            if (row < dimention - 1 && grid[row + 1][col]) 
                uf.union(row_col2uf_idx(row, col), row_col2uf_idx(row + 1, col)); 
            if (col > 0 && grid[row][col-1]) 
                uf.union(row_col2uf_idx(row, col), row_col2uf_idx(row, col - 1)); 
            if (col < dimention - 1 && grid[row][col+1]) 
                uf.union(row_col2uf_idx(row, col), row_col2uf_idx(row, col + 1)); 
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if (row < grid.length && col < grid.length && row >= 0 && col >= 0)
            return grid[row][col];
        else
            throw new IllegalArgumentException("row or col out of range");
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        // check if site is connected with begin
        if (grid[row][col])
            return uf.find(row_col2uf_idx(row, col)) == uf.find(begin);
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        return count;
    }

    // does the system percolate?
    public boolean percolates(){
        // check if beggining is connected with end
        return uf.find(end) == uf.find(begin);
    }

    // Convert row and col to Union Find index
    private int row_col2uf_idx(int row, int col){
        return dimention * row + col;
    }

    // test client (optional)
    public static void main(String[] args){
        // Test
        Percolation obj = new Percolation(5);
        obj.open(0, 0);
        obj.open(1, 0);
        obj.open(2, 0);
        System.out.println("Open Tesets");
        System.out.println(obj.isOpen(0, 0) == true);
        System.out.println(obj.isOpen(1, 0) == true);
        System.out.println(obj.isOpen(3, 0) == false);
        System.out.println("Percolation Tesets");
        System.out.println(obj.percolates() == false);
        obj.open(3, 1);
        obj.open(4, 1);
        System.out.println(obj.percolates() == false);
        obj.open(2, 1);
        System.out.println(obj.percolates() == true);
        System.out.println("Number of open Test");
        System.out.println(obj.numberOfOpenSites() == 6);
    }
}