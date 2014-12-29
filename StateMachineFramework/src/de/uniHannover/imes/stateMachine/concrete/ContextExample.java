package de.uniHannover.imes.stateMachine.concrete;

import de.uniHannover.imes.stateMachine.concrete.state.EndState;
import de.uniHannover.imes.stateMachine.concrete.state.StartState;
import de.uniHannover.imes.stateMachine.concrete.state.StateA;
import de.uniHannover.imes.stateMachine.concrete.state.StateB;
import de.uniHannover.imes.stateMachine.concrete.transition.StartToATransition;
import de.uniHannover.imes.stateMachine.model.AbstractContext;
import de.uniHannover.imes.stateMachine.model.IState;
import de.uniHannover.imes.stateMachine.model.ITransitionEvent;
import de.uniHannover.imes.stateMachine.model.IllegalTransitionException;
import de.uniHannover.imes.stateMachine.model.InputTransition;

/**
 * This class defines all parameters of a finite state machine. First of all
 * states as well as transition objects are instantiated. In addition the states
 * are connected with transitions. This class is an example on how a user could
 * implement a state machine. It is important to derive one's context from the
 * {@link AbstractContext} class.
 * 
 * @author Tobias Klaiber
 * @version 0.1 First running code.
 *
 */
public class ContextExample extends AbstractContext {

    /** The start state of the state machine. */
    private IState startState;
    /** The end state of the state machine. */
    private IState endState;
    /** An intermediate state of the state machine. */
    private IState stateA;
    /** The intermediate state of the state machine. */
    private IState stateB;
    /** The transition from state {@link StartState} to {@link StateB}. */
    private ITransitionEvent startToA;
    /** The transition from state {@link StateA} to {@link StateB}. */
    private ITransitionEvent aToB;
    /** The transition from state {@link StateB} to {@link StateA}. */
    private ITransitionEvent bToA;
    /** The transition from state {@link StateB} to {@link EndState}. */
    private ITransitionEvent bToEnd;

    /**
     * Instantiates all state and transition objects and sets the start- and
     * end-state.
     */
    public final void initialize() {
	
	// Instantiate all state objects
	startState = new StartState();
	endState = new EndState();
	stateA = new StateA();
	stateB = new StateB();
	startToA = new StartToATransition();

	// Instantiate all transition obj.
	startToA = new InputTransition();
	aToB = new InputTransition();
	bToA = new InputTransition();
	bToEnd = new InputTransition();

	// set start- and end-state
	setStartState(startState);
	setEndState(endState);
    }

    /**
     * Defines the transition between the different states.
     * @throws IllegalTransitionException TODO define it
     */
    public final void defineTransitions() throws IllegalTransitionException {
	defineTransition(startState, stateA, startToA);
	defineTransition(stateA, stateB, aToB);
	defineTransition(stateB, stateA, bToA);
	defineTransition(stateB, endState, bToEnd);
    }

}
