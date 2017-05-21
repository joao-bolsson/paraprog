/**
 * Class that contains useful functions.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @since 2017, 20 May.
 */

#ifndef UTIL
#define UTIL

#include <cstdlib>

#include "Circle.cpp"
#include "Triangle.cpp"
#include "Rectangle.cpp"

#define MIN_RADIUS 1
#define MAX_RADIUS 4

#define MIN_WIDTH 1
#define MAX_WIDTH 5

#define MIN_HEIGHT 1
#define MAX_HEIGHT 6

class Util {
public:

    /**
     * @return A random circle.
     */
    static Circle *generateCircle() {
        int rad = rand() % MAX_RADIUS + MIN_RADIUS;
        return new Circle(rad);
    }

    /**
     * @return A random triangle.
     */
    static Triangle *generateTriangle() {
        int width = rand() % MAX_WIDTH + MIN_WIDTH;
        int height = rand() % MAX_HEIGHT + MIN_HEIGHT;

        return new Triangle(width, height);
    }

    /**
     * @return A random rectangle.
     */
    static Rectangle *generateRectangle() {
        int width = rand() % MAX_WIDTH + MIN_WIDTH;
        int height = rand() % MAX_HEIGHT + MIN_HEIGHT;

        return new Rectangle(width, height);
    }

};

#endif