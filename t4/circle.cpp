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

   double area() {
      return PI * r * r;
   }

   double distanceTo(Point* p) {
      return this->p.distanceTo(p);
   }
};
