#include <iostream>
#include "tag.cpp"

using namespace std;

int main() {
    Tag svg = Tag("svg");
    svg.addAttribute("height", "100");
    svg.addAttribute("width", "100");

    Tag circle = Tag("circle");
    circle.addAttribute("cx", "50");
    circle.addAttribute("cy", "50");
    circle.addAttribute("r", "40");
    circle.addAttribute("stroke", "black");
    circle.addAttribute("stroke-width", "3");
    circle.addAttribute("fill", "red");

    svg.addTag(circle);

    cout << svg.toString() << endl;
    return 0;
}
