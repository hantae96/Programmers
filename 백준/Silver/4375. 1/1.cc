#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int main(){
    int n;
    while(cin >> n)
    {
        int idx = 1;

        ll value = 1;
        while(true){
            if(value%n == 0){
                cout << idx << "\n";
                break;
            }
            value = value*10 + 1;
            value %= n;
            idx++;
        }
    }
}