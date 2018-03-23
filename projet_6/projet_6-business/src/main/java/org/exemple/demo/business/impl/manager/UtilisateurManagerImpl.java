package org.exemple.demo.business.impl.manager;

import org.exemple.demo.business.contract.manager.UtilisateurManager;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.exemple.demo.model.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {


    @Override
    public Utilisateur getUtilisateur(Integer pId) throws NotFoundException {
        if (pId < 0) {
            throw new NotFoundException("Utilisateur non trouvé : ID=" + pId);
        }
        Utilisateur vUtilisateur = newUtilisateur(pId);
        return vUtilisateur;
    }


    @Override
    public Utilisateur getUtilisateur(String pLogin, String pPassword) throws NotFoundException {
        if (StringUtils.equals(pLogin, "joe") && StringUtils.equals(pPassword, "joe")) {
            return newUtilisateur(0);
        }
        throw new NotFoundException("Aucun utilisateur correspondant au couple login/password fourni.");
    }


    @Override
    public List<Utilisateur> getListUtilisateur() {
        List<Utilisateur> vList = new ArrayList<>();
        for (int vI = 0; vI < 9; vI++) {
            Utilisateur vUtilisateur = newUtilisateur(vI);
            vList.add(vUtilisateur);
        }
        return vList;
    }


    private Utilisateur newUtilisateur(Integer pId) {
        final String[] vPrenoms = {
                "Joe", "William", "Jack", "Averell"
        };
        Utilisateur vUtilisateur = new Utilisateur(pId);
        vUtilisateur.setPrenom(vPrenoms[Math.abs(pId) % vPrenoms.length]);
        vUtilisateur.setNom("Dalton");
        return vUtilisateur;
    }

}