package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author João Bolsson (joaovictorbolsson@gmail.com)
 * @since 2017, 29 May.
 */
public class Manager {

    private static Manager INSTANCE;

    public static final int NO_PARTICIPANTS = -2;

    private final List<Integer> participants;

    /**
     * Get the active instance of this object.
     *
     * @return The unique instance of this object.
     */
    public static Manager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Manager();
        }
        return INSTANCE;
    }

    private Manager() {
        participants = new ArrayList<>();
    }

    /**
     * Starts the Manager with number of participants to sort.
     *
     * @param numberOfParticipants
     */
    public void start(final int numberOfParticipants) {
        participants.clear();
        for (int i = 0; i < numberOfParticipants; i++) {
            participants.add(i);
        }
    }

    /**
     * Get a random index from participants list.
     *
     * @return Guess index. Note: if -1, no participants in list.
     */
    public int getGuess() {
        if (participants.isEmpty()) {
            return NO_PARTICIPANTS;
        }
        int index = ThreadLocalRandom.current().nextInt(0, participants.size());
        Integer toRemove = participants.get(index);
        participants.remove(toRemove);
        // participantes recebem números começando em 1 e não em 0
        return toRemove + 1;
    }

    public static void main(String[] args) {
        MainPanel mainPanel = new MainPanel();

        mainPanel.showAsDialog();
    }
}
