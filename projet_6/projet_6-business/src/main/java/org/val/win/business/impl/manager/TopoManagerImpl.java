package org.val.win.business.impl.manager;

import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.val.win.business.contract.manager.TopoManager;
import org.val.win.consumer.contract.dao.TopoDao;
import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Classe de gestion des transactions pour les topos
 */
@Named
public class TopoManagerImpl extends AbstractManager implements TopoManager {

    /**
     * creation du dao des topos
     */
    @Inject
    private TopoDao topoDao;

    /**
     * creation d'un platformTransactionManager pour gerer les transactions
     */
    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * Methode retournant un topo
     * @param pId id d'un topo
     * @return un topo
     * @throws NotFoundException en cas de topo de non trouvé
     */
    @Override
    public Topo getTopo(Integer pId) throws NotFoundException {
        List<Topo> listTopo = this.getListTopo();
        Topo vTopo
                = listTopo.stream()
                .filter(p -> p.getIdTopo().equals(pId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Topo non trouvé : ID=" + pId));
        if (vTopo.getIdEmprunteur() == 0) {
            vTopo.setIdEmprunteur(null);
        }
        return vTopo;
    }

    /**
     * Methode recupérant la liste de topo
     * @return liste de topo
     */
    @Override
    public List<Topo> getListTopo() {
        return topoDao.getListTopo();
    }

    /**
     * Methode pour creer un topo
     * @param pTopo topo a creer
     * @throws FunctionalException en cas d'erreur
     */
    @Override
    public void insertTopo(Topo pTopo) {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                topoDao.insertTopo(pTopo);
            }
        });
    }

    /**
     * Methode pour l'emprunt
     * @param pTopo topo a emprunter
     * @throws FunctionalException en cas d'erreur
     */
    @Override
    public void emprunt(Topo pTopo, Utilisateur pUtilisateur) {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                pTopo.setIdEmprunteur(pUtilisateur.getIdUtilisateur());
                pTopo.setDisponible(false);
                topoDao.emprunt(pTopo);
            }
        });
    }

    /**
     * Methode pour l'emprunt
     * @param pTopo topo a emprunter
     * @throws FunctionalException en cas d'erreur
     */
    @Override
    public void retour(Topo pTopo) {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                pTopo.setIdEmprunteur(null);
                pTopo.setDisponible(true);
                topoDao.emprunt(pTopo);
            }
        });
    }


}