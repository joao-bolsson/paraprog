/**
 * Class that defines an interface of a rectangle.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @since 2017, 17 May.
 */

#ifndef RECTANGLE
#define RECTANGLE

#include "Shape.cpp"

class Rectangle : public Shape {

private:
    int width, height;

public:

    /**
     * Default construct.
     *
     * @param width Rectangle width.
     * @param height Rectangle height.
     */
    Rectangle(int width, int height) {
        this->width = width;
        this->height = height;
    }

    /**
     * @return The area of this rectangle.
     */
    double getArea() {
        return width * height;
    }
};

#endif