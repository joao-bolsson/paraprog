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
        return Cookie(Util::getRand(1, 3));
    }

public:

    /**
     * Default construct to build a pack of cookies.
     *
     * @param n Number of cookies that must be in pack.
     */
    Pack(int n) {
        this->n = n;
        buildPack();
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