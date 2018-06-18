package org.val.win.business.contract.manager;

import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

import java.util.List;

/**
 * Interface de UtilisateurManagerImpl
 */
public interface UtilisateurManager {

    /**
     * Liste d'utilisateur
     * @return une liste d'utilisateur
     */
    List<Utilisateur> getListUtilisateur();

    /**
     * Recuperer un utilisateur
     * @param pId id de l'utilisateur
     * @return un utilisateur
     * @throws NotFoundException en cas d'utilisateur non trouvé
     */
    Utilisateur getUtilisateur(Integer pId) throws NotFoundException;

    /**
     * recuperer un utilisateur en fonction de ces identifiants
     * @param pLogin username de l'utilisateur
     * @param pPassword mot de passe de l'utilisateur
     * @return un utilisateur
     * @throws NotFoundException en cas d'utilisateur non trouvé
     */
    Utilisateur getUtilisateur(String pLogin, String pPassword) throws NotFoundException;

    /**
     * creer un utilisateur
     * @param pUtilisateur utilisateur a creer
     * @throws FunctionalException en cas d'erreur
     */
    void insertUtilisateur(Utilisateur pUtilisateur) throws FunctionalException;

}
