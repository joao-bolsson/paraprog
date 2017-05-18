/**
 * Class that defines a triangle.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @since 2017, 17 May.
 */

#include "Shape.cpp"

class Triangle : public Shape {

private:
    int base, height;
public:

    /**
     * Default construct for a simple triangle.
     *
     * @param base Triangle base.
     * @param height Triangle height.
     */
    Triangle(int base, int height) {
        this->base = base;
        this->height = height;
    }

    /**
     * @return Triangle area.
     */
    double getArea() {
        return (base * height) / 2;
    }
};