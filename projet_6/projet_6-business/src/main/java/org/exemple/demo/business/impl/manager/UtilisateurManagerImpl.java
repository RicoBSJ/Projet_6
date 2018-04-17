package org.exemple.demo.business.impl.manager;

import org.exemple.demo.business.contract.manager.UtilisateurManager;
import org.exemple.demo.consumer.contract.dao.UtilisateurDao;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.exemple.demo.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;


import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

    @Inject
    private UtilisateurDao utilisateurDao;

    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public Utilisateur getUtilisateur(Integer pId) throws NotFoundException {
        List<Utilisateur> listUtilisateur = this.getListUtilisateur();
        Utilisateur vUtilisateur
                = listUtilisateur.stream()
                .filter(p -> p.getId().equals(pId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé : ID=" + pId));
        return vUtilisateur;
    }


    @Override
    public List<Utilisateur> getListUtilisateur() {
        return utilisateurDao.getListUtilisateur();
    }
}
