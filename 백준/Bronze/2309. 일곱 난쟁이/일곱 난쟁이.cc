#include<bits/stdc++.h>
using namespace std;

pair<int,int> solve(vector<int> v){
    pair<int,int> p;
    int sum = accumulate(v.begin(),v.end(),0);
    for(int i = 0;i<8;i++){
        for (int j = i+1;j<9;j++){
            if(sum - v[i] - v[j] == 100){
                p.first = v[i];
                p.second = v[j];
                return p;
            }
        }
    }
}

int main(){
    vector<int> v;
    int num;
    for(int i = 0;i<9;i++){
        cin >> num;
        v.push_back(num);
    }

    vector<int> answer;
    pair<int,int> p = solve(v);

    for(int i = 0;i<9;i++){
        if(v[i] != p.first && v[i] != p.second){
            answer.push_back(v[i]);
        }
    }

    sort(answer.begin(),answer.end());
    for (int i = 0;i<answer.size();i++){
        cout << answer[i] << endl;
    }    
}