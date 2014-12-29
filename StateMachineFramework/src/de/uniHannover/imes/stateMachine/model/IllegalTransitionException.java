package de.uniHannover.imes.stateMachine.model;

/**
 * TODO has to be defined.
 * @author Tobias Klaiber
 * @version 0.1 First running code.
 *
 */
public class IllegalTransitionException extends Exception {

    /**
     * The UID.
     */
    private static final long serialVersionUID = 16385537529465950L;

    public IllegalTransitionException()
    {
	super();
    }
    
    public IllegalTransitionException(final String msg)
    {
	super(msg);
    }
}
