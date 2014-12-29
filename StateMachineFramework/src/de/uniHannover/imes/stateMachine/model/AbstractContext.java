package de.uniHannover.imes.stateMachine.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import de.uniHannover.imes.stateMachine.concrete.state.EndState;
import de.uniHannover.imes.stateMachine.concrete.state.StartState;
import de.uniHannover.imes.stateMachine.concrete.state.StateA;
import de.uniHannover.imes.stateMachine.concrete.state.StateB;
import de.uniHannover.imes.stateMachine.concrete.transition.StartToATransition;

/**
 * This class represents the super-class for all finite-state-machine contexts.
 * For implementing a state machine the concrete context has to derive from this
 * class. This class holds all important, state-machine-defining information and
 * offers some methods to operate and check the state-machine.
 * 
 * @author Tobias Klaiber
 * @version 0.1 First running code.
 *
 */
public abstract class AbstractContext {

    /** The final state of the state machine. */
    private IState stopState;
    /** The current active state of the state machine. */
    private IState currentState;
    /**
     * This map holds information about the state-relationship. Every state has
     * one or multiple goalstates. Each state-relation is a single transition.
     * In this map the key is defined as a state and another goal state. The
     * value is the corresponding transition.
     */
    private Map<IState[], ITransitionEvent> stateMachineDef = 
	    new HashMap<IState[], ITransitionEvent>();
    /** A set of all states in the state machine. */
    private Set<IState> setOfStates = new HashSet<IState>();

    /**
     * In this method the states and transition have to be intantiated and the
     * start and end-state have to be set. All state objects have to implement
     * {@link IState} and all transition objects have to implement
     * {@link ITransitionEvent}. For example, the code can look like this:
     * 
     * <pre>
     * <code>
     * 	// Instantiate all state objects
     * 	startState = new StartState();
     * 	endState = new EndState();
     * 	stateA = new StateA();
     * 	stateB = new StateB();
     * 	startToA = new StartToATransition();
     * 
     * 	// Instantiate all transition obj.
     * 	startToA = new InputTransition();
     * 	aToB = new InputTransition();
     * 	bToA = new InputTransition();
     * 	bToEnd = new InputTransition();
     * 
     * 	// set start- and end-state
     * 	setStartState(startState);
     * 	setEndState(endState);
     * </code>
     * </pre>
     */
    protected abstract void initialize();

    /**
     * In this method the state transitions have to be defined. Use {@link
     * defineTransition(...)} for setting an transition between two states. The
     * transitions connected with a single state should be unique, otherwise in
     * case of multiple valid transitions, the state machine will transist to
     * state with the first valid transition (unpredictable).For example, the
     * code can look like this:
     * 
     * <pre>
     * <code>
     * 	defineTransition(startState, stateA, startToA);
     * 	defineTransition(stateA, stateB, aToB);
     * 	defineTransition(stateB, stateA, bToA);
     * 	defineTransition(stateB, endState, bToEnd);
     * </code>
     * </pre>
     * 
     * @throws IllegalTransitionException
     *             //TODO not finished yet.
     */
    protected abstract void defineTransitions()
	    throws IllegalTransitionException;

    /**
     * Sets the starting state of the state machine. When you call
     * {@code checkTransition()} for the first time, all transitions from the
     * start state to other states will be checked.
     * 
     * @param startSt
     *            the first and initial state.
     */
    protected final void setStartState(final IState startSt) {
	currentState = startSt;
    }

    /**
     * Sets the final state of the state machine.
     * 
     * @param endSt
     *            the final state.
     */
    protected final void setEndState(final IState endSt) {
	stopState = endSt;
    }

    /**
     * This method is used for connecting two states with a given transition.
     * 
     * @param firstState
     *            the state, which is operated, before the transition is
     *            checked.
     * @param followingState
     *            the state, which if operated, after the transition was valid.
     * @param transition
     *            the transition connecting the both states.
     * @throws IllegalTransitionException
     *             //TODO not finished yet.
     */
    protected final void defineTransition(final IState firstState,
	    final IState followingState, final ITransitionEvent transition)
	    throws IllegalTransitionException {
	if (!setOfStates.contains(firstState)) {
	    setOfStates.add(firstState);
	}
	if (!setOfStates.contains(followingState)) {
	    setOfStates.add(followingState);
	}
	IState[] neighbours = new IState[2];
	neighbours[0] = firstState;
	neighbours[1] = followingState;

	stateMachineDef.put(neighbours, transition);

    }

    /**
     * This method calls the operate method of the current active state.
     * Warning, do not call {@code operate()} on start- or end-states.
     */
    public final void operate() {
	currentState.operate();
    }

    /**
     * Checks if there is a valid transition from the current state to another
     * state. If there was a valid transition, the following state is set as the
     * current state.
     */
    public final void checkTransition() {
	if (!currentState.equals(stopState)) {
	    ITransitionEvent currentTransition;
	    Iterator<IState[]> keySetIterator;
	    IState[] connectedStates = new IState[2];
	    connectedStates[0] = currentState;
	    Iterator<IState> stateIterator = setOfStates.iterator();
	    while (stateIterator.hasNext()) {
		connectedStates[1] = stateIterator.next();
		keySetIterator = stateMachineDef.keySet().iterator();
		while (keySetIterator.hasNext()) {
		    IState[] currentKey = keySetIterator.next();
		    if (currentKey[0].equals(currentState)) {
			if (currentKey[1].equals(connectedStates[1])) {
			    currentTransition = stateMachineDef.get(currentKey);
			    if (currentTransition.transitionEvent()) {
				currentState = connectedStates[1];
				return;
			    }

			}
		    }
		}
	    }

	}
    }

    /**
     * This method checks if the current state is the final state.
     * 
     * @return true if the current state is equal to the final state (previously
     *         set by calling {@code setStartState(...)}, otherwise false.
     */
    public final boolean isFinalState() {
	return currentState.equals(stopState);
    }


}
