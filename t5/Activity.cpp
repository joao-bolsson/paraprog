/**
 * Class that defines an activity.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @since 2017, 07 May.
 */

#include <iostream>

using namespace std;

class Activity {
private:
    string name, player;
    int scores;

public:
    /**
     * Default construct.
     * @param name Activity name.
     * @param player Activity player.
     * @param scores Player scores in activity.
     */
    Activity(string name, string player, int scores) {
        this->name = name;
        this->player = player;
    }

    string getPlayer() {
        return player;
    }

    /**
     * @return Activity name.
     */
    string getName() {
        return name;
    }

    bool operator<(Activity &act) {
        return this->scores > act.scores;
    }
};
