package main;

/**
 * Class that defines a circle.
 *
 * @author João Bolsson (joaovictorbolsson@gmail.com)
 * @since 2017, 27 May.
 */
public class Circle extends Shape {

    private final int radius;

    private static final double PI = 3.14;

    /**
     * Default construct.
     *
     * @param r Circle radius.
     */
    public Circle(final int r) {
        radius = r;
    }

    /**
     * @return Circle area.
     */
    @Override
    public double getArea() {
        return radius * radius * PI;
    }

    @Override
    public String toString() {
        return "Círculo";
    }

}
