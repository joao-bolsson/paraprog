package main;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class that contains useful functions.
 *
 * @author João Bolsson (joaovictorbolsson@gmail.com)
 * @since 2017, 27 May.
 */
public class Util {

    private static final int MIN_RADIUS = 1, MAX_RADIUS = 4, MIN_WIDTH = 1, MAX_WIDTH = 5,
            MIN_HEIGHT = 1, MAX_HEIGHT = 6;

    /**
     * Gets a random number between min and max.
     *
     * @param min Min range.
     * @param max Max range.
     * @return A random int.
     */
    public static int rand(final int min, final int max) {
        // standard way to get a random number in range with Java 1.7 or later.
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * @return A random circle.
     */
    public static Circle generateCircle() {
        // standard way to gets a random number in range with Java 1.7 or later.
        int rad = rand(MIN_RADIUS, MAX_RADIUS);
        return new Circle(rad);
    }

    /**
     * @return A random triangle.
     */
    public static Triangle generateTriangle() {
        int base = rand(MIN_WIDTH, MAX_WIDTH);
        int height = rand(MIN_HEIGHT, MAX_HEIGHT);

        return new Triangle(base, height);
    }

    /**
     * @return A random rectangle.
     */
    public static Rectangle generateRectangle() {
        int width = rand(MIN_WIDTH, MAX_WIDTH);
        int height = rand(MIN_HEIGHT, MAX_HEIGHT);

        return new Rectangle(width, height);
    }

}
