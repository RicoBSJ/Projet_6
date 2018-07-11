package org.val.win.model.exception;

/**
 * Classe d'exception levée quand une erreur fonctionnelle survient.
 *
 * @author lgu
 */
public class FunctionalException extends Exception {

    /**
     * Constructeur.
     *
     * @param pMessage -
     */
    public FunctionalException(final String pMessage) {
        super(pMessage);
    }


    /**
     * Constructeur.
     *
     * @param pMessage -
     * @param pCause -
     */
    public FunctionalException(final String pMessage, final Throwable pCause) {
        super(pMessage, pCause);
    }
}
