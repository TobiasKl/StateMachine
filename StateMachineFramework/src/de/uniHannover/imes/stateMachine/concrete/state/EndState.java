package de.uniHannover.imes.stateMachine.concrete.state;

import de.uniHannover.imes.stateMachine.model.IState;

/**
 * The final state of the state machine.This state is just for demonstration
 * purposes.
 * 
 * @author Tobias Klaiber
 * @version 0.1 First running code.
 *
 */
public class EndState implements IState {

    @Override
    public final void operate() {
	throw new IllegalStateException(
		"Cannot call operate() on the final state.");
    }

}
