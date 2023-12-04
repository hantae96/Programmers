#include<bits/stdc++.h>
using namespace std;



int main(){
    int n;
    cin >> n;
    vector<string>v;
    for(int i = 0; i<n ;i++){
        string s;
        cin >> s;
        v.push_back(s);
    }
    
    map<char,int> m;
    for(string s : v){
        char c = s.front();
        m[c]++;
    }

    string answer = "";
    for(auto it : m){
        if(it.second > 4){
            answer += it.first;
        }
    }
    if(answer.compare("") == 0){
        cout << "PREDAJA" << endl;
    }else{
        cout << answer << endl;
    }

}