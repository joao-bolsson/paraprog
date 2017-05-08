/**
 * Class that defines a player.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @since 2017, 07 May.
 */

#include <iostream>

using namespace std;

class Player {
private:
    string name;
    int scores;

public:
    /**
     * Default construct.
     * @param name Player name.
     * @param scores Initial scores.
     */
    Player(string name, int scores) {
        this->name = name;
        this->scores = scores;
    }

    /**
     * @return Player name.
     */
    string getName() {
        return name;
    }

    /**
     * Add scores.
     * @param scores Scores to add.
     */
    void sumScores(int scores) {
        this->scores += scores;
    }

    /**
     * @return Player scores.
     */
    int getScores() {
        return this->scores;
    }

    bool operator<(Player &player) {
        return this->name.compare(player.getName()) < 0;
    }

    bool operator==(Player &player) {
        return this->name == player.getName();
    }

};