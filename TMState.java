import java.util.*;

/**
 * This class implements the state functionality of a Turing Machine.
 * 
 * @author  Vladyslav (Vlad) Maliutin
 *          Reggie Wade
 */

public class TMState {
    private Map<Character, Transition> transitions;
    // assuming states are 0, 1, 2, ..., etc
    int name;

    /* 
     * Call super constructor to
     * assign the state a name.
     * Creates a hashmap to store
     * transitions to other states.
     */
    public TMState(int name) {
        this.name = name;
        this.transitions = new HashMap<>();
    }

    /**
     * Adds the transition to the TM's delta data structure
     * @param symbol is the symbol to transition to toState
     * @param transition is an object that holds transition and move data
     */
    public void addTransition(char symbol, Transition transition) {
        transitions.put(symbol, transition);
    }

    /**
     * Gets the next states based on the transition symbol
     * @param symbol is the symbol to transition to toState
     * @return the next from the symbol
     */
    public Transition toStates(char symbol) {
        return transitions.get(symbol);
    }
}