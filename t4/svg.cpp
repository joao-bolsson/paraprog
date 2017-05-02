#include <iostream>
#include <fstream>
#include "tag.cpp"

using namespace std;

int main() {

    ofstream file;
    file.open("circulos.svg");

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

    file << svg.toString() << endl;

    file.close();

    cout << svg.toString() << endl;
    return 0;
}
