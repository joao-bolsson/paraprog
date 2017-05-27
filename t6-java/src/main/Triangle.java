package main;

/**
 * Class that defines a triangle.
 *
 * @author João Bolsson (joaovictorbolsson@gmail.com)
 * @since 2017, 27 May.
 */
public class Triangle extends Shape {

    private final int base, height;

    /**
     * Default construct.
     *
     * @param base Triangle base.
     * @param height Triangle height.
     */
    public Triangle(final int base, final int height) {
        this.base = base;
        this.height = height;
    }

    /**
     * @return Triangle area.
     */
    @Override
    public double getArea() {
        return (base * height) / 2;
    }

    @Override
    public String toString() {
        return "Triângulo";
    }

}
