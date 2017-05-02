#include <iostream>
#include <fstream>
#include "tag.cpp"
#include "circle.cpp"

using namespace std;

#define NUM_CIRCLES 10
#define RAD 20

int main() {

    ofstream file;
    file.open("circulos.svg");

    Tag svg = Tag("svg");
    svg.addAttribute("height", "600");
    svg.addAttribute("width", "800");

    
    for (int i = 0; i < NUM_CIRCLES; i++) {
        Circle cir = Circle(300.0, 0, RAD);
        string cx = to_string(cir.getCenter().getX());
        string cy = to_string(cir.getCenter().getY());
        string r = to_string(cir.getRadius());

        Tag circle = Tag("circle");
        circle.addAttribute("cx", cx);
        circle.addAttribute("cy", cy);
        circle.addAttribute("r", r);
        circle.addAttribute("stroke", "black");
        circle.addAttribute("stroke-width", "3");
        circle.addAttribute("fill", "red");
        svg.addTag(circle);
    }

    file << svg.toString() << endl;

    file.close();

    cout << svg.toString() << endl;
    return 0;
}
