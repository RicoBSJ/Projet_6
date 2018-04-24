package org.val.win.business.contract.manager;

import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

import java.util.List;

public interface UtilisateurManager {

    List<Utilisateur> getListUtilisateur();

    Utilisateur getUtilisateur(Integer pId) throws NotFoundException;

    Utilisateur getUtilisateur(String pLogin, String pPassword) throws NotFoundException;

    void insertUtilisateur(Utilisateur pUtilisateur) throws FunctionalException;

}
