package org.exemple.demo.business.impl.manager;

import org.apache.commons.lang3.StringUtils;
import org.exemple.demo.business.contract.manager.UtilisateurManager;
import org.exemple.demo.consumer.contract.dao.UtilisateurDao;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.exemple.demo.model.exception.FunctionalException;
import org.exemple.demo.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;


import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.rmi.CORBA.Util;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

    @Inject
    private UtilisateurDao utilisateurDao;

    @Inject
    private TransactionHelper transactionHelper;

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


    @Override
    public List<Utilisateur> getListUtilisateur() {
        return utilisateurDao.getListUtilisateur();
    }

    @Override
    public void insertUtilisateur(Utilisateur pUtilisateur) throws FunctionalException {
        if (pUtilisateur == null) {
            throw new FunctionalException("L'objet Utilisateur ne doit pas être null !");
        }

        Set<ConstraintViolation<Utilisateur>> vViolations = getConstraintValidator().validate(pUtilisateur);
        if (!vViolations.isEmpty()) {
            throw new FunctionalException("L'objet Utilisateur est invalide",
                    new ConstraintViolationException(vViolations));

        }
        utilisateurDao.insertUtilisateur(pUtilisateur);
    }
}
