#include<bits/stdc++.h>
using namespace std;

int n,answer;
int main(){
    cin >> n;
    for(int i = 0;i<n;i++){
        string input;
        cin >> input;

        stack<char>stack;
        stack.push(input[0]);

        for(int i = 1;i<input.size();i++){
            if(stack.size() != 0){
                if(input[i] == stack.top()){
                    stack.pop();
                }else{
                    stack.push(input[i]);
                }
            }else{
                stack.push(input[i]);
            }
        }
        if(stack.size() == 0){
            answer ++;
        }
    }
    cout << answer << "\n";
}