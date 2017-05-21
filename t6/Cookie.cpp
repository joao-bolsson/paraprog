/**
 * Class that defines a Cookie.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @since 2017, 20 May.
 */

#ifndef COOKIE
#define COOKIE

#include <iostream>
#include <map>

#include "Util.cpp"

#define TYPE_CIRCLE 1
#define TYPE_TRIANGLE 2

#define SMALL_SIZE 5
#define BIG_SIZE 10

#define SMALL "Pequeno"
#define MEDIUM "Médio"
#define BIG "Grande"

using namespace std;

class Cookie {

private:
    Shape *shape;
    string size;

    map<string, double> prices = {
            {SMALL,  0.4},
            {MEDIUM, 0.65},
            {BIG,    0.75}};

    /**
     * Sets the size of this cookie by its area.
     */
    void setSize() {
        double area = shape->getArea();
        if (area < SMALL_SIZE) {
            size = SMALL;
        } else if (area >= SMALL_SIZE && area < BIG_SIZE) {
            size = MEDIUM;
        } else {
            size = BIG;
        }
    }

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
        setSize();
    }

    /**
     * @return A string representing the shape of this cookie.
     */
    string getShape() {
        if (dynamic_cast<Circle *>(shape)) {
            return "Círculo";
        } else if (dynamic_cast<Triangle *>(shape)) {
            return "Triângulo";
        } else if (dynamic_cast<Rectangle *>(shape)) {
            return "Retângulo";
        } else {
            // never must happen
            return "NULL";
        }
    }

    /**
     * @return The cookie area.
     */
    double getArea() {
        return shape->getArea();
    }

    /**
     * @return The cookie price.
     */
    double getPrice() {
        return prices[size];
    }

    /**
     * String representation of this cookie.
     */
    void toString() {
        cout << "Cookie shape: " << getShape() << " | Área: " << shape->getArea()
             << " | " << size << " | Preço: " << getPrice() << endl;
    }
};

#endif