/**
 * Class that contains useful functions.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @since 2017, 20 May.
 */

#ifndef UTIL
#define UTIL

#include <ctime>
#include <cstdlib>

#include "Circle.cpp"
#include "Triangle.cpp"
#include "Rectangle.cpp"

#define MIN_RADIUS 1
#define MAX_RADIUS 6

#define MIN_WIDTH 4
#define MAX_WIDTH 10

#define MIN_HEIGHT 1
#define MAX_HEIGHT 7

class Util {
public:

    /**
     * @return A random circle.
     */
    static Circle *generateCircle() {
        srand((unsigned) time(NULL));
        int rad = rand() % MAX_RADIUS + MIN_RADIUS;
        return new Circle(rad);
    }

    /**
     * @return A random triangle.
     */
    static Triangle *generateTriangle() {
        srand((unsigned) time(NULL));
        int width = rand() % MAX_WIDTH + MIN_WIDTH;
        int height = rand() % MAX_HEIGHT + MIN_HEIGHT;

        return new Triangle(width, height);
    }

    /**
     * @return A random rectangle.
     */
    static Rectangle *generateRectangle() {
        srand((unsigned) time(NULL));
        int width = rand() % MAX_WIDTH + MIN_WIDTH;
        int height = rand() % MAX_HEIGHT + MIN_HEIGHT;

        return new Rectangle(width, height);
    }

    /**
     * Gets a random number between min and max.
     *
     * @param min Min range.
     * @param max Max range.
     * @return A random int.
     */
    static int getRand(int min, int max) {
        srand((unsigned) time(NULL));
        return rand() % max + min;
    }
};

#endif