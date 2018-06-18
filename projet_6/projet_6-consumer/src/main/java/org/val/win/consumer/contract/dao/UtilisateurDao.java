package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.utilisateur.Utilisateur;

import java.util.List;

/**
 * Interface de UtilisateurDaoImpl
 */
public interface UtilisateurDao {

    /**
     * recuperer une liste d'utilisateur
     * @return une liste d'utilisateur
     */
    List<Utilisateur> getListUtilisateur();

    /**
     * recuperer un utilisateur
     * @param id id de l'utilisateur
     * @return un utilisateur
     */
    Utilisateur getUtilisateur(Integer id);

    /**
     * creer un utilisateur
     * @param pUtilisateur l'utilisateur a creer
     * @return l'utilisateur crée
     */
    Utilisateur insertUtilisateur(Utilisateur pUtilisateur);

    /**
     * mise a jour du statut administrateur d'un utilisateur
     * @param pUtilisateur l'utilisateur a modifier
     */
    void updateEtat(Utilisateur pUtilisateur);

    /**
     * mise a jour des informations d'un utilisateur
     * @param pUtilisateur
     */
    void updateInfoUtil(Utilisateur pUtilisateur);

}