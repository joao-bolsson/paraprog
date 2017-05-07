#include <iostream>
#include <vector>
#include <fstream>
#include <sstream>
#include "Activity.cpp"

using namespace std;

int main() {
    ifstream file("/home/joao/CC/paraprog/t5/pontos.csv");
    string line;

    // activities from csv file
    vector<Activity> activities;
    while (getline(file, line)) {
        stringstream lineStream(line);
        string plName, actName, scores;

        getline(lineStream, plName, ',');
        getline(lineStream, actName, ',');
        getline(lineStream, scores, ',');

        Activity activity = Activity(actName, plName, atoi(scores.c_str()));

        activities.push_back(activity);
        cout << "ola" << endl;
    }

    cout << "Hello" << endl;

    return 0;
}