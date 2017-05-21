/**
 * Class that defines a circle.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @since 2017, 17 May.
 */

#ifndef CIRCLE
#define CIRCLE

#include "Shape.cpp"

#define PI 3.14;

class Circle : public Shape {

private:
    int radius;
public:

    /**
     * Default construct.
     *
     * @param r Circle radius.
     */
    Circle(int r) : Shape() {
        radius = r;
    }

    /**
     * @return Circle area.
     */
    double getArea() {
        return radius * radius * PI;
    }

};

#endif
