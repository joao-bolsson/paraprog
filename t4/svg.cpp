#include <iostream>
#include <fstream>
#include "tag.cpp"
#include "circle.cpp"

using namespace std;

#define NUM_CIRCLES 6
#define RAD 20

int main() {

    ofstream file;
    file.open("circulos.svg");

    Tag svg = Tag("svg");
    svg.addAttribute("height", "600");
    svg.addAttribute("width", "800");

    double x = 100; // valor inicial do primeiro circulo
    double y = 100;

    string x_prev = "";
    string y_prev = "";
    for (int i = 0; i < NUM_CIRCLES; i++) {
        Circle cir = Circle(x, y, RAD);
        x += (4 * RAD);
        y += (4 * RAD);
        string cx = to_string(cir.getCenter().getX());
        string cy = to_string(cir.getCenter().getY());

        if (i % 2 != 0) {
            x_prev = cx;
            y_prev = cy;
        }
        string r = to_string(cir.getRadius());

        Tag circle = Tag("circle");
        circle.addAttribute("cx", cx);
        circle.addAttribute("cy", cy);
        circle.addAttribute("r", r);
        circle.addAttribute("stroke", "black");
        circle.addAttribute("stroke-width", "3");
        circle.addAttribute("fill", "red");
        svg.addTag(circle);

        if (i % 2 == 0) {
            Tag line = Tag("line");
            line.addAttribute("x1", x_prev);
            line.addAttribute("y1", y_prev);
            line.addAttribute("x2", cx);
            line.addAttribute("y2", cy);
            line.addAttribute("style", "stroke:rgb(255,0,0);stroke-width:2");
            svg.addTag(line);
        }
    }

    file << svg.toString() << endl;

    file.close();
    return 0;
}
