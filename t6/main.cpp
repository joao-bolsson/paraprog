#include "Pack.cpp"

using namespace std;

int main() {
    int n = 0;

    cout << "Quantos cookies no pacote? ";
    cin >> n;

    Pack pack = Pack(n);

    pack.showCookies();

    return 0;
}