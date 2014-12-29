package de.uniHannover.imes.stateMachine.model;

/**
 * Transition event, which shows an input dialog and evaluates the user's
 * response. This is just for test purposes.
 * 
 * @author Tobias Klaiber
 *@version 0.1 First running code.
 */
public class InputTransition implements ITransitionEvent {

    @Override
    public final boolean transitionEvent() {
	return javax.swing.JOptionPane.showInputDialog("Nächster Zustand?")
		.toLowerCase().contains("ja");
    }

}
