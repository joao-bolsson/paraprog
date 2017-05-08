#include <iostream>
#include <vector>
#include <fstream>
#include <sstream>
#include <algorithm>
#include "Activity.cpp"
#include "Player.cpp"

using namespace std;

int containsPlayer(vector<Player> players, string plName) {
    int index = 0;
    for (Player pl : players) {
        if (pl.getName() == plName) {
            return index;
        } else {
            index++;
        }
    }
    return -1;
}

int main() {
    ifstream file("/home/joao/CC/paraprog/t5/pontos.csv");
    string line;

    // activities from csv file
    vector<Activity> activities;

    // players from csv file
    vector<Player> players;

    while (getline(file, line)) {
        stringstream lineStream(line);
        string plName, actName, scores;

        getline(lineStream, plName, ',');
        getline(lineStream, actName, ',');
        getline(lineStream, scores, ',');

        int scoresInt = atoi(scores.c_str());

        Activity activity = Activity(actName, plName, scoresInt);

        activities.push_back(activity);

        Player player = Player(plName, scoresInt);
        int index = containsPlayer(players, plName);
        if (index >= 0) {
            Player pl = players.at(index);
            pl.sumScores(scoresInt);
            // refresh index of vector, vector.at doesn't returns a pointer
            players[index] = pl;
        } else {
            players.push_back(player);
        }
    }

    /**
     * Liste as pontuações em atividades ordenadas da maior para a menor pontuação, mostrando
     * todos os atributos (nome, atividade, pontos)
     */
    cout << "--- ATIVIDADES EM ORDEM CRESCENTE ---" << endl;
    sort(activities.begin(), activities.end());
    for (Activity activity : activities) {
        cout << "Nome: " << activity.getPlayer() << " - Atividade: " << activity.getName()
             << " - Pontuação: " << activity.getScores() << endl;
    }


    cout << "--- PONTUAÇÃO DOS JOGADORES EM ORDEM ALFABETICA ---" << endl;
    sort(players.begin(), players.end());
    for (Player player : players) {
        cout << "Nome: " << player.getName() << " - Pontuação total: " << player.getScores()
             << endl;
    }

    return 0;
}