#include <cmath>
#include <iostream>

using namespace std;

const int QT = 5;

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

   double distanceTo(Point* p) {
      double dx = pow((this->x - p->x), 2);
      double dy = pow((this->y - p->y), 2);

      double dist = sqrt(dx + dy);
      return dist;
   }
   
   double getX() {
       return this->x;
   }
   
   double getY() {
       return this->y;
   }

};

/** essa classe não precisa ter main(), apenas para testes
int main() {
   Point p = Point(1.0, 2.0);

   Point* points[QT];
   for (int i = 0; i < QT; i++) {
      points[i] = new Point(i, i + 1.0);
      cout << p.distanceTo(points[i]) << endl;
      delete points[i];
   }
   return 0;
}
**/
