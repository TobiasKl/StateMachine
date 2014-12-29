package de.uniHannover.imes.stateMachine.concrete.state;

import de.uniHannover.imes.stateMachine.model.IState;

/**
 * This class represents the intermediate state "B" of the state machine. This
 * state is just for demonstration purposes.
 * 
 * @author Tobias Klaiber
 * @version 0.1 First running code.
 *
 */
public class StateA implements IState {

    /** The state's operation is represented as a sleep time. */
    private static final long SLEEP_DURATION_MS = 1500;

    @Override
    public final void operate() {

	try {
	    System.out.println(this.getClass().getName() + " operating.");
	    Thread.currentThread();
	    Thread.sleep(SLEEP_DURATION_MS);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

    }

}
