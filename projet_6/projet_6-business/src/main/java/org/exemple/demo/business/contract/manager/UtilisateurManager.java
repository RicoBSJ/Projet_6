package org.exemple.demo.business.contract.manager;

import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.exemple.demo.model.exception.NotFoundException;

import java.util.List;

public interface UtilisateurManager {


    List<Utilisateur> getListUtilisateur();

    Utilisateur getUtilisateur(Integer pId) throws NotFoundException;

    Utilisateur getUtilisateur(String pLogin, String pPassword) throws NotFoundException;
}
