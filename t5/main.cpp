#include <iostream>
#include <vector>
#include <fstream>
#include <sstream>
#include <algorithm>
#include "Activity.cpp"
#include "Player.cpp"

using namespace std;

/**
 * Checks if a vector of players already contains a player by name.
 *
 * @param players Vector to look for.
 * @param plName Player name to check.
 * @return If vector contains the player - return index, else - return -1.
 */
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

/**
 * Compare the scores between two players.
 * @param pl1 Player one.
 * @param pl2 Player two.
 * @return If scores of player two are greater than scores of player one - true, else - false.
 */
bool compareScores(Player &pl1, Player &pl2) {
    return pl1.getScores() < pl2.getScores();
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
    cout << "--- ATIVIDADES EM ORDEM CRESCENTE DE PONTUAÇÃO ---" << endl;
    sort(activities.begin(), activities.end());
    for (Activity activity : activities) {
        cout << "Nome: " << activity.getPlayer() << " - Atividade: " << activity.getName()
             << " - Pontuação: " << activity.getScores() << endl;
    }


    /**
     * Liste as pontuações totais por ordem alfabética do nome do jogador, mostrando todos
     * os atributos (nome, pontos).
     */
    cout << "--- PONTUAÇÃO DOS JOGADORES EM ORDEM ALFABETICA ---" << endl;
    sort(players.begin(), players.end());
    for (Player player : players) {
        cout << "Nome: " << player.getName() << " - Pontuação total: " << player.getScores()
             << endl;
    }

    cout << "--- PONTUAÇÕES TOTAIS DA MENOR PARA A MAIOR ---" << endl;
    sort(players.begin(), players.end(), compareScores);
    for (Player player : players) {
        cout << "Nome: " << player.getName() << " - Pontuação total: " << player.getScores()
             << endl;
    }

    return 0;
}