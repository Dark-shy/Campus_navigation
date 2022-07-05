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
        String path = place[n];
        Floyd a = new Floyd();
        prew = a.dijkstra(m);
        map g=new map(m,n,prew);
    }

}
