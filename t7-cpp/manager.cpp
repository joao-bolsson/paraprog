/**
 * Manager class.
 */

#ifndef TESTE_MANAGER_H
#define TESTE_MANAGER_H

#include <list>
#include <stdio.h>
#include <stdlib.h>

#define NO_PARTICIPANTS -2
using namespace std;

class Manager {

private:
    list<int> participants;

    Manager() {
        // empty
    }

public:
    static Manager &getInstance() {
        static Manager instance;

        return instance;
    }

    /**
     * Starts the Manager with number of participants to sort.
     *
     * @param numberOfParticipants
     */
    void start(int numberOfParticipants) {
        participants.clear();
        for (int i = 0; i < numberOfParticipants; i++) {
            participants.push_back(i);
        }
    }

    int getGuess() {
        if (participants.empty()) {
            return NO_PARTICIPANTS;
        }

        /* Intializes random number generator */
        srand((unsigned) 123456171872871271261726152615251524524215242314216217256142514);

        int index = rand() % participants.size();
        // participantes recebem números começando em 1 e não em 0
        participants.remove(index);

        return index + 1;
    }

};


#endif
