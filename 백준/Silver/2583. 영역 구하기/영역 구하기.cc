#include<bits/stdc++.h>
using namespace std;

int m, n, k, answer;
int lx, ly, rx, ry;
int graph[101][101];
int visited[101][101];

int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};

int dfs(int y, int x) {
    if (visited[y][x] == 1 || graph[y][x] == 1) {
        return 0;
    }

    visited[y][x] = 1;
    int ret = 1;

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || n <= nx || ny < 0 || m <= ny) continue;
        if (visited[ny][nx] == 1 || graph[ny][nx] == 1) continue;
        ret += dfs(ny, nx);
    }
    return ret;
}

int main() {
    cin >> m >> n >> k;

    for (int i = 0; i < k; i++) {
        cin >> lx >> ly >> rx >> ry;
        for (int y = ly; y < ry; y++) {
            for (int x = lx; x < rx; x++) {
                graph[y][x] = 1;  // 수정된 부분
            }
        }
    }

    vector<int> vec;
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if (visited[i][j] == 0 && graph[i][j] == 0) {
                vec.push_back(dfs(i, j));
            }
        }
    }
    sort(vec.begin(), vec.end());
    cout << vec.size() << endl;
    for (int a : vec) cout << a << " ";
}
