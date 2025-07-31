// Weighted Quick Union with Path Compression
public class WQUPC {
    private int[] id; // parent link
    private int[] size; // size of each tree

    public WQUPC(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (id[i] != i) {
            // Path compression
            id[i] = id[id[i]];
            i = id[i];    
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }
}