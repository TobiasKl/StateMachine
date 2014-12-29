package de.uniHannover.imes.stateMachine.concrete;

import de.uniHannover.imes.stateMachine.model.IllegalTransitionException;

/**
 * This class represents the execution environment for the state machine. In
 * this case it is a simple sequential program which shows how to use and to
 * setup the state machine.
 * 
 * @author Tobias Klaiber
 * @version 0.1 First running code.
 *
 */
public class StateMachineRunnerSequentialExample {

    /** The context of the state machine.*/
    private ContextExample context = new ContextExample();

    /**
     * Runs all steps to setup and operate the state machine. The repetitive
     * checkTransition() and operate() can be replaced within a while clause.
     * This is just for demonstration purposes.
     */
    public final void go() {
	context.initialize();
	try {
	    context.defineTransitions();
	} catch (IllegalTransitionException e) {

	    e.printStackTrace();
	}
	context.checkTransition();
	context.operate();
	context.checkTransition();
	context.operate();
	context.checkTransition();
	context.operate();
	context.checkTransition();
	context.operate();
	context.checkTransition();
	context.operate();

    }

    /**
     * Main function.
     * @param args unused parameters
     */
    public static void main(final String[] args) {
	StateMachineRunnerSequentialExample runner = 
		new StateMachineRunnerSequentialExample();
	runner.go();
    }

}
