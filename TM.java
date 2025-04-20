import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class TM {

    private Set<Integer> sigma;
    private TMState startState;
    private HashMap<Integer, TMState> states;
    private TMState finalState;

    public TM () {
        sigma  = new LinkedHashSet<>();
        sigma.add(0);
        startState = null;
        states = new LinkedHashMap<>();
        finalState = null;
    }

    public void addSigma (Integer a) {
        sigma.add(a);
    }

    public void setStart () {
        /*
         * set start state to state at lowest key val
         */
        Set<Integer> keys = states.keySet();
        Integer min = Collections.min(keys);
        startState = states.get(min);
    }

    public void setFinal () {
        /*
         * set final state to state at highest key val
         */
        Set<Integer> keys = states.keySet();
        Integer max = Collections.max(keys);
        finalState = states.get(max);
    }

    public boolean addState(Integer name) {
        if (states.containsKey(name)) return false;
        states.put(name, new TMState(name));
        return true;
    }

    public boolean addTransition(Integer fromState, Set<Integer> toStates, Integer onSymb, char move) {
        if (!states.containsKey(fromState) || !sigma.contains(onSymb)) return false;
        TMState from = states.get(fromState);
        for (Integer toState : toStates) {
            if (!states.containsKey(toState)) return false;
            from.addTransition(onSymb, new Transition(move, states.get(toState)));
        }
        return true;
    }

    public boolean isFinal(Integer name) {
        TMState state = states.get(name);
        return state != null && state.equals(finalState);
    }

    
}
