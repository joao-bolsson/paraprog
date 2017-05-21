/**
 * Class that represents a pack of cookies.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @since 2017, 20 May.
 */

#ifndef PACK
#define PACK

#include <list>
#include "Cookie.cpp"

using namespace std;

class Pack {

private:
    int n;

    list <Cookie> cookies;

    /**
     * Fills this pack with cookies.
     */
    void buildPack() {
        for (int i = 0; i < n; i++) {
            cookies.push_back(makeCookie());
        }
    }

    /**
     * Make a cookie.
     *
     * @return A random cookie.
     */
    static Cookie makeCookie() {
        int type = rand() % 3 + 1;
        return Cookie(type);
    }

    /**
     * Function to sort the pack.
     *
     * @param a First cookie.
     * @param b Second cookie.
     * @return If area of the cookie a is greater than area of the cookie b - false, else - true.
     */
    static bool compare(Cookie &a, Cookie &b) {
        return a.getArea() < b.getArea();
    }

public:

    /**
     * Default construct to build a pack of cookies.
     *
     * @param n Number of cookies that must be in pack.
     */
    Pack(int n) {
        this->n = n;
        srand((unsigned) time(NULL));
        buildPack();
        cookies.sort(compare);
    }

    /**
     * Show all the cookies in this pack.
     */
    void showCookies() {
        for (Cookie cookie : cookies) {
            cookie.toString();
        }
    }

};

#endif