package de.uniHannover.imes.stateMachine.model;


/**
 * Interface for describing the behaviour of states, during they are active in a
 * finite state machine. Implement this interface to program states on your own.
 * 
 * @author Tobias Klaiber
 *@version 0.1 First running code.
 */
public interface IState {

    /**
     * Describes the behaviour of a state during it is active in a finite state
     * machine. How often this method is called depends on the implementation of
     * the state machine runner.
     */
    void operate();

}
