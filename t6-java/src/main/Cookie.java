package main;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines a cookie.
 *
 * @author João Bolsson (joaovictorbolsson@gmail.com)
 * @since 2017, 27 May.
 */
public class Cookie {

    private static final int TYPE_CIRCLE = 1, TYPE_TRIANGLE = 2, SMALL_SIZE = 5, BIG_SIZE = 13;
    public static final String SMALL = "Pequeno", MEDIUM = "Médio", BIG = "Grande";

    private final Shape shape;
    private String size;

    private static final Map<String, Double> PRICES = new HashMap<>();

    static {
        PRICES.put(SMALL, 0.4);
        PRICES.put(MEDIUM, 0.65);
        PRICES.put(BIG, 0.75);
    }

    /**
     * Default construct.
     *
     * @param type Int type representing the cookie shape.
     */
    public Cookie(final int type) {
        switch (type) {
            case TYPE_CIRCLE:
                shape = Util.generateCircle();
                break;
            case TYPE_TRIANGLE:
                shape = Util.generateTriangle();
                break;
            default:
                // by default, the cookie shape will be a rectangle
                shape = Util.generateRectangle();
                break;
        }
        setSize();
    }

    /**
     * Sets the cookie size (string representation) by according with the cookie area.
     */
    private void setSize() {
        double area = shape.getArea();
        if (area < SMALL_SIZE) {
            size = SMALL;
        } else if (area >= SMALL_SIZE && area < BIG_SIZE) {
            size = MEDIUM;
        } else {
            size = BIG;
        }
    }

    /**
     * @return String representation of the cookie shape.
     */
    public String getShape() {
        return shape.toString();
    }

    /**
     * @return Cookie area.
     */
    public double getArea() {
        return shape.getArea();
    }

    /**
     * @return String representation of the cookie size.
     */
    public String getSize() {
        return size;
    }

    /**
     * @return Cookie price.
     */
    public double getPrice() {
        return PRICES.get(size);
    }

    /**
     * @return String representation of this cookie.
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("Cookie shape: ");
        builder.append(getShape());
        builder.append(" | Área: ");
        builder.append(shape.getArea());
        builder.append(" | ");
        builder.append(size);
        builder.append(" | Preço: ");
        builder.append(getPrice());

        return builder.toString();
    }
}
