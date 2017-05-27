package main;

/**
 * Class that defines a rectangle.
 *
 * @author João Bolsson (joaovictorbolsson@gmail.com)
 * @since 2017, 27 May.
 */
public class Rectangle extends Shape {

    private final int height, width;

    /**
     * Default construct.
     *
     * @param width Rectangle width.
     * @param height Rectangle height.
     */
    public Rectangle(final int width, final int height) {
        this.height = height;
        this.width = width;
    }

    /**
     * @return Rectangle area.
     */
    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public String toString() {
        return "Retângulo";
    }

}
