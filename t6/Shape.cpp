/**
 * Class that defines an interface of a shape.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @since 2017, 17 May.
 */

#ifndef SHAPE
#define SHAPE

class Shape {

public:

    virtual double getArea() {
        return 0;
    }
};

#endif