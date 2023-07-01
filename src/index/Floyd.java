package index;

//查找两点间最短路径并返回
public class Floyd {

    static int max = Integer.MAX_VALUE;
    static int dist[] = new int[10];
    static int prev[] = new int[10];
    static int a[][] = {
            {max, 200, max, max, max, max, max, max, max, max},
            {200, max, 300, 500, max, max, max, max, max, max},
            {max, 300, max, 400, max, 200, max, max, max, 300},
            {max, 500, 400, max, 200, 600, max, max, max, max},
            {max, max, max, 200, max, 600, 200, 400, max, max},
            {max, max, 200, 600, 600, max, 300, max, 400, 300},
            {max, max, max, max, 200, 300, max, 300, 600, max},
            {max, max, max, max, 400, max, 300, max, max, max},
            {max, max, max, max, max, 400, 600, max, max, 100},
            {max, max, 300, max, max, 300, max, max, 100, max}
    };

    int[] dijkstra(int v) {
        int n = dist.length - 1;
        boolean s[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = a[v][i];
            s[i] = false;
            if (dist[i] < Integer.MAX_VALUE)
                prev[i] = v;
            else
                prev[i] = -1;
        }

        dist[v] = 0;
        s[v] = true;
        for (int i = 1; i <= n; i++) {
            int temp = Integer.MAX_VALUE;
            int u = v;
            for (int j = 1; j <= n; j++) {
                if (!s[j] && dist[j] < temp) {
                    u = j;
                    temp = dist[j];
                }
            }
            s[u] = true;
            for (int j = 0; j <= n; j++) {
                if (!s[j] && a[u][j] < Integer.MAX_VALUE) {
                    int newDist = dist[u] + a[u][j];
                    if (newDist < dist[j]) {
                        dist[j] = newDist;
                        prev[j] = u;
                    }
                }
            }
        }
        return prev;
    }

}