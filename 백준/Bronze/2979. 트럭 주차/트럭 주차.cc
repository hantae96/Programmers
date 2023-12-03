#include<bits/stdc++.h>
using namespace std;


int arr[100];
int main(){
    int a,b,c;
    cin >> a >> b >> c;
    for(int i = 0;i<3;i++){
        int s,e;
        cin >> s >> e;
        for(int j = s;j<e;j++){
            arr[j]++;
        }
    }

    int answer = 0;
    for(int i = 0;i<100;i++){
        if(arr[i] == 1){
            answer += a;
        }else if(arr[i] == 2){
            answer += b*2;
        }else if(arr[i] == 3){
            answer += c*3;
        }
    }

    cout << answer;
}