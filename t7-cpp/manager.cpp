/**
 * Manager class.
 */

#ifndef TESTE_MANAGER_H
#define TESTE_MANAGER_H

#include <list>
#include <stdio.h>
#include <stdlib.h>
#include <ctime>
#include <iostream>

#define NO_PARTICIPANTS -2
using namespace std;

class Manager {

private:
    list<int> participants;

    Manager() {
        /* Intializes random number generator */
        srand((unsigned) time(NULL));
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
        for (int i = 1; i <= numberOfParticipants; i++) {
            participants.push_back(i);
        }
        cout << "all the participants:";
        for (auto it=participants.begin(); it!=participants.end(); ++it) {
            cout << ' ' << *it;
        }
        cout << '\n';
    }

    int getGuess() {
        if (participants.empty()) {
            return NO_PARTICIPANTS;
        }

        int index = rand() % participants.size();

        auto it = participants.begin();
        advance(it, index);
        // saves the participant that will be removed
        int toRemove = *it;

        participants.erase(it);

        return toRemove;
    }

};


#endif
