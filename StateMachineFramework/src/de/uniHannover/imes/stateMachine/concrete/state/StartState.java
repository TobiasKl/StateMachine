package de.uniHannover.imes.stateMachine.concrete.state;

import de.uniHannover.imes.stateMachine.model.IState;

/**
 * This class represents the initial state of the state machine.This state is
 * just for demonstration purposes.
 * 
 * @author Tobias Klaiber
 * @version 0.1 First running code.
 *
 */
public class StartState implements IState {

    @Override
    public final void operate() {
	throw new IllegalStateException(
		"Cannot call operate() on the beginning step");

    }

}
