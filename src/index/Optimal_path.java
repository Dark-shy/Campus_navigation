package index;

public class Optimal_path {
    String[] place;
    int m, n;

    public Optimal_path(int m, int n, String[] place) {
        this.m = m;
        this.n = n;
        this.place = place;
        get_path();
    }

    void get_path() {
        int[] prew;
        Floyd a = new Floyd();
        prew = a.dijkstra(m);
        new map(m,n,prew);
    }

}
