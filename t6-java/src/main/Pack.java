package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class that representing a pack of cookies.
 *
 * @author João Bolsson (joaovictorbolsson@gmail.com)
 * @since 2017, 27 May.
 */
public class Pack {

    private final int n;

    private final List<Cookie> cookies = new ArrayList<>();

    private static final Comparator<Cookie> COOKIE_COMPARATOR = new Comparator<Cookie>() {
        @Override
        public int compare(final Cookie a, final Cookie b) {
            if (a.getArea() < b.getArea()) {
                return 1;
            } else if (a.getArea() == b.getArea()) {
                return 0;
            }
            return -1;
        }
    };

    /**
     * Default construct.
     *
     * @param n Number of cookies in pack.
     */
    public Pack(int n) {
        this.n = n;
        buildPack();
        cookies.sort(COOKIE_COMPARATOR);
    }

    /**
     * @return A random cookie.
     */
    private static Cookie makeCookie() {
        int type = Util.rand(1, 3);
        return new Cookie(type);
    }

    /**
     * Fills this pack with cookies.
     */
    private void buildPack() {
        for (int i = 0; i < n; i++) {
            cookies.add(makeCookie());
        }
    }

    /**
     * Show all the cookies in this pack.
     */
    public void showCookies() {
        int small = 0, medium = 0, big = 0;
        double price_s = 0, price_m = 0, price_b = 0;
        for (Cookie cookie : cookies) {
            cookie.toString();
            if (cookie.getSize().equals(Cookie.SMALL)) {
                small++;
                price_s += cookie.getPrice();
            } else if (cookie.getSize().equals(Cookie.MEDIUM)) {
                medium++;
                price_m += cookie.getPrice();
            } else {
                big++;
                price_b += cookie.getPrice();
            }
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Pequenos: " + small + " | Estimativa: R$ " + price_s);
        System.out.println("Médios: " + medium + " | Estimativa: R$ " + price_m);
        System.out.println("Grandes: " + big + " | Estimativa: R$ " + price_b);
    }

}
