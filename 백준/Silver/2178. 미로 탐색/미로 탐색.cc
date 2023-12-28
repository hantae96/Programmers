#include <bits/stdc++.h>
using namespace std;


int n,m;
int graph[100][100];
int visited[100][100];
queue<pair<int,int>> que;
string s;
int x,y;
int answer;
int main(){
    cin >> n >> m;
    
    for(int i = 0;i<n;i++){
        cin >> s;
        for(int j = 0;j<m;j++){
            graph[i][j] = s[j] - '0';
        }
    }

    int dx[] = {0,0,-1,1};
    int dy[] = {-1,1,0,0};

    visited[0][0] = 1;
    que.push({0,0});
    while(que.size()){
        tie(y,x) = que.front();
        if(y==n-1 && x == m-1){
            cout << visited[y][x];
            return 0;
        }
        que.pop();

        for(int i = 0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(0 > nx || nx >= m) continue;
            if(0 > ny || ny >= n) continue;
            if(visited[ny][nx] != 0) continue;
            if(graph[ny][nx] == 0) continue;

            visited[ny][nx] += visited[y][x] + 1;
            que.push({ny,nx});
        }
    }
}