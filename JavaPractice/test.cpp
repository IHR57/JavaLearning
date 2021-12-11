#include <bits/stdc++.h>
using namespace std;

int main() {

    int n;
    cin>>n;

    int a = 2, b = 5;

    for(int i = 3; i <= n; i++) {
        int temp = a + b;
        a = b;
        b = temp;
    }

    cout<<b<<endl;
}