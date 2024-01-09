#include <bits/stdc++.h>
using namespace std;

int main() {
    vector<int> answer;
    int sum = 0;

    for (int i = 0; i < 9; i++) {
        int num;
        cin >> num;
        answer.push_back(num);
        sum += num;
    }

    pair<int, int> find;
    for (int i = 0; i < 9; i++) {
        for (int j = i + 1; j < 9; j++) {
            if (sum - answer[i] - answer[j] == 100) {
                find = {answer[i], answer[j]};
                break;
            }
        }
    }
    sort(answer.begin(),answer.end());

    for (int i = 0; i < 9; i++) {
        if (answer[i] == find.first || answer[i] == find.second) {
            continue;
        }
        cout << answer[i] << endl;
    }

    return 0;
}
