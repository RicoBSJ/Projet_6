package org.exemple.demo.business.impl.manager;

import org.exemple.demo.business.contract.manager.UtilisateurManager;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.exemple.demo.model.exception.NotFoundException;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

    @Inject
    private UtilisateurManager utilisateurManager;

    private final List<Utilisateur> listUtilisateur = new ArrayList<>();


    @Override
    public Utilisateur getUtilisateur(Integer pId) throws NotFoundException {
        Utilisateur vUtilisateur
                = this.listUtilisateur.stream()
                .filter(p -> p.getId().equals(pId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé : ID=" + pId));
        return vUtilisateur;
    }


    @Override
    public List<Utilisateur> getListUtilisateur() {
        return this.listUtilisateur;
    }


    /**
     * Initialise et peuple la liste de {@link Utilisateur}
     */
    @PostConstruct
    private void initListUtilisateur() {
        for (int vId = 0; vId < 9; vId++) {
            Utilisateur vUtilisateur = new Utilisateur(vId);
            vUtilisateur.setNom("Utilisateur :" + vUtilisateur.getNom() + " " + vUtilisateur.getPrenom());
            vUtilisateur.setMotDePasse("Mot de Passe : " + vUtilisateur.getMotDePasse());
        }
    }
}
