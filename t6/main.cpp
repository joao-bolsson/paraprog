/**
 * Main file.
 *
 * Generate a executable with:
 * g++ -std=c++11 main.cpp Shape.cpp Rectangle.cpp Circle.cpp Triangle.cpp Cookie.cpp Util.cpp Pack.cpp -o main
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @since 2017, 21 May.
 */
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