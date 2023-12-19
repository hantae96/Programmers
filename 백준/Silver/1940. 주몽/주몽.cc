#include<bits/stdc++.h>
using namespace std;

bool compare(int a, int b){
    return a > b;
}

int n,m,answer;
vector<int> arr;
int main(){
    cin >> n;
    cin >> m;

    for(int i = 0;i<n;i++){
        int num;
        cin >> num;
        arr.push_back(num);
    }
    sort(arr.begin(),arr.end(),compare);

    // 7 5 4 3 2 1
    // 7 2
    // 5 4
    for(int i = 0;i<arr.size()-1;i++){
        int temp = m - arr[i];
        if(temp > arr[i+1]){
            break;
        }
        for(int j = i+1;j<arr.size();j++){
            if(temp - arr[j] == 0){
                answer++;
                break;
            }
        }
    }
    cout << answer << endl;
}