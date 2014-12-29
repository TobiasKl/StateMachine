package de.uniHannover.imes.stateMachine.model;

/**
 * Interface for describing state machine transition events.
 * 
 * @author Tobias Klaiber
 * @version 0.1 First running code.
 *
 */
public interface ITransitionEvent {

    /**
     * Method describing the transition condition between two states.
     * 
     * @return true if transition to another, corresponding state is valid,
     *         otherwise false. (How to set up the relation between states via
     *         transitions see {@link AbstractContext}.
     */
    boolean transitionEvent();

}
