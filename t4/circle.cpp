#include <iostream>
#include "point.cpp"

const double PI = 3.14159;

class Circle {
private:
    Point p;
    double r;

public:

    Circle() {
        p = Point(0.0, 0.0);
        r = 0.0;
    }

    Circle(double cx, double cy, double r) {
        p = Point(cx, cy);
        this->r = r;
    }

    Circle(Point p, double r) {
        this->p = p;
        this->r = r;
    }

    double area() {
        return PI * r * r;
    }

    double distanceTo(Point* p) {
        return this->p.distanceTo(p);
    }

    Point getCenter() {
        return this->p;
    }

    double getRadius() {
        return this->r;
    }
};
