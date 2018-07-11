package org.val.win.business.impl.manager;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.val.win.business.contract.manager.UtilisateurManager;
import org.val.win.consumer.contract.dao.UtilisateurDao;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;


import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Classe de gestion des transactions pour les utilisateurs
 */
@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

    /**
     * creation du dao des utilisateurs
     */
    @Inject
    private UtilisateurDao utilisateurDao;

    /**
     * creation d'un platformTransactionManager pour gerer les transactions
     */
    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * Recuperer un utilisateur
     * @param pId id de l'utilisateur
     * @return un utilisateur
     * @throws NotFoundException en cas d'utilisateur non trouvé
     */
    @Override
    public Utilisateur getUtilisateur(Integer pId) throws NotFoundException {
        List<Utilisateur> listUtilisateur = this.getListUtilisateur();
        Utilisateur vUtilisateur
                = listUtilisateur.stream()
                .filter(p -> p.getIdUtilisateur().equals(pId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé : ID=" + pId));
        return vUtilisateur;
    }

    /**
     * recuperer un utilisateur en fonction de ces identifiants
     * @param pLogin username de l'utilisateur
     * @param pPassword mot de passe de l'utilisateur
     * @return un utilisateur
     * @throws NotFoundException en cas d'utilisateur non trouvé
     */
    @Override
    public Utilisateur getUtilisateur(String pLogin, String pPassword) throws NotFoundException {

        List<Utilisateur> listUtilisateur = this.getListUtilisateur();
        Utilisateur vUtilisateur
                = listUtilisateur.stream()
                .filter(p -> p.getPseudonyme().equals(pLogin))
                .filter(p -> p.getMotDePasse().equals(pPassword))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Aucun utilisateur correspondant au couple login/password fourni."));
        return vUtilisateur;
    }

    /**
     * Liste d'utilisateur
     * @return une liste d'utilisateur
     */
    @Override
    public List<Utilisateur> getListUtilisateur() {
        return utilisateurDao.getListUtilisateur();
    }

    /**
     * creer un utilisateur
     * @param pUtilisateur utilisateur a creer
     * @throws FunctionalException en cas d'erreur
     */
    @Override
    public void insertUtilisateur(Utilisateur pUtilisateur) throws FunctionalException {
        if (pUtilisateur == null) {
            throw new FunctionalException("L'objet Utilisateur ne doit pas être null !");
        }
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                utilisateurDao.insertUtilisateur(pUtilisateur);
            }
        });
    }
}
