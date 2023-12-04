#include<bits/stdc++.h>
using namespace std;



int arr[100];
int main(){
    string str;
    cin >> str;
    
    int s = 0;
    int e = str.size() -1;
    
    while(s<e){
        if(str[s] != str[e]){
            cout << "0" << endl;
            exit(0);
        }
        s++;
        e--;
    }
    cout << "1" << endl;
}