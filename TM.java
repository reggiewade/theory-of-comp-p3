import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class represents a Turing Machine (TM) with states and transitions.
 * It supports adding states, transitions, and setting start and final states.
 * It uses integer-based tape symbols and state names.
 *
 * @author  Vladyslav (Vlad) Maliutin
 *          Reggie Wade
 */
public class TM {

    private Set<Integer> sigma;
    private TMState startState;
    private HashMap<Integer, TMState> states;
    private TMState finalState;
    private Tape tape;

    public TM () {
        sigma  = new LinkedHashSet<>();
        sigma.add(0);
        startState = null;
        states = new LinkedHashMap<>();
        finalState = null;
        tape = new Tape();
    }

    /**
     * Adds a symbol to the tape alphabet.
     *
     * @param a symbol to add
     */
    public void addSigma (Integer a) {
        sigma.add(a);
    }

    /**
     * Gets the start state.
     *
     * @return the start TMState
     */
    public TMState getStart () {
        return startState;
    }

    /**
     * Gets the start state.
     *
     * @return the final TMState
     */
    public TMState getFinal () {
        return finalState;
    }

    /**
     * Sets the start state to the state with the lowest key value.
     */
    public void setStart () {
        /*
         * set start state to state at lowest key val
         */
        Set<Integer> keys = states.keySet();
        Integer min = Collections.min(keys);
        startState = states.get(min);
    }

    /**
     * Sets the final state to the state with the highest key value.
     */
    public void setFinal () {
        Set<Integer> keys = states.keySet();
        Integer max = Collections.max(keys);
        finalState = states.get(max);
    }

    /**
     * Adds a new state to the TM.
     *
     * @param name the name (ID) of the state
     * @return true if the state was added, false if it already exists
     */
    public boolean addState(Integer name) {
        if (states.containsKey(name)) return false;
        states.put(name, new TMState(name));
        return true;
    }

    /**
     * Adds a transition from one state to another on a given symbol.
     *
     * @param fromState the current state
     * @param toState the next state
     * @param onSymb the symbol read on the tape
     * @param move the direction to move ('L' or 'R')
     * @return true if the transition was successfully added
     */
    public boolean addTransition(Integer fromState, Integer toState, Integer onSymb, char move) {
        if (!states.containsKey(fromState) || !sigma.contains(onSymb)) return false;
        TMState from = states.get(fromState);
        if (!states.containsKey(toState)){
            return false;
        }
        from.addTransition(onSymb, new Transition(move, states.get(toState)));
        
        return true;
    }
    
    /**
     * Gets the next state based on the current state and the symbol read on the tape.
     *
     * @param currentState the current state
     * @param onSymb the symbol read on the tape
     * @return the next TMState, or null if no valid transition exists
     */
    public Transition getNextState(Integer currentState, Integer onSymb) {
        if (!states.containsKey(currentState)) return null;
        TMState state = states.get(currentState);
        return state.toState(onSymb);
    }

    /**
     * Checks if a given state is the final state.
     *
     * @param name the name (ID) of the state
     * @return true if it is the final state
     */
    public boolean isFinal(Integer name) {
        TMState state = states.get(name);
        return state != null && state.equals(finalState);
    }

    public void runTM () {
        // set state
        int currState = startState.name;
        // get current symbol
        int symb = tape.read();
        // get next state
        Transition info = getNextState(currState, symb);
        // write to current state
        //tape.write();
        // move left or right
        if (info.move == 'R') {
            tape.moveRight();
        }
        else {
            tape.moveLeft();
        }

    }

}
