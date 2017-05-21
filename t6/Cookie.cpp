/**
 * Class that defines a Cookie.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @since 2017, 20 May.
 */

#ifndef COOKIE
#define COOKIE

#include <iostream>

#include "Util.cpp"

#define TYPE_CIRCLE 1
#define TYPE_TRIANGLE 2

using namespace std;

class Cookie {

private:
    Shape *shape;

public:

    /**
     * Default construct to build a cookie.
     *
     * @param type Define a cookie shape.
     */
    Cookie(int type = 0) {
        if (type == TYPE_CIRCLE) {
            this->shape = Util::generateCircle();
        } else if (type == TYPE_TRIANGLE) {
            this->shape = Util::generateTriangle();
        } else {
            // by default, the cookie shape will be a rectangle
            this->shape = Util::generateRectangle();
        }
    }

    /**
     * @return A string representing the shape of this cookie.
     */
    string getShape() {
        if(dynamic_cast<Circle*>(shape)) {
            return "Círculo";
        } else if (dynamic_cast<Triangle*>(shape)) {
            return "Triângulo";
        } else if (dynamic_cast<Rectangle*>(shape)) {
            return "Retângulo";
        } else {
            // never must happen
            return "NULL";
        }
    }

    /**
     * String representation of this cookie.
     */
    void toString() {
        cout << "Cookie shape: " << getShape() << " | Área: " << shape->getArea() << endl;
    }
};

#endif