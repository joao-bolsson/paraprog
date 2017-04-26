#include <cmath>
#include <iostream>

class Point {

private:
   double x, y;

public:
   Point() {
      x = y = 0.0;
   }

   Point(double x, double y) {
      this->x = x;
      this->y = y;
   }

   void move(double dx, double dy) {
      this->x += dx;
      this->y += dy;
   }

   double distanceTo(Point p) {
      double dx = pow((this->x - p.x), 2);
      double dy = pow((this->y - p.y), 2);

      double dist = sqrt(dx + dy);
      return dist;
   }

};

int main() {
   return 0;
}
